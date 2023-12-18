package com.salesforce.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_16_CreateNewOppurtunities {

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
		//click oppurtunities tab
		WebElement oppurtunitytab= driver.findElement(By.xpath("//a[text()='Opportunities']"));	
		oppurtunitytab.click();
		//click on new button
		WebElement newbutton= driver.findElement(By.name("new"));
		newbutton.click();
		WebElement oppnametextbox= driver.findElement(By.id("opp3"));
		oppnametextbox.sendKeys("nspriyal");
		
		WebElement closedate= driver.findElement(By.xpath("//a[@tabindex='7']"));	
		closedate.click();
		Thread.sleep(3000);
		//select the stage dropodown
		
		WebElement stagedropdown= driver.findElement(By.id("opp11"));
		
		Select stagedrpdwn= new Select(stagedropdown);
		
		stagedrpdwn.selectByVisibleText("Qualification");
		
	//	WebElement probtextbox= driver.findElement(By.id("opp12"));
	//	probtextbox.sendKeys("0");
		
WebElement leadsourcedropdown= driver.findElement(By.id("opp6"));
		
		Select leadsrcdrpdwn= new Select(leadsourcedropdown);
		
		leadsrcdrpdwn.selectByVisibleText("Web");
		//save button
				WebElement savebtn= driver.findElement(By.name("save"));
				savebtn.click();
		
		
	}

}
