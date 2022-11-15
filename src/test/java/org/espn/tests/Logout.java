package org.espn.tests;

import org.espn.reporting.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.is;

public class Logout extends BaseTests {

    @BeforeMethod
    @Parameters({"user","pass"})
    public void login(String user, String pass){
        homepage.clickElement(homepage.getLoginButton());
        driver.getDriver().switchTo().frame(homepage.getiFrame());
        homepage.typeOfInput(homepage.getUsername(), user);
        homepage.typeOfInput(homepage.getUserPass(), pass);
        homepage.clickElement(homepage.getSubmit());
        Reporter.info("User is logged in");
    }
    @Test
    public void logoutTest() {
        homepage.placeMouseOn(homepage.getUserMenu());
        homepage.waitForVisibility(homepage.getUserName());
        homepage.waitForClickable(homepage.getLogoutBtn());
        checkThat("Username is present in menu", homepage.getUserName().getText(), is("WelcomeJaime!"));
        homepage.clickElement(homepage.getLogoutBtn());
        Reporter.info("User is logged out");
        driver.getDriver().navigate().refresh();
        homepage.placeMouseOn(homepage.getUserMenu());
        checkThat("Username is not present in menu", homepage.getUserName().getText(), is("Welcome!"));
    }
}
