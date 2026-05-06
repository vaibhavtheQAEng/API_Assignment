package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.WaitUtils;

public class ProductPage {

    WebDriver driver;
    WaitUtils wait;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        wait = new WaitUtils(driver);
    }

    By addToCartButtons = By.cssSelector(".shelf-item__buy-btn");
    By cartIcon = By.className("bag");

    public void addFirstProduct() {

        wait.waitForElement(addToCartButtons);
        driver.findElements(addToCartButtons).get(0).click();
    }

    public void addSecondProduct() {

        wait.waitForElement(addToCartButtons);
        driver.findElements(addToCartButtons).get(1).click();
    }

    public void openCart() {

        wait.waitForElement(cartIcon);
        WebElement cart = driver.findElement(cartIcon);
        ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", cart);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", cart);
    }
}