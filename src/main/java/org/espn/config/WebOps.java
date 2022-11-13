package org.espn.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.PageFactory.initElements;

public class WebOps {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final Actions action;

    public WebOps(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5L));
        this.action = new Actions(driver);
        initElements(driver, this);
    }

    protected WebDriver getDriver(){
        return driver;
    }
    protected Actions getAction() { return action; }

    public void clickElement(WebElement element){
        waitForClickable(element);
        element.click();
    }

    public void typeOfInput(WebElement element, String text){
        element.sendKeys(text);
    }

    public void waitForVisibility(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForVisibility(List<WebElement> elements){
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public void waitForClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void placeMouseOn(WebElement element){
        waitForClickable(element);
        action.moveToElement(element).perform();
    }
}
