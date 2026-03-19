package utiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import driver.DriverFactory;
import io.cucumber.java.Scenario;

public class takeScreenshot {
	private static final String SCREENSHOT_DIR = "screenshots";
	 public static void takeScreenshot(Scenario scenario) {
		 try {
			 byte[] screenshot = ((TakesScreenshot)DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
			 scenario.attach(screenshot, "image/png",scenario.getName());
			 
			 Path folder = Paths.get(SCREENSHOT_DIR);
			 if(!Files.exists(folder)) {
				 Files.createDirectories(folder);
			 }
			 
			 String timestamp = LocalDateTime.now()
				        .format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss"));

			 String fileName = scenario.getName()
				        .replaceAll("[^a-zA-Z0-9]", "_")
				        + "_" + timestamp + ".png";		
			 Files.write(folder.resolve(fileName), screenshot);	 
		 }catch(IOException e){
			 e.printStackTrace();
			 
		 }catch(Exception e) {
			 
		 }
	 }
}
