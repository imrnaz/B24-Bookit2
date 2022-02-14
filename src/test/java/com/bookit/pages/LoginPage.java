package com.bookit.pages;

import com.bookit.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    @FindBy(xpath = "//input[@name = 'email']")
    public WebElement email;


    @FindBy(xpath = "//input[@name = 'password']")
    public WebElement password;


    @FindBy(xpath = "//button[.='sign in']")
    public WebElement signInBtn;

    public void signIn(String emailAdd, String passwordAdd){

        email.sendKeys(emailAdd);
        password.sendKeys(passwordAdd);
        signInBtn.click();
    }
}
