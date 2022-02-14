package com.bookit.step_definitions;

import com.bookit.pages.SelfPage;
import com.bookit.utilities.BookItApiUtil;

import com.bookit.utilities.Environment;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.Map;

import static org.junit.Assert.*;

import static io.restassured.RestAssured.*;

public class ApiStepDefs {

    String accessToken;
    Response response;

    @Given("User logged in BookIt api as teacher role")
    public void user_logged_in_BookIt_api_as_teacher_role() {

      accessToken =  BookItApiUtil.getAccessToken(Environment.TEACHER_EMAIL,Environment.TEACHER_PASSWORD);
        System.out.println("Teacher email = " + Environment.TEACHER_EMAIL);
        System.out.println("Teacher password = " + Environment.TEACHER_PASSWORD);
    }

    @And("User sends request to {string}")
    public void user_sends_request_to(String path) {

      response =  given().accept(ContentType.JSON)
                .and().header("Authorization",accessToken)
                .when().get(Environment.BASE_URL + path);

        System.out.println("API Endpoint = " + Environment.BASE_URL + path);

    }

    @Then("status code should be {int}")
    public void status_code_should_be(int expStatusCode) {

       assertEquals(expStatusCode,response.statusCode());
    }

    @And("content type is {string}")
    public void content_type_is(String contentType) {

        assertEquals(contentType,response.contentType());
    }

    @Then("role is {string}")
    public void role_is(String role) {

        Assert.assertEquals(role,response.path("role"));
    }

    @Then("User should see same info on UI and API")
    public void user_should_see_same_info_on_UI_and_API() {

        SelfPage selfPage = new SelfPage();

        Map<String , String > apiUser = response.body().as(Map.class);

        System.out.println(apiUser);

        assertEquals(apiUser.get("firstName"),selfPage.fullName.getText().split(" ")[0]);
        assertEquals(apiUser.get("role"),selfPage.role.getText());
    }

}
