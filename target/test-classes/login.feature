Feature:Facebook Login 

@Loginwithvalidcredentials
Scenario: Login with valid credentials
Given User opens facebook login page
When user enter valid username 
And user enter valid password 
And user should be logged in successfully
Then Verify new page url contains "https://practicetestautomation.com/logged-in-successfully/"
And verify new page contains expected text "Logged In Successfully"
And verify logout button displayed on login page

@Invalidusername
Scenario: Login with invalid username
Given User opens facebook login page
When user enter invalid username 
And user enter valid password 
And User clicks on Submit button
Then Error message should be displayed
And Error message text should be "Your username is invalid!"

@Invalidpassword
Scenario: Login with invalid password
Given User opens facebook login page
When user enter valid username 
And user enter invalid password 
And User clicks on Submit button
Then passError message should be displayed
And Error message text should be as "Your password is invalid!"




