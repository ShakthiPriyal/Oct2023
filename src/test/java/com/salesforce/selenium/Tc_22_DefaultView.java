package com.salesforce.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_22_DefaultView {

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
		Thread.sleep(3000);
		//click leads tab
	
				WebElement leadstab= driver.findElement(By.xpath("//a[text()='Leads']"));	
				leadstab.click();
		//select the leads dropodown
		
		WebElement leadsdropdown= driver.findElement(By.id("fcf"));
		
		Select selectleadsdrpdwn= new Select(leadsdropdown);
		
		selectleadsdrpdwn.selectByVisibleText("Today's Leads");
	//click the  user menu dropdown
	
	WebElement usermenudrpdwn= driver.findElement(By.id("userNavLabel"));
	usermenudrpdwn.click();
	
	
//select logout from usermenu dropdown

WebElement logout= driver.findElement(By.xpath("//a[text()='Logout']"));	
logout.click();
Thread.sleep(3000);
//login to the app
WebElement userrname= driver.findElement(By.id("username"));
userrname.sendKeys("nshakthipriyal@sand.com");
WebElement pswd= driver.findElement(By.id("password"));
pswd.sendKeys("Priyag123");

WebElement loginbutn= driver.findElement(By.id("Login"));
loginbutn.click();
Thread.sleep(3000);
//click leads tab
WebElement leadsstab= driver.findElement(By.xpath("//a[text()='Leads']"));	
leadsstab.click();
//verification

WebElement verifyleadsdropdown= driver.findElement(By.id("fcf"));
Select selectverifyleadsdrpdwn= new Select(verifyleadsdropdown);
WebElement selectedoption = selectverifyleadsdrpdwn.getFirstSelectedOption();
String selectedValueInDropDown = selectedoption.getText();
System.out.println(selectedValueInDropDown);
Thread.sleep(3000);
WebElement gobutton= driver.findElement(By.name("go"));
gobutton.click();
	}

}
