package org.testnganotations.tests;


import org.testng.annotations.*;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class Tests {

    Logger logger = LoggerFactory.getLogger(Tests.class);

    @Test
    public void loginTest(){
        logger.info("Login in the app");
    }

    @Test (priority = 1)
    public void deactivateTest(){
        logger.info("User deactivated successfully!");
    }

    @Test (priority = 2)
    public void logoutTest(){
        logger.info("Login out the app");
    }

    @BeforeSuite
    public void openBrowser(){
        logger.info("Browser opened");
    }

    @AfterSuite
    public void closeBrowser(){
        logger.info("Browser closed");
    }

}
