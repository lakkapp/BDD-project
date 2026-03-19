package hooks;

import driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utiles.takeScreenshot;

public class Hooks {
private static final String SCREENSHOT_DIR = System.getProperty("user.dir")
+"/target/screenshots";

	@Before
 public void startbrowser() {
	 DriverFactory.intialiseBrowser();
 }

 @After 
 public void closebrowser(Scenario scenario) {
	 takeScreenshot.takeScreenshot(scenario);
	 DriverFactory.quitdriver();
 }
}
