package com.example.salesfox.insert.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.salesfox.salesforce.service.SalesforceService;
import com.example.salesfox.util.model.ServiceResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CaseController 
{
    @Autowired
    private final SalesforceService salesforceService;

    @PostMapping("/api/case/create")
    public ResponseEntity<ServiceResponse<String>> createCase(@RequestBody String jsonPayload) 
    {
        ServiceResponse<String> serviceResponse = salesforceService.insertNewCase(jsonPayload);
        if (serviceResponse.isSuccess()) return ResponseEntity.ok(serviceResponse);
        return ResponseEntity.badRequest().body(serviceResponse);
    }
}
