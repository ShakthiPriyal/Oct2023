package com.salesforce.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_04B_Forgotpassword {

	public static void main(String[] args) {
		//launch the Web browser
		
				WebDriverManager.chromedriver().setup();
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				
				//Enter the url 
				
			driver.get("https://login.salesforce.com/");
			
			//login data
				WebElement usrname= driver.findElement(By.id("username"));
				usrname.sendKeys("123");
				WebElement pwd= driver.findElement(By.id("password"));
				pwd.sendKeys("22131");
				
				//login button
				WebElement loginbtn= driver.findElement(By.id("Login"));
				loginbtn.click();
				
				//capturing the error message
				
				WebElement errormsg= driver.findElement(By.id("error"));
				String errmsg =errormsg.getText();
				System.out.println(errmsg);

	}

}
