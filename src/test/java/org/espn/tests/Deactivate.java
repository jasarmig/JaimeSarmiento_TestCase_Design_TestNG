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
        homepage.clickElement(homepage.getElement("loginButton"));
        Reporter.info("Switching to iFrame");
        driver.getDriver().switchTo().frame(homepage.getElement("iFrame"));
        Reporter.info("User email input");
        homepage.typeOfInput(homepage.getElement("userHandle"), "je.sarmiento+6@globant.com");
        Reporter.info("User password input");
        homepage.typeOfInput(homepage.getElement("userPass"), "pop1280c");
        Reporter.info("Loging in");
        homepage.clickElement(homepage.getElement("loginSubmit"));
        homepage.waitForVisibility(homepage.getElement("userMenu"));
        homepage.waitForClickable(homepage.getElement("userMenu"));
        homepage.placeMouseOn(homepage.getElement("userMenu"));
    }

    @Test
    public void deactivate(){
        homepage.waitForClickable(homepage.getElement("profile"));
        homepage.clickElement(homepage.getElement("profile"));
        Reporter.info("Switching to iFrame");
        driver.getDriver().switchTo().frame(homepage.getElement("iFrame"));
        homepage.clickElement(homepage.getElement("deleteAccount"));
        homepage.waitForClickable(homepage.getElement("cancel"));
        homepage.clickElement(homepage.getElement("loginSubmit"));
        homepage.waitForClickable(homepage.getElement("error"));
        homepage.clickElement(homepage.getElement("loginSubmit"));
    }
}
