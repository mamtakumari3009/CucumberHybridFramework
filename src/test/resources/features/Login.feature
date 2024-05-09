Feature:Login functionality

Scenario Outline: Login with valid credentials
Given User has navigated to login page
When User enters valid email address <username> into the email field
And User enters valid password <password> into password field
And User clicks on Login button
Then User should get successfully Logged in
Examples:
|username|password|
|soulmateconnection222@gmail.com   |MamtaKumari@123|
|soulmateconnection272@gmail.com   |MamtaKumari@123|
|soulmateconnection22@gmail.com    |MamtaKumari@123|

Scenario: Login With invalid credentials
Given User has navigated to login page
When User enters invalid email address into email field
And User enters invalid password "123456789" into password field
And User clicks on Login button
Then User should get proper warning message about credentials mismatch

Scenario: Login with valid email and invalid Password
Given User has navigated to login page
When User enters valid email address "soulmateconnection222@gmail.com" into email field
And User enters invalid password "123456789" into password field
And User clicks on Login button
Then User should get proper warning message about credentials mismatch

Scenario: Login with Invalid email and valid Password
Given User has navigated to login page
When User enters invalid email address into email field
And User enters valid password "MamtaKumari@123" into password field
And User clicks on Login button
Then User should get proper warning message about credentials mismatch

Scenario: Login without providing any credentials
Given User has navigated to login page
When User do not enter email address into email field
And User do not enters password into password field
And User clicks on Login button
Then User should get proper warning message about credentials mismatch



