package com.example.salesfox.salesforce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.salesfox.salesforce.service.SalesforceService;

@RestController
@RequestMapping("/api")
public class SalesforceContoller {
    
    @Autowired
    private SalesforceService salesforceService;

    @GetMapping("/query")
    public String query() 
    {
        String soql = "SELECT Id, Name FROM Account";
        return salesforceService.querySalesforce(soql);
    }
}
