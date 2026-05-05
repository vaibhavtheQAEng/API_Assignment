package pages;

import org.openqa.selenium.*;

public class PurchasePage_1 {

    WebDriver driver;

    public PurchasePage_1(WebDriver driver) {
        this.driver = driver;
    }

    By name = By.id("inputName");
    By address = By.id("address");
    By city = By.id("city");
    By card = By.id("creditCardNumber");
    By purchaseBtn = By.cssSelector("input[type='submit']");

    public void fillDetails(String n, String addr, String c, String cc) {
        driver.findElement(name).sendKeys(n);
        driver.findElement(address).sendKeys(addr);
        driver.findElement(city).sendKeys(c);
        driver.findElement(card).sendKeys(cc);
    }

    public void clickPurchase() {
        driver.findElement(purchaseBtn).click();
    }
}