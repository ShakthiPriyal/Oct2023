package com.salesforce.selenium;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_21_LeadsSelectView {

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
		//verify leads dropdown
		
	/*	List<String> expectedlist = new ArrayList<String>();
		expectedlist.add("All Open Leads");
		expectedlist.add("My Unread Leads");
		expectedlist.add("Recently Viewed Leads");
		expectedlist.add("Today's Leads");
		expectedlist.add("View-Custom1");
		expectedlist.add("View-Custom2");
		
		//list of drop down items
		//select the leads dropodown
		
				WebElement leadsdropdown= driver.findElement(By.id("fcf"));
				
				Select leadsdrpdwn= new Select(leadsdropdown);
				List<WebElement> options	=  leadsdrpdwn.getOptions();

				for(WebElement actuallist : options) {
				System.out.println( actuallist.getText());
if(expectedlist.contains(actuallist.getText())) {
					
					System.out.println("Testcase passed");
					
				}

			//	leadsdrpdwn.selectByVisibleText("Qualification");
		

	*/////}
				String expectedlist[] = {"All Open Leads", "My Unread Leads", "Recently Viewed Leads", "Today's Leads", "View - Custom 1", "View - Custom 2" };
				WebElement leadsdropdown= driver.findElement(By.id("fcf"));
								
								Select select= new Select(leadsdropdown);
								
								List <WebElement> options =select.getOptions();

				for(int i=0;i<options.size();i++) {
					//System.out.println("Actual: "+actualdropdownlist.get(i)+" & Expected: "+expectedlist.get(i));
				Assert.assertEquals(options.get(i).getText(),expectedlist[i] );
	}
}}
