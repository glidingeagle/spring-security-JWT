package com.vttp.springsecurity.jwt.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import com.vttp.springsecurity.jwt.CucumberSpringContextConfig;
// import com.vttp.springsecurity.jwt.utility.config.AuthenticationToken;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TriedUpStepDefinition extends CucumberSpringContextConfig{
    
    // private RequestSpecification request;
    // private Response response;

    // // private String token;
    // // private AuthenticationToken authenticationToken;
    
    // @Given("a client register to the API")
    // @Given("a client undergoes authentication")
    // public void a_client_register_to_the_api(Map<String, String> user) {

    //     //String json = new ObjectMapper().writeValueAsString(user);

    //     // if (user.get("userId") != null && user.get("userId") != "")
    //     //     cardholder.setUserId(user.get("userId"));
    //     // cardholder.setUsername(user.get("username"));
    //     // cardholder.setFirstName(user.get("firstName"));
    //     // cardholder.setLastName(user.get("lastName"));
    //     // cardholder.setEmail(user.get("email"));
    //     // cardholder.setPassword(user.get("password"));

    //     request = RestAssured.given()
    //             .header("Content-Type", "application/json")
    //             .body(user);
    // }

    // @Given("a client has a token for login")
    // public void a_client_has_a_token_for_login () {
        
    //     String token = "Bearer " + "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJmcmVkQGdtYWlsLmNvbSIsImV4cCI6MTY3MTQyNDkzMywiaWF0IjoxNjcxNDIxMzMzfQ.MjRO6-ZS0fA3E0U1sgTnWQUkwUoXX2UmerttQcKTVqRg16ggHDkmblyVyEQoybcD6x7p2khq8gN11x8LxPdnXw";

    //     request = RestAssured.given()
    //             .header("Content-Type", "application/json")
    //             .header("Authorization", token)
    //             .header("Accept", "application/json");
    // }

    // // @When("API receives request at {httpMethod} {word} endpoint")
    // @When("API receives request at {word} {word} endpoint")
    // public void api_receives_request_at_post_endpoint(String method, String endpoint) {
    //     // Write code here that turns the phrase above into concrete actions
    //     // response = request.post(endpoint);

    //     switch (method) {
    //         case "POST":
    //             response = request.post(endpoint);
    //             return;
    //         case "GET":
    //             response = request.get(endpoint);
    //             return;
    //     }
    //     // given()
    //     //     .header("Content-Type", "application/json")
    //     //     .body(client).
    //     // when().
    //     //     post("http://localhost:12345/" + endpoint).
    //     // then().
    //     //     contentType(ContentType.JSON);
    // }

    // @Then("the response has:")
    // public void skip() {}

    // @Then("http status: {int}")
    // public void http_status(int code) {
    //     response.then().statusCode(code);
    // }

    // @Then("response body message as {string}")
    // public void response_body_message_as (String message) {

    //     String actualResponse = response.getBody().asString();

    //     System.out.println(actualResponse);
    //     assertTrue(actualResponse.contains(message));
    // }

    // @Then("response body property {word} with value: {word}")
    // public void response_body_property_with_value(String property, String value) {
        
    //     String actualResponse = response.getBody().asString();

    //     // String tkn = "Bearer " + JsonPath.from(actualResponse).get("token").toString();
    //     // authenticationToken.setToken(tkn);

    //     // String uid = JsonPath.from(actualResponse).get("userId");
    //     // authenticationToken.setUserId(uid);

    //     System.out.println(actualResponse);
    //     assertEquals(value, JsonPath.from(actualResponse).get(property));
    // }
}

//https://www.youtube.com/playlist?list=PLhJTa4U57yUsc2xuxb7zHKMyJ2fnjgvGV
//https://www.youtube.com/playlist?list=PL6tu16kXT9PpgqfMbMdzUzDenYgb0gbk0
//https://medium.com/codex/bdd-testing-with-cucumber-junit-5-fb5a1c4354f9 
//https://github.com/wenqiglantz/customer-service 
//https://www.toolsqa.com/cucumber/junit-test-runner-class/ 
//https://palashray.com/example-of-creating-cucumber-based-bdd-tests-using-junit5-and-spring-dependency-injection/
//https://github.com/paawak/spring-boot-demo/tree/master/cucumber/cucumber-with-junit5-spring
