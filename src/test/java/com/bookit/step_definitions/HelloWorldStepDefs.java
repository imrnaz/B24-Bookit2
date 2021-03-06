package com.bookit.step_definitions;

import com.bookit.utilities.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import javax.security.auth.login.Configuration;

import static io.restassured.RestAssured.*;

public class HelloWorldStepDefs {
    Response response;
    @Given("User sends get request to hello world api")
    public void user_sends_get_request_to_hello_world_api() {

        response = given().accept(ContentType.JSON)
                .when().get(ConfigurationReader.getProperty("hello.world.api"));
    }

    @Then("status code is {int}")
    public void status_code_is(int status) {

        assertEquals(status,response.statusCode());

    }

    @And("response body contains {string}")
    public void response_body_contains(String HelloWorld) {

        assertEquals(HelloWorld,response.body().path("message"));
    }

}
