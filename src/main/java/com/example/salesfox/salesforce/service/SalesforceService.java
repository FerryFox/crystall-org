package com.example.salesfox.salesforce.service;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class SalesforceService 
{
    private final String clientId = "3MVG9k02hQhyUgQC5s3dVYFGeHDBXa8nXzMGlijdxP4DR.r.BHl9lGSfguhMy000HJ7kj_rf7W5VbiB0NqTWq";
    private final String clientSecret = "C16184EE73691505A7ADAB4CC0B8ECEF98BADF6F460869A19B1EC2741EE20C20";
    private final String username = "dustin.rasch@resilient-goat-uddb3x.com";
    private final String password = "Mainz123Mainz!?";
    private final String token = "QUnpX0X5tzShLXbDnGTLb7BN";
    private final String loginUrl = "https://login.salesforce.com";

    private String accessToken;
    private String instanceUrl;

    public void authenticate() {
        RestTemplate restTemplate = new RestTemplate();
        String url = UriComponentsBuilder.fromHttpUrl(loginUrl + "/services/oauth2/token")
                .queryParam("grant_type", "password")
                .queryParam("client_id", clientId)
                .queryParam("client_secret", clientSecret)
                .queryParam("username", username)
                .queryParam("password", password + token)
                .toUriString();

        Map<String, String> response = restTemplate.postForObject(url, null, Map.class);
        this.accessToken = response.get("access_token");
        this.instanceUrl = response.get("instance_url");
    }

    public String querySalesforce(String soql) {
        if (accessToken == null || instanceUrl == null) {
            authenticate();
        }
        RestTemplate restTemplate = new RestTemplate();
        String url = UriComponentsBuilder.fromHttpUrl(instanceUrl + "/services/data/v54.0/query")
                .queryParam("q", soql)
                .toUriString();

        return restTemplate.getForObject(url, String.class, Map.of("Authorization", "Bearer " + accessToken));
    }
}
