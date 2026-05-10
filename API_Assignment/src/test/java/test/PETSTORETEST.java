package test;

import static io.restassured.RestAssured.given;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.restassured.response.Response;
import test.EXTENTMANAGER;

public class PETSTORETEST {

    int petId = 111;

    ExtentReports extent;
    ExtentTest test;

    @BeforeSuite
    public void setupReport() {

        extent = EXTENTMANAGER.getReportObject();
    }
    @Test(priority = 1)
    public void TC01_FindPetByStatus() {

        test = extent.createTest("TC01_FindPetByStatus");

        Response response =

                given()
                .when()
                .get("https://petstore.swagger.io/v2/pet/findByStatus?status=available");

        response.then().log().body();

        System.out.println("Status Code : " + response.statusCode());

        test.info("Pet status fetched successfully");
    }

    @Test(priority = 2)
    public void TC02_AddPet() {

        test = extent.createTest("TC02_AddPet");

        Response response =

                given()
                .header("Content-Type", "application/json")
                .body("{\r\n"
                        + "\"id\": 111,\r\n"
                        + "\"category\": {\r\n"
                        + "\"id\": 0,\r\n"
                        + "\"name\": \"string\"\r\n"
                        + "},\r\n"
                        + "\"name\": \"doggie\",\r\n"
                        + "\"photoUrls\": [\"string\"],\r\n"
                        + "\"tags\": [{\r\n"
                        + "\"id\": 0,\r\n"
                        + "\"name\": \"string\"\r\n"
                        + "}],\r\n"
                        + "\"status\": \"available\"\r\n"
                        + "}")
                .when()
                .post("https://petstore.swagger.io/v2/pet");

        response.then().log().body();

        System.out.println("Status Code : " + response.statusCode());

        test.info("New pet added successfully");
    }

    @Test(priority = 3)
    public void TC03_FindPetById() {

        test = extent.createTest("TC03_FindPetById");

        Response response =

                given()
                .when()
                .get("https://petstore.swagger.io/v2/pet/" + petId);

        response.then().log().body();

        System.out.println("Status Code : " + response.statusCode());

        test.info("Pet fetched using pet ID");
    }

    @Test(priority = 4)
    public void TC04_UpdatePet() {

        test = extent.createTest("TC04_UpdatePet");

        Response response =

                given()
                .header("Content-Type", "application/json")
                .body("{\r\n"
                        + "\"id\": 111,\r\n"
                        + "\"category\": {\r\n"
                        + "\"id\": 0,\r\n"
                        + "\"name\": \"string\"\r\n"
                        + "},\r\n"
                        + "\"name\": \"UpdatedDog\",\r\n"
                        + "\"photoUrls\": [\"string\"],\r\n"
                        + "\"tags\": [{\r\n"
                        + "\"id\": 0,\r\n"
                        + "\"name\": \"string\"\r\n"
                        + "}],\r\n"
                        + "\"status\": \"sold\"\r\n"
                        + "}")
                .when()
                .put("https://petstore.swagger.io/v2/pet");

        response.then().log().body();

        System.out.println("Status Code : " + response.statusCode());

        test.info("Pet updated successfully");
    }

    @Test(priority = 5)
    public void TC05_DeletePet() {

        test = extent.createTest("TC05_DeletePet");

        Response response =

                given()
                .when()
                .delete("https://petstore.swagger.io/v2/pet/" + petId);

        response.then().log().body();

        System.out.println("Status Code : " + response.statusCode());

        test.info("Pet deleted successfully");
    }

    @AfterMethod
    public void getResult(ITestResult result) {

        if (result.getStatus() == ITestResult.SUCCESS) {

            test.pass("Test Case Passed");
        }

        else if (result.getStatus() == ITestResult.FAILURE) {

            test.fail("Test Case Failed");
            test.fail(result.getThrowable());
        }

        else {

            test.skip("Test Case Skipped");
        }
    }

    @AfterSuite
    public void tearDown() {

        extent.flush();
    }
}