package com.salesforce.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_33_VerifyFirstnameAndLastnameOfLoggedinUserIsDisplayed {

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
		//click home tab
		WebElement hometab= driver.findElement(By.xpath("//a[text()='Home']"));	
		hometab.click();
		WebElement fnamelname= driver.findElement(By.xpath("//a[contains(text(),'Shakthi')]"));
		
		//verify name
	String actualname=fnamelname.getText();
	
	String expectedname = "Shakthi Priyal ABCD";
	if (expectedname.equals(actualname)) {
		System.out.println(" Test case Passed");
	}else {
		System.out.println(" test case failed");
	}
	
	//verify link
	WebElement linkName= driver.findElement(By.linkText("Shakthi Priyal ABCD"));
	if(linkName.isDisplayed())
	{
	  System.out.println("Yes link is there");
	}
	else
	{
	  System.out.println("No link is there");
	}
		//to verify the link
		/*if (driver.findElements(By.xpath("//a[contains(text(),'Shakthi')]")).size() >0){ 
			 System.out.println("link exists"); 
		}else { 
			 System.out.println("link not exists"); 
	*////	} 
		fnamelname.click(); 
	}

}
