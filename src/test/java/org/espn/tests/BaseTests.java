package org.espn.tests;

import org.espn.config.Driver;
import org.espn.pages.Homepage;
import org.espn.pages.IFrame;
import org.espn.pages.Watch;
import org.espn.reporting.Reporter;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.*;

import static java.lang.String.format;

public class BaseTests {

    protected Driver driver;
    protected Homepage homepage;
    protected IFrame frame;
    protected Watch watch;


    @Parameters({"browser","url"})
    @BeforeTest(groups = {"logout","watch","deactivate"})
    public void testSetup(String browser, String url){
        driver = new Driver(browser);
        Reporter.info("Deleting cookies");
        driver.getDriver().manage().deleteAllCookies();
        Reporter.info(format("Navigating to %s", url));
        driver.getDriver().get(url);
        driver.getDriver().manage().window().maximize();
        homepage = new Homepage(driver.getDriver());
        driver.getDriver().switchTo().frame(homepage.getBannerFrame());
        homepage.clickElement(homepage.getBannerCloseBtn());
        frame = new IFrame(driver.getDriver());
    }

    @AfterTest(groups = {"logout","watch","deactivate"})
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
