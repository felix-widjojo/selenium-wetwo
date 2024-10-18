package pages;

import bases.WebBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends WebBasePage {
    public ProductDetailsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void checkProductDetails(String product){
        By titlePage = By.xpath("//*[text()='"+product+"']");
        waitForElementVisible(titlePage);
    }
}
