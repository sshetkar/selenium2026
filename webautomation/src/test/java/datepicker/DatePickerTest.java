package datepicker;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DatePickerTest {

	public static void main(String[] args) {
		
		/*
 		 * Assignment 6:
 		 * Read and print the currently selected value in the Single Date input
 		 * Select date and print the selected date
		 * Select date range from - to and print
		 * Select time and print
		 * Print disabled dates
		 */
		
		//Launch edge browser and navigate to AUT
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://uiplayground.techwithjatin.com/");
		
		//ExplicitWait
		WebDriverWait myWait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		//Click 'Date Picker' from Left-side menu bar
		By datePickerLocator = By.xpath("//span[contains(text(),'Date Picker')]//parent::div[@data-testid='nav-10']");
		myWait.until(ExpectedConditions.elementToBeClickable(datePickerLocator)).click();

		//Read and print the currently selected value in the Single Date input
		By singleDateInputLocator = By.xpath("//input[@data-testid='date-single']");
		WebElement singleDateInput = myWait.until(ExpectedConditions.visibilityOfElementLocated(singleDateInputLocator));
		String singleDateInputValue = singleDateInput.getDomAttribute("min");
		System.out.println("Default Today's date - Input Value in DOM:"+singleDateInputValue);
		
		//Select date and print the selected date
		singleDateInput.sendKeys("01-07-2026");
		By dateSelectedLocator = By.xpath("//div[@data-testid='date-selected']");
		WebElement dateSelected = myWait.until(ExpectedConditions.visibilityOfElementLocated(dateSelectedLocator));
		System.out.println("Date "+dateSelected.getText());
		
		//Select date range from - to and print
		By dateFromLocator = By.xpath("//input[@data-testid='date-from']");
		myWait.until(ExpectedConditions.visibilityOfElementLocated(dateFromLocator)).sendKeys("15-08-1947");
		By dateToLocator = By.xpath("//input[@data-testid='date-to']");
		myWait.until(ExpectedConditions.visibilityOfElementLocated(dateToLocator)).sendKeys("15-08-2047");
		By dateRangeLocator = By.xpath("//div[@data-testid='range-result']");
		String getSelecteddateRange = myWait.until(ExpectedConditions.visibilityOfElementLocated(dateRangeLocator)).getText();
		System.out.println("Selected date range:"+getSelecteddateRange);
		
		//Select time and print
		By timePickerLocator = By.xpath("//input[@data-testid='time-picker']");
		myWait.until(ExpectedConditions.visibilityOfElementLocated(timePickerLocator)).sendKeys("22:22");
		By timeSelectedLocator = By.xpath("//div[@data-testid='time-selected']");
		String getSelectedTime = myWait.until(ExpectedConditions.visibilityOfElementLocated(timeSelectedLocator)).getText();
		System.out.println(getSelectedTime);
		
		//Print disabled dates
		By disabledDatesLocator = By.xpath("//div[@class='disabled-dates']/child::span");
		List<WebElement> disabledDatesList = myWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(disabledDatesLocator));
		System.out.println("Disabled Dates:");
		for(WebElement singleDisabledDate:disabledDatesList) {
			System.out.println(singleDisabledDate.getText());
		}
		
		//Quit driver instance
		driver.quit();
		
	}

}
