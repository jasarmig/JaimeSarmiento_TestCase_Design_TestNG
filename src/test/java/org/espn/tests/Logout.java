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
        homepage.typeOfInput(homepage.getUsername(), "je.sarmiento+8@globant.com");
        homepage.typeOfInput(homepage.getUserPass(), "pop1280c");
        homepage.clickElement(homepage.getSubmit());
        Reporter.info("User is logged in");
    }
    @Test
    public void logoutTest() {
        homepage.placeMouseOn(homepage.getUserMenu());
        homepage.clickElement(homepage.getLogoutBtn());
        driver.getDriver().navigate().refresh();
        homepage.placeMouseOn(homepage.getUserMenu());
        checkThat("Username is not present in menu", homepage.getUserName().getText(), is("Welcome!"));
    }
}
