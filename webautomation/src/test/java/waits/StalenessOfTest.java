package waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StalenessOfTest {

	public static void main(String[] args) {
		
		/*
		 * Assignment 4 - Task 5:
		 * Print attribute value 'data-render-key'
		 * Click trigger button, and again check attribute value 'data-render-key'
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
		
		//Print attribute value 'data-render-key'
		By waitStaleTargetLocator = By.xpath("//div[@data-testid='wait-stale-target' and contains(text(),'render-key')]");
		WebElement waitStaleTarget = myWait.until(ExpectedConditions.visibilityOfElementLocated(waitStaleTargetLocator));
		System.out.println("Attribute value of data-render-key: "+waitStaleTarget.getAttribute("data-render-key"));

		//Click trigger button, and again check attribute value 'data-render-key'
		By btnTriggerStaleLocator = By.xpath("//button[@data-testid='btn-trigger-stale']");
		WebElement btnTriggerStale = myWait.until(ExpectedConditions.elementToBeClickable(btnTriggerStaleLocator));
		btnTriggerStale.click();
		
		boolean staleStatus = myWait.until(ExpectedConditions.stalenessOf(waitStaleTarget));
		System.out.println("Stale status? "+staleStatus);
		if(staleStatus) {
			WebElement waitStaleTargetNew = myWait.until(ExpectedConditions.visibilityOfElementLocated(waitStaleTargetLocator));
			System.out.println("Attribute value of data-render-key after trigger: "+waitStaleTargetNew.getAttribute("data-render-key"));
		}
		
		//Quit driver instance
		driver.quit();
		
	}

}
