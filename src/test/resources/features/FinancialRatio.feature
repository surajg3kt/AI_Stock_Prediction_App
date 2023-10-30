Feature: Financial ratio radio button

Scenario: Validate Financial  button

Given Open the app
Given Click on Financial Ratios radio button
When Select one stock 
Then Selected stock should display below textfield
When Click on submit button
Then Relative Result should be displayed