package pages;

import bases.WebBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LocationsPage extends WebBasePage{

    public LocationsPage (WebDriver webDriver){
        super(webDriver);
    }

    public void clickLocation (String loc){
        By location = By.xpath("//*[text()='"+loc+"']");
        waitForElementVisible(location);
        click(location);
    }

    public ProductListPage navigateToProductListPage() {
        // Navigation logic here
        return new ProductListPage(this.webDriver);
    }
}
