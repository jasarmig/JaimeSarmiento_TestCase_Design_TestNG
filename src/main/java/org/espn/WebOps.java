package org.espn;

public class WebOps {

    private final WebDriver driver;
    private final WenDriverWait wait;

    public WebOps(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriver(drive, Duration.ofSeconds(5L));
        initElements(driver, this);
    }

    protected WebDriver getDriver(){
        return driver;
    }

    public void clickElement(WebElement element){
        waitForClickable(element);
        element.click();
    }

    public void typeOfInput(WebElement element, String text){
        element.sendKeys(text);
    }

    public void waitForVisibility(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForVisibility(List<WebElement> elements){
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public void waitForClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
