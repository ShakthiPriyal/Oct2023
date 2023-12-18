package com.salesforce.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_32_CheckSaveAndNewButtonWorksInNewContactPage {

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
				lastnametextbox.sendKeys("Indian");
				
				//enter account name
				WebElement accountnametextbox= driver.findElement(By.id("con4"));
				accountnametextbox.sendKeys("Global Media");
				//click save and new
				WebElement savebtn= driver.findElement(By.name("save_new"));
				savebtn.click();
				//to verify
				WebElement actualerrormsg= driver.findElement(By.id("errorDiv_ep"));
				System.out.println(actualerrormsg.getText());
			String expectederrormsg="Error: Invalid Data.Review all error messages below to correct your data.";
			Assert.assertEquals(expectederrormsg, expectederrormsg);
	}

}
