package org.testnganotations.tests;


import org.testng.annotations.*;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class UserTests {

    protected Logger logger = LoggerFactory.getLogger(UserTests.class);
    protected String website = "https://www.espnqa.com/?_adbock=true&src=com&espn=cloud";

    @Test
    public void loginTest(){
        logger.info("A valid account is needed");
        logger.info("Login to the app");
    }

    @Test (priority = 1)
    public void deactivateTest(){
        logger.info("A valid account is needed");
        logger.info("User must be logged in");
        logger.info("User deactivated successfully!");
    }

    @Test (priority = 2)
    public void logoutTest(){
        logger.info("A valid account is needed");
        logger.info("User must be logged in");
        logger.info("Logout off the app");
    }

    @BeforeMethod
    public void openBrowser(){
        logger.info("Browser opened");
        logger.info("Opening " + website);
    }

    @AfterMethod
    public void closeBrowser(){
        logger.info("Browser closed");
    }
    
}
