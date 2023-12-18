package com.salesforce.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_35_VerifyTheTabCustomization  {

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
		//click + tab
		WebElement plustab= driver.findElement(By.className("allTabsArrow"));	
		plustab.click();
		//click customize tab
		WebElement customizetab= driver.findElement(By.name("customize"));	
		customizetab.click();
		
		//select reports from selected tabs
		//WebElement deselectsubscript= driver.findElement(By.xpath("//select[text()='Subscriptions']"));	
		WebElement deselectsubscript= driver.findElement(By.id("duel_select_1"));
		Select select = new Select(deselectsubscript);
		select.selectByVisibleText("Subscriptions");
	//String	expectedname="Subscriptions";
		
		
		WebElement removebutton= driver.findElement(By.className("leftArrowIcon"));	
		removebutton.click();
		
			
		//click save
		WebElement savebutton= driver.findElement(By.name("save"));
		savebutton.click();
		//to verify
		//click customize tab
				WebElement customizetab1= driver.findElement(By.name("customize"));	
				customizetab1.click();
				//already webelement is found above
			WebElement deselectsubscript1= driver.findElement(By.id("duel_select_1"));
				Select deselectsub = new Select(deselectsubscript1);
				List<WebElement> options	=  deselectsub.getOptions();

				for(WebElement actuallist : options) {
				System.out.println( actuallist.getText());
			//	if(expectedname.contains(actuallist.getText())) {
			//		System.out.println("failed");}
			//		else {
			//			System.out.println("passed");	
				
					}
				//click the  user menu dropdown
				
				WebElement usermenudrpdwn= driver.findElement(By.id("userNavLabel"));
				usermenudrpdwn.click();
				//select logout from usermenu dropdown
				
				WebElement logout= driver.findElement(By.xpath("//a[text()='Logout']"));	
				logout.click();
				Thread.sleep(3000);
				//to verify login page
				String actualloginpagetitle=driver.getTitle();
				System.out.println(actualloginpagetitle);
				String expectedloginpagetitle=	"Login | Salesforce";
	if(expectedloginpagetitle.equals(actualloginpagetitle)){
		System.out.println("Testcase passed");
	}
	else {
		System.out.println("Testcase failed");
	}
	
	//login
	WebElement username= driver.findElement(By.id("username"));
	username.sendKeys("nshakthipriyal@sand.com");
	WebElement pswd= driver.findElement(By.id("password"));
	pswd.sendKeys("Priyag123");
	
	WebElement loginbutton= driver.findElement(By.id("Login"));
	loginbutton.click();
	Thread.sleep(3000);
	//click + tab
			WebElement plustab1= driver.findElement(By.className("allTabsArrow"));	
			plustab1.click();
			//click customize tab
			WebElement customizetab2= driver.findElement(By.name("customize"));	
			customizetab2.click();
			WebElement deselectsubscript11= driver.findElement(By.id("duel_select_1"));
			Select deselect = new Select(deselectsubscript11);
			List<WebElement> alloptions	=  deselect.getOptions();

			for(WebElement actuallist : alloptions) {
			System.out.println( actuallist.getText());
	}
	}
	
	}

//}
