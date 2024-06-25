package com.example.salesfox.util.controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EndPointController 
{
    @Value("${my.variable}")
    private String myVariable;

    @GetMapping("/api/greeting")
    public String greeting() 
    {
        return myVariable;
    }
}
