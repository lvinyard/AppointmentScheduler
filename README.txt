##Title and Purpose
Title: Appointment Scheduler

Purpose: The purpose of this application is to serve as an Appointment/Customer management system. The program features CRUD operations for the given mySQL database.
Customers can be created, modified and deleted. Appointments can be created, modified and deleted. All of this data is persistent as it is saved into the mySQL database.
The application also features a small reporting section where simple reports about the system can be viewed.

##Student Information
Author: Lucas Vinyard
Contact Information: lvinya1@wgu.edu
Student Application version: v1.0
Date: 2/19/2023

##Requirements
IDE: Intellij Community Edition 2022.3.2
JDK Version: 17.0.6 (corretto)
JavaFX Version: 17.0.2 (maven)
MySQL Connector: mysql-connector-j-8.0.32

##Additional Report
The additional report I added as part of A3f is a simple table that groups customers into what division they reside in.

##LAMBDA
The Lambda expressions are commented in the java docs. You will find them in ReportingController.java and ModifyCustomer.java
**Revised 2/20/23: Added an additional Lamdba function that is different than the above two. This new function can be found in the helper.Alerts.java file. Javadocs have been updated.

##How to Run application
1. Extract folder from Zip file
2. Open Intellij
3. Select Open, Navigate to my Project
4. Trust Project
5. File > Project Structure > Change Libraries for mysqlConnector
    5a. May need to remove my path and add your path to mysqlConnector
    5b. Apply > OK
6. Run Project
    6a. Should see in Console "Connection Successful". This means the mySqlConnector is working, and you may continue.
        If you see an error with mySqlConnector, then revisit step 5. I have tested this in the VM workspace. It should work with connector 8.0.25.