package radiobutton;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RadioButtonSelectionTest {

	public static void main(String[] args) {
		
		/*
 		 * Assignment 10 Task 1:
 		 * Locate all gender radio buttons and print their count
 		 * Select the Male radio button and verify its selection status
 		 * Iterate through each radio button, print its id and selection state,
 		 * Click each radio button, and verify the updated selection status
		 */

		//Launch chrome browser and navigate to AUT
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://testautomationpractice.blogspot.com/");
		
		//ExplicitWait
		WebDriverWait myWait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		//Locate all gender radio buttons and print their count
		By genderRadioBtnLocator = By.xpath("//input[@type='radio']");
		List<WebElement> genderRadioBtnList = myWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(genderRadioBtnLocator));
		System.out.println("Total gender radio buttons:"+genderRadioBtnList.size());
		
		//Select the Male radio button and verify its selection status
		By genderMaleRadioBtnLocator = By.id("male");
		WebElement genderMaleRadioBtn = myWait.until(ExpectedConditions.elementToBeClickable(genderMaleRadioBtnLocator));
		genderMaleRadioBtn.click();
		boolean isGenderMaleRadioBtnSelected = genderMaleRadioBtn.isSelected();
		System.out.println("Is gender Male Radio Btn Selected? "+isGenderMaleRadioBtnSelected);
		
		//print its id and selection state, click each radio button, and verify the updated selection status
		for(WebElement singleGenderRadioBtn:genderRadioBtnList) {
			System.out.println("Attribute id value: "+singleGenderRadioBtn.getDomAttribute("id"));
			System.out.println("is '"+singleGenderRadioBtn.getDomAttribute("id")+"' radio button selected?"+singleGenderRadioBtn.isSelected());
			singleGenderRadioBtn.click();
			System.out.println("After click is "+singleGenderRadioBtn.getDomAttribute("id")+" radio button selected?"+singleGenderRadioBtn.isSelected());
		}
		
		//Quit browser
		driver.quit();
		
	}

}
