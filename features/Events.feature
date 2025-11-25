@event
Feature: Adding new events
Background: The user is logged in as admin and is in the admin dashboard

Scenario: Adding an event with a valid future date
When the admin enters the valid event details ,Date as "05/12/2025", Title as "Year End Party", Description as "Celebrate the New Year", Location as "Main Auditorium", and Presenter as "CEO"
And clicks the add button for valid case
Then the system navigates to the events page and shows the added event in the event list

Scenario: Adding an event with an invalid past date
When the admin enters the invalid event details, Date as "01/01/2001", Title as "New Year Party", Description as "Celebrate the New Year", Location as "Main Auditorium", and Presenter as "CEO"
And click the add button for invalid case
Then the system should display and error message Event date must be today or a future date
  