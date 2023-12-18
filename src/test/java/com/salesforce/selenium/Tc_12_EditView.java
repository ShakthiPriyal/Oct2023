package com.salesforce.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_12_EditView {

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
		
		Thread.sleep(3000);
		//select the view name from dropdown
		
		WebElement viewnamedropdown= driver.findElement(By.id("fcf"));
		Select viewname = new Select(viewnamedropdown);
		viewname.selectByVisibleText("nspriyal");	
		
		//select edit link
		WebElement editlink= driver.findElement(By.xpath("//a[text()='Edit']"));	
		editlink.click();
		//enter the details	
		WebElement viewnametextbox= driver.findElement(By.id("fname"));
		viewnametextbox.sendKeys("nspriyalns");
		//enter the deatils
		WebElement fielddropdown= driver.findElement(By.id("fcol1"));
		Select fieldname = new Select(fielddropdown);
		fieldname.selectByVisibleText("Account Name");
		
		WebElement operatordropdown= driver.findElement(By.id("fop1"));
		Select operatorname = new Select(operatordropdown);
		operatorname.selectByVisibleText("contains");
		
		WebElement valuetextbox= driver.findElement(By.id("fval1"));
		valuetextbox.sendKeys("a");
		//click on save button
		WebElement savebutton= driver.findElement(By.name("save"));
		savebutton.click();
		
	}

}
