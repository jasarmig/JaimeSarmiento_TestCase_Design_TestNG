package org.espn.tests;

import org.espn.reporting.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Logout extends BaseTests {

    @BeforeMethod
    public void login(){
        Reporter.info("Click on Login Button");
        homepage.clickElement(homepage.getLoginButton());
        Reporter.info("Switching to iFrame");
        driver.getDriver().switchTo().frame(homepage.getiFrame());
        Reporter.info("User email input");
        homepage.typeOfInput(homepage.getUserHandle(), "je.sarmiento+2@globant.com");
        Reporter.info("User password input");
        homepage.typeOfInput(homepage.getUserPass(), "pop1280c");
        Reporter.info("Loging in");
        homepage.clickElement(homepage.getSubmit());
    }
    @Test
    public void logoutTest() {
        homepage.waitForVisibility(homepage.getUserMenu());
        homepage.waitForClickable(homepage.getUserMenu());
        homepage.placeMouseOn(homepage.getUserMenu());
        homepage.clickElement(homepage.getLogout());
        homepage.waitForVisibility(homepage.getUserMenu());
        homepage.waitForClickable(homepage.getUserMenu());
        homepage.placeMouseOn(homepage.getUserMenu());
    }
}
