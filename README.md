🛒 BStack E-Commerce Automation Testing Framework
📌 Project Overview

This project is an End-to-End Automation Testing Framework developed for the BrowserStack Demo E-Commerce Application.

The framework automates complete shopping workflows including:

User Authentication

Product Filtering & Catalog Validation

Cart Functional Validation

Checkout & Order Placement

Receipt Download Verification

The framework is designed using Java, Selenium WebDriver, TestNG, and Maven, following Page Object Model (POM) and modern Thread-Safe Automation Architecture to ensure scalability, maintainability, and parallel test execution support.

🌐 Application Under Test (AUT)

BrowserStack Demo Store
👉 https://bstackdemo.com/

The application simulates real-world e-commerce workflows including:

User Login & Authentication

Product Browsing & Filtering

Add to Cart & Cart Management

Checkout & Order Placement

Order Receipt Download

🚀 Framework Key Highlights
✔ Thread-Safe WebDriver Architecture

Implemented ThreadLocal WebDriver

Enables safe parallel execution

Ensures complete test isolation

✔ Parallel Execution Support

TestNG parallel class execution

Multiple browser instances run simultaneously

Improved execution speed & scalability

✔ Page Object Model (POM)

Separation of locators and business logic

Improves maintainability and reusability

Supports scalable test design

✔ Config-Driven Framework

Centralized configuration via config.properties

Supports dynamic browser selection

Centralized wait & environment handling

✔ Custom WebDriver Factory

Dynamic driver initialization

Multi-browser support (Chrome & Edge)

Download directory configuration

✔ Advanced Synchronization Handling

Centralized Explicit Wait Utility

Handles:

Visibility synchronization

Clickability synchronization

Dynamic text update validation

✔ Reporting & Debugging Support

Extent Reports Integration

Screenshot capture on failure

Step-level logging using TestNG Listeners

✔ Failure Debugging Capability

Automatic screenshot capture

Detailed failure logging

Execution report integration

Framework Architecture
Driver Lifecycle Flow
Test Class
   ↓
BaseTest
   ↓
WebDriverFactory (ThreadLocal Driver)
   ↓
Page Classes & Utilities
   ↓
Driver Cleanup (Post Test Execution)

Project Structure

src/main/java
 ├── framework/base
 │    └── BaseTest.java
 │
 ├── framework/utils
 │    ├── ConfigReader.java
 │    ├── WebDriverFactory.java
 │    ├── WaitUtils.java
 │    ├── ScreenShotUtils.java
 │    └── ExtentManager.java
 │
 └── pages
      ├── LoginPage.java
      ├── ProductPage.java
      ├── CartPage.java
      └── CheckOutPage.java

src/test/java
 ├── tests
 │    ├── LoginTest.java
 │    ├── ProductTest.java
 │    ├── CartTest.java
 │    └── CheckOutTest.java
 │
 ├── listener
 │    └── Listener.java
 │
 └── testdata
      └── LoginTestData.java

resources
 └── config.properties

🎯 Automation Coverage
🔐 Login Module

Valid login verification

Invalid login validation

Blank credential validation

Error message verification

Data-Driven login execution using TestNG DataProvider

🛍 Product Module

Product listing verification

Brand filter validation

🛒 Cart Module

Add single item to cart

Add multiple items to cart

Cart item count validation

Subtotal calculation verification

Remove item validation

Cart item name validation

💳 Checkout Module

Checkout workflow validation

Order summary validation

Successful order placement

Receipt download automation

Negative checkout validation

Continue shopping workflow

🛠 Technology Stack
Category	Technology
Programming Language	Java (JDK 17)
Automation Tool	Selenium WebDriver
Test Framework	TestNG
Build Tool	Maven
Design Pattern	Page Object Model
Reporting	Extent Reports
Synchronization	Explicit Wait Utilities
Configuration	Properties File
Version Control	Git & GitHub
Browser Management	WebDriverManager
⚡ Parallel Execution Support

This framework supports parallel test execution using:

TestNG Class Level Parallel Execution

ThreadLocal WebDriver Implementation

Test Isolation & Resource Safety

📊 Reporting & Debugging Features

Extent HTML Execution Reports

Screenshot Capture on Failure

Test Lifecycle Logging

Detailed Execution Logs

▶️ How To Execute The Project
🔧 Prerequisites

Java JDK 17+

Maven Installed

Chrome / Edge Browser

Git Installed

Clone Repository
git clone https://github.com/jayantshukla3009-spec/bstack-selenium-automation-framework.git

Run Using Maven
mvn clean test

Run Using TestNG

Execute:

testng.xml

📁 Generated Outputs

ExtentReports/ → Execution Reports

ScreenShots/ → Failure Screenshots

Receipts/ → Downloaded Order Receipts

🎓 Key Learning Outcomes

Enterprise-Level Automation Framework Design

Thread-Safe Driver Architecture Implementation

Parallel Execution Handling

Config-Driven Test Execution

Advanced Synchronization Handling

Reporting & Failure Debugging Integration

Real-World E-Commerce Workflow Testing

👨‍💻 Author

Jayant Kumar Shukla

🔗 LinkedIn
https://www.linkedin.com/in/jayant-kumar-shukla

🔗 GitHub
https://github.com/jayantshukla3009-spec

📎 Notes

This project was developed as part of a capstone automation assignment to demonstrate real-time automation framework architecture, parallel execution design, and industry-level testing best practices.
