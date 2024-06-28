package com.example.salesfox.salesforce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.salesfox.util.model.ServiceResponse;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


@Service
public class SalesforceService {

    @Autowired
    private final ConnectionService connectionService;

    private static final String INSTACE_URL = "https://resilient-goat-uddb3x-dev-ed.trailblaze.my.salesforce.com";

    public SalesforceService(ConnectionService connectionService) {
        this.connectionService = connectionService;
    }
    
    public String querySalesforce(String query) 
    {
        String token = connectionService.getAccessToken();

        return
            given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
            .when().get(INSTACE_URL + "/services/data/v61.0/query/?q=" + query)
            .then().statusCode(200).log().body().extract().asString();
    }

    public ServiceResponse<String> insertNewCase(String jsonPayload) 
    {
        Response response =
            given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + connectionService.getAccessToken())
                .body(jsonPayload)
            .when().post(INSTACE_URL + "/services/apexrest/Case");

        ServiceResponse<String> serviceResponse = new ServiceResponse<>();
        if(response.getStatusCode() == 201) {
            serviceResponse.setMessage("Case created successfully");
            serviceResponse.setSuccess(true);
            serviceResponse.setPayload(response.body().asString());
            return serviceResponse;
        }
        
        String errorMessage = response.jsonPath().getString("error");
        serviceResponse.setMessage(errorMessage);
        serviceResponse.setSuccess(false);
        serviceResponse.setPayload(null);
        return serviceResponse; 
    }
}
