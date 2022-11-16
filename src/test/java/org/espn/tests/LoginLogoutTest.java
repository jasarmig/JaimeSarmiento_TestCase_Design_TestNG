package org.espn.tests;

import org.espn.reporting.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.is;

public class LoginLogoutTest extends BaseTests {

    @Parameters({"user","pass"})
    @Test
    public void loginTest(String user,String pass){
        homepage.clickElement(homepage.getLoginButton());
        driver.getDriver().switchTo().frame(homepage.getiFrame());
        checkThat("ESPN logo is displayed", frame.getLogo().isDisplayed(), is(true));
        checkThat("User email input is displayed", frame.getSubmit().isDisplayed(), is(true));
        checkThat("Password input is displayed", frame.getCreate().isDisplayed(), is(true));
        frame.typeOfInput(frame.getUsername(), user);
        frame.typeOfInput(frame.getUserPass(), pass );
        frame.clickElement(frame.getSubmit());
        Reporter.info("User is logged in");
    }

    @Test(priority = 1)
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

    @BeforeClass
    @Parameters({"testName"})
    public void printInitMsg(String testName){
        Reporter.info(testName + " initiated");
    }

    @AfterClass
    @Parameters({"testName"})
    public void printEndMsg(String testName){
        Reporter.info(testName + " finalized");
    }
}