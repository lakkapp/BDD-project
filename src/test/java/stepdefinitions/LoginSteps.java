package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import driver.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import loginPage.Login;
import utiles.ConfigReader;


public class LoginSteps {
	private WebDriver driver; 
	private Login loginpage;
	private WebDriverWait wait;
	
	@Given("User opens facebook login page")
	public void user_opens_facebook_login_page() {
		driver= DriverFactory.getDriver();
		if(driver==null) {
			throw new IllegalStateException("WebDriver is null, So Initialise properly");
		}
		 wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		loginpage=new Login(driver);
		driver.get(ConfigReader.get("base_url"));
	}

	@When("user enter valid username")
	public void user_enter_valid_username() {
		String username = ConfigReader.get("username");
		loginpage.enterEmail(username);
	}
	@When("user enter invalid username")
	public void user_enter_invalid_username() {
		String username = ConfigReader.get("invalid.username");
		loginpage.enterEmail(username);
	}

	@When("user enter valid password")
	public void user_enter_valid_password() {
		String password = ConfigReader.get("password");
		loginpage.enterUsername(password);
	}
	@When("user enter invalid password")
	public void user_enter_invalid_password() {
		String password = ConfigReader.get("invalid.password");
		loginpage.enterUsername(password);
	}

	@Then("user should be logged in successfully")
	public void user_should_be_logged_in_successfully() {
		loginpage.clickLoginbtn();
	}
	@Then("Verify new page url contains {string}")
	public void verify_new_page_url_contains_https_practicetestautomation_com_logged_in_successfully(String expectedFragment) {
	    boolean urlContains=wait.until(driver->driver.getCurrentUrl().contains(expectedFragment));
	    Assert.assertTrue(urlContains, "Expected URL to contain" + expectedFragment +  "but was: " + driver.getCurrentUrl());
	}
	
	@And("verify new page contains expected text {string}")
	public void verify_new_page_contains_expected_text(String expectedText) {
		boolean textPresent = wait.until(d->loginpage.isConfirmationTextPresent());
		Assert.assertTrue(textPresent, "Expected confirmation text not found on page.");
	}
	@Then("verify logout button displayed on login page")
	public void verify_logout_button_displayed_on_login_page() {
	    boolean logoutButton = wait.until(driver->loginpage.isLogoutbuttonpresent());
	    Assert.assertTrue(logoutButton, "Expected logout button not found on page");
	}
	@When("User clicks on Submit button")
	public void user_clicks_on_submit_button() {
	  loginpage.clickLoginbtn();
	}
	@Then("Error message should be displayed")
	public void error_message_should_be_displayed() {
		 boolean present = loginpage.iserrormsgPresent();
		    System.out.println("DEBUG: iserrormsgPresent = " + present);
		    Assert.assertTrue(present, "Expected error message to be displayed but it was not.");
	}
	@Then("Error message text should be {string}")
	public void error_message_text_should_be(String expectedMsg) {
		  String actual = loginpage.displayErrormsg();
	        System.out.println("DEBUG: Actual error text = [" + actual + "]");
	        Assert.assertEquals(actual, expectedMsg, "Error message text mismatch.");
	}
	@Then("passError message should be displayed")
	public void pass_error_message_should_be_displayed() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	   Assert.assertTrue(loginpage.ispasserrormsgPresent());
	}
	@Then("Error message text should be as {string}")
	public void error_message_text_should_be_as(String string) {
		   String actual = loginpage.displaypassErrormsg();
	        System.out.println("DEBUG: Actual pass error text = [" + actual + "]");
	        Assert.assertEquals(actual, string, "Password error text mismatch.");
	    	}
}
