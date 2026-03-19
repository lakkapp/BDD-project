package practicePgae;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Practice {
private WebDriver driver;	
private By practice = By.xpath("(//a[contains(text(),'Practice')])[1]");
private By exceptions = By.xpath("(//a[contains(text(),'Test Exceptions')])");
private By addButton = By.xpath("//button[@name='Add']");
private By savebutton = By.xpath("((//div[@class='row'])//button)[4]");
private By practicepage = By.xpath("//h1[contains(text(),'Practice')]");
private By testExceptions = By.xpath("//h2[contains(text(), 'Test Exceptions')]");
private By row2 = By.xpath("(//label[contains(text(), 'Row')])[2]");
private By row2text = By.xpath("(//input[@type='text'])[2]");
private By editRow2Button= By.xpath("(//button[@id='edit_btn'])[2]");
private By instruction = By.xpath("//p[@id='instructions']");

public Practice(WebDriver driver) {
	this.driver = driver;
}
public void clickOnPractice() {
	driver.findElement(practice).click();	
}
public boolean isVisiblePractice() {
	return driver.findElement(practicepage).isDisplayed();
}

public boolean isVisibleClickonTestException() {
	return driver.findElement(exceptions).isDisplayed();
}
public void clickonExceptions(){
	driver.findElement(exceptions).click();
}
public boolean isVisibleTestException() {
	return driver.findElement(testExceptions).isDisplayed();
}
public void clickOnAddButton() {
	driver.findElement(addButton).click();
}
public boolean isVisiblerow2() {
	return driver.findElement(row2).isDisplayed();
}
public void textOnRow2() {
	driver.findElement(row2text).sendKeys("Burger");
}
public void clickOnSave() {
	driver.findElement(savebutton).click();
}
public boolean row2notEmpty() {
	String text= driver.findElement(row2text).getText();
	return text !=null && !text.trim().isEmpty();
	
}
public void editonRow2() {
	driver.findElement(row2text).clear();
	driver.findElement(row2text).sendKeys("Badam");
}
public boolean verifyTextchanged() {
	String expectedText= "Badam";
	String actualText = driver.findElement(row2text).getAttribute("value");
	if(expectedText.equals(actualText)) {
		System.out.println(actualText);
		return true;
		}else {
			System.out.println(actualText + "Actual text not matched with expected text");
		return false;
	}
	
}
public void clickOnEditbutton() {
	driver.findElement(editRow2Button).click();
}
public boolean verifyInstructionElementdisplayed() {
	String expectedText= "Push “Add” button to add another row";
	String actualtext = driver.findElement(instruction).getText().trim();
	if(actualtext.equals(expectedText)) {
		System.out.println("Get correct instructions" + actualtext);
		return true;
	}else {
		System.out.println("Got incorrect instructions" + actualtext);
		return false;
	}
	
}
public boolean verifysecondrowisvisible() {
	driver.findElement(row2text).isDisplayed();
	return true;
}
}
