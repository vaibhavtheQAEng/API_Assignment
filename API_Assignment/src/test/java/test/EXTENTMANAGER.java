package test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class EXTENTMANAGER {

    public static ExtentReports extent;

    public static ExtentReports getReportObject() {

        String reportPath =
                System.getProperty("user.dir")
                + "/test-output/PetStoreExtentReport.html";

        ExtentSparkReporter reporter =
                new ExtentSparkReporter(reportPath);

        reporter.config().setReportName("PetStore API Automation Report");
        reporter.config().setDocumentTitle("PetStore API Results");

        extent = new ExtentReports();

        extent.attachReporter(reporter);

        extent.setSystemInfo("Tester", "Vaibhav");
        extent.setSystemInfo("Environment", "QA");

        return extent;
    }
}