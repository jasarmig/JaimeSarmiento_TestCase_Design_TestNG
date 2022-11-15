package org.espn.tests;


import org.espn.reporting.Reporter;
import org.slf4j.Logger;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static java.lang.String.format;
import static org.hamcrest.Matchers.is;

public class Login extends BaseTests {

    @Parameters({"url"})
    @Test
    public void loginTest(String url){
        homepage.clickElement(homepage.getLoginButton());
        driver.getDriver().switchTo().frame(homepage.getiFrame());
        checkThat("ESPN logo is displayed", homepage.getLogo().isDisplayed(), is(true));
        checkThat("User email input is displayed", homepage.getUsername().isDisplayed(), is(true));
        checkThat("Password input is displayed", homepage.getUserPass().isDisplayed(), is(true));
        homepage.typeOfInput(homepage.getUsername(), "je.sarmiento+8@globant.com");
        homepage.typeOfInput(homepage.getUserPass(), "pop1280c" );
        homepage.clickElement(homepage.getSubmit());
        Reporter.info("User is logged in");
        Reporter.info("Navigating to Watch page");
        homepage.clickElement(homepage.getWatchButton());
        checkThat("At least one carousel is present", homepage.getTileContent().isDisplayed(), is(true));
        Reporter.info("Carousel is present");
        homepage.clickElement(homepage.getSecondElement());
        homepage.waitForVisibility(homepage.getWatchLightbox());
        homepage.waitForClickable(homepage.getClosePopupBtn());
        checkThat("Check X button is present",homepage.getClosePopupBtn().isDisplayed(),is(true));
        homepage.clickElement(homepage.getClosePopupBtn());
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
