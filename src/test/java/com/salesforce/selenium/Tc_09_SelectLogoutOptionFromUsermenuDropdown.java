package com.salesforce.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_09_SelectLogoutOptionFromUsermenuDropdown {

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
				
				
		//select logout from usermenu dropdown
		
		WebElement logout= driver.findElement(By.xpath("//a[text()='Logout']"));	
		logout.click();
		Thread.sleep(3000);
		
		//to get the title of the page
		String pagetitle = driver.getTitle();
  System.out.println(pagetitle);
	}

}
