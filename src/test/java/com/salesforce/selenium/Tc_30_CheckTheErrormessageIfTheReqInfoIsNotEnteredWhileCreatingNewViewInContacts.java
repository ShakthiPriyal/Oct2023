package com.salesforce.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_30_CheckTheErrormessageIfTheReqInfoIsNotEnteredWhileCreatingNewViewInContacts {

	public static void main(String[] args) {
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
		//click contact tab
				WebElement contactstab= driver.findElement(By.xpath("//a[text()='Contacts']"));	
				contactstab.click();
				//click create new view
				WebElement newviewlink= driver.findElement(By.xpath("//a[text()='Create New View']"));	
				newviewlink.click();
				
			//	WebElement viewname= driver.findElement(By.id("fname"));
			//	viewname.sendKeys("priya");
				//enter unique view name
				WebElement uniqueviewname= driver.findElement(By.id("devname"));
				 uniqueviewname.sendKeys("EFGH");
				 uniqueviewname.clear();
				 uniqueviewname.sendKeys("EFGH");
				 //save button
				 WebElement savebtn= driver.findElement(By.name("save"));
					savebtn.click();
					//verify error message
					WebElement actualerrormsg= driver.findElement(By.className("errorMsg"));
					System.out.println(actualerrormsg.getText());
					String expectederrormsg="Error: You must enter a value";
					if(actualerrormsg.equals(expectederrormsg)) {
						System.out.println("testcase passed");
					}
	}

}
