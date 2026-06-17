package forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RegistrationFormTest {

	public static void main(String[] args) {
		
		WebDriver driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://uiplayground.techwithjatin.com/");
		
		//Locate form fields
		By firstNameFieldLocator = By.xpath("//input[@data-testid='input-first-name']");
		WebElement firstNameField = driver.findElement(firstNameFieldLocator);
		firstNameField.clear();
		firstNameField.sendKeys("Cristiano");
		
		By lastNameFieldLocator = By.xpath("//input[@data-testid='input-last-name']");
		WebElement lastNameField = driver.findElement(lastNameFieldLocator);
		lastNameField.clear();
		lastNameField.sendKeys("Ronaldo");

		By emailFieldLocator = By.xpath("//input[@data-testid='input-email-reg']");
		WebElement emailField = driver.findElement(emailFieldLocator);
		emailField.clear();
		emailField.sendKeys("Cristiano.Ronaldo@gmail.com");
		
		By passwordFieldLocator = By.xpath("//input[@data-testid='input-password']");
		WebElement passwordField = driver.findElement(passwordFieldLocator);
		passwordField.clear();
		passwordField.sendKeys("cr7@2026");
		
		By phoneFieldLocator = By.xpath("//input[@data-testid='input-phone']");
		WebElement phoneField = driver.findElement(phoneFieldLocator);
		phoneField.clear();
		phoneField.sendKeys("8928885292");
		
		By genderMaleRadioBtnLocator = By.xpath("//input[@value='Male']");
		WebElement genderMaleRadioBtn = driver.findElement(genderMaleRadioBtnLocator);
		genderMaleRadioBtn.click();
		
		By tandcCheckboxLocator = By.xpath("//input[@type='checkbox']");
		WebElement tandcCheckbox = driver.findElement(tandcCheckboxLocator);
		tandcCheckbox.click();
		
		By dobLocator = By.xpath("//input[@type='date']");
		WebElement dob = driver.findElement(dobLocator);
		dob.click();
		dob.sendKeys("07-07-1987");
		
		By countrySelectDropdownLocator = By.cssSelector("select#country");
		WebElement countrySelectDropdown = driver.findElement(countrySelectDropdownLocator);
		Select countrySelect = new Select(countrySelectDropdown);
		countrySelect.selectByVisibleText("France");
		
		By registerBtnLocator = By.xpath("//button[starts-with(text(),'Register')]//..");
		WebElement registerBtn = driver.findElement(registerBtnLocator);
		registerBtn.click();
		
		By registerationSuccessMsgLocator = By.xpath("//div[@data-testid='registration-success']//child::div[contains(text(),'Registration Successful!')]");
		WebElement registerationSuccessMsg = driver.findElement(registerationSuccessMsgLocator);
		String expectedMsg = registerationSuccessMsg.getText();
		if(expectedMsg.equals("Registration Successful!")) {
			System.out.println("Registration Successful!");
		}else {
			System.out.println("Registration Un-Successful!");
		}
		
		
		
		
		
	}

}
