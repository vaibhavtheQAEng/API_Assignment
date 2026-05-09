package telecome_RestAssured_Capstone3;

import static io.restassured.RestAssured.given;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.restassured.response.Response;
import utils.ExtentManager;

public class TelecomeProjectTestcases {

    String userToken;
    String contactId;

    String email =
            "vnb" + System.currentTimeMillis() + "@gmail.com";

    ExtentReports extent;
    ExtentTest test;

    @BeforeSuite
    public void setupReport() {

        extent = ExtentManager.getReportObject();
    }

    @Test(priority = 1)
    public void TC01_AddUser() {

        test = extent.createTest("TC01_AddUser");

        Response response =

                given()
                .header("Content-Type", "application/json")
                .body("{\r\n"
                        + "\"firstName\": \"Vaibhav\",\r\n"
                        + "\"lastName\": \"Bhavsar\",\r\n"
                        + "\"email\": \"" + email + "\", \r\n"
                        + "\"password\": \"vnb@123\"\r\n"
                        + "}")
                .when()
                .post("https://thinking-tester-contact-list.herokuapp.com/users");

        response.then().log().body();

        userToken = response.jsonPath().getString("token");

        System.out.println("Token is : " + userToken);
        System.out.println("Status code is : " + response.statusCode());

        test.info("User created successfully");
    }

    @Test(priority = 2)
    public void TC02_GetUserProfile() {

        test = extent.createTest("TC02_GetUserProfile");

        Response response =

                given()
                .header("Authorization", "Bearer " + userToken)
                .when()
                .get("https://thinking-tester-contact-list.herokuapp.com/users/me");

        response.then().log().body();

        System.out.println("Status code is : " + response.statusCode());

        test.info("User profile fetched successfully");
    }

    @Test(priority = 3)
    public void TC03_UpdateUser() {

        test = extent.createTest("TC03_UpdateUser");

        Response response =

                given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + userToken)
                .body("{\r\n"
                        + "\"firstName\": \"Updated\",\r\n"
                        + "\"lastName\": \"Bhavsar\",\r\n"
                        + "\"email\": \"" + email + "\", \r\n"
                        + "\"password\": \"newpass123\"\r\n"
                        + "}")
                .when()
                .patch("https://thinking-tester-contact-list.herokuapp.com/users/me");

        response.then().log().body();

        System.out.println("Status code is : " + response.statusCode());

        test.info("User updated successfully");
    }

    @Test(priority = 4)
    public void TC04_LoginUser() {

        test = extent.createTest("TC04_LoginUser");

        Response response =

                given()
                .header("Content-Type", "application/json")
                .body("{\r\n"
                        + "\"email\": \"" + email + "\",\r\n"
                        + "\"password\": \"newpass123\"\r\n"
                        + "}")
                .when()
                .post("https://thinking-tester-contact-list.herokuapp.com/users/login");

        response.then().log().body();

        userToken = response.jsonPath().getString("token");

        System.out.println("New Token is : " + userToken);
        System.out.println("Status code is : " + response.statusCode());

        test.info("Login successful");
    }

    @Test(priority = 5)
    public void TC05_AddContact() {

        test = extent.createTest("TC05_AddContact");

        Response response =

                given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + userToken)
                .body("{\r\n"
                        + "\"firstName\": \"John\",\r\n"
                        + "\"lastName\": \"Doe\",\r\n"
                        + "\"birthdate\": \"1970-01-01\",\r\n"
                        + "\"email\": \"jdoe@fake.com\",\r\n"
                        + "\"phone\": \"8005555555\",\r\n"
                        + "\"street1\": \"1 Main St.\",\r\n"
                        + "\"street2\": \"Apartment A\",\r\n"
                        + "\"city\": \"Anytown\",\r\n"
                        + "\"stateProvince\": \"KS\",\r\n"
                        + "\"postalCode\": \"12345\",\r\n"
                        + "\"country\": \"USA\"\r\n"
                        + "}")

                .when()
                .post("https://thinking-tester-contact-list.herokuapp.com/contacts");

        response.then().log().body();

        contactId = response.jsonPath().getString("_id");

        System.out.println("Contact ID is : " + contactId);
        System.out.println("Status code is : " + response.statusCode());

        test.info("Contact added successfully");
    }

    @Test(priority = 6)
    public void TC06_GetContactList() {

        test = extent.createTest("TC06_GetContactList");

        Response response =

                given()
                .header("Authorization", "Bearer " + userToken)
                .when()
                .get("https://thinking-tester-contact-list.herokuapp.com/contacts");

        response.then().log().body();

        System.out.println("Status code is : " + response.statusCode());

        test.info("Contact list fetched successfully");
    }

    @Test(priority = 7)
    public void TC07_GetSingleContact() {

        test = extent.createTest("TC07_GetSingleContact");

        Response response =

                given()
                .header("Authorization", "Bearer " + userToken)
                .when()
                .get("https://thinking-tester-contact-list.herokuapp.com/contacts/" + contactId);

        response.then().log().body();

        System.out.println("Status code is : " + response.statusCode());

        test.info("Single contact fetched successfully");
    }

    @Test(priority = 8)
    public void TC08_UpdateFullContact() {

        test = extent.createTest("TC08_UpdateFullContact");

        Response response =

                given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + userToken)
                .body("{\r\n"
                        + "\"firstName\": \"Amy\",\r\n"
                        + "\"lastName\": \"Miller\",\r\n"
                        + "\"birthdate\": \"1992-02-02\",\r\n"
                        + "\"email\": \"amy@fake.com\",\r\n"
                        + "\"phone\": \"9999999999\",\r\n"
                        + "\"street1\": \"Street 1\",\r\n"
                        + "\"street2\": \"Apartment 2\",\r\n"
                        + "\"city\": \"Toronto\",\r\n"
                        + "\"stateProvince\": \"ON\",\r\n"
                        + "\"postalCode\": \"123456\",\r\n"
                        + "\"country\": \"Canada\"\r\n"
                        + "}")
                .when()
                .put("https://thinking-tester-contact-list.herokuapp.com/contacts/" + contactId);

        response.then().log().body();

        System.out.println("Status code is : " + response.statusCode());

        test.info("Full contact update successful");
    }

    @Test(priority = 9)
    public void TC09_UpdatePartialContact() {

        test = extent.createTest("TC09_UpdatePartialContact");

        Response response =

                given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + userToken)
                .body("{\r\n"
                        + "\"firstName\": \"Anna\"\r\n"
                        + "}")
                .when()
                .patch("https://thinking-tester-contact-list.herokuapp.com/contacts/" + contactId);

        response.then().log().body();

        System.out.println("Status code is : " + response.statusCode());

        test.info("Partial contact update successful");
    }

    @Test(priority = 10)
    public void TC10_LogoutUser() {

        test = extent.createTest("TC10_LogoutUser");

        Response response =

                given()
                .header("Authorization", "Bearer " + userToken)
                .when()
                .post("https://thinking-tester-contact-list.herokuapp.com/users/logout");

        response.then().log().body();

        System.out.println("Status code is : " + response.statusCode());

        test.info("Logout successful");
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