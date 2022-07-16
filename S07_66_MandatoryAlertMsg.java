package sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S07_66_MandatoryAlertMsg {

	public static void main(String[] args) throws InterruptedException {
	
		/*
		 * Test Steps:
1) Launch the app
2) Click Login
3) Login with the credentials
4) Click on the App Laucher Icon left to Setup
5) Click on View All
6) Click on Work Types
7) Click on New
8) Enter Work Type Name as 'Bootcamp'
9) Click on Save
Expexted Result:
"Complete this field." alert message should be displayed for Estimated Duration
		 */
		
	//  Step 1 
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
			
			driver.findElement(By.xpath("//li[@class='slds-button slds-button--neutral']/a")).click();
			
	//Step 8 
			
			
			driver.findElement(By.xpath("//label[@class='label inputLabel uiLabel-left form-element__label uiLabel']/following-sibling::input")).sendKeys("Bootcamp");
			
	//Step 9 
			driver.findElement(By.xpath("//button[@title='Save']/span")).click();
		
			String text = driver.findElement(By.xpath("//span[text()='Review the errors on this page.']")).getText();
			
			if(text.contains("Review the errors on this page."))
				System.out.println("Mandatory field Alert message thrown Successfully");
			else 
				System.out.println("Mandatory field Alert message not thrown");
			
			driver.close();
	}

}
