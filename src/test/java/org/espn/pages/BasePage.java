package org.espn.pages;
import org.espn.config.WebOps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage extends WebOps {

    public BasePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "global-scoreboard")
    private WebElement topScoreboard;

    @FindBy(id = "global-header")
    private WebElement navMenu;

    @FindBy(className = "ad-banner-wrapper")
    private WebElement banner;

    @FindBy(id="news-feed")
    private WebElement newsFeed;

    @FindBy(className="col-three")
    private WebElement leftColumn;

    @FindBy(className = "PageFooter")
    private WebElement footer;

    @FindBy(css = ".col-one>.quicklinks")
    private WebElement rightColumn;

}
