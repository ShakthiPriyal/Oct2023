package com.salesforce.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_10_CreateAnAccount {

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
		//click accounts tab
		WebElement accounttab= driver.findElement(By.xpath("//a[text()='Accounts']"));	
		accounttab.click();
		
		//to verify account name
		WebElement acctnameverify= driver.findElement(By.xpath("//a[text()='Shakthi Priyal']"));
		
		String expectedname = "Shakthi Priyal";
		if(acctnameverify.equals(expectedname)) {
			System.out.println("Account name verified");
		}
		//click new tab
		WebElement newtab= driver.findElement(By.name("new"));
		newtab.click();
		
		//account name textbox
		WebElement accnametextbox= driver.findElement(By.id("acc2"));
		accnametextbox.sendKeys("Shakthi Priyall92");
		
		//select the type drop down
		WebElement typedropdown= driver.findElement(By.id("acc6"));
		
		Select techpartner = new Select(typedropdown);
		techpartner.selectByIndex(6);
		
		//scroll down
		
		//select customer priority
WebElement custprioritydropdown= driver.findElement(By.id("00NHn00000HYReq"));
		
		Select highpriority = new Select(custprioritydropdown);
		highpriority.selectByIndex(1);
		//save button
	WebElement savebutton= driver.findElement(By.name("save"));
		savebutton.click();
	}

}
