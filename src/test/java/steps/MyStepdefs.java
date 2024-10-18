package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.*;


public class MyStepdefs {
    WebDriver driver;
    @Before
    public void setUp(){
        driver = PagePool.locationsPage.chromeDriverSetup();
        PagePool.locationsPage = new LocationsPage(driver);
    }

    @Given("User on Location List Page")
    public void UserOnLocationListPage() {
        driver.get("https://wetwo.id");
    }

    @When("User click {string} location")
    public void userClickLocation(String location) {
        PagePool.locationsPage.clickLocation(location);
    }

    @And("User click {string} Add Button at Product List Page")
    public void userClickAddButtonAt(String product) {
        PagePool.productListPage = new ProductListPage(driver);
        PagePool.productListPage.clickAddButton(product);
    }

    @And("User click {string} Plus Button at Product List Page")
    public void userClickPlusButtonAt(String product) {
        PagePool.productListPage.clickPlusButton(product);
    }

    @And("User click Cart button")
    public void userClickCartButton() {
        PagePool.productListPage.clickCartButton();
    }

    @And("User see {string} with the quantity added")
    public void userSeeWithTheQuantityAdded(String product) {
        PagePool.cartPage = new CartPage(driver);
        PagePool.cartPage.checkProductAndQuantity(product);
    }

    @And("User click Minus button at {string}")
    public void userClickMinusButtonAt(String product) {
        PagePool.cartPage.clickMinusButton(product);
    }

    @And("User click Product Image at {string}")
    public void userClickProductImageAtPDP(String product) {
        PagePool.cartPage.clickProductImage(product);
    }

    @Then("User redirect to Product Details Page of {string}")
    public void userRedirectToProductDetailsPage(String product) {
        PagePool.productDetailsPage = new ProductDetailsPage(driver);
        PagePool.productDetailsPage.checkProductDetails(product);
    }
}