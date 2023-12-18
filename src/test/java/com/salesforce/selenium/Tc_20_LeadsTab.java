package com.salesforce.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_20_LeadsTab {

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
		//click leads tab
				WebElement leadstab= driver.findElement(By.xpath("//a[text()='Leads']"));	
				leadstab.click();
				//to verify
				String actualtitle=driver.getTitle();
				System.out.println(actualtitle);
				String expectedtitle = "Leads: Home ~ Salesforce - Developer Edition";
				if(actualtitle.equals(expectedtitle)) {
					System.out.println("test case passed");
				}

	}

}
