package com.vttp.springsecurity.jwt.steps;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.vttp.springsecurity.jwt.common.HttpContext;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CommonStepDefintion {

    private final HttpContext context;

    public CommonStepDefintion(HttpContext httpContext) {
        context = httpContext;
    }
    
    // @When("API receives request at {httpMethod} {word} endpoint")
    @When("API receives request at {word} {word} endpoint")
    public void api_receives_request_at_post_endpoint(String method, String endpoint) {
        // Write code here that turns the phrase above into concrete actions
        // response = request.post(endpoint);

        switch (method) {
            case "POST":
                context.response = context.request.post(endpoint);
                return;
            case "GET":
                context.response = context.request.get(endpoint);
                return;
        }
        // given()
        //     .header("Content-Type", "application/json")
        //     .body(client).
        // when().
        //     post("http://localhost:12345/" + endpoint).
        // then().
        //     contentType(ContentType.JSON);
    }

    @Then("the response has:")
    public void skip() {}

    @Then("http status: {int}")
    public void http_status(int code) {
        context.response.then().statusCode(code);
    }

    @Then("response body message as {string}")
    public void response_body_message_as (String message) {

        String actualResponse = context.response.getBody().asString();

        System.out.println(actualResponse);
        assertTrue(actualResponse.contains(message));
    }
}
