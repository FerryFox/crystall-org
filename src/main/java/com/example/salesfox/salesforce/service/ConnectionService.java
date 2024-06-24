package com.example.salesfox.salesforce.service;

import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;

import static io.restassured.RestAssured.given;

@Service
@Getter
@Setter
public class ConnectionService {

    public String accessToken;
    
    public ConnectionService() {
        this.accessToken = getAccessToken();
    }
    
    private String getAccessToken()
    {
        if (this.accessToken != null ) return this.accessToken;

        return
            given().urlEncodingEnabled(true)
            .param("username", "dustin.rasch@resilient-goat-uddb3x.com")
            .param("password", "Mainz123mainz!?QUnpX0X5tzShLXbDnGTLb7BN")
            .param("client_id", "3MVG9k02hQhyUgQC5s3dVYFGeHAZkwHWsQJGEuCmRGZ9I3uX3ISLocZPXXgRL6T.y9cYUz.BItY93MScB4ZSL")
            .param("client_secret", "1059EAC9E880E72F19F92BDF9E11EBE6A085C0F243B42245A6CDB54BC880A7B7")
            .param("grant_type", "password")
            .header("Accept", "application/json")
            .header("Content-Type", "application/x-www-form-urlencoded")
        .when()
        .post("https://login.salesforce.com/services/oauth2/token")
        .then()
        .assertThat().statusCode(200).log().body().extract().path("access_token");
    }
}
