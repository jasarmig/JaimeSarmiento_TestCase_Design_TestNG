package org.espn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Watch extends Homepage{

    public Watch(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".BucketsContainer>div:first-child .Carousel__Inner>li:nth-child(2)")
    private WebElement secondElement;

    @FindBy(css = ".BucketsContainer>div:first-child .Carousel__Inner>li:nth-child(2)>a>div:nth-child(2)")
    private WebElement tileContent;

    @FindBy(css = "button.lightbox__closebtn")
    private WebElement closePopupBtn;

    @FindBy(className = "lightbox__contentBox")
    private WebElement watchLightbox;

    public WebElement getSecondElement() {
        return secondElement;
    }

    public WebElement getTileContent() {
        return tileContent;
    }

    public WebElement getClosePopupBtn() {
        return closePopupBtn;
    }

    public WebElement getWatchLightbox() {
        return watchLightbox;
    }
}
