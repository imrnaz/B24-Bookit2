package com.bookit.step_definitions;

import com.bookit.pages.*;
import com.bookit.utilities.BrowserUtils;
import com.bookit.utilities.Driver;
import com.bookit.utilities.Environment;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Map;

public class UIStepDefs {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    SelfPage selfPage = new SelfPage();
    HuntPage huntPage = new HuntPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
    BookingPage bookingPage = new BookingPage();
    @And("Given user logged in to BookIt app as teacher role")
    public void given_user_logged_in_to_BookIt_app_as_teacher_role() {

        Driver.getDriver().get(Environment.URL);

        loginPage.signIn(Environment.TEACHER_EMAIL,Environment.TEACHER_PASSWORD);
    }

    @And("user is on self page")
    public void user_is_on_self_page() {

        homePage.gotoSelf();

    }

    @Given("User logged in to Bookit app as team lead role")
    public void user_logged_in_to_Bookit_app_as_team_lead_role() {
        Driver.getDriver().get(Environment.URL);

        loginPage.signIn(Environment.LEADER_EMAIL,Environment.LEADER_PASSWORD);
        wait.until(ExpectedConditions.urlContains("map"));
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("map"));
    }

    @When("User goes to room hunt page")
    public void user_goes_to_room_hunt_page() {

        homePage.hunt.click();
    }

    @When("User searches for room with date:")
    public void user_searches_for_room_with_date(Map<String,String> reserveInfo){

        huntPage.dateField.sendKeys(reserveInfo.get("date"));
        huntPage.from.sendKeys(reserveInfo.get("from"));
        huntPage.to.sendKeys(reserveInfo.get("to"));
        huntPage.submitBtn.click();
        BrowserUtils.waitFor(5);
        huntPage.submitBtn.click();



        BrowserUtils.waitFor(5);


    }

    @Then("User should see available rooms")
    public void user_should_see_available_rooms() {

        List<String> availableRooms = BrowserUtils.getElementsText(bookingPage.rooms);

        System.out.println("availableRooms = " + availableRooms);

        Assert.assertEquals(7,availableRooms.size());
    }



}
