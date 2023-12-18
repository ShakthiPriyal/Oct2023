package com.salesforce.selenium;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_36_BlockingAnEventInTheCalendar {

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
		//click home tab
		WebElement hometab= driver.findElement(By.xpath("//a[text()='Home']"));	
		hometab.click();
		Thread.sleep(3000);
		WebElement datelink= driver.findElement(By.xpath("//a[contains(text(),' 2023')][1]"));
		
		datelink.click();
		String actualpage= driver.getTitle();
		//System.out.println( actualpage);
		String expectedpage ="Calendar for Shakthi Priyal ABCD ~ Salesforce - Developer Edition";
		Assert.assertEquals(actualpage,expectedpage);
		WebElement eightpmlink= driver.findElement(By.xpath("//a[contains(text(),' 8:00 PM')]"));	
		eightpmlink.click();
		String actualeventpage= driver.getTitle();
		String expectedeventpage ="Calendar: New Event ~ Salesforce - Developer Edition";
		Assert.assertEquals(actualeventpage,expectedeventpage);
		//System.out.println( actualeventpage);
		//enter subject
			//	WebElement subjicon= driver.findElement(By.className("comboboxIcon"));
			//	subjicon.click();
			///	Thread.sleep(3000);
				//to get parentwindow id
				
		/*	String parentwindow =	driver.getWindowHandle();
			System.out.println(parentwindow);
				
				//tpo switch to the child window	
				
						Set<String> handles = driver.getWindowHandles();
						for(String handle:handles) {
							//to get child window id
							System.out.println(handle);
							//to swith control from parent to child window
							driver.switchTo().window(handle);
						}
						//to verify whether its in child window
						
				//		String childtitle=driver.getTitle();
		*///	System.out.println(childtitle);
				
			
						WebElement other= driver.findElement(By.id("evt5"));
						other.sendKeys("Other");
						
						//driver.switchTo().window(parentwindow);
						WebElement enddatefield= driver.findElement(By.id("EndDateTime_time"));
						enddatefield.sendKeys("");
						enddatefield.clear();
						enddatefield.sendKeys("9:00 PM");
						//save button
						WebElement savebtn= driver.findElement(By.name("save"));
						savebtn.click();
			}
	/*	//click8pm link
		WebElement eightpmlink= driver.findElement(By.xpath("//a[contains(text(),' 8:00 PM')]"));	
		eightpmlink.click();
//verify focus
		//enter subject
		WebElement subjicon= driver.findElement(By.className("comboboxIcon"));
		subjicon.click();
		//to get parentwindow id
		
		String parentwindow =	driver.getWindowHandle();
		
		//tpo switch to the child window	
		
				Set<String> handles = driver.getWindowHandles();
				for(String handle:handles) {
					//to get child window id
					System.out.println(handle);
					//to swith control from parent to child window
					driver.switchTo().window(handle);
				}
				//to verify whether its in child window
				
				String childtitle=driver.getTitle();
				System.out.println(childtitle);
				
				
	}*////

}
