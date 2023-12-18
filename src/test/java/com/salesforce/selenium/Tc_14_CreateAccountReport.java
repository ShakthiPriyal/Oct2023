package com.salesforce.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_14_CreateAccountReport {

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
		//click accounts tab
		WebElement accounttab= driver.findElement(By.xpath("//a[text()='Accounts']"));	
		accounttab.click();
		WebElement acctactivitylink= driver.findElement(By.xpath("//a[text()='Accounts with last activity > 30 days']"));	
		acctactivitylink.click();
		Thread.sleep(3000);
		//datefield
		WebElement datefielddropdown= driver.findElement(By.id("ext-gen148"));
		//Select dtaefield = new Select(datefielddropdown);
		//dtaefield.selectByVisibleText("Created Date");
		datefielddropdown.click();
		WebElement createddate= driver.findElement(By.xpath("//div[text()='Created Date']"));
		createddate.click();
		
		//calendar field
		WebElement fromcal= driver.findElement(By.id("ext-comp-1042"));
		fromcal.sendKeys("10/29/2023");
		
	WebElement tocal= driver.findElement(By.id("ext-comp-1045"));
	 tocal.clear();
tocal.sendKeys("11/13/2023");
		//save button
		WebElement savebtn= driver.findElement(By.id("ext-gen49"));
		savebtn.click();
		
		//window handle
		WebElement reportnametextbox= driver.findElement(By.id("saveReportDlg_reportNameField"));
		reportnametextbox.sendKeys("pri");
		
		WebElement reportuniquenametextbox= driver.findElement(By.id("saveReportDlg_DeveloperName"));
		reportuniquenametextbox.sendKeys("pri22");
		
		WebElement saveandrunbutton= driver.findElement(By.xpath("//button[text()='Save and Run Report']"));
		saveandrunbutton.click();
	}
	

}
