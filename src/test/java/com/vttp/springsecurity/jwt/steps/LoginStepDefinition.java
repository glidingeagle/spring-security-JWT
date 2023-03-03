package com.vttp.springsecurity.jwt.steps;

import com.vttp.springsecurity.jwt.common.HttpContext;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginStepDefinition {

    private final HttpContext context;
    
    public LoginStepDefinition(HttpContext httpContext) {
        context = httpContext;
    }

    @Given("a client has a token for login")
    public void a_client_has_a_token_for_login () {

        context.request = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Authorization", context.data.get("token").toString())
                .header("Accept", "application/json");
    }

    @Given ("a client uses a fabricated {string} for login")
    public void a_client_uses_a_fabricated_token_for_login (String token) {

        context.request = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Authorization", token)
                .header("Accept", "application/json");
    }
}

// https://www.youtube.com/watch?v=TyKYvhtZaXM
// https://www.youtube.com/playlist?list=PL6tu16kXT9PpgqfMbMdzUzDenYgb0gbk0
// https://github.com/executeautomation/restassured