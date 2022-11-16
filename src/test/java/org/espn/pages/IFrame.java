package org.espn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IFrame extends Homepage {

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

    @FindBy(id = "TextError")
    private WebElement byErrorLink;

    @FindBy(id = "logo")
    private WebElement logo;

    @FindBy(css = "#Title > span")
    private WebElement iFrameTitle;

    @FindBy(className = "need-help-signing-in")
    private WebElement helpLink;

    public WebElement getHelpLink() {
        return helpLink;
    }

    public IFrame(WebDriver driver) {
        super(driver);
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

    public WebElement getByErrorLink() {
        return byErrorLink;
    }

    public WebElement getCreate() {
        return create;
    }
}
