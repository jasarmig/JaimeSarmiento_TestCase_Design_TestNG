package org.testnganotations.tests;


import org.testng.annotations.*;

public class Tests {

    @Test (priority = 0)
    public void loginTest(){
        System.out.println("Login in the app");
    }

    @Test (priority = 1)
    public void deactivateTest(){
        System.out.println("User deactivated successfully!");
    }

    @Test (priority = 2)
    public void logoutTest(){
        System.out.println("Login out the app");
    }

    @BeforeSuite
    public void openBrowser(){
        System.out.println("Browser opened");
    }

    @AfterSuite
    public void closeBrowser(){
        System.out.println("Browser closed");
    }

}
