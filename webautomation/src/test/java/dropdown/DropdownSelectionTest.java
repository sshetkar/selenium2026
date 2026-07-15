package dropdown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropdownSelectionTest {

	public static void main(String[] args) {
		
		/*
		 * Assignment 12 Task 1:
		 * Locate the Country dropdown and print the total number of options
		 * Iterate through all available countries and print their names
		 * Select a country using visible text and Print the selected country
		 */
		
		//Launch edge browser and navigate to UAT
		WebDriver driver  = new EdgeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://testautomationpractice.blogspot.com/");
		
		//Explicit wait
		WebDriverWait myWait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		//Locate the Country dropdown and print the total number of options
		By countrySelectDropdownLocator = By.id("country");
		WebElement countrySelectDropdown = myWait.until(ExpectedConditions.visibilityOfElementLocated(countrySelectDropdownLocator));
		Select countrySelectDropdownList = new Select(countrySelectDropdown);
		List<WebElement> numberOfCountryOptions = countrySelectDropdownList.getOptions();
		System.out.println("Number of country options="+numberOfCountryOptions.size());
		
		//Iterate through all available countries and print their names
		for(WebElement singleCounty:numberOfCountryOptions) {
			System.out.println(singleCounty.getText());
		}
		
		//Select a country using visible text and Print the selected country
		countrySelectDropdownList.selectByVisibleText("India");
	
		//Quit driver
		driver.quit();
		
	}

}
