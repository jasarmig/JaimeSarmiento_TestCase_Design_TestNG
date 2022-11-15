package org.espn.tests;

import org.espn.reporting.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.is;

public class Logout extends BaseTests {

    @BeforeMethod
    public void login(){
        homepage.clickElement(homepage.getLoginButton());
        driver.getDriver().switchTo().frame(homepage.getiFrame());
        homepage.typeOfInput(homepage.getUserHandle(), "je.sarmiento+7@globant.com");
        homepage.typeOfInput(homepage.getUserPass(), "Ailatan9843");
        homepage.clickElement(homepage.getSubmit());
        Reporter.info("User is logged in");
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
        checkThat("Username is not present in menu", homepage.getUserName().getText(), is(""));
    }
}
