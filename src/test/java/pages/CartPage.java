package pages;

import bases.WebBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends WebBasePage {
    public CartPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void checkProductAndQuantity(String product){
        By pageTitle = By.xpath("//*/div/p[contains(text(),'Cart')]");
        By relatedProduct = By.xpath("//*[text()='"+product+"']");
        waitForElementVisible(pageTitle);
        waitForElementVisible(relatedProduct);
    }

    public void clickMinusButton(String product){
        By relatedProduct = By.xpath("//*[text()='"+ product +"']");
        By minusButtonPath = By.xpath("//*/button/div/p[text()='-']");

        waitForElementVisible(relatedProduct);
        WebElement minusButton = checkBelow(minusButtonPath,relatedProduct);
        forceClick(minusButton);
    }

    public void clickProductImage(String product){
        By relatedProduct = By.xpath("//*[text()='"+product+"']");
        click(relatedProduct);
    }
}
