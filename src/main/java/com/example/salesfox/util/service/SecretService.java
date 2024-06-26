package com.example.salesfox.util.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SecretService {
    
    @Value("${app.username:built-in-user@com}")
    private String username;

    @Value("${app.password:built-in-password}")
    private String password;

    @Value("${app.client_id:built-in-client-id}")
    private String client_id;

    @Value("${app.client_secret:built-in-client-secret}")
    private String client_secret;

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
