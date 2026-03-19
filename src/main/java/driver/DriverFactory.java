package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import utiles.ConfigReader;

public class DriverFactory {
private static ThreadLocal<WebDriver>tlDriver = new ThreadLocal<>();

public static void intialiseBrowser() {
	if(tlDriver.get()==null) {
		String browser = ConfigReader.get("browser");
		boolean headless = ConfigReader.getBoolean("headless");
		switch(browser.toLowerCase()) {
		case "chrome": 
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			if(headless) chromeOptions.addArguments("--headless=new");
			chromeOptions.addArguments("--start-maximised");
			tlDriver.set(new ChromeDriver(chromeOptions));
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions fireFoxOptions = new FirefoxOptions();
			if (headless) fireFoxOptions.addArguments("--headless=new");
			tlDriver.set(new FirefoxDriver(fireFoxOptions));
			break;
			default:
				throw new IllegalArgumentException("Unsupported browser:" + browser);
		}
	}
}

public static WebDriver getDriver() {
	return tlDriver.get();
}
	public static void quitdriver() {
		if(tlDriver.get()!=null) {
			tlDriver.get().quit();
			tlDriver.remove();
		}
	}

}
