package com.example.salesfox.util.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EndPointController 
{
    @GetMapping("/api/greeting")
    public String greeting() 
    {
        return "Hello from Spring Boot!";
    }
    
}
