package com.salesforce.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_06_SelectmyProfileOptionFromUsermenuDropdown {

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
		
		//click the  user menu dropdown
		
				WebElement usermenudrpdwn= driver.findElement(By.id("userNavLabel"));
				usermenudrpdwn.click();
				WebElement myprofile= driver.findElement(By.xpath("//a[text()='My Profile']"));	
				myprofile.click();
				
				
				//click edit button
				
				WebElement editbtn= driver.findElement(By.xpath("//img[@title='Edit Profile'][1]"));
				editbtn.click();
				
				//to switch to frame
				WebElement findframe= driver.findElement(By.xpath("//iframe[@id='contactInfoContentId']"));
				driver.switchTo().frame(findframe);
				
				Thread.sleep(3000);
				
				//Click about tab
				
				WebElement abouttab= driver.findElement(By.xpath("//a[@aria-controls='TabPanel:0:Body:1']"));
				abouttab.click();
				
				//type in the last name
				
				WebElement lastnamebox= driver.findElement(By.id("lastName"));
				lastnamebox.sendKeys("NatarajanAdhi");
				
				//click saveall button sd21
				WebElement saveallbtn= driver.findElement(By.xpath("//input[@value='Save All']"));
				saveallbtn.click();
				//switch to webpage
				
				driver.switchTo().defaultContent();
				//click on post link
				
				WebElement postlink= driver.findElement(By.xpath("//span[text()='Post']"));
				 postlink.click();
				 
				 //frame to type the message
				 driver.switchTo().frame(0);
				 //post the text  in the text box and share
				 
				 WebElement posttextbox= driver.findElement(By.xpath("//body[text()='Share an update, @mention someone...']"));
				 posttextbox.click();
				 
				 posttextbox.sendKeys("Hi! im doing automation");
				 
				 driver.switchTo().defaultContent();
				 
				 WebElement sharebtn= driver.findElement(By.id("publishersharebutton"));
				 sharebtn.click();
				 
				 
				Thread.sleep(3000);
				 //click on file link and upload a photo
				 WebElement filelink= driver.findElement(By.xpath("//span[text()='File']"));
				 filelink.click();
				 
				 WebElement uploadfilelink= driver.findElement(By.xpath("//a[text()='Upload a file from your computer']"));
				 uploadfilelink.click();
				 
				 WebElement choosefilelink= driver.findElement(By.id("chatterFile"));
				 choosefilelink.sendKeys("/Users/lpg/Pictures/uploadpic.JPG");
				 
				 WebElement filesharebtn= driver.findElement(By.id("publishersharebutton"));
				 filesharebtn.click();
				 
				 Thread.sleep(3000);
				 
				 //crop an image
				 Actions action = new Actions(driver);
				 
				 WebElement uploadphotomousehover= driver.findElement(By.id("photoSection"));
				 action.moveToElement(uploadphotomousehover).click().build().perform();
				 Thread.sleep(3000);
				 
				 WebElement addphotolink= driver.findElement(By.xpath("//a[@id='uploadLink']"));
				 addphotolink.click();
				 //switch to frame
				 driver.switchTo().frame("uploadPhotoContentId");
				 
				 Thread.sleep(3000);
				 
				 WebElement choosephoto= driver.findElement(By.xpath("//input[@id='j_id0:uploadFileForm:uploadInputFile']"));
				 choosephoto.sendKeys("/Users/lpg/Pictures/uploadpic.JPG");
				 
				 Thread.sleep(5000);
				 
				 WebElement savebutton= driver.findElement(By.xpath("//input[@id='j_id0:uploadFileForm:uploadBtn']"));
				 savebutton .click(); 
				 Thread.sleep(5000);
				
			//	 WebElement cropimagemousehover= driver.findElement(By.id("imgCrop_handle imgCrop_handleNW"));
				// action.moveToElement(uploadphotomousehover).click().build().perform();
				    
				 /*   WebElement dragFrom = driver.findElement(By.xpath("imgCrop_handle imgCrop_handleNW"));
				    WebElement dropTo = driver.findElement(By.className("imgCrop_handle imgCrop_handleSW"));
				    actions.dragAndDrop(dragFrom, dropTo).build().perform();
				   */// Thread.sleep(5000);
					 WebElement saveaftercropbutton= driver.findElement(By.xpath("//input[@id='j_id0:j_id7:save']"));
					 saveaftercropbutton .click(); 
				 driver.switchTo().defaultContent();
				System.out.println("Testcase passed");
				
	}

}
