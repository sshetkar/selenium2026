package customcalendar;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerifyDisabledDatesTest {

	public static void main(String[] args) {
		
		/*
 		 * Assignment 7 Task 2:
 		 * Select tab 'Single Date' and open the calendar
		 * Select a date and print the same
		 * Try selecting any disabled date (it should not allow)
		 * Validate if earlier selected date has changed?
		 */
		
		//Launch edge browser and navigate to AUT
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://uiplayground.techwithjatin.com/");
		
		//ExplicitWait
		WebDriverWait myWait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		//Click 'Date Picker' from Left-side menu bar
		By customCalendarLocator = By.xpath("//span[contains(text(),'Custom Calendar')]//parent::div[@data-testid='nav-11']");
		myWait.until(ExpectedConditions.elementToBeClickable(customCalendarLocator)).click();

		//Select tab 'Single Date' and open the calendar
		By singleDateTabLocator = By.id("btn-single-mode");
		myWait.until(ExpectedConditions.elementToBeClickable(singleDateTabLocator)).click();
		By calendarWidgetLocator = By.name("selectedDate");
		WebElement calendarWidget = myWait.until(ExpectedConditions.elementToBeClickable(calendarWidgetLocator));
		calendarWidget.click();

		//Select a weekday
		By weekdayAvailableDatesLocator = By.xpath("//tbody[@data-testid='calendar-body']/tr/td[@class='dp-day dp-day-available']");
		List<WebElement> weekdayAvailableDates = myWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(weekdayAvailableDatesLocator));
		System.out.println("Total count of weekday available dates: "+weekdayAvailableDates.size());
		
		String dateToBeSelected = "13"; //Provide user date selection number here (1 to 31) only available weekdays
		for(WebElement singleWeekdayDate : weekdayAvailableDates) {
			if(dateToBeSelected.equals(singleWeekdayDate.getText())) {
				System.out.println("Single Weekday Date clicked: "+singleWeekdayDate.getText());
				singleWeekdayDate.click();
				break;
			}
		}
		
		//Current selected date
		By selectedDateLocator = By.xpath("//input[@id='date-input']");
		WebElement selectedDate = myWait.until(ExpectedConditions.visibilityOfElementLocated(selectedDateLocator));
		String expectedDate = selectedDate.getDomProperty("value");
		System.out.println("Selected and expected Date:"+expectedDate);
		
		//Try selecting any disabled date (it should not allow)
		myWait.until(ExpectedConditions.elementToBeClickable(calendarWidgetLocator)).click();
		By disabledDatesListLocator = By.xpath("//tbody/child::tr/child::td[@class='dp-day dp-day-disabled']");
		List<WebElement> disabledDatesList = myWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(disabledDatesListLocator));
		System.out.println("Total count of weekend disabled dates: "+disabledDatesList.size());
		
		String disableDateToBeSelected = "26"; //Provide user date selection number here (1 to 31) only available weekends
		String actualSingleDisabledDate = null;
		for(WebElement singleDisabledDate:disabledDatesList) {
			actualSingleDisabledDate = singleDisabledDate.getText();
			if(disableDateToBeSelected.equals(actualSingleDisabledDate)) {
				System.out.println("Single weekend date clicked: "+actualSingleDisabledDate);
				singleDisabledDate.click();
				break;
			}
		}
		
		//Validate if earlier selected date has changed?
		String actualDate = selectedDate.getDomProperty("value");

		if(expectedDate.equals(actualDate)) {
		    System.out.println("Test Pass: Disabled date was not selected.");
		}
		else {
		    System.out.println("Test Fail: Disabled date got selected.");
		}
		
		//Quit driver instance
		driver.quit();
		
	}

}
