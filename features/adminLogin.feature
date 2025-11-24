@admin
Feature: Admin dashboard
Background: The user is in the login page
Scenario: Accessing admin dashboard as admin
When the user clicks the admin button and enters the username as "admin" and password as "admin" 
Then the system redirects the user to admin dashboard

Scenario: Accessing admin dashboard as guest
When the user tries clicking the admin button and  enters the username as "guest" and password as "guest" 
Then the system does not redirect the user to the login page and keeps the user in the login page