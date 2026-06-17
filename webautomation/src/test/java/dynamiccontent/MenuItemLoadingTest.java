package dynamiccontent;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class MenuItemLoadingTest {

	public static void main(String[] args) throws InterruptedException {
		
		/* Assignment 2: Click + Add Menu Item three times and wait for each item to appear. 
		 * After all three are loaded, print the name and price of each item to the console.
		 * Read the live counter and print its current value.
		 * Click Hide Menu, then confirm the section is no longer visible and printing it. 
		 */
		
		//Launch edge browser and navigate to AUT
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://uiplayground.techwithjatin.com/");
		
		//Select 'Dynamic Elements' from Left-side menu bar
		By dynamicElementMenuLocator = By.xpath("//div[@data-testid='nav-1']");
		driver.findElement(dynamicElementMenuLocator).click();
		
		//1. Add menu button 3 times
		By addMenuItemBtnLocator = By.id("btn-add-item");
		WebElement addMenuItemBtn = driver.findElement(addMenuItemBtnLocator);
		
		int counter=1, maxAttempt=3;
		while(counter<=maxAttempt) {
			addMenuItemBtn.click();
			counter++;
			Thread.sleep(2000);
		}
		
		//2. Print name, price of each item
		By foodMenuLocators = By.xpath("//div[@class='swiggy-card']");
		List<WebElement> foodMenuList = driver.findElements(foodMenuLocators);
		
		for(WebElement singleFoodItem:foodMenuList) {
			
			By foodNameLocator = By.xpath(".//div[@class='swiggy-name']");
			WebElement foodName = singleFoodItem.findElement(foodNameLocator); //chaining of xpath (singleFoodItem+foodNameLocator)
			
			By foodPriceLocator = By.xpath(".//span[@class='swiggy-price']");
			WebElement foodPrice = singleFoodItem.findElement(foodPriceLocator); //chaining of xpath (singleFoodItem+foodPriceLocator)
			System.out.println(foodName.getText()+" : "+foodPrice.getText());
			
		}
		
		//3. Read the live counter and print its current value
		By liveCounterLocator = By.cssSelector("div#live-counter");
		WebElement liveCounter = driver.findElement(liveCounterLocator);
		System.out.println("Live Counter: "+liveCounter.getText());
		
		//4. Click Hide Menu, then confirm the section is no longer visible and printing it.
		By hideShowMenuBtnLocator = By.xpath("//button[@data-testid='btn-toggle-visibility']");
		WebElement hideShowMenuBtn = driver.findElement(hideShowMenuBtnLocator);
		hideShowMenuBtn.click(); //Button text = Hide Menu
		
		String gethideShowMenuBtnTextPostClick = hideShowMenuBtn.getText();
		System.out.println("Hide/Show menu btn post click: "+gethideShowMenuBtnTextPostClick);
		if(gethideShowMenuBtnTextPostClick.equalsIgnoreCase("Show Menu")) {
			System.out.println("Menu is hidden.");
		} else {
			System.err.println("Menu is still displayed");
		}
		
	}

}
