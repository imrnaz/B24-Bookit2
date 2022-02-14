package com.bookit.step_definitions;

import com.bookit.pages.HomePage;
import com.bookit.pages.LoginPage;
import com.bookit.pages.SelfPage;
import com.bookit.utilities.Driver;
import com.bookit.utilities.Environment;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class UIStepDefs {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    SelfPage selfPage = new SelfPage();
    @And("Given user logged in to BookIt app as teacher role")
    public void given_user_logged_in_to_BookIt_app_as_teacher_role() {

        Driver.getDriver().get(Environment.URL);

        loginPage.signIn(Environment.TEACHER_EMAIL,Environment.TEACHER_PASSWORD);
    }

    @And("user is on self page")
    public void user_is_on_self_page() {

        homePage.gotoSelf();

    }


}
