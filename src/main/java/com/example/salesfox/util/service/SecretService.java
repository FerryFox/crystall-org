package com.example.salesfox.util.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SecretService {
    
    @Value("${app.username:defaultName}")
    private String username;

    @Value("${app.password:defaultPassword}")
    private String password;

    @Value("${app.client_id:defaultId}")
    private String client_id;

    @Value("${app.client_secret:defaultSecret}")
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
