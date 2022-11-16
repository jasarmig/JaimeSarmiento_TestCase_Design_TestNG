package org.espn.pages;

import org.espn.config.WebOps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends WebOps {

    public Homepage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "user")
    private WebElement userMenu;

    @FindBy(css = ".col-one button[tref*=\"login\"]")
    private WebElement loginButton;

    @FindBy(className = "watch")
    private WebElement watchButton;

    @FindBy(id = "oneid-iframe")
    private WebElement iFrame;

    @FindBy(css = ".user [onclick*=\"logout\"]")
    private WebElement logoutBtn;

    @FindBy(css = ".user [tref*=\"modify\"]")
    private WebElement profileBtn;

    @FindBy(css = ".display-user")
    private WebElement userName;

    @FindBy(css = ".promo-banner-container > iframe")
    private WebElement bannerFrame;

    @FindBy(css = "#fittPageContainer .PromoBanner__CloseBtn")
    private WebElement bannerCloseBtn;

    public WebElement getBannerFrame() {
        return bannerFrame;
    }

    public WebElement getBannerCloseBtn() {
        return bannerCloseBtn;
    }

    public WebElement getUserName() {
        return userName;
    }

    public WebElement getUserMenu() {
        return userMenu;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getWatchButton() {
        return watchButton;
    }

    public WebElement getiFrame() {
        return iFrame;
    }

    public WebElement getLogoutBtn() {
        return logoutBtn;
    }

    public WebElement getProfileBtn() {
        return profileBtn;
    }

}