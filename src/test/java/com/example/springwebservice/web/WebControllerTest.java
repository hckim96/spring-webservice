package com.example.springwebservice.web;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class WebControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void mainPageTest() {
        String body = restTemplate.getForObject("/", String.class);

        assertTrue(body.contains("spring-webservice"));
    }

}