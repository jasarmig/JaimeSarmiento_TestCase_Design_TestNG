package org.espn.tests;

import org.espn.pages.Watch;
import org.espn.reporting.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static java.lang.String.format;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;

public class UserTests extends BaseTests{

    @Parameters({"user","pass"})
    @Test(groups = {"logout", "watch" , "deactivate"})
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

    @Test(groups = {"logout","watch"}, priority = 2)
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

    @Parameters({"url"})
    @Test(groups = {"watch"}, priority = 1)
    public void watchTest(String url){
        Reporter.info("Navigating to Watch page");
        homepage.clickElement(homepage.getWatchButton());
        watch = new Watch(driver.getDriver());
        checkThat("At least one carousel is present", watch.getCarouselList().size(), greaterThan(0));
        Reporter.info(watch.getCarouselList().size() + " carousels are present.");
        Reporter.info("The first carousel has " + watch.getFirstCarouselTiles().size() + " tiles");
        checkThat("all tiles have titles [found:" + watch.getTileTitles().size() + "]", watch.getTileTitles().size(),is(watch.getFirstCarouselTiles().size()));
        checkThat( "all tiles have metas [found:" + watch.getTileMetas().size() + "]", watch.getTileMetas().size(), is(watch.getFirstCarouselTiles().size()));
        watch.clickElement(watch.getSecondElement());
        watch.waitForVisibility(watch.getWatchLightbox());
        watch.waitForClickable(watch.getClosePopupBtn());
        checkThat("Check X button is present",watch.getClosePopupBtn().isDisplayed(),is(true));
        watch.clickElement(watch.getClosePopupBtn());
        Reporter.info("Lightbox closed");
        Reporter.info(format("Navigating to %s", url));
        driver.getDriver().navigate().back();
    }

    @Parameters({"user","pass"})
    @Test(groups = {"deactivate"}, priority = 1)
    public void deactivate(String user, String pass){
        homepage.placeMouseOn(homepage.getUserMenu());
        homepage.waitForClickable(homepage.getProfileBtn());
        homepage.clickElement(homepage.getProfileBtn());
        driver.getDriver().switchTo().frame(homepage.getiFrame());
        frame.clickElement(frame.getDeleteAccountLink());
        frame.waitForClickable(frame.getCancel());
        frame.clickElement(frame.getSubmit());
        frame.waitForClickable(frame.getByErrorLink());
        checkThat("Account has been deleted", frame.getiFrameTitle().getText(), is("Your account has been deleted."));
        frame.clickElement(frame.getSubmit());
        driver.getDriver().switchTo().defaultContent();
        homepage.clickElement(homepage.getLoginButton());
        driver.getDriver().switchTo().frame(homepage.getiFrame());
        frame.typeOfInput(frame.getUsername(), user);
        frame.typeOfInput(frame.getUserPass(), pass);
        frame.clickElement(frame.getSubmit());
        frame.waitForVisibility(frame.getiFrameTitle());
        checkThat("Account has been deactivated", frame.getiFrameTitle().getText(), is("Account Deactivated"));
    }
}
