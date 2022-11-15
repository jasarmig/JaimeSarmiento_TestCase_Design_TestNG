package org.espn.tests;


import org.espn.reporting.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Login extends BaseTests {

    @Parameters({"url"})
    @Test
    public void loginTest(String url){
        Reporter.info("Click on Login Button");
        homepage.clickElement(homepage.getElement("loginButton"));
        Reporter.info("Switching to iFrame");
        driver.getDriver().switchTo().frame(homepage.getElement("iFrame"));
        Reporter.info("User email input");
        homepage.typeOfInput(homepage.getElement("userHandle"), "je.sarmiento+2@globant.com");
        Reporter.info("User password input");
        homepage.typeOfInput(homepage.getElement("userPass"), "pop1280c" );
        Reporter.info("Loging in");
        homepage.clickElement(homepage.getElement("loginSubmit"));
        Reporter.info("Click on Watch");
        homepage.clickElement(homepage.getElement("watchButton"));
        Reporter.info("Click on second element of first carrousel");
        homepage.clickElement(homepage.getElement("secondElement"));
        Reporter.info("Closing provider popup");
        homepage.waitForVisibility(homepage.getElement("closePopup"));
        homepage.waitForClickable(homepage.getElement("closePopup"));
        homepage.clickElement(homepage.getElement("closePopup"));
        Reporter.info("Back to homepage");
        driver.getDriver().get(url);
        homepage.waitForVisibility(homepage.getElement("userMenu"));
        homepage.waitForClickable(homepage.getElement("userMenu"));
        homepage.placeMouseOn(homepage.getElement("userMenu"));
        homepage.clickElement(homepage.getElement("logout"));
        homepage.waitForVisibility(homepage.getElement("userMenu"));
        homepage.waitForClickable(homepage.getElement("userMenu"));
        homepage.placeMouseOn(homepage.getElement("userMenu"));
    }


}
