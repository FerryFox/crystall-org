package com.example.salesfox.salesforce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.salesfox.salesforce.model.Describe;
import com.example.salesfox.util.model.ServiceResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.response.ResponseBody;

@Service
public class MetaService {

    @Autowired
    private final ConnectionService connectionService;
    private static final String INSTACE_URL = "https://resilient-goat-uddb3x-dev-ed.trailblaze.my.salesforce.com"; 

    public MetaService(ConnectionService connectionService) {
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
            .then().log().body().extract().asString();
    }

    public String queryTooling(String query){
        String token = connectionService.getAccessToken();

        return
            given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
            .when().get(INSTACE_URL + "/services/data/v61.0/tooling/query/?q=" + query)
            .then().log().body().extract().asString();
    }

    public ServiceResponse<Describe> getMetadata() throws JsonMappingException, JsonProcessingException 
    {
        String token = connectionService.getAccessToken();
        String objectAPIName = "Contact";
        String endpoint = "/services/data/v61.0/sobjects/";
        String url = INSTACE_URL + endpoint + objectAPIName + "/describe";
        ServiceResponse<Describe> serviceResponse = 
            new ServiceResponse<Describe>(false, "failed to get metadata", null);

        @SuppressWarnings("rawtypes")
        ResponseBody response =
        given()
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .header("Authorization", "Bearer " + token)
        .when().get(url);

        System.out.println(response.prettyPrint());
        String jsonResponse = response.asString();
        ObjectMapper objectMapper = new ObjectMapper();
        
        try {
            Describe describe = objectMapper.readValue(jsonResponse, Describe.class);
            serviceResponse.setMessage("Metadata");
            serviceResponse.setSuccess(true);
            serviceResponse.setPayload(describe);
        } catch (Exception e) {
            serviceResponse.setMessage(e.getMessage());
        }
       
        return serviceResponse;
    }
    
    public String queryForValidation() 
    {
        String query = "SELECT Id, Active, Description, EntityDefinitionId, ErrorDisplayField, ErrorMessage, ValidationName FROM ValidationRule";
        return queryTooling(query);
        
    }

    public String queryForTriggers(){
        String query = "SELECT Id, Name, TableEnumOrId FROM ApexTrigger";
        return querySalesforce(query);
    }
}
