package com.example.salesfox.salesforce.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.restassured.http.ContentType;

import org.json.JSONObject;
import static io.restassured.RestAssured.*;


@Service
public class SalesforceService {

    @Autowired
    private final ConnectionService connectionService;

    private static final String INSTACE_URL = "https://resilient-goat-uddb3x-dev-ed.trailblaze.my.salesforce.com";

    public SalesforceService(ConnectionService connectionService) {
        this.connectionService = connectionService;
    }
    
    public String insertAccount () 
    {
        Map<String, Object> mapper = new HashMap<String, Object>();
        mapper.put("Name", "Test Account XCVB");

        JSONObject jsonAccount = new JSONObject(mapper);

        System.out.println("Access_Token :::" + connectionService.accessToken);
        System.out.println("JSON Account ::: " + jsonAccount.toString());

        return
            given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + connectionService.accessToken)
                .header("Content-Type", "application/json")
                .body(jsonAccount.toString())
            .when().post(INSTACE_URL + "/services/data/v61.0/sobjects/Account")
            .then().statusCode(201).log().body().extract().path("id");
    }
}
