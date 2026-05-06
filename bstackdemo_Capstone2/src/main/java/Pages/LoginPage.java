package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    
    By loginIcon = By.id("signin");
    By username = By.id("react-select-2-input");
    By password = By.id("react-select-3-input");
    By loginBtn = By.id("login-btn");

    public void clickLoginIcon() {
        driver.findElement(loginIcon).click();
    }

    public void login(String user, String pass) throws InterruptedException {

        Thread.sleep(2000); 
        driver.findElement(username).sendKeys(user);
        Thread.sleep(1000);
        driver.findElement(username).sendKeys(org.openqa.selenium.Keys.ENTER);
        driver.findElement(password).sendKeys(pass);
        Thread.sleep(1000);
        driver.findElement(password).sendKeys(org.openqa.selenium.Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(loginBtn).click();
    }
}