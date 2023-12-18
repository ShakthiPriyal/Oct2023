package com.salesforce.selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_13_MergeAccounts {

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
		
		//click accounts tab
				WebElement accounttab= driver.findElement(By.xpath("//a[text()='Accounts']"));	
				accounttab.click();
				
				Thread.sleep(3000);
				//account name textbox
				WebElement mergeaccountlink= driver.findElement(By.xpath("//a[text()='Merge Accounts']"));
				mergeaccountlink.click();
				
				
			
				//find account textbox
				
				WebElement accttextbox= driver.findElement(By.id("srch"));
				accttextbox.sendKeys("Shakthi");
				
				WebElement findacctbutton= driver.findElement(By.name("srchbutton"));
				findacctbutton.click();	
				
				
				
				//next button
				WebElement nextbutton= driver.findElement(By.name("goNext"));
				nextbutton.click();	
				//click merge
				WebElement mergebutton= driver.findElement(By.name("save"));
				mergebutton.click();	
				
				//popup
				
				Alert alert = driver.switchTo().alert();
				alert.accept();
				
	}

}
