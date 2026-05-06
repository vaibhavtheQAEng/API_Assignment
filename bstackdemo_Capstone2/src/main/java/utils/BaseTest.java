package utils;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.*;

public class BaseTest {

    public WebDriver driver;
    public ExtentReports extent;
    public ExtentTest test;

    ConfigReader config;

    @BeforeMethod
    public void setup(Method method) {

        config = new ConfigReader();

        driver = WebDriverFactory.initDriver(config.getBrowser());
        driver.manage().window().maximize();
        driver.get(config.getUrl());

        extent = ExtentReportManager.getReport();
        test = extent.createTest(method.getName());
    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE) {
            test.fail(result.getThrowable());
        } else {
            test.pass("Test Passed");
        }

        extent.flush();
        driver.quit();
    }
}