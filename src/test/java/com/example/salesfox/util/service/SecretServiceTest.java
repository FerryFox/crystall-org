package com.example.salesfox.util.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class SecretServiceTest {

    @Autowired
    private SecretService secretService;

    @Test
    public void testGetSecret() {
        assertEquals("nameDummy@com", secretService.getUsername());
        assertEquals("passwordDummy", secretService.getPassword());
        assertEquals("SWAGGERId", secretService.getClient_id());
        assertEquals("SWAGGERSecret", secretService.getClient_secret());
        assertEquals("nameDummy@com".split("@")[0], secretService.getName());
    }   
}
