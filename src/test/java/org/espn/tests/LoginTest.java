package org.espn.tests;


import org.espn.pages.Watch;
import org.espn.reporting.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static java.lang.String.format;
import static org.hamcrest.Matchers.is;

public class LoginTest extends BaseTests {

    protected Watch watch;

    @Parameters({"url","user","pass"})
    @Test
    public void loginTest(String url,String user,String pass){
        homepage.clickElement(homepage.getLoginButton());
        driver.getDriver().switchTo().frame(homepage.getiFrame());
        checkThat("ESPN logo is displayed", frame.getLogo().isDisplayed(), is(true));
        checkThat("User email input is displayed", frame.getUsername().isDisplayed(), is(true));
        checkThat("Password input is displayed", frame.getUserPass().isDisplayed(), is(true));
        homepage.typeOfInput(frame.getUsername(), user);
        homepage.typeOfInput(frame.getUserPass(), pass );
        homepage.clickElement(frame.getSubmit());
        Reporter.info("User is logged in");
        Reporter.info("Navigating to Watch page");
        homepage.clickElement(homepage.getWatchButton());
        watch = new Watch(driver.getDriver());
        checkThat("At least one carousel is present", watch.getTileContent().isDisplayed(), is(true));
        Reporter.info("Carousel is present");
        homepage.clickElement(watch.getSecondElement());
        homepage.waitForVisibility(watch.getWatchLightbox());
        homepage.waitForClickable(watch.getClosePopupBtn());
        checkThat("Check X button is present",watch.getClosePopupBtn().isDisplayed(),is(true));
        homepage.clickElement(watch.getClosePopupBtn());
        Reporter.info("Lightbox closed");
        Reporter.info(format("Navigating to %s", url));
        driver.getDriver().navigate().back();
        homepage.placeMouseOn(homepage.getUserMenu());
        homepage.waitForVisibility(homepage.getUserName());
        homepage.waitForClickable(homepage.getLogoutBtn());
        checkThat("Username is present in menu", homepage.getUserName().getText(), is("WelcomeJaime!"));
        homepage.clickElement(homepage.getLogoutBtn());
        Reporter.info("User logged out");
        driver.getDriver().navigate().refresh();
        homepage.placeMouseOn(homepage.getUserMenu());
        checkThat("Username is not present in menu", homepage.getUserName().getText(), is("Welcome!"));
    }
}
