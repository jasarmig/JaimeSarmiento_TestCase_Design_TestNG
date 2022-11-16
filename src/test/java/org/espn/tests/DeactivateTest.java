package org.espn.tests;

import org.espn.reporting.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import static org.hamcrest.Matchers.is;

public class DeactivateTest extends BaseTests {

    @BeforeMethod
    @Parameters({"user","pass"})
    public void login(String user, String pass){
        homepage.clickElement(homepage.getLoginButton());
        driver.getDriver().switchTo().frame(homepage.getiFrame());
        homepage.typeOfInput(frame.getUsername(), user);
        homepage.typeOfInput(frame.getUserPass(), pass);
        homepage.clickElement(frame.getSubmit());
        Reporter.info("User is logged in");
        homepage.placeMouseOn(homepage.getUserMenu());
    }

    @Test
    @Parameters({"user","pass"})
    public void deactivate(String user, String pass){
        homepage.waitForClickable(homepage.getProfileBtn());
        homepage.clickElement(homepage.getProfileBtn());
        driver.getDriver().switchTo().frame(homepage.getiFrame());
        homepage.clickElement(frame.getDeleteAccountLink());
        homepage.waitForClickable(frame.getCancel());
        homepage.clickElement(frame.getSubmit());
        checkThat("Account has been deleted", frame.getiFrameTitle().getText(), is("Your account has been deleted."));
        homepage.waitForClickable(frame.getByErrorLink());
        homepage.clickElement(frame.getSubmit());
        driver.getDriver().switchTo().defaultContent();
        homepage.clickElement(homepage.getLoginButton());
        driver.getDriver().switchTo().frame(homepage.getiFrame());
        homepage.typeOfInput(frame.getUsername(), user);
        homepage.typeOfInput(frame.getUserPass(), pass);
        homepage.clickElement(frame.getSubmit());
        checkThat("Account has been deactivated", frame.getiFrameTitle().getText(), is("Account Deactivated"));
    }
}
