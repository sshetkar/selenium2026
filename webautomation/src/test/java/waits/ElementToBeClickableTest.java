package waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementToBeClickableTest {

	public static void main(String[] args) {

		/*
		 * Assignment 3 - Task 2:
		 * Read and print the attribute disabled of 'Disabled..' button
		 * Click Trigger button and Wait until the disabled button becomes clickable
		 * Print disabled atrribute status, before and after click: "true" to "null"
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

		//Locate disabled button attribute, click trigger
		By disabledBtnLocator = By.xpath("//button[contains(text(),'') and @data-testid='wait-clickable-target']");
		WebElement disabledBtn = myWait.until(ExpectedConditions.visibilityOfElementLocated(disabledBtnLocator));
		String actualDisabledBtnAttribute = disabledBtn.getAttribute("disabled");
		System.out.println("Disabled button getAttribiute value? "+actualDisabledBtnAttribute);
		
		By btnTriggerClickableLocator = By.xpath("//button[contains(text(),'Trigger') and @data-testid='btn-trigger-clickable']");
		WebElement btnTriggerClickable = myWait.until(ExpectedConditions.elementToBeClickable(btnTriggerClickableLocator));
		btnTriggerClickable.click();
		
		//Recheck - disabled button attribute
		WebElement disabledBtnRecheck = myWait.until(ExpectedConditions.elementToBeClickable(disabledBtnLocator));
		actualDisabledBtnAttribute = disabledBtn.getAttribute("disabled");
		System.out.println("Button Disabled? "+actualDisabledBtnAttribute);
		
		//Quit driver instance
		driver.quit();
		
	}

}
