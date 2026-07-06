package customcalendar;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DateRangeTest {

	public static void main(String[] args) {
		
		/*
 		 * Assignment 7 Task 3:
 		 * Select tab 'Date Range'
		 * Select start date and end date
		 * Print the above selected dates
		 */
		
		//Launch edge browser and navigate to AUT
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://uiplayground.techwithjatin.com/");
		
		//ExplicitWait
		WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		
		//Click 'Date Picker' from Left-side menu bar
		By customCalendarLocator = By.xpath("//span[contains(text(),'Custom Calendar')]//parent::div[@data-testid='nav-11']");
		myWait.until(ExpectedConditions.elementToBeClickable(customCalendarLocator)).click();

		//Select tab 'Date Range'
		By dateRangeLocator = By.cssSelector("button#btn-range-mode");
		myWait.until(ExpectedConditions.elementToBeClickable(dateRangeLocator)).click();
		
		//Select start date and end date
		By startDateLocator = By.name("rangeStart");
		myWait.until(ExpectedConditions.elementToBeClickable(startDateLocator)).click();
		
		By weekdayAvailableDatesLocator = By.xpath("//tbody[@data-testid='calendar-body']/tr/td[@class='dp-day dp-day-available']");
		List<WebElement> weekdayAvailableDates = myWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(weekdayAvailableDatesLocator));
		System.out.println("Total count of weekday available dates: "+weekdayAvailableDates.size());
		
		String startDateToBeSelected = "1"; //Provide user date selection number here (1 to 31) only available weekdays
		for(WebElement singleWeekdayDate : weekdayAvailableDates) {
			if(startDateToBeSelected.equals(singleWeekdayDate.getText())) {
				System.out.println("Single Weekday Date clicked: "+singleWeekdayDate.getText());
				singleWeekdayDate.click();
				break;
			}
		}
		
		/*
		 * When start date is selected selection shifts to end date (TAB) hence no need to explicitly click end date widget
		 * By endDateLocator = By.name("rangeEnd");
		 * myWait.until(ExpectedConditions.elementToBeClickable(endDateLocator)).click();
		 * myWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(weekdayAvailableDatesLocator));
		 */
		
		String endDateToBeSelected = "13"; //Provide user date selection number here (1 to 31) only available weekdays
		for(WebElement singleWeekdayDate : weekdayAvailableDates) {
			if(endDateToBeSelected.equals(singleWeekdayDate.getText())) {
				System.out.println("Single Weekday Date clicked: "+singleWeekdayDate.getText());
				singleWeekdayDate.click();
				break;
			}
		}
		
		//Print the above selected dates
		By endDateLocator = By.name("rangeEnd");
		String startDateValue = myWait.until(ExpectedConditions.visibilityOfElementLocated(startDateLocator)).getDomAttribute("value");
		String endDateValue = myWait.until(ExpectedConditions.visibilityOfElementLocated(endDateLocator)).getDomAttribute("value");
		System.out.println("Start Date: "+startDateValue+"\tEnd Date:"+endDateValue);
		
		//Quit driver instance
		driver.quit();

	}

}
