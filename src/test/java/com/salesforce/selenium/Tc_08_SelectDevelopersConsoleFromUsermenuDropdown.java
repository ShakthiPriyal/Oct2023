package com.salesforce.selenium;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_08_SelectDevelopersConsoleFromUsermenuDropdown {

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
		
		//click the  user menu dropdown
		
		WebElement usermenudrpdwn= driver.findElement(By.id("userNavLabel"));
		usermenudrpdwn.click();
		
		//to get parentwindow id
		
	String parentwindow =	driver.getWindowHandle();
	
		
		//click on Developerconsole from usermenu dropdown
		WebElement devconsole= driver.findElement(By.xpath("//a[text()='Developer Console']"));	
		devconsole.click();
		//tpo switch to the child window	
		
		Set<String> handles = driver.getWindowHandles();
		for(String handle:handles) {
			System.out.println(handle);
			driver.switchTo().window(handle);
		}
		
		//to verify whether its in child window
		
		String childtitle=driver.getTitle();
		System.out.println(childtitle);
		driver.close();
		
		//to get back to the parentwindow
		
		driver.switchTo().window(parentwindow);
System.out.println("passed");
	}

}
;