package com.example.salesfox.salesforce.service;

import static io.restassured.RestAssured.given;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

@Service
public class SalesforceEventService  {

    @Autowired
    private final ConnectionService connectionService;

    private static final String INSTACE_URL = "https://resilient-goat-uddb3x-dev-ed.trailblaze.my.salesforce.com"; 


    public SalesforceEventService(ConnectionService connectionService) {
        this.connectionService = connectionService;
    }

    public String createEvent() {
        String apiCallURL = INSTACE_URL +  "/services/data/v52.0/sobjects/News__e/eventSchema";
        String token = connectionService.getAccessToken();

            
         Response response =
            given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
            .when().get( apiCallURL );

       return response.asString();
    }
}
