package com.example.salesfox.util.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.salesfox.util.service.SecretService;

@RestController
public class EndPointController 
{
    private final SecretService secretService;

    public EndPointController(SecretService secretService) 
    {
        this.secretService = secretService;
    }


    @GetMapping("/api/greeting")
    public String greeting() 
    {
        return "Hello, World! From Avenir Suisse!";
    }

    @GetMapping("/api/secret")
    public String secret() 
    {
        return secretService.getName(); 
    }
}
