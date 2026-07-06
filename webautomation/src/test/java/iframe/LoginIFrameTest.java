package iframe;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginIFrameTest {

	public static void main(String[] args) {
		
		/*
 		 * Assignment 8 Task 1:
 		 * Handle iframe
		 * Login and print welcome message
		 */

		//Launch chrome browser and navigate to AUT
		WebDriver driver = new ChromeDriver();
		
		Dimension windowSize = new Dimension(1920, 1080);
		driver.manage().window().setSize(windowSize);
		
		driver.get("http://uiplayground.techwithjatin.com/");
		
		//ExplicitWait
		WebDriverWait myWait = new WebDriverWait(driver,Duration.ofSeconds(10));

		//Click 'iFrame Sim' from Left-side menu bar
		By iFrameMenuLocator = By.xpath("//span[contains(text(),'iFrame Sim')]/parent::div[@data-testid='nav-8']");
		myWait.until(ExpectedConditions.elementToBeClickable(iFrameMenuLocator)).click();
		
		//Handle iframe
		String targetFrame = "real-iframe";
		List<WebElement> frameList = driver.findElements(By.tagName("iframe"));
		System.out.println("Number of frames are "+frameList.size());
		for (WebElement frame : frameList) {       
		  if(frame.getAttribute("id").equalsIgnoreCase("real-iframe")) {
			  driver.switchTo().frame(targetFrame);
		  }
		} 
	
		//Login
		By usernameFieldLocator = By.cssSelector("input[placeholder=\"admin\"]");
		WebElement usernameField = myWait.until(ExpectedConditions.elementToBeClickable(usernameFieldLocator));
		usernameField.clear();
		usernameField.sendKeys("admin");
		
		By passwordFieldLocator = By.cssSelector("input[placeholder='sdet123'][type='password']");
		WebElement passwordField = myWait.until(ExpectedConditions.elementToBeClickable(passwordFieldLocator));
		passwordField.clear();
		passwordField.sendKeys("sdet123");
		
		By loginButtonLocator = By.id("btn-login");
		myWait.until(ExpectedConditions.elementToBeClickable(loginButtonLocator)).click();
	
		//Print welcome message
		By welcomeHeadingLocator = By.cssSelector("div.welcome");
		boolean isWelcomeHeadingDisplayed = myWait.until(ExpectedConditions.textToBePresentInElementLocated(welcomeHeadingLocator, "Welcome,"));
		if(isWelcomeHeadingDisplayed) {
			System.out.println("Admin login Success");
		} else {
			System.out.println("Admin login Failure. Please check credentials");
		}
		
		driver.switchTo().defaultContent();
		
		//Quit driver instance
		driver.quit();
		
	}

}
