Feature: Search Functionality

Scenario: User searches for a valid product
Given User opens the Application
When User enters valid product "HP" into searchbox field
And User clicks on Search button
Then User should get valid product display in the search results

Scenario: User searches for a invalid product
Given User opens the Application
When User enters invalid product "HONDA" into searchbox field
And User clicks on Search button
Then User should get a message about no product matching

Scenario: User searches without any product
Given User opens the Application
When User do not enter any product name into searchbox field
And User clicks on Search button
Then User should get a message about no product matching