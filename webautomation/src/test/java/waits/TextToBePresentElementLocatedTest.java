package waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TextToBePresentElementLocatedTest {

	public static void main(String[] args) {
		
		/*
		 * Assignment 3 - Task 3:
		 * Print text of empty field before triggering
		 * Click Trigger button and wait until text "injected" appears inside the element
		 * Print the full text content after condition is met
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
		
		//Print text of empty field before trigger
		By divTextBoxLocator = By.xpath("//div[@data-testid='wait-text-target']");
		WebElement divTextBox = myWait.until(ExpectedConditions.visibilityOfElementLocated(divTextBoxLocator));
		System.out.println("Div empty text box actual text before trigger: "+divTextBox.getText());
		
		//Click Trigger button and print the full text content after condition is met
		By btnTriggerTextLocator = By.xpath("//button[@data-testid='btn-trigger-text']");
		WebElement btnTriggerText = myWait.until(ExpectedConditions.elementToBeClickable(btnTriggerTextLocator));
		btnTriggerText.click();
		
		boolean injectedTextStatus = myWait.until(ExpectedConditions.textToBePresentInElementLocated(divTextBoxLocator, "injected"));
		System.out.println("Is text been injected on trigger? "+injectedTextStatus);
		System.out.println("Div empty text box actual text after trigger: "+divTextBox.getText());
		
		//Quit driver instance
		driver.quit();
		
	}

}
