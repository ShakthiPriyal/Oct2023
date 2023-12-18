package com.salesforce.selenium;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_07_SelectMySettingsOptionFromUsermenuDropdown {
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
	
	
	
	//click the  user menu dropdown
	
	WebElement usermenudrpdwn= driver.findElement(By.id("userNavLabel"));
	usermenudrpdwn.click();
	//click on my settings from usermenu dropdown
	WebElement mysettings= driver.findElement(By.xpath("//a[text()='My Settings']"));	
	mysettings.click();
	//click on personal link and select login history link
	WebElement personallink= driver.findElement(By.id("PersonalInfo_font"));
	personallink.click();
	WebElement loghistorylink= driver.findElement(By.id("LoginHistory_font"));
	loghistorylink.click();
	
	//verify the loginhistory page
	String actualtitle= driver.getTitle();
	System.out.println(actualtitle);
	String expectedtitle="Login History ~ Salesforce - Developer Edition";
	Assert.assertEquals(actualtitle, expectedtitle);
	// click download login history 
	WebElement loginhistorydownloadlink= driver.findElement(By.xpath("//a[contains(text(),'Download login history for last six months')]"));
	loginhistorydownloadlink.click();
	
	Thread.sleep(3000);
	//click on display and layout link
	WebElement displayoutlink= driver.findElement(By.id("DisplayAndLayout_font"));
	displayoutlink.click();
	WebElement customtablink= driver.findElement(By.id("CustomizeTabs_font"));
	customtablink.click();
	//select salesforce chatter from drop down
	WebElement customappdrpdown= driver.findElement(By.id("p4"));
	Select saleschatter = new Select(customappdrpdown);
	saleschatter.selectByVisibleText("Salesforce Chatter");
	
	
	
	//select reports from available tabs
	WebElement addreports= driver.findElement(By.id("duel_select_0"));	
	Select selectreport = new Select(addreports);
	selectreport.selectByVisibleText("Reports");
	
	
	WebElement addbutton= driver.findElement(By.className("rightArrowIcon"));	
	addbutton.click();
	
	//click on email link
	WebElement emaillink= driver.findElement(By.id("EmailSetup_font"));
	emaillink.click();
	WebElement emailsettinglink= driver.findElement(By.id("EmailSettings_font"));
	emailsettinglink.click();
	
	//enter the email name and fileld
	WebElement emailnametextbox= driver.findElement(By.id("sender_name"));
	emailnametextbox.clear();
	emailnametextbox.sendKeys("Shakthi Priyal");
	WebElement emailaddresstextbox= driver.findElement(By.id("sender_email"));
	emailaddresstextbox.clear();
	emailaddresstextbox.sendKeys("nshakthipriyal@gmail.com");
	
	WebElement bccradiobutton= driver.findElement(By.id("auto_bcc1"));
	bccradiobutton.click();
	
	WebElement savebutton= driver.findElement(By.name("save"));
	savebutton.click();
	
	String actualmysettingstitle= driver.getTitle();
	System.out.println(actualmysettingstitle);
	String expectedsettingstitle="Login History ~ Salesforce - Developer Edition";
	Assert.assertEquals(actualtitle, expectedtitle);
	//click on calendars and remainders
	
	WebElement calandreminderlink= driver.findElement(By.id("CalendarAndReminders_font"));
	calandreminderlink.click();
	WebElement activityreminderlink= driver.findElement(By.id("Reminders_font"));
	activityreminderlink.click();
	//click on test remainder button
	WebElement testbutton= driver.findElement(By.id("Reminders_font"));
	testbutton.click();
	
	Thread.sleep(3000);
	//to get parentwindow id
	
	/*	String parentwindow =	driver.getWindowHandle();
		System.out.println(parentwindow);
		//to switch to the child window	
		
				Set<String> handles = driver.getWindowHandles();
				for(String handle:handles) {
					System.out.println(handle);
					driver.switchTo().window(handle);
				}
				//to verify whether its in child window
				
				String childtitle=driver.getTitle();
				System.out.println(childtitle);
			//	driver.close();
				//to get back to the parentwindow
				
	*///			driver.switchTo().window(parentwindow);
		System.out.println("passed");
		WebElement saveagainbutton= driver.findElement(By.name("save"));
		saveagainbutton.click();
		
}
}
