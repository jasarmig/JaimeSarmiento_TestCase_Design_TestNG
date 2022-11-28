package org.espn.pages;

import org.espn.config.Driver;
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

    @FindBy(css = ".input-InputLoginValue")
    private WebElement username;

    @FindBy(css = ".input-InputPassword")
    private WebElement userPass;

    @FindBy(id = "BtnSubmit")
    private WebElement submit;

    @FindBy(id = "BtnCancel")
    private WebElement cancel;

    @FindBy(id = "BtnCreateAccount")
    private WebElement create;

    @FindBy(id = "AccountDeleteLink")
    private WebElement deleteAccountLink;

    @FindBy(id = "TextSuccess")
    private WebElement successText;

    @FindBy(id = "logo")
    private WebElement logo;

    @FindBy(css = "#Title > span")
    private WebElement iFrameTitle;

    @FindBy(id = "TextBlock")
    private WebElement textBlock;

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

    public WebElement getWatchButton() { return watchButton; }

    public WebElement getiFrame() { return iFrame; }

    public WebElement getLogoutBtn() {
        return logoutBtn;
    }

    public WebElement getProfileBtn() {
        return profileBtn;
    }

    public Watch goToWatch(Driver driver) {
        clickElement(getWatchButton());
        return new Watch(driver.getDriver());
    }

    public WebElement getLogo() {
        return logo;
    }

    public WebElement getiFrameTitle() {
        return iFrameTitle;
    }

    public WebElement getUsername() {
        return username;
    }

    public WebElement getUserPass() {
        return userPass;
    }

    public WebElement getSubmit() {
        return submit;
    }

    public WebElement getCancel() {
        return cancel;
    }

    public WebElement getDeleteAccountLink() {
        return deleteAccountLink;
    }

    public WebElement getCreate() {
        return create;
    }

    public WebElement getSuccessText() {
        return successText;
    }

    public WebElement getTextBlock() {
        return textBlock;
    }

}