package org.espn.pages;

import org.espn.config.WebOps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends WebOps {

    public Homepage(WebDriver driver) {
        super(driver);
    }

    //home
    @FindBy(className = "user")
    private WebElement userMenu;

    //home
    @FindBy(css = ".col-one button[tref*=\"login\"]")
    private WebElement loginButton;

    //home
    @FindBy(className = "watch")
    private WebElement watchButton;

    //home
    @FindBy(id = "oneid-iframe")
    private WebElement iFrame;

    //iframe
    @FindBy(css = ".input-InputLoginValue")
    private WebElement username;

    //iframe
    @FindBy(css = ".input-InputPassword")
    private WebElement userPass;

    //iframe
    @FindBy(id = "BtnSubmit")
    private WebElement submit;

    //iframe
    @FindBy(id = "BtnCancel")
    private WebElement cancel;

    //watch
    @FindBy(css = ".BucketsContainer>div:first-child .Carousel__Inner>li:nth-child(2)")
    private WebElement secondElement;

    //watch
    @FindBy(css = ".BucketsContainer>div:first-child .Carousel__Inner>li:nth-child(2)>a>div:nth-child(2)")
    private WebElement tileContent;

    //watch
    @FindBy(css = "button.lightbox__closebtn")
    private WebElement closePopupBtn;

    //home
    @FindBy(css = ".user [onclick*=\"logout\"]")
    private WebElement logoutBtn;

    //home
    @FindBy(css = ".user [tref*=\"modify\"]")
    private WebElement profileBtn;

    //iframe
    @FindBy(id = "AccountDeleteLink")
    private WebElement deleteAccountLink;

    //iframe
    @FindBy(id = "TextError")
    private WebElement byErrorLink;

    //iframe
    @FindBy(id = "logo")
    private WebElement logo;

    //home
    @FindBy(css = ".display-user")
    private WebElement userName;

    //watch
    @FindBy(className = "lightbox__contentBox")
    private WebElement watchLightbox;

    //iframe
    @FindBy(css = "#Title > span")
    private WebElement iFrameTitle;

    public WebElement getLogo() {
        return logo;
    }

    public WebElement getiFrameTitle() {
        return iFrameTitle;
    }

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

    public WebElement getSecondElement() {
        return secondElement;
    }

    public WebElement getClosePopupBtn() {
        return closePopupBtn;
    }

    public WebElement getLogoutBtn() {
        return logoutBtn;
    }

    public WebElement getProfileBtn() {
        return profileBtn;
    }

    public WebElement getDeleteAccountLink() {
        return deleteAccountLink;
    }

    public WebElement getByErrorLink() {
        return byErrorLink;
    }
}