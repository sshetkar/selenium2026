package forms;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.TestDataGenerator;

public class ServiceNowTest {

	public static void main(String[] args) {
		
		/*
 		 * Assignment 4:
 		 * Fill in all mandatory fields using testDataGenerator utility class
 		 * Retrive captcha and enter captcha
		 */
		
		//Launch edge browser and navigate to AUT
		WebDriver driver  = new EdgeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://mphasisin2.service-now.com/ExEmployeeServiceForm");

		//ExplicitWait
		WebDriverWait myWait = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		//Call methods and store output from TestDataGenerator class
		String fullName = TestDataGenerator.getFullName();
		String email = TestDataGenerator.getEmail(fullName);
		String mobile = TestDataGenerator.getSpainMobileNumber();
		String employeeId = TestDataGenerator.getEmployeeId();
		
		//Fill detail in form fields and dropdowns
		By requestedByFieldLocator = By.id("requestedBy");
		WebElement requestedByField = myWait.until(ExpectedConditions.visibilityOfElementLocated(requestedByFieldLocator));
		requestedByField.sendKeys(fullName);
		
		By employeeNameFieldLocator = By.id("requestedFor");
		WebElement employeeNameField = myWait.until(ExpectedConditions.visibilityOfElementLocated(employeeNameFieldLocator));
		employeeNameField.sendKeys(fullName);
		
		By countrySelectDropdownLocator = By.id("CountryCode");
		WebElement countrySelectDropdownList = myWait.until(ExpectedConditions.visibilityOfElementLocated(countrySelectDropdownLocator));
		Select countryListDropdown = new Select(countrySelectDropdownList); //Select class constructor expects a single <select> WebElement, not a list
		countryListDropdown.selectByVisibleText("Spain");
		
		By contactFieldLocator = By.name("contact");
		WebElement contactField = myWait.until(ExpectedConditions.visibilityOfElementLocated(contactFieldLocator));
		contactField.sendKeys(mobile);
		
		By employeeIdLocator = By.name("RequestedforEmployeeID");
		WebElement empId = myWait.until(ExpectedConditions.visibilityOfElementLocated(employeeIdLocator));
		empId.sendKeys(employeeId);
		
		By emailIdLocator = By.id("EmailID");
		WebElement emailId = myWait.until(ExpectedConditions.visibilityOfElementLocated(emailIdLocator));
		emailId.sendKeys(email);
		
		By queryTypeDropdownLocator = By.id("queryType");
		WebElement queryTypeDropdownList = myWait.until(ExpectedConditions.visibilityOfElementLocated(queryTypeDropdownLocator));
		Select queryTypeListDropdown = new Select(queryTypeDropdownList);
		queryTypeListDropdown.selectByValue("Others");
		
		//Fill query summary and query description
		By querySummaryTextareaLocator = By.id("querySummary");
		WebElement querySummaryTextarea = myWait.until(ExpectedConditions.visibilityOfElementLocated(querySummaryTextareaLocator));
		querySummaryTextarea.sendKeys("query subject line");
		
		By queryDescriptionTextareaLocator = By.id("queryDescription");
		WebElement queryDescriptionTextarea = myWait.until(ExpectedConditions.visibilityOfElementLocated(queryDescriptionTextareaLocator));
		queryDescriptionTextarea.sendKeys("A big fat description");
		
		//Retrieve and enter captcha details
		By captchaLocator = By.xpath("//input[@id='randomfield']");
		WebElement captcha = myWait.until(ExpectedConditions.visibilityOfElementLocated(captchaLocator));
		String captchaValue = captcha.getAttribute("value");
		System.out.println("Captcha Value:"+captchaValue);
		
		By captchaEnterFieldLocator = By.id("CaptchaEnter");
		WebElement captchaEnterField = myWait.until(ExpectedConditions.visibilityOfElementLocated(captchaEnterFieldLocator));
		captchaEnterField.sendKeys(captchaValue);
		
		//Quit driver instance
		driver.quit();
		
	}

}
