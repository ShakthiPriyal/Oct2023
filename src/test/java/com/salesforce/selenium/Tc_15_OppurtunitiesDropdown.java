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

public class Tc_15_OppurtunitiesDropdown {

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
		
		//click oppurtunities tab
				WebElement oppurtunitytab= driver.findElement(By.xpath("//a[text()='Opportunities']"));	
				oppurtunitytab.click();
				
				//verify oppurtunity dropdown
				
			/*	List<String> expectedlist = new ArrayList<String>();
				expectedlist.add("All Opportunities");
				expectedlist.add("Closing Next Month");
				expectedlist.add("Closing This Month");
				expectedlist.add("My Opportunities");
				expectedlist.add("New Last Week");
				expectedlist.add("New This Week");
				expectedlist.add("Opportunity Pipeline");
				expectedlist.add("Private");
				expectedlist.add("Recently Viewed Opportunities");
				expectedlist.add("Won");
			WebElement oppurtunitydropdown= driver.findElement(By.id("fcf"));
				Select select= new Select (oppurtunitydropdown);
				
				for(WebElement actuallist :select.getOptions()) {
					
					Assert.assertEquals(actuallist,expectedlist );
				
				
			*///	}
				String expectedlist[] = {"All Opportunities","Closing Next Month", "Closing This Month", "My Opportunities", "New Last Week", "New This Week", "Opportunity Pipeline", "Private", "Recently Viewed Opportunities", "Won"};
				WebElement oppurtunitydropdown= driver.findElement(By.id("fcf"));
								
								Select select= new Select(oppurtunitydropdown);
								
								List <WebElement> options =select.getOptions();

				for(int i=0;i<options.size();i++) {
					//System.out.println("Actual: "+actualdropdownlist.get(i)+" & Expected: "+expectedlist.get(i));
				Assert.assertEquals(options.get(i).getText(),expectedlist[i] );
	}
driver.close();
}
	}