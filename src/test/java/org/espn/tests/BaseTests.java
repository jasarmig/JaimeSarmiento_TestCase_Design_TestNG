package org.espn.tests;

import org.espn.config.Driver;
import org.espn.pages.Homepage;
import org.espn.pages.Watch;
import org.espn.reporting.Reporter;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.*;

import static java.lang.String.format;

public class BaseTests {

    protected Driver driver;
    protected Homepage homepage;
    protected Watch watch;


    @Parameters({"browser","url"})
    @BeforeTest
    public void testSetup(String browser, String url){
        driver = new Driver(browser);
        Reporter.info("Deleting cookies");
        driver.deleteCookies();
        Reporter.info(format("Navigating to %s", url));
        driver.goToUrl(url);
        driver.maximize();
        homepage = new Homepage(driver.getDriver());
    }

    @AfterTest
    public void endTest(){
        driver.getDriver().quit();
    }


    protected <T> void checkThat(String description, T actualValue, Matcher<? super T> expectedValue) {
        Reporter.info(format("Checking that " + description.toLowerCase() + " [Expected: %s]", expectedValue));
        try {
            MatcherAssert.assertThat(actualValue,expectedValue);
        } catch (AssertionError e) {
            Reporter.error(format("Assertion error: [%s]", e.getMessage().replaceAll("\n", "")));
        }
    }
}
