package checkbox;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckBoxSelectionTest {

	public static void main(String[] args) {
		
		/*
		 * Assignment 11:
		 * Locate all day checkboxes and print their count
		 * Select Monday and Wednesday checkboxes
		 * Iterate through each checkbox, print its id and selection state
		 */

		//Launch chrome browser and navigate to AUT
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://testautomationpractice.blogspot.com/");
		
		//ExplicitWait
		WebDriverWait myWait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		//Locate all day checkboxes and print their count
		By daysCheckboxLocator = By.xpath("//div[@class='form-group']//input[@type='checkbox']");
		List<WebElement> daysCheckboxList = myWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(daysCheckboxLocator));
		System.out.println("Count of number of days:"+daysCheckboxList.size());
		
		//Select Monday and Wednesday checkboxes
		String selectionMonday = "monday";
		String selectionWednesday = "wednesday";
		String currentDay;
		for(WebElement singleDay:daysCheckboxList) {
			currentDay = singleDay.getDomProperty("value");
			if(currentDay.equalsIgnoreCase(selectionMonday) || currentDay.equalsIgnoreCase(selectionWednesday)) {
				singleDay.click();
			}
		}
		
		//Iterate through each checkbox, print its id and selection state
		for(WebElement singleDay:daysCheckboxList) {
			System.out.println("Attribute id value: "+singleDay.getDomProperty("id"));
			System.out.println("Is '"+singleDay.getDomProperty("id")+"' is selected? "+singleDay.isSelected());
		}
		
		//Quit browser
		driver.quit();
		
	}

}
