package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReservePage_1 {

    WebDriver driver;

    public ReservePage_1(WebDriver driver) {
        this.driver = driver;
    }

    public void SelectFlight(String airline) {

        driver.findElement(
            By.xpath("//td[text()='" + airline + "']/parent::tr//input")
        ).click();
    }
}