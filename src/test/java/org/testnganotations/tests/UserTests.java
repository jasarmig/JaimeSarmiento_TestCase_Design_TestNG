package org.testnganotations.tests;


import org.testng.annotations.*;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class UserTests {

    protected Logger logger = LoggerFactory.getLogger(UserTests.class);
    protected String website = "https://www.espnqa.com/?_adbock=true&src=com&espn=cloud";

    @Test
    public void loginTest(){
        logger.info("Login to the app");
    }

    @Test
    public void deactivateTest(){
        logger.warn("User must be logged in");
        logger.info("User deactivated successfully!");
    }

    @Test
    public void logoutTest(){
        logger.warn("User must be logged in");
        logger.info("Logout off the app");
    }

    @BeforeMethod
    public void openBrowser(){
        logger.info("************** TEST BEGINS HERE **************");
        logger.info("Browser opened");
        logger.info("Opening " + website);
        logger.warn("A valid account is needed");
    }

    @AfterMethod
    public void closeBrowser(){
        logger.info("Browser closed");
    }


}
