Feature: Login Application
  In order to check authentication of legitimate user to newtours, I want to check login functionality
 
Scenario Outline: Successful Login with Valid Credentials 
    Given User is on Home Page
    When User Navigate to LogIn Page
    And User enters <username> and <password>
    Then Home Page Displayed Successfully with "Find a Flight: Mercury Tours:" Page Title
Examples:
	|username|password|
	|hemanto|123123|
	|tinyowl|123456|

	
	