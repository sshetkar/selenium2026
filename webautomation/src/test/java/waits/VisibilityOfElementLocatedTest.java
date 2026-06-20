package waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VisibilityOfElementLocatedTest {

	public static void main(String[] args) {

		/*
		 * Assignment 3 - Task 1: Click Trigger button to start the condition
		 * Record the time before clicking using System.currentTimeMillis() 
		 * Wait until text becomes visible
		 * and Print the element text and total elapsed time in milliseconds
		 */

		// Launch edge browser and navigate to AUT
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://uiplayground.techwithjatin.com/");

		// ExlicitWait
		WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));

		//Click 'Explicit Waits' from Left-side menu bar
		By explicitWaitsMenuLocator = By.xpath("//span[starts-with(text(),'Explicit Waits')]/parent::div[@data-testid='nav-27']");
		WebElement explicitWaitMenu = myWait.until(ExpectedConditions.elementToBeClickable(explicitWaitsMenuLocator));
		explicitWaitMenu.click();
		
		//Pre-requisite: recording time before click
		long beforeElementVisibleTextTime = System.currentTimeMillis();
		
		//Scroll to 'Element Visibility', click trigger and validate visible text
		By btnTriggerVisibleLocator = By.xpath("//button[contains(text(),'Trigger') and @data-testid='btn-trigger-visible']");
		WebElement btnTriggerVisible = myWait.until(ExpectedConditions.elementToBeClickable(btnTriggerVisibleLocator));
		btnTriggerVisible.click();
		
		By elementVisibleTextLocator = By.xpath("//div[contains(text(),'Element is now visible')]");
		WebElement elementVisibleText = myWait.until(ExpectedConditions.visibilityOfElementLocated(elementVisibleTextLocator));
		String actualelementVisibleText = elementVisibleText.getText();
		System.out.println("Actual element visible text: "+actualelementVisibleText);
		long afterElementVisibleTextTime = System.currentTimeMillis();
		System.out.println("Total elapsed time: "+((afterElementVisibleTextTime-beforeElementVisibleTextTime)/1000)+" seconds");
		
		//Quit driver instance
		driver.quit();
	}

}
