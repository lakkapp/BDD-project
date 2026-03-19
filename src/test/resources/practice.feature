Feature:Navigate exceptions practice page

@Nosuchelementexception
Scenario:No such element exception 
Given User opens facebook login page
And User clicks on practice option
And User clicks on Testexceptions
And Verify test exception page opened
And Click on ADD button
Then verify Row2 is visible

@ElementNotInteractableException
Scenario: ElementNotInteractableException
Given User opens facebook login page
And User clicks on practice option
And User clicks on Testexceptions
And Verify test exception page opened
And Click on ADD button
And Wait for the second row to load
And Type text into the second input field
And Push Save button 
And Verify text saved

@InvalidElementStateException
Scenario:InvalidElementStateException
Given User opens facebook login page
And User clicks on practice option
And User clicks on Testexceptions
And Verify test exception page opened
And Click on ADD button
And Wait for the second row to load
And Type text into the second input field
And Push Save button 
And Verify text saved
And Click on editButton
And Text into row2
Then Verify text changed 

@StaleElementReferenceException
Scenario:  StaleElementReferenceException
Given User opens facebook login page
And User clicks on practice option
And User clicks on Testexceptions
And Verify test exception page opened
Then Verify instruction text element is no longer displayed 
And Click on ADD button
Then Verify instruction text element is no longer displayed 

@TimeoutException
Scenario:TimeoutException
Given User opens facebook login page
And User clicks on practice option
And User clicks on Testexceptions
And Verify test exception page opened
And Click on ADD button
Then Verify second input field is displayed















