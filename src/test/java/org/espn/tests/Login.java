package org.espn.tests;


import org.espn.reporting.Reporter;
import org.hamcrest.Matcher;
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
        //TODO modularizar esta comprobacion
        checkThat("ESPN logo is displayed", homepage.getLogo().isDisplayed(), is(true));
        checkThat("User email input is displayed", homepage.getUserHandle().isDisplayed(), is(true));
        checkThat("Password input is displayed", homepage.getUserPass().isDisplayed(), is(true));
        homepage.typeOfInput(homepage.getUserHandle(), "je.sarmiento+8@globant.com");
        homepage.typeOfInput(homepage.getUserPass(), "pop1280c" );
        homepage.clickElement(homepage.getSubmit());
        Reporter.info("User is logged in");
        Reporter.info("Navigating to Watch page");
        homepage.clickElement(homepage.getWatchButton());
        checkThat("At least one carousel is present", homepage.getTileContent().isDisplayed(), is(true));
        Reporter.info("Carousel is present");
        homepage.clickElement(homepage.getSecondElement());
        homepage.waitForVisibility(homepage.getWatchLightbox());
        homepage.waitForClickable(homepage.getWatchLightbox());
        checkThat("Check X button is present",homepage.getClosePopup().isDisplayed(),is(true));
        homepage.clickElement(homepage.getClosePopup());
        Reporter.info("Lightbox closed");
        Reporter.info(format("Navigating to %s", url));
        driver.getDriver().get(url);
        homepage.waitForVisibility(homepage.getUserMenu());
        homepage.waitForClickable(homepage.getUserMenu());
        homepage.placeMouseOn(homepage.getUserMenu());
        homepage.waitForVisibility(homepage.getUserName());
        homepage.waitForClickable(homepage.getLogout());
        checkThat("Username is present in menu", homepage.getUserName().getText(), is("WelcomeJaime!"));
        homepage.clickElement(homepage.getLogout());
        homepage.waitForVisibility(homepage.getUserMenu());
        homepage.waitForClickable(homepage.getUserMenu());
        homepage.placeMouseOn(homepage.getUserMenu());
        homepage.waitForVisibility(homepage.getUserMenu());
        homepage.waitForClickable(homepage.getUserMenu());
        checkThat("Username is not present in menu", homepage.getUserName().getText(), is(""));
    }


}
