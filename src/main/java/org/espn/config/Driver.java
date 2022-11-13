package org.espn.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class Driver {

    private WebDriver driver;

    public Driver(String browser){
        switch (browser.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                break;
        }
    }

    public WebDriver getDriver(){
        return driver;
    }

}
