package com.example.salesfox.salesforce.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import static io.restassured.RestAssured.given;

@Service
public class ConnectionService {

    public String accessToken;

    @Value("${app.username}")
    private String username;

    @Value("${app.password}")
    private String password;

    @Value("${app.client_id}")
    private String client_id;

    @Value("${app.client_secret}")
    private String client_secret;

    public ConnectionService() {
        
    }

    public String getAccessToken()
    {
        return
            given().urlEncodingEnabled(true)
            .param("username", username)
            .param("password", password)
            .param("client_id", client_id)
            .param("client_secret", client_secret)
            .param("grant_type", "password")
            .header("Accept", "application/json")
            .header("Content-Type", "application/x-www-form-urlencoded")
        .when()
        .post("https://login.salesforce.com/services/oauth2/token")
        .then()
        .assertThat().statusCode(200).log().body().extract().path("access_token");
    }
}
