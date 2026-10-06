# Selenium Framework Lessons

A Selenium WebDriver automation framework built with Java, TestNG, and Page Object Model (POM) patterns for end-to-end UI testing.

This project is designed to demonstrate practical test automation architecture, reusable utilities, and test reporting in a clean, maintainable structure.

## Tech Stack

- Java 17
- Selenium 4.18.1
- TestNG 7.9.0
- Apache POI 5.2.5
- Extent Reports 5.1.1
- Maven
- ChromeDriver / WebDriver management

## Architecture Overview

This project follows a modular Selenium framework structure that separates test logic, page logic, and reusable utilities.

```text
Lessons/
├── src/
│   └── test/
│       └── java/
│           ├── lessons/
│           │   ├── TestScripts/
│           │   │   └── LoginTest.java
│           │   ├── PageObjects/
│           │   │   └── LoginPage.java
│           │   └── utilities/
│           │       ├── DriversUtility.java
│           │       ├── ListenersUtility.java
│           │       └── ...
│           └── lessonsBaseTest/
│               └── BaseTest.java
├── Reports/
├── pom.xml
├── testng.xml
├── README.md
└── target/
```

## Framework Design

### 1. Page Object Model (POM)
Page classes encapsulate the UI elements and actions for each page, keeping test logic clean and maintainable.

Example responsibilities:
- locating web elements
- sending values to input fields
- clicking actions
- page-specific business flows

### 2. Base Test Layer
The base test class provides common setup and teardown operations, including:
- browser startup
- navigation to the application URL
- teardown/quit browser

### 3. Utility Layer
Reusable utility classes centralize common actions such as:
- WebDriver initialization and browser management
- window handling
- page navigation
- test listeners
- report generation

### 4. Test Scripts Layer
Test scripts focus on assertions and end-to-end workflow validation without repeating manual setup logic.

### 5. Reporting Layer
Extent Reports are used to produce detailed test execution reports showing test pass/fail status and execution summaries.

## What This Project Demonstrates

- Selenium WebDriver automation for a real web application
- TestNG annotations and test priorities
- Page Object Model implementation
- Reusable utility classes
- Browser lifecycle setup and teardown
- Assertions and validations
- HTML reporting with Extent Reports
- Clean and scalable framework structure

## Current Test Coverage

The current test class verifies a SauceDemo login flow and validates:

- page title
- expected URL
- number of links on the page
- successful login redirect to the inventory page

## Prerequisites

- Java 17 or higher
- Maven
- Chrome browser
- Internet access for the live application being tested

## How to Run

```bash
git clone https://github.com/anithaswam95-beep/Lessons.git
cd Lessons
mvn test
```

## Test Execution Notes

This framework is built for learning and practice and follows common enterprise UI automation patterns. It can be expanded with:

- additional page objects
- data-driven testing
- screenshot capture on failure
- cross-browser execution
- CI integration with GitHub Actions

## Why This Project Matters

This repository is a strong example of Selenium framework thinking and structured automation design. It shows the ability to build maintainable, testable automation code that separates concerns between:

- page interactions
- test logic
- browser utilities
- reporting

## Suggested Next Improvements

- Add more page objects for other application flows
- Implement Excel-driven test data
- Add screenshot attachments for failed tests
- Add cross-browser parameterization
- Integrate with CI/CD workflows

## Summary

This project reflects a practical Selenium automation framework mindset and is a useful portfolio project for demonstrating UI automation skills, framework structure, and professional test practices.

