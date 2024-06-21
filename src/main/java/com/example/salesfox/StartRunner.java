package com.example.salesfox;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.salesfox.salesforce.service.SalesforceService;

@Component
public class StartRunner implements CommandLineRunner
{
    @Autowired
    private SalesforceService salesforceService;

    @Override
    public void run(String ...args) throws Exception 
    {

    }
}
