package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import driver.DriverFactory;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testTablePractice.TestTablePractice;

public class TestTablepracticestep {
	private TestTablePractice testTablePractice;
	private WebDriver driver;
	
	@Before
	public void setup() {
		DriverFactory.intialiseBrowser(); 
		driver=DriverFactory.getDriver();
		testTablePractice= new TestTablePractice(driver);
	}
	
	@Given("User click on Test Table")
	public void user_click_on_test_table() {
		testTablePractice.clickOntestTable();
	}
	@Given("Scrollup till filters visible")
	public void scrollup_till_filters_visible() {
		testTablePractice.scrollUptoseeFilter();
	}
	@Given("Select Java radio button")
	public void select_java_radio_button() {
		testTablePractice.clickOnJavaradiobtn();
	}
	@Given("Scroll up till complete table visible")
	public void scroll_up_till_complete_table_visible() {
		testTablePractice.scrollUptotestcase1();
	}
	@Then("verify only java courses are visible")
	public void verify_only_java_courses_are_visible() {
		testTablePractice.verifyOnlyjavacoursesarevisible();
	}
	@Given("Deselect intermidiate level")
	public void deselect_intermidiate_level() {
		testTablePractice.deselectIntermidiate();
	}
	@Given("Deselect Advanced level")
	public void deselect_advanced_level() {
		testTablePractice.deselectAdvanced();
	}
	@Then("verify only beginner level visible")
	public void verify_only_beginner_level_visible() {
		testTablePractice.verifyOnlyBeginnerslevelvisible();
	}
	@Given("Select 10000+ from minenrollment dropdown")
	public void select_from_minenrollment_dropdown() {
		testTablePractice.select10000Fromenrollments();
	}
	@Then("Verify every visible row shows enrollments greater than {int}")
	public void verify_every_visible_row_shows_enrollments(int minEnrollment) {
		boolean result = testTablePractice.verifyAllrowsenrolmentsmorethan(minEnrollment);
		Assert.assertTrue(result, "Some rows have enrollments less than " + minEnrollment);
	}
	@Given("Select Python radio button")
	public void select_python_radio_button() {
		testTablePractice.clickOnpythonradbtn();
	}
	@Then("Verify only Python Beginner courses with greater than {double} enrollments are visible")
	public void verify_only_python_beginner_courses_with_greater_than_enrollments_are_visible(Double double1) {
		boolean result=testTablePractice.verifyRowsvisibleasperfilter();
		Assert.assertTrue(result, "Some values are not equals as per selection");
	}
	@Given("Deselect Beginner level")
	public void deselect_beginner_level() {
		testTablePractice.deselectBiginner();
	}
	@Then("Verify msg visible as {string}")
	public void verify_msg_visible_as(String expectedMsg) {
		boolean result = testTablePractice.verifyNomatchingcoursemsg(expectedMsg);
		Assert.assertTrue(result, "Values are available with this selection");
	}
	@Then("Verify the Reset button becomes visible")
	public void verify_the_reset_button_becomes_visible() {
	    boolean result = testTablePractice.verifyResetbtnVisible();
	    Assert.assertTrue(result, "Reset button not visible");
	}
	@When("user Click on reset button")
	public void user_click_on_reset_button() {
		testTablePractice.clickOnresetbtn();
	}
	@Then("Verify reset button is invisible")
	public void verify_reset_button_is_invisible() {
	    boolean result = testTablePractice.verifyResetbtninvisible();
	    Assert.assertTrue(result, "Reset button is visible");
	}
	@Then("verify language filter reset to {string}")
	public void verify_language_filter_reset_to(String string) {
	    boolean result = testTablePractice.verifyLanguagefilterresettoAny();
	    Assert.assertTrue(result, "Language is not selected as any");
	}
	@Then("level filter select {string},{string},{string}")
	public void level_filter_select(String string, String string2, String string3) {
	    boolean result = testTablePractice.verifyLevelscheckboxselected();
	    Assert.assertTrue(result, "One of level check box not selected");
	}
	@Then("Min enrollments filter selected  {string}")
	public void min_enrollments_filter_selected(String string) {
	    boolean result = testTablePractice.verifyMinenorllmentselectedAny();
	    Assert.assertTrue(result, "Enrollment not selected as any");
	}
	@Given("User select sort by enrollments from sort by")
	public void user_select_sort_by_enrollments_from_sort_by() {
		testTablePractice.selectEnrollmentsfromsortBy();
	}
	@Then("Verify visible rows are ordered from smallest to largest enrollment")
	public void verify_visible_rows_are_ordered_from_smallest_to_largest_enrollment() {
	   boolean result = testTablePractice.verifyEnrollmentsvaluessortedbydescending();
	   Assert.assertTrue(result, "Order not in descending");
	}
	@Then("Verify numbers with commas sort correctly")
	public void verify_numbers_with_commas_sort_correctly() {
	   boolean result = testTablePractice.verifyNumberswithcommasuperated();
	   Assert.assertTrue(result, "Numbers are not comma superated");
	}

	@Given("Scrollup sortby visible")
	public void scrollup_sortby_visible() {
	testTablePractice.scrolluptoSortBy();
	}
	@Given("User select sort by course name from sort by")
	public void user_select_sort_by_course_name_from_sort_by() {
		testTablePractice.selectCoursefromSortBy();
	}
	@Then("Verify visible rows are ordered A→Z by course name")
	public void verify_visible_rows_are_ordered_a_z_by_course_name() {
	   boolean result = testTablePractice.verifyCourserowsorderAlphabatically();
	   Assert.assertTrue(result, "Order not in alphabetically");
	}
	@Then("Verify order updates after changing filters")
	public void verify_order_updates_after_changing_filters() {
	   boolean result = testTablePractice.verifyOrderupdateafterchangefilter();
	   Assert.assertTrue(result, "Order not update");
	}
	

}
