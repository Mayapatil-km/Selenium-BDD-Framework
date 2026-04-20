#we will write the name of the feature which we are going to perform actions on 

#we will write the scenario discription in the scenario
#in given we will write the pre condition required
#in when we will write the actios we are performing
#in Then we will write the validations 
@Login
Feature: Login Feature

@smoke @regression
Scenario: User should be able to log in valid cresentials

When user enters valid creds using "valid creds" data
Then user varifies the dashboard page is loaded

#multiple data passing
@sanity @regression
Scenario Outline: User should not be able to login with invalid credentials

When user enters valid creds using "<Testcase>" data
Then user varifies the error massage
And user varifies the fileds on the dashboard page

Examples:
| Testcase        |
| invalid username|
| invalid password|
| invalid creds   |
