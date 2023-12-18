package com.salesforce.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_31_CheckTheCancelbuttonWorksFineInCreateNewView {

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
		//click create new view
		WebElement newviewlink= driver.findElement(By.xpath("//a[text()='Create New View']"));	
		newviewlink.click();
		
	WebElement viewname= driver.findElement(By.id("fname"));
	viewname.sendKeys("ABCD");
		//enter unique view name
		WebElement uniqueviewname= driver.findElement(By.id("devname"));
		 uniqueviewname.sendKeys("EFGH");
		 uniqueviewname.clear();
		 uniqueviewname.sendKeys("EFGH");
		 //cancel button
		 WebElement cancelbtn= driver.findElement(By.name("cancel"));
			cancelbtn.click();
			//to verify
			/*WebElement contactdropdown= driver.findElement(By.id("fcf"));
			
			Select select= new Select(contactdropdown);
			List<WebElement> options	=  select.getOptions();

			for(WebElement actuallist : options) {
			System.out.println( actuallist.getText());
			//if(actuallist.equals(expectedlist)) {
				
		//		System.out.println("Testcase passed");
			//	break;
		*///	}
			WebElement verifycontactsdropdown= driver.findElement(By.id("fcf"));
			Select selectverifyleadsdrpdwn= new Select(verifycontactsdropdown);
			WebElement selectedoption = selectverifyleadsdrpdwn.getFirstSelectedOption();
			String selectedValueInDropDown = selectedoption.getText();
			System.out.println(selectedValueInDropDown);

	}
	}

