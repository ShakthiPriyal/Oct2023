package com.salesforce.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_25_CreateNewContact {

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
		//click new button
		WebElement newbtn= driver.findElement(By.name("new"));
		newbtn.click();
		
		//enter lastname
		WebElement lastnametextbox= driver.findElement(By.id("name_lastcon2"));
		lastnametextbox.sendKeys("Natarajan");
		
		//enter account name
		WebElement accountnametextbox= driver.findElement(By.id("con4"));
		accountnametextbox.sendKeys("Shakthi Priyal");
		//click save
		WebElement savebtn= driver.findElement(By.name("save"));
		savebtn.click();
		//to verify
		WebElement verifycontactname= driver.findElement(By.id("con2_ileinner"));
		System.out.println(verifycontactname.getAttribute("value"));
		
	}

}
