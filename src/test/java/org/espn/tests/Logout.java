package org.espn.tests;

import org.espn.reporting.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Logout extends BaseTests {

    @BeforeMethod
    public void login(){
        Reporter.info("Click on Login Button");
        homepage.clickElement(homepage.getElement("loginButton"));
        Reporter.info("Switching to iFrame");
        driver.getDriver().switchTo().frame(homepage.getElement("iFrame"));
        Reporter.info("User email input");
        homepage.typeOfInput(homepage.getElement("userHandle"), "je.sarmiento+2@globant.com");
        Reporter.info("User password input");
        homepage.typeOfInput(homepage.getElement("userPass"), "pop1280c");
        Reporter.info("Loging in");
        homepage.clickElement(homepage.getElement("loginSubmit"));
    }
    @Test
    public void logoutTest() {
        homepage.waitForVisibility(homepage.getElement("userMenu"));
        homepage.waitForClickable(homepage.getElement("userMenu"));
        homepage.placeMouseOn(homepage.getElement("userMenu"));
        homepage.clickElement(homepage.getElement("logout"));
        homepage.waitForVisibility(homepage.getElement("userMenu"));
        homepage.waitForClickable(homepage.getElement("userMenu"));
        homepage.placeMouseOn(homepage.getElement("userMenu"));
    }
}
