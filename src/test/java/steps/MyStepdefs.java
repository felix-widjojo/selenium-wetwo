package steps;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class MyStepdefs {
    WebDriver driver;

    @Given("User on Location List Page")
    public void UserOnLocationListPage() {
        driver = new ChromeDriver();
        driver.get("https://wetwo.id");
    }

    @When("User click {string} location")
    public void userClickLocation(String location) {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='"+location+"']")));
        driver.findElement(By.xpath("//*[text()='"+location+"']")).click();
    }

    @And("User click {string} Add Button at Product List Page")
    public void userClickAddButtonAt(String product) {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='"+product+"']")));
        WebElement relatedProduct =driver.findElement(By.xpath("//*[text()='"+product+"']"));
        WebElement addButton = driver.findElement(with(By.xpath("//*[text()='Add']")).toRightOf(relatedProduct));
        addButton.click();
    }

    @And("User click {string} Plus Button at Product List Page")
    public void userClickPlusButtonAt(String product) {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
        WebElement relatedProduct = driver.findElement(By.xpath("//*[text()='"+product+"']"));
        WebElement plusButton = driver.findElement(with(By.xpath("//*/button/div/p[text()='+']")).toRightOf(relatedProduct));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='"+product+"']")));
        wait.until(ExpectedConditions.elementToBeClickable(with(By.xpath("//*/button/div/p[text()='+']")).toRightOf(relatedProduct)));
        Actions actions = new Actions(driver);
        actions.moveToElement(plusButton).click().build().perform();
    }

    @And("User click Cart button")
    public void userClickCartButton() {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*/div/p/b[contains(text(),'Total')]")));
        WebElement cartButton = driver.findElement(By.xpath("//*/div/p/b[contains(text(),'Total')]"));
        cartButton.click();
    }

    @And("User see {string} with the quantity added")
    public void userSeeWithTheQuantityAdded(String product) {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*/div/p[contains(text(),'Cart')]")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='"+product+"']")));
    }

    @And("User click Minus button at {string}")
    public void userClickMinusButtonAt(String product) {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
        WebElement relatedProduct = driver.findElement(By.xpath("//*[text()='"+product+"']"));
        WebElement minusButton = driver.findElement(with(By.xpath("//*/button/div/p[text()='-']")).below(relatedProduct));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='"+product+"']")));
        wait.until(ExpectedConditions.elementToBeClickable(with(By.xpath("//*/button/div/p[text()='-']")).below(relatedProduct)));
        Actions actions = new Actions(driver);
        actions.moveToElement(minusButton).click().build().perform();
    }

    @And("User click Product Image at {string}")
    public void userClickProductImageAtPDP(String product) {
        driver.findElement(By.xpath("//*[text()='"+product+"']")).click();
    }

    @Then("User redirect to Product Details Page of {string}")
    public void userRedirectToProductDetailsPage(String product) {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='"+product+"']")));
    }
}