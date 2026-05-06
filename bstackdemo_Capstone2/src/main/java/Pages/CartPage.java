package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    By checkoutBtn = By.xpath("//div[text()='Checkout']");

    public void clickCheckout() {
        driver.findElement(checkoutBtn).click();
    }
}