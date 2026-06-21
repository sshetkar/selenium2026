package waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InvisibilityOfElementLocatedTest {

	public static void main(String[] args) {
		
		/*
		 * Assignment 3 - Task 4:
		 * Check loading spinner element displayed or not?
		 * Click trigger button, check invisibility of loading spinner
		 */

		// Launch edge browser and navigate to AUT
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://uiplayground.techwithjatin.com/");

		// ExlicitWait
		WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Click 'Explicit Waits' from Left-side menu bar
		By explicitWaitsMenuLocator = By.xpath("//span[starts-with(text(),'Explicit Waits')]/parent::div[@data-testid='nav-27']");
		WebElement explicitWaitMenu = myWait.until(ExpectedConditions.elementToBeClickable(explicitWaitsMenuLocator));
		explicitWaitMenu.click();
		
		//Check loading spinner element displayed or not?
		By loadingSpinnerLocator = By.xpath("//div[@data-testid='wait-invisible-target']");
		WebElement loadingSpinner = myWait.until(ExpectedConditions.visibilityOfElementLocated(loadingSpinnerLocator));
		System.out.println("Is loading spinner displayed? "+loadingSpinner.isDisplayed());
		
		//Click trigger, check invisibility of loading spinner
		By btnTriggerInvisibleLocator = By.xpath("//button[@data-testid='btn-trigger-invisible']");
		WebElement btnTriggerInvisible = myWait.until(ExpectedConditions.elementToBeClickable(btnTriggerInvisibleLocator));
		btnTriggerInvisible.click();
		boolean isloadingSpinnerInvisible = myWait.until(ExpectedConditions.invisibilityOfElementLocated(loadingSpinnerLocator));
		System.out.println("Is loading Spinner Invisible after trigger? "+isloadingSpinnerInvisible);
		
		//Quit driver instance
		driver.quit();
		
	}

}
