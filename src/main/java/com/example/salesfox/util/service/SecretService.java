package com.example.salesfox.util.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SecretService {
    
    private String username;
    private String password;
    private String client_id;
    private String client_secret;

    @Value("${spring.profiles.active}")
    private String activeProfile;

    @Value("${app.username}")
    private String propUsername;

    @Value("${app.password}")
    private String propPassword;

    @Value("${app.client_id}")
    private String propClientId;

    @Value("${app.client_secret}")
    private String propClientSecret;

    Boolean isLoaded = false;

    public String getUsername() {
        checkData();
        return username;
    }

    public String getPassword() {
        checkData();
        return password;
    }

    public String getClient_id() {
        checkData();
        return client_id;
    }

    public String getClient_secret() {
        checkData();
        return client_secret;
    }

    public String getName() {
        checkData();
        String name = username.split("@")[0];
        return name;
    }

    private void loadDataFromHerokuEnv(){
        System.out.println("Loading data from Heroku environment variables");
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

    private void loadDataFromProperties(){
        System.out.println("Loading data from application.yml");
        username = propUsername;
        password = propPassword;
        client_id = propClientId;
        client_secret = propClientSecret;
    }

    private void checkData(){
        if(isLoaded == false) {
            if("prod".equals(activeProfile)) loadDataFromHerokuEnv();
            else loadDataFromProperties();
            isLoaded = true;
        }    
    }
}
