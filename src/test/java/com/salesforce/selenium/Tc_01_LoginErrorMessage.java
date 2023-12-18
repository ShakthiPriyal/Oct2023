package com.salesforce.selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_01_LoginErrorMessage {
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
		pwd.sendKeys("");
		

	WebElement loginbtn= driver.findElement(By.id("Login"));
	loginbtn.click();
	
	//capturing the error message
	
	WebElement actualerrormsg= driver.findElement(By.id("error"));
	
	System.out.println(actualerrormsg.getText());
	String expectederrormsg="Please enter your password.";
	if(actualerrormsg.equals(expectederrormsg)) {
		System.out.println("testcase passed");
	}

}}
