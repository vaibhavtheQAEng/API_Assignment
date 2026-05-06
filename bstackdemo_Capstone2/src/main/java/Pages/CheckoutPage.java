package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    By firstName = By.id("firstNameInput");
    By lastName = By.id("lastNameInput");
    By address = By.id("addressLine1Input");
    By province = By.id("provinceInput");
    By postCode = By.id("postCodeInput");
    By submitBtn = By.id("checkout-shipping-continue");

    public void fillDetails() {

        driver.findElement(firstName).sendKeys("Vaibhav");
        driver.findElement(lastName).sendKeys("Test");
        driver.findElement(address).sendKeys("Pune");
        driver.findElement(province).sendKeys("MH");
        driver.findElement(postCode).sendKeys("411001");
        driver.findElement(submitBtn).click();
    }
}