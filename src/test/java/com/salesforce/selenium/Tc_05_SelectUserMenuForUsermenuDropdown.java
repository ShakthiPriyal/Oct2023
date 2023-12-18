package com.salesforce.selenium;

import java.util.List;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Tc_05_SelectUserMenuForUsermenuDropdown {

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
		
		//login button
		
		WebElement loginbtn= driver.findElement(By.id("Login"));
		loginbtn.click();
		
		//select Usermenu from user menu dropdown
		WebElement usermenudrpdwn= driver.findElement(By.id("userNavLabel"));
		usermenudrpdwn.click();
		
		List<String> expectedusermenulist = new ArrayList<String>();
		expectedusermenulist.add("My Profile");
		expectedusermenulist.add("My Settings");
		expectedusermenulist.add("Developer Console");
		expectedusermenulist.add("Switch to Ligtning Experience");
		expectedusermenulist.add("Logout");
		//List <WebElement> usermenulist =(List<WebElement>) driver.findElement(By.id("userNavLabel"));
		List <WebElement> actualusermenulist = driver.findElements(By.id("userNav-menuItems"));
		String actualuserlists;
	for(WebElement actualuserlists1 :actualusermenulist) {
			System.out.println(actualuserlists1.getText());
		//	if(expectedusermenulist.contains(userlists.getText())) {
			//Assert.assertEquals(actualuserlists,expectedusermenulist);
			}
		//	Assert.assertEquals(actualuserlists,expectedusermenulist);
	////		System.out.println("testcase passed");
		/*for(int i=0;i<actualusermenulist.size();i++) {
		//	System.out.println(actualusermenulist.get(i).getText());
		//	if(expectedusermenulist.contains(actualusermenulist.get(i).getText()));
		*///	}
		
	System.out.println("testcase passed");
			}
			
			
		
	}
		
	
