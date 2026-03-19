package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features={"src/test/resources/practice.feature","src/test/resources/login.feature",
				"src/test/resources/testTablePractice.feature"},
		glue= {"stepdefinitions","hooks"},
		tags= "@SortbyCourseNamealphabetical",
				 plugin = {
			                "pretty",
			                "summary",
			                "json:target/cucumber.json",
			                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		monochrome=true,
		dryRun=false
		)



public class TestRunner extends AbstractTestNGCucumberTests{
  @Override
  @DataProvider(parallel=true)
  public Object[][] scenarios() {
	  return super.scenarios();
  }
}
