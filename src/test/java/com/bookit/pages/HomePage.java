package com.bookit.pages;

import com.bookit.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{


    @FindBy(linkText = "my")
    public WebElement me;

    @FindBy(linkText = "self")
    public WebElement self;

    @FindBy(linkText = "hunt")
    public WebElement hunt;

    public void gotoSelf(){
        BrowserUtils.hover(me);
        self.click();
    }


}
