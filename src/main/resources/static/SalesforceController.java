package com.example.salesfox.salesforce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.salesfox.salesforce.service.SalesforceService;

@RestController
public class SalesforceController {

    @Autowired
    private final SalesforceService salesforceService;

    public SalesforceController(SalesforceService salesforceService) {
        this.salesforceService = salesforceService;
    }
    
    @GetMapping("/api/search")
    public String insertAccount(@RequestParam("text") String query) 
    {
        return salesforceService.querySalesforce(query);
    }
}
