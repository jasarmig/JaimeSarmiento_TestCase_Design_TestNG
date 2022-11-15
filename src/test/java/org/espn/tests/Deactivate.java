package org.espn.tests;

import org.espn.reporting.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import static org.hamcrest.Matchers.is;

public class Deactivate extends BaseTests {

    @BeforeMethod
    public void login(){
        homepage.clickElement(homepage.getLoginButton());
        driver.getDriver().switchTo().frame(homepage.getiFrame());
        homepage.typeOfInput(homepage.getUsername(), "je.sarmiento+8@globant.com");
        homepage.typeOfInput(homepage.getUserPass(), "pop1280c");
        homepage.clickElement(homepage.getSubmit());
        Reporter.info("User is logged in");
        homepage.waitForVisibility(homepage.getUserMenu());
        homepage.waitForClickable(homepage.getUserMenu());
        homepage.placeMouseOn(homepage.getUserMenu());
    }

    @Test
    public void deactivate(){
        homepage.waitForClickable(homepage.getProfileBtn());
        homepage.clickElement(homepage.getProfileBtn());
        driver.getDriver().switchTo().frame(homepage.getiFrame());
        homepage.clickElement(homepage.getDeleteAccountLink());
        homepage.waitForClickable(homepage.getCancel());
        homepage.clickElement(homepage.getSubmit());
        checkThat("Account has been deleted", homepage.getiFrameTitle().getText(), is("Your account has been deleted."));
        homepage.waitForClickable(homepage.getByErrorLink());
        homepage.clickElement(homepage.getSubmit());
        driver.getDriver().switchTo().defaultContent();
        homepage.clickElement(homepage.getLoginButton());
        driver.getDriver().switchTo().frame(homepage.getiFrame());
        homepage.typeOfInput(homepage.getUsername(), "je.sarmiento+8@globant.com");
        homepage.typeOfInput(homepage.getUserPass(), "pop1280c");
        homepage.clickElement(homepage.getSubmit());
        checkThat("Account has been deactivated", homepage.getiFrameTitle().getText(), is("Account Deactivated"));
    }
}
