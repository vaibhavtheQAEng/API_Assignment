# Flight Booking Automation Framework (Capstone Project)

## Project Overview

This project is an end-to-end **Test Automation Framework** developed using **Selenium WebDriver, Java, TestNG, and Page Object Model (POM)**.

The framework automates key functionalities of a flight booking application (BlazeDemo) including:

* Flight search
* Flight selection
* Booking confirmation
* Negative and data-driven scenarios

## Tech Stack

* **Language:** Java
* **Automation Tool:** Selenium WebDriver
* **Test Framework:** TestNG
* **Design Pattern:** Page Object Model (POM)
* **Build Tool:** Maven
* **IDE:** Eclipse

---

## Project Structure

```
FlightBookingFramework/
│
├── src/test/java
│   ├── pages/
│   │   ├── HomePage_1.java
│   │   ├── ReservePage_1.java
│   │   ├── PurchasePage_1.java
│   │   ├── ConfirmationPage_1.java
│   │
│   ├── utils/
│       ├── Base_1.java
│   ├── tests/
│       ├── TestScenariosToAutomate.java
│
├── pom.xml
└── testng.xml
└── README.md  

```

---

## Features Implemented

### Functional Testing

* Search flights between cities
* Select flight based on airline
* Complete booking flow

### Smoke Testing

* Verify homepage loads successfully
* Validate dropdown visibility

### Negative Testing

* Blank credit card scenario
* Invalid credit card input
* Same source and destination

### Data-Driven Testing

* Multiple booking scenarios using TestNG DataProvider

---

## Test Scenarios Covered



TC01_Verify homepage loads and dropdowns visible_Smoke

TC02_Search flights with valid cities_Functional

TC03_Complete a flight booking_Functional

TC04_Multiple bookings with different data sets_Data-driven

TC05_Blank credit card_Negative

TC06_Invalid credit card characters_Negative

TC07_Same departure and destination city_Negative

---

## How to Run the Project

### 1. Clone the repository

```
git clone <your-repo-url>
```

### 2. Import into IDE

* Open Eclipse
* Import as **Maven Project**

### 3. Install Dependencies

```
Right Click Project → Maven → Update Project
```

### 4. Run Tests

* Run via TestNG:

```
Right Click → Run As → TestNG Test
```

OR via terminal:

```
mvn test
```

---

## Known Limitations

* The BlazeDemo application does **not validate credit card inputs**, so some negative test cases may pass unexpectedly.
* Basic synchronization is used (can be improved with explicit waits).

---

## Future Enhancements

* Add **Extent Reports / Allure Reports**
* Integrate **Log4j logging**
* Add **Cross-browser testing**
* Implement **CI/CD (Jenkins/GitHub Actions)**
* Replace Thread.sleep with **WebDriverWait**
* Add **Screenshot capture on failure**

---

## Key Learnings

* Implementation of **Page Object Model (POM)**
* Handling **web elements using Selenium locators**
* Writing **TestNG test cases with priorities & DataProviders**
* Debugging real-world automation issues
* Understanding **application limitations vs automation failures**

---

## Author

**Vaibhav Bhavsar**

---

## Conclusion

This project demonstrates a complete automation framework setup with structured design, reusable components, and real-world test scenarios, making it suitable for interview discussions and practical automation learning.

---
