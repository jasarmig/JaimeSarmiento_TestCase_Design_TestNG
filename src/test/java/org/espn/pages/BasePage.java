package org.espn.pages;
import org.espn.config.WebOps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage extends WebOps {

    public BasePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "global-scoreboard")
    private WebElement topScoreboard;

    //TODO declare all common elements using @FindBy
}
