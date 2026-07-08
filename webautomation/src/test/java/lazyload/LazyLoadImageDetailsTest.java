package lazyload;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LazyLoadImageDetailsTest {

	public static void main(String[] args) {
		
		/*
 		 * Assignment 9 Task 3:
 		 * Scroll each lazy-loaded image into view
 		 * Print its data-testid, alt text, caption, CSS class
 		 * And the updated image loading counter after every successful load
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
			System.out.println("is Image " +(i+1)+ " loaded successfully? "+image.isDisplayed());

			//Print its data-testid, alt text, caption, CSS class
			By imgAltAttributeLocator = By.xpath("//div[@data-testid='img-container-"+i+"']/img");
			String imgAltAttribute = myWait.until(ExpectedConditions.presenceOfElementLocated(imgAltAttributeLocator)).getDomProperty("alt");
			System.out.println("Image "+(i+1)+" alt attribute value: "+imgAltAttribute);
			
			By imgCaptionLocator = By.xpath("//div[@data-testid='img-container-"+i+"']/child::div");
			String imgCaption = myWait.until(ExpectedConditions.visibilityOfElementLocated(imgCaptionLocator)).getText();
			System.out.println("Image "+(i+1)+" caption: "+imgCaption);
			
			String imgClassAttribute = myWait.until(ExpectedConditions.presenceOfElementLocated(imgAltAttributeLocator)).getAttribute("class");
			System.out.println("Image "+(i+1)+" class attribute value: "+imgClassAttribute);
			boolean isImgLoaded = imgClassAttribute.contains("img-loaded");
			System.out.println("Image "+(i+1)+" class attribute value contains img-loaded? "+isImgLoaded);
			
			By imgLoadCounterLocator = By.xpath("//div[@data-testid='lazy-count']");
			String imgLoadCounter = myWait.until(ExpectedConditions.visibilityOfElementLocated(imgLoadCounterLocator)).getText();
			System.out.println(imgLoadCounter);
			
			System.out.println("----------------------------------------------------------------");
			
			//Quit driver instance
			driver.quit();
			
		}
			
	}

}
