package bases;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class WebBasePage {
    protected WebDriver webDriver;
    protected WebDriverWait wait;
    private WebElement webElement;
    private Actions actions;

    public WebBasePage getUrl(String url) {
        this.webDriver.manage().window().maximize();
        this.webDriver.get(url);
        return this;
    }

    protected WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected List<WebElement> findElements(By locator) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    protected void click(By locator) {
        WebElement element = findElement(locator);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    protected void enterText(By locator, String text) {
        WebElement element = findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected boolean isElementPresent(By locator) {
        try {
            findElement(locator);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    protected void waitForElementVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected String getText(By locator) {
        return findElement(locator).getText();
    }

    protected void waitForCustomCondition(java.util.function.Function<WebDriver, Boolean> condition, int timeoutInSeconds) {
        new WebDriverWait(webDriver, Duration.ofSeconds(timeoutInSeconds)).until(condition);
    }

    protected By id(String id) {
        return By.id(id);
    }

    protected By xpath(String xpath) {
        return By.xpath(xpath);
    }

    protected WebElement checkBelow(By by, By by2) {
        return findElement(with(by).below(by2));
    }

    protected WebElement checkAbove(By by, By by2) {
        return findElement(with(by).above(by2));
    }

    protected WebElement checkLeftOf(By by, By by2) {
        return findElement(with(by).toLeftOf(by2));
    }

    protected WebElement checkRightOf(By by, By by2) {
        return findElement(with(by).toRightOf(by2));
    }

    protected void forceClick(WebElement by){
        actions.moveToElement(by).click().build().perform();
    }

    public static WebDriver chromeDriverSetup(){
        return new ChromeDriver();
    }

    public WebBasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        this.actions = new Actions(this.webDriver);
    }
}
