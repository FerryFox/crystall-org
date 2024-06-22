package com.example.salesfox.salesforce.service;

import java.util.Collections;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


public class ConnectionService {

    public String authenticate() {

        String url = "https://login.salesforce.com/services/oauth2/token";
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("username", "dustin.rasch@resilient-goat-uddb3x.com");
        map.add("password", "Mainz123Mainz!?QUnpX0X5tzShLXbDnGTLb7BN");
        map.add("client_id", "3MVG9k02hQhyUgQC5s3dVYFGeHAZkwHWsQJGEuCmRGZ9I3uX3ISLocZPXXgRL6T.y9cYUz.BItY93MScB4ZSL");
        map.add("client_secret", "1059EAC9E880E72F19F92BDF9E11EBE6A085C0F243B42245A6CDB54BC880A7B7");
        map.add("grant_type", "password");

      
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        try {
            ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
            String responseBody = response.getBody();
            // Assuming the response body is in JSON format and contains the access_token field
            // You can use a JSON parser like Jackson to extract the access token
            // For simplicity, using a placeholder method extractAccessToken
            String accessToken = extractAccessToken(responseBody);
            System.out.println("Access Token: " + accessToken);
            return accessToken;
        } catch (Exception e) {
            e.printStackTrace();
            return "Error during authentication: " + e.getMessage();
        }
    }

    // Placeholder method for extracting access token from JSON response
    private String extractAccessToken(String responseBody) {
        // You can use a JSON parsing library like Jackson or Gson to extract the access_token
        // For example, using Jackson:
        /*
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(responseBody);
        return root.path("access_token").asText();
        */
        return ""; // Implement the actual extraction logic
    }
}
