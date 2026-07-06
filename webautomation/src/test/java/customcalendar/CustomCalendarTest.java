package customcalendar;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomCalendarTest {

	public static void main(String[] args) {
		
		/*
 		 * Assignment 7 Task 1:
 		 * Select tab 'Single Date' and open the calendar
		 * Read the month/year header and go to next month
		 * Select a weekday and Verify the input attribute value changed
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
		
		String selectDateAttributeValue = calendarWidget.getText();
		System.out.println("Before selection attribute value of select date: "+selectDateAttributeValue);
		calendarWidget.click();
		
		//Read the month/year header and go to next month
		By activeMonthYearLocator = By.xpath("//span[@class='dp-header-title']");
		String activeMonthYear = myWait.until(ExpectedConditions.visibilityOfElementLocated(activeMonthYearLocator)).getText();
		System.out.println("Current active month: "+activeMonthYear);
		
		By nextMonthArrowLocator = By.xpath("//button[@class='dp-btn-next btn btn-secondary']");
		myWait.until(ExpectedConditions.elementToBeClickable(nextMonthArrowLocator)).click();
		activeMonthYear = myWait.until(ExpectedConditions.visibilityOfElementLocated(activeMonthYearLocator)).getText();
		System.out.println("After clicking next arrow active month: "+activeMonthYear);
		
		//Select a weekday
		By weekdayAvailableDatesLocator = By.xpath("//tbody[@data-testid='calendar-body']/tr/td[@class='dp-day dp-day-available']");
		List<WebElement> weekdayAvailableDates = myWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(weekdayAvailableDatesLocator));
		System.out.println("Total count of weekday Available Dates: "+weekdayAvailableDates.size());
		
		String dateToBeSelected = "13"; //Provide user date selection number here (1 to 31) only available weekdays
		for(WebElement singleWeekdayDate : weekdayAvailableDates) {
			if(dateToBeSelected.equals(singleWeekdayDate.getText())) {
				System.out.println("Single Weekday Date clicked: "+singleWeekdayDate.getText());
				singleWeekdayDate.click();
				break;
			}
		}
		
		//Verify the input attribute value changed
		WebElement newCalenderWidget = myWait.until(ExpectedConditions.elementToBeClickable(calendarWidgetLocator));
		System.out.println("After selection attribute value of select date: "+newCalenderWidget.getDomAttribute("value"));
		
		//Quit driver instance
		driver.quit();
		
	}

}
