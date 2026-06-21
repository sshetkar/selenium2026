package waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementToBeSelected {

	public static void main(String[] args) {
		
		/*
		 * Assignment 3 - Task 6:
		 * Print checkbox selection
		 * Click trigger button, and again print checkbox selection
		 */

		// Launch chrome browser and navigate to AUT
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://uiplayground.techwithjatin.com/");
		
		// ExlicitWait
		WebDriverWait myWait = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		// Click 'Explicit Waits' from Left-side menu bar
		By explicitWaitsMenuLocator = By.xpath("//span[starts-with(text(),'Explicit Waits')]/parent::div[@data-testid='nav-27']");
		WebElement explicitWaitMenu = myWait.until(ExpectedConditions.elementToBeClickable(explicitWaitsMenuLocator));
		explicitWaitMenu.click();
		
		//Print checkbox selection
		By checkboxElementToBeSelectedLocator = By.xpath("//input[@type='checkbox' and @data-testid='wait-selected-target']");
		WebElement checkboxElementToBeSelected = myWait.until(ExpectedConditions.visibilityOfElementLocated(checkboxElementToBeSelectedLocator));
		System.out.println("Is checkbox selected? "+checkboxElementToBeSelected.isSelected());
		
		//Click trigger button, and again print checkbox selection
		By btnTriggerSelectedLocator = By.xpath("//button[@data-testid='btn-trigger-selected']");
		WebElement btnTriggerSelected = myWait.until(ExpectedConditions.elementToBeClickable(btnTriggerSelectedLocator));
		btnTriggerSelected.click();
		
		boolean checkboxElementToBeSelectedAfterTrigger = myWait.until(ExpectedConditions.elementToBeSelected(checkboxElementToBeSelectedLocator));
		System.out.println("Is checkbox selected after trigger? "+checkboxElementToBeSelectedAfterTrigger);
		
		//Quit driver instance
		driver.quit();
		
	}

}
