package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import driver.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import practicePgae.Practice;

public class practiceSteps {
	private Practice practicepage;
	private WebDriver driver;
	private WebDriverWait wait;
	
	public practiceSteps() {
        this.driver = DriverFactory.getDriver();  // ensure driver already created in Hooks
        this.practicepage = new Practice(driver);
        this.wait= new WebDriverWait(driver, Duration.ofSeconds(30));
    }
	
	@And("User clicks on practice option")
	public void user_clicks_on_practice_option() {
		practicepage.clickOnPractice();
	}
	@And("User clicks on Testexceptions")
	public void user_clicks_on_testexceptions() {
		practicepage.clickonExceptions();
	}
	@And("Verify test exception page opened")
	public void verify_test_exception_page_opened() {
	    Assert.assertTrue(practicepage.isVisibleTestException()); 
	}
	@And("Click on ADD button")
	public void click_on_add_button() {
		practicepage.clickOnAddButton();
	}
	
	@And("Wait for the second row to load")
	public void wait_for_the_second_row_to_load() {
		Boolean secondRow = wait.until(driver->practicepage.isVisiblerow2());
	    Assert.assertTrue(secondRow, "Expected second row not found on page");
	}
	@And("Type text into the second input field")
	public void type_text_into_the_second_input_field() {
		practicepage.textOnRow2();
	}
	@And("Push Save button")
	public void push_save_button() {
		practicepage.clickOnSave();
	}
	@And("Verify text saved")
	public void verify_text_saved() {
	   practicepage.row2notEmpty();
	}
	@Then("verify Row2 is visible")
	public void verify_row2_is_visible() {
		Boolean row2visible= wait.until(driver->practicepage.isVisiblerow2());
		Assert.assertTrue(row2visible);
	}
	@And("Text into row2")
	public void text_into_row2() {
		practicepage.editonRow2();
	}

	@Then("Verify text changed")
	public void verify_text_changed() {
		practicepage.verifyTextchanged();
	}
	@And("Click on editButton")
	public void click_on_edit_button() {
		practicepage.clickOnEditbutton();
	}
	@Then("Verify instruction text element is no longer displayed")
	public void verify_instruction_text_element_is_no_longer_displayed() {
		practicepage.verifyInstructionElementdisplayed();
	}
	@Then("Verify second input field is displayed")
	public void verify_second_input_field_is_displayed() throws InterruptedException {
		Thread.sleep(5000);
		practicepage.verifysecondrowisvisible();
	}
}
