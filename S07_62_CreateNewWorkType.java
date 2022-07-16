package sprint1;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S07_62_CreateNewWorkType {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * 1) Launch the app
	2) Click Login
	3) Login with the credentials
	4) Click on the App Laucher Icon left to Setup
	5) Click on View All
	6) Click on Work Types
	7) Click on New
	8) Enter Work Type Name as 'Salesforce Project'
	9) Enter Description as 'Specimen'
	10) Create new operating hours by Entering a name as 'UK Shift'
	11) Enter Estimated Duration as '7'
	12 Click on Save
	13 Verify the Created message 
	Expected Result:
		The New Work Type should be created successfully 
		 * 
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
		
		
		driver.findElement(By.xpath("//label[@class='label inputLabel uiLabel-left form-element__label uiLabel']/following-sibling::input")).sendKeys("Salesforce Project");
		
		//Step 9 
		
		driver.findElement(By.xpath("//label[@class='label inputLabel uiLabel-left form-element__label uiLabel']/following-sibling::textarea")).sendKeys("Specimen");
		
		// Step 10 
		driver.findElement(By.xpath("//div[@class='autocompleteWrapper slds-grow']/input")).sendKeys("UK Shift");
		
		
		driver.findElement(By.xpath("//div[@title='UK Shift']/mark")).click();
		
		//Step 11
		
		driver.findElement(By.xpath("//input[@class='input uiInputSmartNumber']")).sendKeys("7");
		
		//Step 12 
		
		driver.findElement(By.xpath("//button[@title='Save']/span")).click();
		
		//Step 13 -Verify the Created message
		
		String text = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
		
		if(text.contains("was created"))
			System.out.println("New Work Type Created Successfully");
		else 
			System.out.println("New Work Type is failed to Create");
		
		driver.close();
			
	
		
	}

}
