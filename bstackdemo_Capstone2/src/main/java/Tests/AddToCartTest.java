package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.ProductPage;
import utils.BaseTest;
import utils.WaitUtils;

import java.util.List;

public class AddToCartTest extends BaseTest {

    @Test(priority = 4)
    public void TC_004_addSingleItem() throws Exception {

        LoginPage lp = new LoginPage(driver);
        ProductPage pp = new ProductPage(driver);
        WaitUtils wait = new WaitUtils(driver);

        lp.clickLoginIcon();
        lp.login("demouser", "testingisfun99");

        wait.waitForElement(By.cssSelector(".shelf-item"));

        driver.findElements(By.cssSelector(".shelf-item__buy-btn")).get(0).click();

        pp.openCart();

        wait.waitForElement(By.cssSelector(".float-cart__shelf-container"));

        List<WebElement> items =
                driver.findElements(By.cssSelector(".shelf-item"));

        Assert.assertTrue(items.size() >= 1);

        test.pass("Single product added successfully");
    }

    @Test(priority = 5)
    public void TC_005_addMultipleItems() throws Exception {

        LoginPage lp = new LoginPage(driver);
        ProductPage pp = new ProductPage(driver);
        WaitUtils wait = new WaitUtils(driver);

        lp.clickLoginIcon();
        lp.login("demouser", "testingisfun99");

        wait.waitForElement(By.cssSelector(".shelf-item"));

        List<WebElement> buttons =
                driver.findElements(By.cssSelector(".shelf-item__buy-btn"));

        buttons.get(0).click();
        buttons.get(1).click();

        pp.openCart();

        wait.waitForElement(By.cssSelector(".float-cart__shelf-container"));

        List<WebElement> cartItems =
                driver.findElements(By.cssSelector(".float-cart__shelf-container .shelf-item"));

        Assert.assertTrue(cartItems.size() >= 2);

        test.pass("Multiple items added successfully");
    }

    @Test(priority = 6)
    public void TC_006_removeItem() throws Exception {

        LoginPage lp = new LoginPage(driver);
        ProductPage pp = new ProductPage(driver);
        WaitUtils wait = new WaitUtils(driver);

        lp.clickLoginIcon();
        lp.login("demouser", "testingisfun99");

        wait.waitForElement(By.cssSelector(".shelf-item"));

        driver.findElements(By.cssSelector(".shelf-item__buy-btn")).get(0).click();

        pp.openCart();

        wait.waitForElement(By.cssSelector(".float-cart__shelf-container"));

        driver.findElement(By.cssSelector(".shelf-item__del")).click();

        Thread.sleep(2000);

        List<WebElement> remaining =
                driver.findElements(By.cssSelector(".float-cart__shelf-container .shelf-item"));

        Assert.assertTrue(remaining.size() == 0);

        test.pass("Item removed successfully");
    }
}