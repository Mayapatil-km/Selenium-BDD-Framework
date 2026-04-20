@Admin
Feature: Admin feature

@smoke @regression
Scenario: User should be able to access admin feature

When user enters valid creds using "valid creds" data
Then user varifies the dashboard page is loaded
When user navigates to AdminPage and requaired details