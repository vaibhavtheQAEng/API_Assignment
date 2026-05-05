package pages;

import org.openqa.selenium.*;

public class ConfirmationPage_1 {

    WebDriver driver;

    public ConfirmationPage_1(WebDriver driver) {
        this.driver = driver;
    }

    By message = By.tagName("h1");

    public String getMessage() {
        return driver.findElement(message).getText();
    }
}