package com.salesforce.selenium;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_37_blockingAnEventinTheCalendarWithWeeklyrecurrence {

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
				//(By.xpath("//a[contains(text(),'2023')][]"));
				datelink.click();
				String actualpage= driver.getTitle();
				//System.out.println( actualpage);
				String expectedpage ="Calendar for Shakthi Priyal ABCD ~ Salesforce - Developer Edition";
				Assert.assertEquals(actualpage,expectedpage);
				WebElement fourpmlink= driver.findElement(By.xpath("//a[contains(text(),' 4:00 PM')]"));	
				fourpmlink.click();
				String actualeventpage= driver.getTitle();
				String expectedeventpage ="Calendar: New Event ~ Salesforce - Developer Edition";
				Assert.assertEquals(actualeventpage,expectedeventpage);
				WebElement other= driver.findElement(By.id("evt5"));
				other.sendKeys("Other");
				
				//driver.switchTo().window(parentwindow);
				WebElement enddatefield= driver.findElement(By.id("EndDateTime_time"));
				enddatefield.sendKeys("");
				enddatefield.clear();
				enddatefield.sendKeys("7:00 PM");
				//Recurrence
				WebElement checkrecuurence= driver.findElement(By.id("IsRecurrence"));
				checkrecuurence.click();
				WebElement weeklyradibtn= driver.findElement(By.id("rectypeftw"));
				weeklyradibtn.click();
				WebElement enddate= driver.findElement(By.id("RecurrenceEndDateOnly"));
				enddate.click();
				SimpleDateFormat df = new SimpleDateFormat("MM/dd/YYYY");
				Date dt = new Date();
				Calendar cl = Calendar.getInstance();
				cl.setTime(dt);;
				 cl.add(Calendar.DATE, 14);
				//dt=cl.getTime();
				  String newDate = df.format(cl.getTime());
				//String str = df.format(dt);
				    System.out.println("the date today is " + newDate);


				
				    enddate .sendKeys(newDate);
				  //save button
				    WebElement savebutton= driver.findElement(By.name("save"));
					savebutton.click();
					 WebElement monthicon= driver.findElement(By.className("monthViewIcon"));
					 monthicon.click();
					 String actualtitle = driver.getTitle();
						//System.out.println(actualtitle);
					String expectedtitle="Calendar for Shakthi Priyal ABCD - Month View ~ Salesforce - Developer Edition";
					Assert.assertEquals(actualtitle, expectedtitle);
				//WebElement savebtn= driver.findElement(By.xpath("//input[@name='save'])[2]"));
			//	savebtn.click();
					driver.close();
	}

	}


