package com.example.salesfox.util.service;

import org.springframework.stereotype.Service;

@Service
public class SecretService {
    
    private String username;

    private String password;

    private String client_id;

    private String client_secret;

    public SecretService() 
    {
        System.getenv().forEach((k, v) -> {
            if (k.equals("USERNAME")) {
                username = v;
            } else if (k.equals("PASSWORD")) {
                password = v;
            } else if (k.equals("CLIENT_ID")) {
                client_id = v;
            } else if (k.equals("CLIENT_SECRET")) {
                client_secret = v;
            }
        });
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getClient_id() {
        return client_id;
    }

    public String getClient_secret() {
        return client_secret;
    }

    public String getName() {
        String name = username.split("@")[0];
        return name;
    }

}
