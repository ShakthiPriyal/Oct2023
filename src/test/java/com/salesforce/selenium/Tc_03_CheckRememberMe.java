package com.salesforce.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_03_CheckRememberMe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//launch the Web browser
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//Enter the url 
		
	driver.get("https://login.salesforce.com/");
	
	//login data
		WebElement usrname= driver.findElement(By.id("username"));
		usrname.sendKeys("nshakthipriyal@sand.com");
		WebElement pwd= driver.findElement(By.id("password"));
		pwd.sendKeys("Priyag123");
		
		//Remember me
		WebElement rememberme= driver.findElement(By.xpath("//label[text() = 'Remember me']"));
	
		rememberme.click();
		
		//verification
		if(rememberme.isSelected()) {
			System.out.println("Checkbox ios selected");
		}
		else {
			System.out.println("Checkbox is not selected");
		}
		//login button
		
		WebElement loginbtn= driver.findElement(By.id("Login"));
		loginbtn.click();

	}

}
