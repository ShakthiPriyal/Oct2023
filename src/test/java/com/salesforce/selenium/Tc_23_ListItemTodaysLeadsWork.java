package com.salesforce.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_23_ListItemTodaysLeadsWork {

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
		
WebElement leadsdropdown= driver.findElement(By.id("fcf"));
		
		Select leadsdrpdwn= new Select(leadsdropdown);
		
	leadsdrpdwn.selectByVisibleText("Today's Leads");

		WebElement gobutton= driver.findElement(By.name("go"));
		gobutton.click();

	}

}
