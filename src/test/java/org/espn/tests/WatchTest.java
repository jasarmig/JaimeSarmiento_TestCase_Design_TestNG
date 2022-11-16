package org.espn.tests;


import org.espn.pages.Watch;
import org.espn.reporting.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static java.lang.String.format;
import static org.hamcrest.Matchers.is;

public class WatchTest extends BaseTests {

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


    @Parameters({"url"})
    @Test(priority = 1)
    public void watchTest(String url){
        Reporter.info("Navigating to Watch page");
        homepage.clickElement(homepage.getWatchButton());
        watch = new Watch(driver.getDriver());
        checkThat("At least one carousel is present", watch.getTileContent().isDisplayed(), is(true));
        Reporter.info("Carousel is present");
        watch.clickElement(watch.getSecondElement());
        watch.waitForVisibility(watch.getWatchLightbox());
        watch.waitForClickable(watch.getClosePopupBtn());
        checkThat("Check X button is present",watch.getClosePopupBtn().isDisplayed(),is(true));
        watch.clickElement(watch.getClosePopupBtn());
        Reporter.info("Lightbox closed");
        Reporter.info(format("Navigating to %s", url));
        driver.getDriver().navigate().back();
    }

    @Test(priority = 2)
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
