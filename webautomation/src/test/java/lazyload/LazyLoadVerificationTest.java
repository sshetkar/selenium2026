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

public class LazyLoadVerificationTest {

	public static void main(String[] args) {
		
		/*
 		 * Assignment 9 Task 4:
 		 * Verify that all lazy-loaded images are successfully loaded by counting images with the img-loaded class,
 		 * confirming no placeholders remain, and validating the final loading counter.
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
		
		//Scroll each lazy-loaded image into view
		JavascriptExecutor js = (JavascriptExecutor)driver; //Narrowcasting
		final int TOTAL_IMAGES = 12;
		for(int i=0; i<TOTAL_IMAGES; i++) {
			By imageContainerListLocator = By.xpath("//div[@data-testid='img-container-"+i+"']"); //dynamic xpath
			WebElement imageList = myWait.until(ExpectedConditions.visibilityOfElementLocated(imageContainerListLocator));
			
			js.executeScript("arguments[0].scrollIntoView({behavior:'smooth',block:'center'})", imageList); //smooth scrolling
		
			//And verify that the corresponding image becomes visible using explicit waits 
			By imageLocator = By.xpath("//img[@data-testid='img-" + i + "']");
			WebElement image = myWait.until(ExpectedConditions.visibilityOfElementLocated(imageLocator));
			
		}	
		
		//Verify that all lazy-loaded images are successfully loaded by counting images with the img-loaded class
		By imgLoadedLocator = By.cssSelector("img.img-loaded");
		List<WebElement> imgLoaded = myWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(imgLoadedLocator));
		System.out.println("Count of images loaded:"+imgLoaded.size());
		
		//wait for its placeholder to disappear
		By imagePlaceholderListLocator = By.xpath("//div[contains(@data-testid,'img-placeholder-')]"); //dynamic xpath
		int imagePlaceholderList = driver.findElements(imagePlaceholderListLocator).size();
		System.out.println("Count of images still not loaded: "+imagePlaceholderList);
		
		By countImgLoadedLocator = By.cssSelector("div[data-testid='lazy-count']");
		WebElement countImgLoaded = myWait.until(ExpectedConditions.visibilityOfElementLocated(countImgLoadedLocator));
		System.out.println(countImgLoaded.getText());
		
		//Quit driver instance
		driver.quit();

	}

}
