package org.espn.tests;

import org.espn.reporting.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static java.lang.String.format;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;

public class UserTests extends BaseTests{


    @Parameters({"name", "lastName", "email", "pass", "url"})
    @Test
    public void webTest(String name,String lastName, String email, String pass, String url){
        homepage.clickElement(homepage.getLoginButton());
        homepage.switchToLogin(driver);
        checkThat("Login modal is present", homepage.loginFrameIsVisible(), is(true));
        homepage.clickElement(homepage.getCreateBtn());
        checkThat("Sign Up modal is present", homepage.signupFrameIsVisible(), is(true));
        homepage.fillSignUpForm(name, lastName, email, pass);
        homepage.clickElement(homepage.getSubmit());
        Reporter.info("User is logged in");
        Reporter.info("Navigating to Watch page");
        watch = homepage.goToWatch(driver);
        checkThat("At least one carousel is present", watch.countCarousels(), greaterThan(0));
        Reporter.info(watch.countCarousels() + " carousels are present.");
        Reporter.info("The first carousel has " + watch.countCarouselTiles() + " tiles");
        checkThat("all tiles have titles [found:" + watch.countTitleTiles() + "]", watch.countTitleTiles(),
                is(watch.countCarouselTiles()));
        checkThat( "all tiles have metas [found:" + watch.countTitleMetas() + "]", watch.countTitleMetas(),
                is(watch.countCarouselTiles()));
        watch.clickElement(watch.getSecondElement());
        watch.waitForVisibility(watch.getWatchLightbox());
        watch.waitForClickable(watch.getClosePopupBtn());
        checkThat("Check X button is present",watch.closePopupBtnDisplayed(),is(true));
        watch.clickElement(watch.getClosePopupBtn());
        Reporter.info("Lightbox closed");
        Reporter.info(format("Navigating to %s", url));
        driver.goBack();
        homepage.placeMouseOn(homepage.getUserMenu());
        homepage.waitForVisibility(homepage.getUserName());
        homepage.waitForClickable(homepage.getLogoutBtn());
        checkThat("Username is present in menu", homepage.getUserNameText(), is("Welcome" + name + "!"));
        homepage.clickElement(homepage.getLogoutBtn());
        Reporter.info("User is logged out");
        driver.refresh();
        homepage.placeMouseOn(homepage.getUserMenu());
        checkThat("Username is not present in menu", homepage.getUserName().getText(), is("Welcome!"));
    }

}
