package com.vttp.springsecurity.jwt;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;

import io.cucumber.spring.CucumberContextConfiguration;

@SpringBootTest (webEnvironment = WebEnvironment.DEFINED_PORT)
@CucumberContextConfiguration
public class CucumberSpringContextConfig {
    
}
