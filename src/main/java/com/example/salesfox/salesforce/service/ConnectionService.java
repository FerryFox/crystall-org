package com.example.salesfox.salesforce.service;

import org.springframework.stereotype.Service;
import com.example.salesfox.util.service.SecretService;
import static io.restassured.RestAssured.given;

@Service
public class ConnectionService {

    private final SecretService secretService;

    public String accessToken;

    public ConnectionService(SecretService secretService) {
        this.secretService = secretService;
        
    }

    public String getAccessToken()
    {
        return
            given().urlEncodingEnabled(true)
            .param("username", secretService.getUsername())
            .param("password", secretService.getPassword())
            .param("client_id", secretService.getClient_id())
            .param("client_secret", secretService.getClient_secret())
            .param("grant_type", "password")
            .header("Accept", "application/json")
            .header("Content-Type", "application/x-www-form-urlencoded")
        .when()
        .post("https://login.salesforce.com/services/oauth2/token")
        .then()
        .assertThat().statusCode(200).log().body().extract().path("access_token");
    }
}
