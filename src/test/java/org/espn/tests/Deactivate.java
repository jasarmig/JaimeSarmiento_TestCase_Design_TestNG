package org.espn.tests;

import org.espn.config.Driver;
import org.espn.reporting.Reporter;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Deactivate extends BaseTests {

    @BeforeMethod
    public void login(){
        Reporter.info("Click on Login Button");
        homepage.clickElement(homepage.getLoginButton());
        Reporter.info("Switching to iFrame");
        driver.getDriver().switchTo().frame(homepage.getiFrame());
        Reporter.info("User email input");
        homepage.typeOfInput(homepage.getUserHandle(), "je.sarmiento+6@globant.com");
        Reporter.info("User password input");
        homepage.typeOfInput(homepage.getUserPass(), "pop1280c");
        Reporter.info("Loging in");
        homepage.clickElement(homepage.getSubmit());
        homepage.waitForVisibility(homepage.getUserMenu());
        homepage.waitForClickable(homepage.getUserMenu());
        homepage.placeMouseOn(homepage.getUserMenu());
    }

    @Test
    public void deactivate(){
        homepage.waitForClickable(homepage.getProfile());
        homepage.clickElement(homepage.getProfile());
        Reporter.info("Switching to iFrame");
        driver.getDriver().switchTo().frame(homepage.getiFrame());
        homepage.clickElement(homepage.getDeleteAccountLink());
        homepage.waitForClickable(homepage.getCancel());
        homepage.clickElement(homepage.getSubmit());
        homepage.waitForClickable(homepage.getByError());
        homepage.clickElement(homepage.getSubmit());
    }
}
