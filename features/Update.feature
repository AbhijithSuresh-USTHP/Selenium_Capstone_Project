@update
Feature: Email Updation
Background: The user has successfully logged in and is in the update information page

Scenario Outline: Updating Email using a valid email id
When the user enters a valid email address like "<email>" and clicks the submit button
Then the system redirects the user to the home page

Examples:
|email|
|admin@gmail.com|
|admin@yahoo.com|

Scenario Outline: Updating Email with an invalid email id
When the user enters an invalid email address like "<email>" and click the submit button
Then the system should display an error message Provide a valid email id

Examples:
|email|
|admin@abcd.com|
|admin@blabla.com|
