package com.salesforce.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_24_CheckNewButtonOnLeadsHome {

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
				WebElement leadsstab= driver.findElement(By.xpath("//a[text()='Leads']"));	
				leadsstab.click();
				//click on new button
				WebElement newbutton= driver.findElement(By.name("new"));
				newbutton.click();
				//enter the details
				WebElement lastnametextbox= driver.findElement(By.id("name_lastlea2"));
				lastnametextbox.sendKeys("ABCD");
				WebElement compnametextbox= driver.findElement(By.id("lea3"));
			    compnametextbox.sendKeys("ABCD");
			  //save button
				WebElement savebtn= driver.findElement(By.name("save"));
				savebtn.click();
				String actualtitle=driver.getTitle();
				System.out.println(actualtitle);
				//String expectedtitle="Lead: ABCD ~ Salesforce - Developer Edition";
			//	if(actualtitle.equals(expectedtitle)) {
			//		System.out.println("testcase passed");
			//	}
	}

}
