package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;
import utils.BaseTest;

public class LoginTest extends BaseTest {

    @Test(priority = 1)
    public void TC_001_validLogin() throws Exception {

        LoginPage lp = new LoginPage(driver);

        test.info("Click login icon");
        lp.clickLoginIcon();

        test.info("Entering valid credentials");
        lp.login("demouser", "testingisfun99");

        test.info("Validating login success");
        Assert.assertTrue(driver.getPageSource().contains("demouser"));

        test.pass("Valid login successful");
    }

    @Test(priority = 2)
    public void TC_002_invalidLogin() throws Exception {

        LoginPage lp = new LoginPage(driver);

        lp.clickLoginIcon();
        lp.login("wronguser", "wrongpass");

        test.info("Invalid login attempted");

        Assert.assertTrue(driver.getCurrentUrl().contains("bstackdemo"));

        test.pass("Invalid login validation passed");
    }

    @Test(priority = 3)
    public void TC_003_emptyLogin() throws Exception {

        LoginPage lp = new LoginPage(driver);

        lp.clickLoginIcon();
        lp.login("", "");

        test.info("Empty login attempted");

        Assert.assertTrue(driver.getCurrentUrl().contains("bstackdemo"));

        test.pass("Empty login validation passed");
    }
}