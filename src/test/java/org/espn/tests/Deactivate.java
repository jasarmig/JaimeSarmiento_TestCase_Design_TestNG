package org.espn.tests;

import org.espn.config.Driver;
import org.espn.reporting.Reporter;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static java.lang.String.format;

public class Deactivate extends BaseTests {

    @BeforeMethod
    public void login(){
        homepage.clickElement(homepage.getLoginButton());
        driver.getDriver().switchTo().frame(homepage.getiFrame());
        homepage.typeOfInput(homepage.getUserHandle(), "je.sarmiento+6@globant.com");
        homepage.typeOfInput(homepage.getUserPass(), "pop1280c");
        homepage.clickElement(homepage.getSubmit());
        Reporter.info("User is logged in");
        homepage.waitForVisibility(homepage.getUserMenu());
        homepage.waitForClickable(homepage.getUserMenu());
        homepage.placeMouseOn(homepage.getUserMenu());
    }

    @Test
    public void deactivate(){
        homepage.waitForClickable(homepage.getProfile());
        homepage.clickElement(homepage.getProfile());
        driver.getDriver().switchTo().frame(homepage.getiFrame());
        homepage.clickElement(homepage.getDeleteAccountLink());
        homepage.waitForClickable(homepage.getCancel());
        homepage.clickElement(homepage.getSubmit());
        homepage.waitForClickable(homepage.getByError());
        homepage.clickElement(homepage.getSubmit());
    }
}
