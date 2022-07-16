package sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S07_63_NegativeEditWorkType {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * Test Steps:
	1) Launch the app
	2) Click Login
	3) Login with the credentials
	4) Click on the App Laucher Icon left to Setup
	5) Click on View All
	6) Click on Work Types
	7) Click on the Arrow button at the end of the first result
	8) Click on Edit
	9) Enter Time Frame Start as '9'	
	10) Enter Time Frame End as '6'
	11) Click on Save
	12) Verify the error message
	Expected Result:
			The Error message should be displayed
		 * 
		 */

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver =new ChromeDriver(options);
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Step 2 and 3
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("matschie@testleaf.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SeleniumBootcamp@123");
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		
		//Step 4
		
		driver.findElement(By.className("slds-icon-waffle")).click();
				
		//Step 5 
				
			driver.findElement(By.xpath("//button[text()='View All']")).click();
				
		//Step 6 
			driver.findElement(By.xpath("//lightning-input[@class='searchBar slds-form-element']//input")).sendKeys("Work Types");
				
			driver.findElement(By.xpath("//p[@class='slds-truncate']/mark")).click();
		
		//Step 7 
				Thread.sleep(3000);
						
				driver.findElement(By.xpath("//a[contains(@class,'slds-button slds-button--icon-x-small')]")).click();
				
		//Step 8 
				
				driver.findElement(By.xpath("(//div[@class='branding-actions actionMenu'])//ul//li[1]//a[1]")).click();
				
		//Step 9 
				
				driver.findElement(By.xpath("(//label[@class='label inputLabel uiLabel-left form-element__label uiLabel'])[7]/following-sibling::input")).sendKeys("9");
				
		//Step 10
				
				driver.findElement(By.xpath("(//label[@class='label inputLabel uiLabel-left form-element__label uiLabel'])[8]/following-sibling::input")).sendKeys("6");
				
		//Step 11
				driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
				
		//Step 12
				String text = driver.findElement(By.xpath("//span[text()='Review the errors on this page.']")).getText();
				
				if(text.contains("Review the errors"))
					System.out.println("The Error message displayed Successfully");
				else 
					System.out.println("The Error message is not displayed ");
				
				driver.close();
				
	}

}
