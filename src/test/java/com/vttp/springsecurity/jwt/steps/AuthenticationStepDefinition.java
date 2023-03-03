package com.vttp.springsecurity.jwt.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Map;

import com.vttp.springsecurity.jwt.common.HttpContext;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

// import io.cucumber.java.en.Then;

public class AuthenticationStepDefinition {

    private final HttpContext context;

    public AuthenticationStepDefinition(HttpContext httpContext) {
        context = httpContext;
    }

    @Given("a client undergoes authentication")
    public void a_client_register_to_the_api(Map<String, String> user) {

        context.request = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(user);
    }

    @Then("response body property {word} with value: {word}")
    public void response_body_property_with_value(String property, String value) {
        
        String actualResponse = context.response.getBody().asString();

        String token = "Bearer " + JsonPath.from(actualResponse).get("token").toString();
        context.data.put("token", token);

        String uid = JsonPath.from(actualResponse).get("userId").toString();
        context.data.put("userId", uid);

        System.out.println(actualResponse);
        assertEquals(value, JsonPath.from(actualResponse).get(property));
    }

}
