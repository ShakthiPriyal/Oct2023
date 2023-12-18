package com.salesforce.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_34_VerifyEditedLastnameIsUpdatedAtVariousPlaces {

	public static void main(String[] args) throws InterruptedException {
		//launch the Web browser
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//Enter the url 
		
	driver.get("https://login.salesforce.com/");
		WebElement usrname= driver.findElement(By.id("username"));
		usrname.sendKeys("nshakthipriyal@sand.com");
		WebElement pwd= driver.findElement(By.id("password"));
		pwd.sendKeys("Priyag123");
		
		WebElement loginbtn= driver.findElement(By.id("Login"));
		loginbtn.click();
		//click home tab
				WebElement hometab= driver.findElement(By.xpath("//a[text()='Home']"));	
				hometab.click();
				WebElement fnamelname= driver.findElement(By.xpath("//a[contains(text(),'Shakthi')]"));
				String actualname=fnamelname.getText();
				
				String expectedname = "Shakthi Priyal ABCD";
			//	String expectedname = "Shakthi Priyal ABCDNatarajanAdhiNatarajanAdhi";
				if (expectedname.equals(actualname)) {
					System.out.println(" Test case Passed");
				}else {
					System.out.println(" test case failed");
				}
				fnamelname.click();
//click edit button
				
				WebElement editbtn= driver.findElement(By.xpath("//img[@title='Edit Profile'][1]"));
				editbtn.click();
				
				//to switch to frame
				WebElement findframe= driver.findElement(By.xpath("//iframe[@id='contactInfoContentId']"));
				driver.switchTo().frame(findframe);
				Thread.sleep(3000);
				//to verify contact is displayed
				
			//	WebElement contacttab= driver.findElement(By.id("email"));
				WebElement contacttab= driver.findElement(By.xpath("//a[normalize-space()='Contact']"));
				
				System.out.println(contacttab.getText());
				Thread.sleep(3000);
			String	actualvalue=contacttab.getText();
			
			String expectedvalue="Contact";
			
			Assert.assertEquals(actualvalue,expectedvalue);

			//Click about tab
			
			WebElement abouttab= driver.findElement(By.xpath("//a[@aria-controls='TabPanel:0:Body:1']"));
			abouttab.click();
			//to check if textbox has focus
			WebElement firstnametextbox = driver.findElement(By.id("firstName"));
			boolean textfield =firstnametextbox.isEnabled();
			Assert.assertEquals(textfield,true);
			
		//	boolean anytextfield = driver.findElement(By.xpath("respectivexpath")).isEnabled();
		//	Assert.assertEquals(anytextfield,true);
			
			// Check if the element has focus 
			
			/*WebElement firstnametextbox = driver.findElement(By.id("firstName")); 
	       */// boolean hasFocus = firstnametextbox.equals(driver.switchTo().activeElement()); 
	 
	        // Print the result 
	     //   System.out.println("Element has focus: " + hasFocus); 
	      //type in the last name
			
			WebElement lastnamebox= driver.findElement(By.id("lastName"));
			lastnamebox.sendKeys("");
			lastnamebox.clear();
			lastnamebox.sendKeys("ABCD");
			//click saveall button sd21
			WebElement saveallbtn= driver.findElement(By.xpath("//input[@value='Save All']"));
			saveallbtn.click();
			//switch to webpage
			
			driver.switchTo().defaultContent();
			Thread.sleep(3000);
			WebElement usermenudrpdwn= driver.findElement(By.id("userNavLabel"));
			String actualusername=usermenudrpdwn.getText();
			String expectedusername="Shakthi Priyal ABCD";
			if(expectedusername.equals(actualusername)) {
				System.out.println(" Test case Passed");
			}
			else {
				System.out.println(" test case failed");
			}
			

			
			
	}

}
