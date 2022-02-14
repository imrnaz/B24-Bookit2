package com.bookit.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import java.util.Map;

public class AddNewStudentStepDefs {



    @When("Users sends post request to {string} with following info:")
    public void users_sends_post_request_to_with_following_info(String path, Map<String,Object> dataTable) {

       given().accept(ContentType.JSON)
                .and().body(dataTable)
                .when().post(path)
                .then().assertThat().statusCode(201);

        System.out.println(dataTable);


    }

    @Then("User deletes previously created student")
    public void user_deletes_previously_created_student() {

    }
}
