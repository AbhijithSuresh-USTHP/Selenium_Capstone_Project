@login
Feature: Signin
Background: The user is in the Sign in page

Scenario Outline: Signin with valid details
When The user enters username as "<username>" and password as "<password>"
Then system redirects the user to the HOME page

Examples:
|username|password|
|admin|admin|
|guest|guest|

Scenario Outline: Signin with invalid details
When the user enters the username as "<username>" and password as "<password>"
Then system shows an error message Login or password in incorrect

Examples:
|username|password|
|admin|guest|
|guest|admin|
