Selenium ProductsTest — Automated UI Testing Framework

This project is a complete UI Test Automation framework for the web application https://www.saucedemo.com/
The framework is built using:
•	Java
•	Selenium WebDriver
•	TestNG
•	Page Object Model (POM)
•	Allure Reports
•	WebDriverManager
•	Maven
•	GitHub Actions (CI/CD Pipeline)
•	IntelliJ IDEA
It covers essential end to end scenarios such as login, product sorting, price validation, and adding items to the cart.

Test Scenarios
•	Valid login → user is redirected to the Products page
•	Invalid login → error message is displayed
•	Sort products A → Z
•	Sort products Z → A
•	Sort products by price (low → high)
•	Add a product to the cart

Project Structure
Cod
src/
 ├── main/java/org.example
 │     ├── BasePage.java
 │     ├── LoginPage.java
 │     └── ProductsPage.java
 └── test/java/org.example
       ├── BaseTest.java
       └── ProductsTest.java

Page Object Overview
BasePage
Common reusable methods:
•	waitForVisible
•	click
•	type
•	getText
LoginPage
Login page actions:
•	enter username
•	enter password
•	click Login
•	validate error message
ProductsPage
Functionalities:
•	sorting by name and price
•	retrieving product titles and prices
•	adding items to cart
BaseTest
Configures:
•	WebDriver
•	WebDriverWait
•	ChromeOptions
ProductsTest
Contains all automated UI test scenarios.

Technologies Used:
Technology	Purpose
Java	Main programming language
Selenium WebDriver	Browser automation
TestNG	Test framework
WebDriverManager	Driver management
Maven	Build & dependency management
Allure Reports	Advanced reporting
GitHub Actions	CI/CD pipeline
IntelliJ IDEA	IDE used

How to Run the Project
1.	Clone the repository:
git clone <repository-url>
2.	Open the project in IntelliJ IDEA
3. Run the tests
You can run:
•	the entire test suite
•	or the ProductsTest class directly
(Chrome must be installed on your system.)

Generate Allure Report
After running the tests, the folder allure-results is created automatically.
To generate the report:
allure serve allure-results
The report will open in your browser.
CI/CD — GitHub Actions
The project includes a GitHub Actions workflow that automatically runs Selenium tests on every push to the master branch.
The pipeline:
•	installs Java & Maven
•	installs Google Chrome
•	runs TestNG tests
•	uploads allure-results as artifacts
•	marks the build as success or failed
•	allows viewing execution logs in the Actions tab
Workflow file location:
.github/workflows/selenium-tests.yml

Example Test Scenarios
Valid Login
•	Open login page
•	Enter valid username and password
•	Verify redirect to Products page
•	Verify 6 products are displayed
Invalid Login
•	Enter valid username + wrong password
•	Click Login
•	Verify error message
Sort A → Z
•	Select sorting: Name (A to Z)
•	Validate alphabetical order
Sort Z → A
•	Select sorting: Name (Z to A)
•	Validate descending order
Sort by Price (low → high)
•	Select sorting: Price (low to high)
•	Validate ascending price order
Add Product to Cart
•	Select Sauce Labs Backpack
•	Click Add to cart
•	Verify button changes to Remove

