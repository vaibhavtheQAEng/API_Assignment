package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.ProductPage;
import utils.BaseTest;
import utils.WaitUtils;

public class CheckoutTest extends BaseTest {

    @Test(priority = 7)
    public void TC_007_checkout() throws Exception {

        LoginPage lp = new LoginPage(driver);
        ProductPage pp = new ProductPage(driver);
        WaitUtils wait = new WaitUtils(driver);

        lp.clickLoginIcon();
        lp.login("demouser", "testingisfun99");

        wait.waitForElement(By.cssSelector(".shelf-item"));

        driver.findElements(By.cssSelector(".shelf-item__buy-btn")).get(0).click();

        pp.openCart();

        wait.waitForElement(By.cssSelector(".float-cart__footer"));

        WebElement checkoutBtn = driver.findElement(By.xpath("//div[text()='Checkout']"));
        ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", checkoutBtn);

        wait.waitForElement(By.id("firstNameInput"));

        driver.findElement(By.id("firstNameInput")).sendKeys("John");
        driver.findElement(By.id("lastNameInput")).sendKeys("Doe");
        driver.findElement(By.id("addressLine1Input")).sendKeys("India");

        driver.findElement(By.id("provinceInput")).clear();
        driver.findElement(By.id("provinceInput")).sendKeys("Maharashtra");

        driver.findElement(By.id("postCodeInput")).clear();
        driver.findElement(By.id("postCodeInput")).sendKeys("411033");

        WebElement continueBtn =
                driver.findElement(By.id("checkout-shipping-continue"));

        ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", continueBtn);

        ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", continueBtn);

        wait.waitForElement(By.id("confirmation-message"));

        Assert.assertTrue(
                driver.findElement(By.id("confirmation-message"))
                        .isDisplayed()
        );

        test.pass("Your Order has been successfully placed."); 	
    }

    @Test(priority = 8)
    public void TC_008_checkoutWithoutItems() throws Exception {

        ProductPage pp = new ProductPage(driver);
        WaitUtils wait = new WaitUtils(driver);

        pp.openCart();

        wait.waitForElement(By.cssSelector(".float-cart__content"));

        boolean checkoutPresent =
                driver.findElements(By.xpath("//div[text()='Checkout']")).size() > 0;

        Assert.assertFalse(checkoutPresent);

        test.pass("Checkout not available for empty cart - PASSED");
    }
}