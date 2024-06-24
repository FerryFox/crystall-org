package com.example.salesfox.salesforce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.salesfox.salesforce.service.SalesforceService;

@RestController
public class AccountController {

    @Autowired
    private final SalesforceService salesforceService;

    public AccountController(SalesforceService salesforceService) {
        this.salesforceService = salesforceService;
    }
    
    @GetMapping("/api/insert")
    public String insertAccount() 
    {
        return salesforceService.insertAccount();
    }
}
