package com.salesforce.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_26_CreateNewViewInTheContactPage {

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
				viewname.sendKeys("priya");
				WebElement uniqueviewname= driver.findElement(By.id("devname"));
				uniqueviewname.sendKeys("11");
				//click save
				WebElement savebtn= driver.findElement(By.name("save"));
				savebtn.click();
				//verify
				WebElement verifycontactdropdown= driver.findElement(By.id("fcf"));
				Select selectverifyleadsdrpdwn= new Select(verifycontactdropdown);
				WebElement selectedoption = selectverifyleadsdrpdwn.getFirstSelectedOption();
				String selectedValueInDropDown = selectedoption.getText();
				System.out.println(selectedValueInDropDown);
	}

}
