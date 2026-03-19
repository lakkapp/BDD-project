package loginPage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
private WebDriverWait wait;
private WebDriver driver;
private By emailaddress = By.xpath("//input[@name='username']");
private By password = By.xpath("//div[@id='form']/div//input[@type='password']");
private By loginbtn = By.xpath("//section[@class='main-container']//section[@id='login']//div[@id='form']//button[@class='btn']");
private By confirmationArea= By.xpath("(//*[contains(text(),'Logged In Successfully')])[3]");
private By logoutbtn = By.xpath("//a[contains(text(),'Log out')]");
private By errorMsg = By.xpath("//div[contains(text(), 'Your username is invalid!')]");
private By passerrorMsg = By.xpath("//div[contains(text(), 'Your password is invalid!')]");

public Login(WebDriver driver) {
	this.driver = driver;
	this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
}

public void enterEmail(String username) {
	driver.findElement(emailaddress).clear();
    driver.findElement(emailaddress).sendKeys(username);
}

public void enterUsername(String pwd) {
	 driver.findElement(password).clear();
     driver.findElement(password).sendKeys(pwd);
}

public void clickLoginbtn() {
	driver.findElement(loginbtn).click();
}

public boolean isConfirmationTextPresent() {
	  List<WebElement> elems = driver.findElements(confirmationArea);
      return !elems.isEmpty() && elems.get(0).isDisplayed();
}
public boolean isLogoutbuttonpresent() {
	 List<WebElement> logoutElems = driver.findElements(logoutbtn);
     return !logoutElems.isEmpty() && logoutElems.get(0).isDisplayed();
}
public boolean iserrormsgPresent() {
	try {
		wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsg));
		WebElement el = driver.findElement(errorMsg);
		return el !=null && el.isDisplayed(); 
	}catch (Exception e){
	return false;
}
}
public String displayErrormsg() {
	 try {
         WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsg));
         return el.getText().trim();
     } catch (Exception e) {
         return "";
     }
}

public boolean ispasserrormsgPresent() {
	  try {
          wait.until(ExpectedConditions.visibilityOfElementLocated(passerrorMsg));
          WebElement el = driver.findElement(passerrorMsg);
          return el != null && el.isDisplayed();
      } catch (Exception e) {
          return false;
      }
}

public String displaypassErrormsg() {
	try {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(passerrorMsg));
        return el.getText().trim();
    } catch (Exception e) {
        return "";
    }
}
}
