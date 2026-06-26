package fileupload;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InvalidFileUploadTest {

	public static void main(String[] args) {
		
		/*
 		 * Assignment 5 - Task 2:
 		 * Locate the hidden tag input using data-testid="file-input" (present in DOM but not visible on webpage)
 		 * Upload a file having size greater than 1 mb
 		 * Print file name, size and status should be rejected
		 */
		
		//Launch chrome browser and navigate to AUT
		WebDriver driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://uiplayground.techwithjatin.com/");

		//ExplicitWait
		WebDriverWait myWait = new WebDriverWait(driver,Duration.ofSeconds(10));

		//Click 'File Upload' from Left-side menu bar
		By fileUploadMenuLocator = By.xpath("//span[contains(text(),'File Upload')]//parent::div[@data-testid='nav-5']");
		myWait.until(ExpectedConditions.elementToBeClickable(fileUploadMenuLocator)).click();
	
		//Extract the test files directory once
		String testFilesPath = System.getProperty("user.dir") + "\\src\\test\\resources\\testfiles\\";
		
		//Locate the hidden tag input using data-testid="file-input" (present in DOM but not visible on webpage)
		By fileUploadInputLocator = By.xpath("//input[@data-testid='file-input']"); 
		myWait.until(ExpectedConditions.presenceOfElementLocated(fileUploadInputLocator)).sendKeys(testFilesPath + "report_large.html");
		
		//Before uploading next file it takes time to complete upload previous file
		By fileUploadedListLocator = By.xpath("//div[@data-testid='file-list']");
		myWait.until(ExpectedConditions.visibilityOfElementLocated(fileUploadedListLocator));
		myWait.until(ExpectedConditions.presenceOfElementLocated(fileUploadInputLocator)).sendKeys(testFilesPath + "notes_large.txt");
		
		//Print file name, size and status
		By numberOfFilesUploadedLocator = By.xpath("//div[@data-testid='file-list']/div");
		myWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(numberOfFilesUploadedLocator, 1));
		
		List<WebElement> listOfFilesUploaded = myWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(numberOfFilesUploadedLocator));
		System.out.println("Number of files uploaded: "+listOfFilesUploaded.size());
		for(WebElement singleFile : listOfFilesUploaded) {
			WebElement fileName = singleFile.findElement(By.xpath(".//span[@class='file-name']"));
			WebElement fileSize = singleFile.findElement(By.xpath(".//span[@class='file-size']"));
			WebElement fileStatus = singleFile.findElement(By.xpath(".//span[@class='file-status']"));
			System.out.println(fileName.getText()+"\t"+fileSize.getText()+"\t"+fileStatus.getText());
			
			if("rejected".equals(fileStatus.getText())) {
				System.out.println(fileName.getText()+": Rejected due to size > 1 MB");
			}
		}
		
		//Quit driver instance
		driver.quit();
		
	}

}
