# Software Principles Assignment 011
## Introduction
This project implements in Java code the expense managment system designed in *Assignment 010*.  Details of the design can be found in the document **MOD003484 - Assignment 010.pdf**.

(See the file header in *Application.java* for SID and assignment 10 team name)

## Code layout
* The `expense_system` package contains all of the Java code
* The 3 files *Teams.csv*, *Users.csv*, and *Expenses.csv* at the root level are required to run the Application

## Instructions
* Running the `main()` method in the `Application` class will load an initial state from CSV files
* The application creates a simple menu-driven console interface
* The user *Matthew* with password *password* can be used to login and test the application
* The logged in user can choose to change their password, file new expenses, or add new users
* Upon logout or application quit, the .csv files will be updated to store the application state

Some extra help details are built into the application menus, and some ideas for further work to improve the application can be found in *TODO.md*.
