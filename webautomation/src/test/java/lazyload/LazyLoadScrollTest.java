package lazyload;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LazyLoadScrollTest {

	public static void main(String[] args) {
		
		/*
 		 * Assignment 9 Task 2:
 		 * Scroll each lazy-loaded image container into view, wait for its placeholder to disappear,
 		 * And verify that the corresponding image becomes visible using explicit waits 
		 */

		//Launch chrome browser and navigate to AUT
		WebDriver driver = new ChromeDriver();
		
		Dimension windowSize = new Dimension(1920, 1070);
		driver.manage().window().setSize(windowSize);
		
		driver.get("http://uiplayground.techwithjatin.com/");
		
		//ExplicitWait
		WebDriverWait myWait = new WebDriverWait(driver,Duration.ofSeconds(15));

		//Click 'Lazy Load Images' from Left-side menu bar
		By iFrameMenuLocator = By.xpath("//span[contains(text(),'Lazy Load')]/parent::div[@data-testid='nav-12']");
		myWait.until(ExpectedConditions.elementToBeClickable(iFrameMenuLocator)).click();
		
		//Scroll each lazy-loaded image container into view
		JavascriptExecutor js = (JavascriptExecutor)driver; //Narrowcasting
		final int TOTAL_IMAGES = 12;
		for(int i=0; i<TOTAL_IMAGES; i++) {
			By imageContainerListLocator = By.xpath("//div[@data-testid='img-container-"+i+"']"); //dynamic xpath
			WebElement imageList = myWait.until(ExpectedConditions.visibilityOfElementLocated(imageContainerListLocator));
			
			js.executeScript("arguments[0].scrollIntoView({behavior:'smooth',block:'center'})", imageList); //smooth scrolling
			
			//wait for its placeholder to disappear
			By imagePlaceholderListLocator = By.xpath("//div[@data-testid='img-placeholder-"+i+"']"); //dynamic xpath
			boolean isImagesInvisible = myWait.until(ExpectedConditions.invisibilityOfElementLocated(imagePlaceholderListLocator));
			System.out.println("is placeholder "+i+" Invisible = "+isImagesInvisible);
			
			//And verify that the corresponding image becomes visible using explicit waits 
			By imageLocator = By.xpath("//img[@data-testid='img-" + i + "']");
			WebElement image = myWait.until(ExpectedConditions.visibilityOfElementLocated(imageLocator));
			System.out.println("is Image " + i + " loaded successfully? "+image.isDisplayed());
			
		}
		
		//Quit driver instance
		driver.quit();
				
	}

}
