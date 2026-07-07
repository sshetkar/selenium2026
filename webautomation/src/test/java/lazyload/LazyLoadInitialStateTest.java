package lazyload;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LazyLoadInitialStateTest {

	public static void main(String[] args) {
		
		/*
 		 * Assignment 9 Task 1:
 		 * Verify the initial state of the lazy loading component by printing the image counter
 		 * And count visible placeholder elements before scrolling
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
		
		//Verify the initial state of the lazy loading component by printing the image counter
		By imageCounterLocator = By.xpath("//div[@data-testid='lazy-count']//child::strong"); //strong//parent::div
		WebElement imageCounter = myWait.until(ExpectedConditions.visibilityOfElementLocated(imageCounterLocator));
		String countOfImagesLoaded = imageCounter.getText();
		System.out.println("Count of intial images loaded:"+countOfImagesLoaded);
		
		/*
		 * to locate and generate xpath we need to pause the page load by putting in debugger mode
		 * inspect element >> sources >> Breakpoint >> Event Listner Breakpoint >> Mouse >> Double Click
		 */
		
		//And count visible placeholder elements before scrolling
		By imageBeforeLoadLocator = By.xpath("//div[starts-with(@data-testid,'img-placeholder-')]");
		List<WebElement> imageListBeforeLoad = myWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(imageBeforeLoadLocator));
		System.out.println("Count of image placeholder before load:"+imageListBeforeLoad.size());
		
		//Quit driver instance
		driver.quit();
				
	}

}
