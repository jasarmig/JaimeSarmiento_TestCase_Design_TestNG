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
    private WebElement loginSubmit;

    @FindBy(id = "BtnCancel")
    private WebElement cancel;

    @FindBy(css = ".BucketsContainer>div:first-child .Carousel__Inner>li:nth-child(2)")
    private WebElement secondElement;

    //@FindBy(className = ".lightbox__closebtn")
    @FindBy(css = "button.lightbox__closebtn")
    private WebElement closePopup;

    @FindBy(css = ".user [onclick*=\"logout\"]")
    private WebElement logout;

    @FindBy(css = ".user [tref*=\"modify\"]")
    private WebElement profile;

    @FindBy(id = "AccountDeleteLink")
    private WebElement deleteAccountLink;

    @FindBy(css = ".global-overlay[role=\"alert\"]")
    private WebElement check;

    @FindBy(id = "TextError")
    private WebElement byError;


    public WebElement getElement(String element) {
        switch (element){
            case "userMenu":
                return userMenu;
            case "loginButton":
                return loginButton;
            case "watchButton":
                return watchButton;
            case "iFrame":
                return iFrame;
            case "userHandle":
                return userHandle;
            case "userPass":
                return userPass;
            case "loginSubmit":
                return loginSubmit;
            case "secondElement":
                return secondElement;
            case "closePopup":
                return closePopup;
            case "logout":
                return logout;
            case "profile":
                return profile;
            case "deleteAccount":
                return deleteAccountLink;
            case "check":
                return check;
            case "cancel":
                return cancel;
            case "error":
                return byError;
            default:
                return null;
        }
    }
}