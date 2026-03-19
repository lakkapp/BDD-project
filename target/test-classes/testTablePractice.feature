Feature:Navigate testTable practice page

@Languagefilerbyjava
Scenario: Language filter → Java
Given User opens facebook login page
And User clicks on practice option
And User click on Test Table
And Scrollup till filters visible
And Select Java radio button
And Scroll up till complete table visible
Then verify only java courses are visible

@LevelfilterbyBeginneronly
Scenario: Level filter → Beginner only
Given User opens facebook login page
And User clicks on practice option
And User click on Test Table
And Scrollup till filters visible
And Deselect intermidiate level
And Deselect Advanced level
And Scroll up till complete table visible
Then verify only beginner level visible 

@FilterbyMinenrollments10,000+
Scenario: Min enrollments → 10,000+
Given User opens facebook login page
And User clicks on practice option
And User click on Test Table
And Scrollup till filters visible
And Select 10000+ from minenrollment dropdown
And Scroll up till complete table visible
Then Verify every visible row shows enrollments greater than 10000

@CombinedfiltersPythonBeginner10,000+
Scenario: Combined filters → Python + Beginner + 10,000+
Given User opens facebook login page
And User clicks on practice option
And User click on Test Table
And Scrollup till filters visible
And Select Python radio button
And Deselect intermidiate level
And Deselect Advanced level
And Select 10000+ from minenrollment dropdown
Then Verify only Python Beginner courses with greater than 10,000 enrollments are visible

@Filternomatchingcourses
Scenario: Filter python with intermidiate and advanced
Given User opens facebook login page
And User clicks on practice option
And User click on Test Table
And Scrollup till filters visible
And Select Python radio button
And Deselect Beginner level
Then Verify msg visible as "No matching courses."

@Resetbuttonvisibilityandbehavior
Scenario:  Reset button visibility and behavior
Given User opens facebook login page
And User clicks on practice option
And User click on Test Table
And Scrollup till filters visible
And Select Python radio button
Then Verify the Reset button becomes visible 
When user Click on reset button
Then Verify reset button is invisible 
And  verify language filter reset to "any"
And  level filter select "beginner","Intermidiate","Advanced"
And  Min enrollments filter selected  "any"

@SortbyEnrollmentsascendingnumeric
Scenario: Sort by Enrollments (ascending, numeric)
Given User opens facebook login page
And User clicks on practice option
And User click on Test Table
And Scrollup sortby visible
And User select sort by enrollments from sort by
Then Verify visible rows are ordered from smallest to largest enrollment
Then Verify numbers with commas sort correctly

@SortbyCourseNamealphabetical
Scenario:Sort by Course Name (alphabetical)
Given User opens facebook login page
And User clicks on practice option
And User click on Test Table
And Scrollup sortby visible
And User select sort by course name from sort by
Then Verify visible rows are ordered A→Z by course name
Then Verify order updates after changing filters









































