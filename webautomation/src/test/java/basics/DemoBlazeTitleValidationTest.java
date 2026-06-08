package basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoBlazeTitleValidationTest {

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("Test Case  - Validate title of the DemoBlaze website");
		
		//Launch browser and maximize
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.demoblaze.com/");
		
		//Validate title
		String expectedTitle = "STORE";
		String actualTitle = driver.getTitle();
		if(actualTitle.equals(expectedTitle)) {
			System.out.println("Test Pass - Validate title of the DemoBlaze website\nExpected Title:"+expectedTitle+"\nActual Title:"+actualTitle);
		} else {
			System.out.println("Test Fail - Validate title of the DemoBlaze website\nExpected Title:"+expectedTitle+"\nActual Title:"+actualTitle);
		}
		
		//Quit all browser instances of webdriver
		driver.quit();
		
	}
	
}
