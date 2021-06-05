Front Gate Tickets Test Automation

This  project is written in Java to autmate a ticket purchase scenario.

Test Scenario:
A brand new user will purchase 1 of Ticket 'GA pass GA' for 'edc test event'

Test Case overview:
Given a User will open the website qatest.frontgatetickets.com
And Go to the event 'edc test event'
And add 1 ticket for 'GA pass GA' to cart
And create a new account
And checkout with credit card
Then will get a success checkout message with orderID

Validations:
- 'edc test event' is displayed on page
- the event venue is displayed -> 'South Austin Recreation Centah (Park)'
- All 'SOLD OUT' tickets will be logged


Prerequisites
JDK8 installed
Chrome Browser installed
Build tool used is Maven. pom.xml has the Maven Configuration

Features:
Can be used in FireFox, Chrome, Edge and IE browsers
Page Object Model is used to define UI elements under the UIElements package. All UI elements are seperated according to the related web page/function
ConstantVariables under the Utility package contains all the constants used throughout the project
Log4J is used for Logging Purposes
TestNG default test reporting is used

How to Run the Test:
Uncomment/Comment the necessary driver setup statements according to the browser to be used in TicketPurchaseTest.java class under @BeforeClass
Default is Chrome Browser
Before running a test user email must be changed to a unique e-mail:
ConstantVariables - String email variable

TicketPurchaseTest.Java class has the main test case. newAccountTicketPurchase method with @Test annotation is the Test Runner

Reporting:
The test report is under test-output folder. Open the index.html in a browser
The logs can be found in the logfile.log file

Maintenance:
To add or change the UI elements use the related POM class
To define or modify new constant variable use ConstantVariables class
Wait times can be redefined according to test responses

Improvements to be done:
Validation of each webelement used
Validation wrong input format messages
Validation of invalid credit card info
Validation of existing email input
