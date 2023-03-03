package com.vttp.springsecurity.jwt.steps;

import java.util.Map;

import com.vttp.springsecurity.jwt.CucumberSpringContextConfig;
import com.vttp.springsecurity.jwt.common.HttpContext;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;

public class SignUpStepDefinition extends CucumberSpringContextConfig{

    private final HttpContext context;

    public SignUpStepDefinition(HttpContext httpContext) {
        context = httpContext;
    }
    
    @Given("a client register to the API")
    public void a_client_register_to_the_api(Map<String, String> user) {

        //String json = new ObjectMapper().writeValueAsString(user);

        // if (user.get("userId") != null && user.get("userId") != "")
        //     cardholder.setUserId(user.get("userId"));
        // cardholder.setUsername(user.get("username"));
        // cardholder.setFirstName(user.get("firstName"));
        // cardholder.setLastName(user.get("lastName"));
        // cardholder.setEmail(user.get("email"));
        // cardholder.setPassword(user.get("password"));

        context.request = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(user);
    }
}
