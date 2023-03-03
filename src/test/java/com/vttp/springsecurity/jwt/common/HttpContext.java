package com.vttp.springsecurity.jwt.common;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Configuration;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Configuration
public class HttpContext {
    
    public RequestSpecification request;

    public Response response;

    public Map<String, String> data = new HashMap<>();
}
