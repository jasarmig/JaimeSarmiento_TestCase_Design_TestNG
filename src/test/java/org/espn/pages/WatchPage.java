package org.espn.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WatchPage {

    @FindBy(className = "Carousel")
    private WebElement carousel;

    @FindBy(css = ".BucketsContainer>div:first-child .Carousel__Inner>li:nth-child(2)")
    private WebElement interestElement;


}
