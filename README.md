🛒 BStack E-Commerce Automation Testing Framework
📌 Project Overview

This project is an end-to-end Automation Testing Framework developed for the BrowserStack Demo E-Commerce Application (bstackdemo.com). The framework automates core shopping workflows including authentication, product filtering, cart validation, and checkout functionality.

The framework is designed using Java, Selenium WebDriver, TestNG, and Maven, following the Page Object Model (POM) architecture to ensure scalability, maintainability, and reusable test components.

This project simulates real-world enterprise automation framework design including centralized configuration handling, dynamic waits, reporting integration, and cross-browser support.

🌐 Application Under Test

BrowserStack Demo Store
https://bstackdemo.com/

The application provides typical e-commerce functionalities including:

User login and authentication

Product catalog browsing and filtering

Add to cart and cart validation

Checkout and order placement

Receipt download functionality

🎯 Automation Scope
🔐 Login Module

Validate login with valid credentials

Validate login with invalid credentials

Validate login with blank credentials

Verify error message handling

Data-driven login execution using TestNG DataProvider

🛍 Product Module

Verify product listing display

Validate product filtering based on brand selection

🛒 Cart Module

Add single product to cart

Add multiple products to cart

Validate cart item count

Verify subtotal calculation against individual item prices

Remove item from cart and validate updated subtotal

Verify cart item name validation

💳 Checkout Module

Validate checkout workflow with valid shipping details

Verify order summary and total price validation

Validate successful order placement

Automate receipt download functionality

Negative scenario – Checkout without adding items

Continue shopping workflow validation

🛠 Tech Stack
Category	Technology
Programming Language	Java (JDK 17)
Automation Tool	Selenium WebDriver
Test Framework	TestNG
Build Tool	Maven
Design Pattern	Page Object Model (POM)
Reporting	Extent Reports
Synchronization	Explicit Wait Utilities
Configuration	Properties File Handling
Version Control	Git & GitHub
Browser Management	WebDriverManager
🏗 Framework Architecture Highlights
✔ Page Object Model Implementation

Separation of locators and test logic

Improves scalability and maintainability

✔ Config Driven Execution

Browser selection managed via config.properties

Centralized URL and wait configuration

✔ Custom WebDriver Factory

Dynamic browser initialization

Chrome download directory configuration

Multi-browser support (Chrome, Edge)

✔ Wait Utility Framework

Centralized explicit wait methods

Visibility, clickability, and text change synchronization

✔ Thread-Safe Reporting Framework

Extent Reports integrated using TestNG Listeners

Step-level logging and failure screenshots

Automated HTML report generation

✔ Failure Debugging Support

Automatic screenshot capture on test failure

Report integration with screenshot evidence

src/main/java
 ├── com.jayant.framework.base
 │    └── BaseTest.java
 │
 ├── com.jayant.framework.utils
 │    ├── ConfigReader.java
 │    ├── WebDriverFactory.java
 │    ├── WaitUtils.java
 │    ├── ScreenShotUtils.java
 │    └── ExtentManager.java
 │
 └── com.jayant.pages
      ├── LoginPage.java
      ├── ProductPage.java
      ├── CartPage.java
      └── CheckOutPage.java

src/test/java
 ├── com.jayant.tests
 │    ├── LoginTest.java
 │    ├── ProductTest.java
 │    ├── CartTest.java
 │    └── CheckOutTest.java
 │
 ├── com.jayant.listener
 │    └── Listener.java
 │
 └── com.jayant.testdata
      └── LoginTestData.java

src/main/resources
 └── config.properties

ExtentReports/ – Execution reports  
ScreenShots/ – Failure screenshots  
Receipts/ – Downloaded order receipts  

testng.xml – Test suite execution  
pom.xml – Maven dependencies

✅ Test Scenarios Covered
Login

Valid login verification

Invalid login verification

Blank credential validation

Product

Product listing verification

Brand filter validation

Cart

Add item validation

Remove item validation

Cart subtotal verification

Cart item validation

Checkout

Complete checkout workflow

Order summary verification

Receipt download validation

Negative checkout validation

📊 Reporting & Debugging Features

Extent HTML execution reports

Screenshot capture on failure

Test lifecycle logging using TestNG Listener

Console logging for debugging

▶️ How To Execute The Project
Prerequisites

Java JDK 17+

Maven Installed

Chrome or Edge Browser

Git

Clone Repository
git clone <repository-url>

Run Using Maven
mvn clean test

Run Using TestNG

Execute:

testng.xml

🚀 Key Learning Outcomes

Enterprise-level automation framework design

Config-driven execution implementation

Advanced synchronization handling

Reporting and failure debugging integration

E-commerce workflow automation testing

Real-world Selenium + TestNG architecture implementation

👨‍💻 Author

Jayant Kumar Shukla
🔗 LinkedIn: https://www.linkedin.com/in/jayant-kumar-shukla

🔗 GitHub: https://github.com/jayantshukla3009-spec

📎 Notes

This project was developed as part of a capstone automation testing assignment to demonstrate real-time automation framework design and testing best practices.
