package com.example.salesfox.salesforce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.salesfox.salesforce.model.CountObject;
import com.example.salesfox.salesforce.model.Describe;
import com.example.salesfox.salesforce.service.MetaService;
import com.example.salesfox.salesforce.service.SalesforceEventService;
import com.example.salesfox.salesforce.service.SalesforceService;
import com.example.salesfox.util.model.ServiceResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
public class SalesforceController {

    @Autowired
    private final SalesforceService salesforceService;

    @Autowired
    private final MetaService metaService;

    @Autowired
    private final SalesforceEventService eventService;

    public SalesforceController(SalesforceService salesforceService, MetaService metaService, SalesforceEventService eventService) {
        this.metaService = metaService;
        this.salesforceService = salesforceService;
        this.eventService = eventService;
    }
    
    @GetMapping("/api/search")
    public String insertAccount(@RequestParam("text") String query) 
    {
        return salesforceService.querySalesforce(query);
    }

    @GetMapping("/api/meta")
    public ServiceResponse<Describe> getMetadata() throws JsonMappingException, JsonProcessingException 
    {
        return metaService.getMetadata();
    }

    
    @GetMapping("/api/validations")
    public String getValidationList() {
        return metaService.queryForValidation();
        
    }

    @GetMapping("/api/count")
    public ServiceResponse<List<CountObject>> getCount() {
        return salesforceService.countAllRecords();
    }

    @GetMapping("/api/trigger")
    public String getTriggersInformation() {
        return metaService.queryForTriggers();
    }

    @GetMapping("/api/events")
    public String getEventsInformation() {
         return eventService.createEvent();   
    }
}
