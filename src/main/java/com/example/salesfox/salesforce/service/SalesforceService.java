package com.example.salesfox.salesforce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.restassured.http.ContentType;
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
}
