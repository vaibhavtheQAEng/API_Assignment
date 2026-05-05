package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage_1 {

    WebDriver driver;

    public HomePage_1(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isFromCityDisplayed() {
        return driver.findElement(By.name("fromPort")).isDisplayed();
    }

    public boolean isToCityDisplayed() {
        return driver.findElement(By.name("toPort")).isDisplayed();
    }

    public void searchFlight(String from, String to) {
        driver.findElement(By.name("fromPort")).sendKeys(from);
        driver.findElement(By.name("toPort")).sendKeys(to);
        driver.findElement(By.cssSelector("input[type='submit']")).click();
    }
}