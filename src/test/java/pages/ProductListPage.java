package pages;

import bases.WebBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductListPage extends WebBasePage {
    public ProductListPage(WebDriver webDriver) {
        super(webDriver);}

    public void clickAddButton(String product){
        By relatedProduct = By.xpath("//*[text()='"+ product +"']");
        By addButtonPath = By.xpath("//*[text()='Add']");

        waitForElementVisible(relatedProduct);
        WebElement addButton = checkRightOf(addButtonPath,relatedProduct);
        forceClick(addButton);

    }

    public void clickPlusButton(String product){
        By relatedProduct = By.xpath("//*[text()='"+ product +"']");
        By plusButtonPath = By.xpath("//*/button/div/p[text()='+']");

        waitForElementVisible(relatedProduct);
        WebElement plusButton = checkRightOf(plusButtonPath,relatedProduct);
        forceClick(plusButton);
    }

    public void clickCartButton(){
        By cartPath = By.xpath("//*/div/p/b[contains(text(),'Total')]");
        waitForElementVisible(cartPath);
        click(cartPath);
    }
}
