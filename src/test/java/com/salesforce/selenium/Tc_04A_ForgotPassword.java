package com.salesforce.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_04A_ForgotPassword {

	public static void main(String[] args) {
		//launch the Web browser
		
				WebDriverManager.chromedriver().setup();
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				
				//Enter the url 
				
			driver.get("https://login.salesforce.com/");
			
			//login data
				WebElement usrname= driver.findElement(By.id("username"));
				usrname.sendKeys("nshakthipriyal@sand.com");
				
				//Forgot pwd
				WebElement forgotpwd= driver.findElement(By.id("forgot_password_link"));
				forgotpwd.click();
				
				WebElement forgotpwdusername= driver.findElement(By.id("un"));
				forgotpwdusername.sendKeys("nshakthipriyal@sand.com");
				
				WebElement contbutton= driver.findElement(By.id("continue"));
				contbutton.click();
				
				WebElement returnlogin= driver.findElement(By.xpath("//a[text()='Return to Login']"));
				returnlogin.click();

	}

}
