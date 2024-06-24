package com.example.salesfox.util.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.salesfox.salesforce.service.ConnectionService;

@RestController
public class EndPointController 
{
    @GetMapping("/api/greeting")
    public String greeting() 
    {
        ConnectionService conectionservice = new ConnectionService();
        String access_token = conectionservice.accessToken;
        System.out.println("Access Token::: " + access_token);
        return access_token;
    }

    @PostMapping("/api/account")
    public String insertAccount() 
    {

        return "Account";
    }
}
