package testTablePractice;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utiles.ScrollToElement;

public class TestTablePractice {
private WebDriver driver;	
private By testtable = By.xpath("//a[text()='Test Table']");
private By minenrollments = By.xpath("//fieldset/legend[contains(text(), 'Min enrollments')]");
private By javaradiobutton= By.xpath("(//input[@type='radio'])[2]");
private By table = By.id("//table[@id='courses_table']");
private By testcase1 = By.xpath("//h5[contains(text(), 'Test case 1: Language filter → Java')]");
private By sortbyid = By.xpath("//select[@id='sortBy']");
private By beginnerLevel = By.xpath("//input[@value='Beginner']");
private By intermidiatelevel = By.xpath("//input[@value='Intermediate']");
private By advancedlevel = By.xpath("//input[@value='Advanced']");
private By valuesofLevelcolumn = By.xpath("//table[@id='courses_table']/tbody/tr/td[4]");
private By valuesOflanguagecolumn = By.xpath("//table[@id='courses_table']/tbody/tr/td[3]");
private By enrollmentDropdown = By.xpath("//div[@class='dropdown-button']");
//private By enrolmntDpvalues = By.xpath("//ul[@class='dropdown-menu']");
//private By enrolmntDpvalues = By.xpath("//ul[@class='dropdown-menu']");)
private By enrolmet10000 = By.xpath("//li[@data-value='10000']");
private By enrolmentcolvalues = By.xpath("//table[@id='courses_table']/tbody/tr/td[5]");
private By pythonradibtn = By.xpath("(//input[@type='radio'])[3]");
private By coursetablevalues= By.xpath("//table[@id='courses_table']/tbody/tr/td");
private By noMatchingCoursemsg=By.xpath("//div[contains(text(),' No matching courses.')]");
private By resetbtn = By.xpath("//button[contains(text(),'Reset')]");
private By any = By.xpath("(//input[@type='radio'])[1]");
private By levels = By.xpath("//input[@type='checkbox' and @name='level']");
private By anyenroll = By.xpath("//span[contains(text(),'Any')]");
private By sortBy = By.xpath("//select[@id='sortBy']");
private By courseNamevalues= By.xpath("//table[@id='courses_table']/tbody/tr/td[2]");

public TestTablePractice(WebDriver driver) {
	this.driver = driver;
}
public void clickOntestTable() {
	driver.findElement(testtable).click();
}
public void scrollUptoseeFilter() {
	WebElement minr = driver.findElement(minenrollments);
	ScrollToElement.scrollToElemt(driver,minr);
}
public void clickOnJavaradiobtn() {
	driver.findElement(javaradiobutton).click();
}
public void scrollUptotestcase1() {
	WebElement tsCse = driver.findElement(sortbyid);
	ScrollToElement.scrollToElemt(driver, tsCse);
}
public boolean verifyOnlyjavacoursesarevisible() {
	List<WebElement>language = driver.findElements(valuesOflanguagecolumn);
	if(language.isEmpty()) {
		return false;
	}
	for (WebElement langcol: language) {
		String value1 = langcol.getText().trim();
		if(!value1.equalsIgnoreCase("Java")) {
			System.out.println("Non java values are find" + value1);
			return false;
		}
	}
	return true;
}
public void deselectIntermidiate() {
	driver.findElement(intermidiatelevel).click();
}
public void deselectAdvanced() {
	driver.findElement(advancedlevel).click();
}
public boolean verifyOnlyBeginnerslevelvisible() {
	List<WebElement>levels = driver.findElements(valuesofLevelcolumn);
	if(levels.isEmpty()) {
		return false;	
	}
	for(WebElement level : levels) {
		String value = level.getText().trim();
		if(!value.equalsIgnoreCase("Beginner")) {
			System.out.println("Non beginner values found" + value);
			return false;
		}
	}
	return true;
}

public void select10000Fromenrollments() {
	driver.findElement(enrollmentDropdown).click();
	driver.findElement(enrolmet10000).click();
}
public boolean verifyAllrowsenrolmentsmorethan(int minEnrollment) {

    List<WebElement> values = driver.findElements(enrolmentcolvalues);

    if (values.isEmpty()) {
        System.out.println("No enrollment values found");
        return false;
    }

    for (WebElement value : values) {

        String text = value.getText().trim();

        // 🔴 Skip empty cells
        if (text.isEmpty()) {
            System.out.println("Skipping empty enrollment cell");
            continue;
        }

        // 🔴 Remove commas
        text = text.replace(",", "");

        // 🔴 Ensure it contains only digits
        if (!text.matches("\\d+")) {
            System.out.println("Skipping non-numeric enrollment value: " + text);
            continue;
        }

        int enrollment = Integer.parseInt(text);

        if (enrollment < minEnrollment) {
            System.out.println(
                "Enrollment less than " + minEnrollment + " found: " + enrollment
            );
            return false;
        }
    }
    return true;
}
public void clickOnpythonradbtn() {
	driver.findElement(pythonradibtn).click();
}
public boolean verifyRowsvisibleasperfilter() {
	List<WebElement>values = driver.findElements(coursetablevalues);
	if(values.isEmpty()) {
		return false;
	}
	for(WebElement value: values) {
		String language = value.findElement(By.xpath("//table[@id='courses_table']//td[@headers='col_lang']"))
				.getText().trim();
		String level = value.findElement(By.xpath("//table[@id='courses_table']//td[@headers='col_level']"))
				.getText().trim();
		String enrolments = value.findElement(By.xpath("//table[@id='courses_table']//td[@headers='col_enroll']"))
				.getText().trim();
		int enrolmentnum= Integer.parseInt(enrolments);
		if(language.equalsIgnoreCase("Python")&&
				level.equalsIgnoreCase("Beginner")
				&& enrolmentnum >= 10000 ) {
			return true;
		}
			
	}
	return false;
}
public void deselectBiginner() {
	driver.findElement(beginnerLevel).click();
	}
public boolean verifyNomatchingcoursemsg( String expectedMsg) {
	String actualMsg = driver.findElement(noMatchingCoursemsg).getText().trim();
	System.out.println("Expected Msg : [" + expectedMsg + "]");
    System.out.println("Actual Msg   : [" + actualMsg + "]");
	return actualMsg.equalsIgnoreCase(expectedMsg);
}
public boolean verifyResetbtnVisible() {
	return driver.findElement(resetbtn).isDisplayed();
}
public void clickOnresetbtn() {
	driver.findElement(resetbtn).click();
}
public boolean verifyResetbtninvisible() {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	return wait.until(ExpectedConditions.invisibilityOfElementLocated(resetbtn));
}
public boolean verifyLanguagefilterresettoAny() {
	return driver.findElement(any).isSelected();
}
public boolean verifyLevelscheckboxselected() {
	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	//return wait.until(driver->{
		List<WebElement>levels1 = driver.findElements(levels);
	for(WebElement level: levels1) {
		if(!level.isSelected()) {
			System.out.println("Selected checkbox"	+ levels1);
			return false;
		}
	}
		return true;
}
public boolean verifyMinenorllmentselectedAny() {
	return driver.findElement(anyenroll).isDisplayed();
}
public void selectEnrollmentsfromsortBy() {
	//WebElement sortBydropdown = driver.findElement(sortBy);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	WebElement sortBydropdown = wait.until(ExpectedConditions.elementToBeClickable(sortBy));
	sortBydropdown.click();
	Select select = new Select(sortBydropdown);
	select.selectByVisibleText("Enrollments");
}

public List<Integer> getenrollmentsvalues(){
	List<WebElement> enrollments = driver.findElements(enrolmentcolvalues);
	List<Integer>actualEnrollments = new ArrayList<>();
	   for (WebElement cell : enrollments) {
	        int value = Integer.parseInt(
	                cell.getText().replace(",", "").trim()
	        );
	        actualEnrollments.add(value);
	    }
	    return actualEnrollments;
	}
public boolean verifyEnrollmentsvaluessortedbydescending() {
	//List<WebElement> enrollments = driver.findElements(enrolmentcolvalues);
	List<Integer>actualEnrollments = getenrollmentsvalues();
	List<Integer>sorteddesc =  new ArrayList<>(actualEnrollments);
	Collections.sort(sorteddesc);
	if(actualEnrollments.equals(sorteddesc)) {
		return true;
	}
	return false;
}
public boolean verifyNumberswithcommasuperated() {
	List<Integer>actualEnrollments = getenrollmentsvalues();
	return actualEnrollments!=null && !actualEnrollments.isEmpty();
}
public void scrolluptoSortBy() {
	WebElement minr = driver.findElement(sortBy);
	ScrollToElement.scrollToElemt(driver,minr);
}
public void selectCoursefromSortBy() {
	WebElement sortBydropdown = driver.findElement(sortBy);
	sortBydropdown.click();
	Select select = new Select(sortBydropdown);
	select.selectByVisibleText("Course Name");
}
public List<String>getCoursenameavlues(){
	List<WebElement> Corsnmes=driver.findElements(courseNamevalues);
	ArrayList<String> names = new ArrayList<>();
	for (WebElement cell: Corsnmes ) {
		String text = cell.getText().trim();
		names.add(text);
	}
	return names;
}
public boolean verifyCourserowsorderAlphabatically() {
	List<String> actualArraylist = getCoursenameavlues();
	List<String>expectedArraylist= new ArrayList<>(actualArraylist);
	Collections.sort(expectedArraylist, String.CASE_INSENSITIVE_ORDER);
	return expectedArraylist.equals(actualArraylist);
}

public List<String> actuallist(){
	WebElement sortBydropdown = driver.findElement(sortBy);
	sortBydropdown.click();
	Select select = new Select(sortBydropdown);
	select.selectByVisibleText("ID");
	
	List<WebElement> values = driver.findElements(courseNamevalues);
	List<String> arr = new ArrayList<>();
	for(WebElement cells:values ) {
		String text = cells.getText().trim();
		arr.add(text);
	}
	return arr;
}
public boolean verifyOrderupdateafterchangefilter() {
	List<String> actualOrder = actuallist();
	List<String>expectedOrder=new ArrayList<>(actualOrder);
	Collections.sort(expectedOrder, String.CASE_INSENSITIVE_ORDER);
	if (!actualOrder.equals(expectedOrder)) {
		System.out.println("Actual order" + actualOrder);
		System.out.println("Expected order" + expectedOrder);
		return true;
	}else {
		return false;
	}
}
}








