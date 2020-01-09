# Andreys
Java Web Development Basics Exam - 17 December 2019
Andrey's is an shop application. There are several requirements you must follow in the implementation.
1.	Database Requirements
The Database of the Andrey's application needs to support 2 entities:
User
•	Has an Id – UUID-string
•	Has a Username
•	Has a Password
•	Has an Email
Product
•	Has an Id – UUID-string
•	Has a Name
•	Has a Description
•	Has a Price
•	Has a Category – option between (Shirt, Denim, Shorts ,Jacket)
•	Has a Sex – option between (Male and Female)
Implement the entities with the correct datatypes and implement repositories for them.
Page Requirements
Index Page (logged out user)
 
Login Page (logged out user)
 
Register Page (logged out user)
 
Home Page (logged in user)
 
Add Product (logged in user)
 
Product Details Page (logged in user)
 
 
The templates have been given to you in the application skeleton, so make sure you implement the pages correctly. 
NOTE: The templates should look EXACTLY as shown above.
NOTE: The templates do NOT require additional CSS for you to write. Only bootstrap and the given css are enough.
Functional Requirements
The Functionality Requirements describe the functionality that the Application must support.
The application should provide Guest (not logged in) users with the functionality to login, register and view the Index page.
The application should provide Users (logged in) with the functionality to logout, add a Product, view details about a Product, delete a Product, and view all Products(Home page). 
Andray's button in navbar should redirect to appropriate URL depending on that if the user is logged in.
The application should provide functionality for adding products with category (Shirt, Denim, Shorts, Jacket) and sex(Male,Female)
The image is combination between category and sex. When you click on the image on Home Page, you should be redirected to Details page. On Details page you should have Delete button.
The application should store its data into a MySQL database, using Hibernate native.
Security Requirements
The Security Requirements are mainly access requirements. Configurations about which users can access specific functionalities and pages.
•	Guest (not logged in) users can access Index page.
•	Guest (not logged in) users can access Login page.
•	Guest (not logged in) users can access Register page.
•	Users (logged in) can access Home page.
•	Users (logged in) can access Product Add page.
•	Users (logged in) can access Product Details page.
•	Users (logged in) can access Logout functionality.
