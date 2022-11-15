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

    @FindBy(css = ".input-InputLoginValue")
    private WebElement userHandle;

    @FindBy(css = ".input-InputPassword")
    private WebElement userPass;

    @FindBy(id = "BtnSubmit")
    private WebElement submit;

    @FindBy(id = "BtnCancel")
    private WebElement cancel;

    @FindBy(css = ".BucketsContainer>div:first-child .Carousel__Inner>li:nth-child(2)")
    private WebElement secondElement;

    @FindBy(css = ".BucketsContainer>div:first-child .Carousel__Inner>li:nth-child(2)>a>div:nth-child(2)")
    private WebElement tileContent;

    @FindBy(css = "button.lightbox__closebtn")
    private WebElement closePopup;

    @FindBy(css = ".user [onclick*=\"logout\"]")
    private WebElement logout;

    @FindBy(css = ".user [tref*=\"modify\"]")
    private WebElement profile;

    @FindBy(id = "AccountDeleteLink")
    private WebElement deleteAccountLink;

    @FindBy(id = "TextError")
    private WebElement byError;

    public WebElement getLogo() {
        return logo;
    }

    @FindBy(id = "logo")
    private WebElement logo;

    @FindBy(css = ".display-user")
    private WebElement userName;

    @FindBy(className = "lightbox__contentBox")
    private WebElement watchLightbox;

    public WebElement getWatchLightbox() {
        return watchLightbox;
    }

    public WebElement getUserName() {
        return userName;
    }

    public WebElement getTileContent() {
        return tileContent;
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

    public WebElement getUserHandle() {
        return userHandle;
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

    public WebElement getSecondElement() {
        return secondElement;
    }

    public WebElement getClosePopup() {
        return closePopup;
    }

    public WebElement getLogout() {
        return logout;
    }

    public WebElement getProfile() {
        return profile;
    }

    public WebElement getDeleteAccountLink() {
        return deleteAccountLink;
    }

    public WebElement getByError() {
        return byError;
    }
}