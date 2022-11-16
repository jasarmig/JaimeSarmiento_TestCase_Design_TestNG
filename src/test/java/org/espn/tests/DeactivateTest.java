package org.espn.tests;

import org.espn.reporting.Reporter;
import org.testng.annotations.*;


import static org.hamcrest.Matchers.is;

public class DeactivateTest extends BaseTests {

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


    @Parameters({"user","pass"})
    @Test(priority = 1)
    public void deactivate(String user, String pass){
        homepage.waitForClickable(homepage.getProfileBtn());
        homepage.clickElement(homepage.getProfileBtn());
        driver.getDriver().switchTo().frame(homepage.getiFrame());
        frame.clickElement(frame.getDeleteAccountLink());
        frame.waitForClickable(frame.getCancel());
        frame.clickElement(frame.getSubmit());
        checkThat("Account has been deleted", frame.getiFrameTitle().getText(), is("Your account has been deleted."));
        frame.waitForClickable(frame.getByErrorLink());
        frame.clickElement(frame.getSubmit());
        driver.getDriver().switchTo().defaultContent();
        homepage.clickElement(homepage.getLoginButton());
        driver.getDriver().switchTo().frame(homepage.getiFrame());
        frame.typeOfInput(frame.getUsername(), user);
        frame.typeOfInput(frame.getUserPass(), pass);
        frame.clickElement(frame.getSubmit());
        checkThat("Account has been deactivated", frame.getiFrameTitle().getText(), is("Account Deactivated"));
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
