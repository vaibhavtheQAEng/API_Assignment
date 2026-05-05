package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.Base_1;

public class TestScenariosToAutomate extends Base_1 {

    @Test(priority=1, groups="Smoke")
    public void TC01_verifyHomePage() {

        HomePage_1 HP = new HomePage_1(driver);

        Assert.assertTrue(HP.isFromCityDisplayed());
        Assert.assertTrue(HP.isToCityDisplayed());
    }

    @Test(priority=2, groups="Functional")
    public void TC02_searchFlights() {

        HomePage_1 HP = new HomePage_1(driver);
        HP.searchFlight("Boston", "New York");

        Assert.assertTrue(driver.getTitle().contains("BlazeDemo"));
    }

    @Test(priority=3, groups="Functional")
    public void TC03_completeBooking() {

        HomePage_1 HP = new HomePage_1(driver);
        HP.searchFlight("Boston", "London");

        ReservePage_1 RS = new ReservePage_1(driver);
        RS.SelectFlight("Lufthansa");

        PurchasePage_1 PP = new PurchasePage_1(driver);
        PP.fillDetails("Vaibhav", "Pune", "Pune", "123456");
        PP.clickPurchase();

        String msg = new ConfirmationPage_1(driver).getMessage();

        Assert.assertTrue(msg.contains("Thank you"));
    }

    @Test(priority=4, groups="Data-driven")
    public void TC04_multipleBooking() {

        HomePage_1 HP = new HomePage_1(driver);
        HP.searchFlight("Boston", "Paris");

        new ReservePage_1(driver).SelectFlight("Lufthansa");

        PurchasePage_1 PP = new PurchasePage_1(driver);
        PP.fillDetails("User1", "Addr", "City", "1111");
        PP.clickPurchase();

        Assert.assertTrue(new ConfirmationPage_1(driver)
                .getMessage().contains("Thank you"));
    }

    @Test(priority=5, groups="Negative")
    public void TC05_blankCard() {

        HomePage_1 HP = new HomePage_1(driver);
        HP.searchFlight("Boston", "Rome");

        new ReservePage_1(driver).SelectFlight("Lufthansa");

        PurchasePage_1 PP = new PurchasePage_1(driver);
        PP.fillDetails("Test", "Addr", "City", "");
        PP.clickPurchase();

        Assert.assertFalse(driver.getPageSource().contains("Thank you"));
    }

    @Test(priority=6, groups="Negative")
    public void TC06_invalidCard() {

        HomePage_1 HP = new HomePage_1(driver);
        HP.searchFlight("Boston", "Berlin");

        new ReservePage_1(driver).SelectFlight("Lufthansa");

        PurchasePage_1 PP = new PurchasePage_1(driver);
        PP.fillDetails("Test", "Addr", "City", "abcd123");
        PP.clickPurchase();

        Assert.assertFalse(driver.getPageSource().contains("Thank you"));
    }

        @Test(priority=7)
    public void TC07_sameCity() {

        HomePage_1 HP = new HomePage_1(driver);
        HP.searchFlight("Boston", "Boston");

        Assert.assertTrue(driver.getPageSource().contains("Flights"));
    }
}