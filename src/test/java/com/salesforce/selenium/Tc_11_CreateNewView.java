package com.salesforce.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_11_CreateNewView {

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
				//click create new vioew tab
				
				WebElement newviewtab= driver.findElement(By.xpath("//a[text()='Create New View']"));
				newviewtab.click();
			//enter the details	
				WebElement viewnametextbox= driver.findElement(By.id("fname"));
				viewnametextbox.sendKeys("nspriyal");
				
				WebElement uniqueviewnametextbox= driver.findElement(By.id("devname"));
				//uniqueviewnametextbox.clear();
			//	uniqueviewnametextbox.sendKeys("");
				uniqueviewnametextbox.sendKeys("201");//need to give diddrent 
		//save		
				WebElement savebutton= driver.findElement(By.name("save"));
				savebutton.click();
			
				
				
				Thread.sleep(3000);
				
				//to verify the view name in the dropdown
				WebElement actualviewname= driver.findElement(By.id("fcf"));
				Select selectviewname = new Select(actualviewname);
				// selectviewname.selectByVisibleText()
				System.out.println(((WebElement) selectviewname).getText());
				//if(viewnametextbox.equals(actualviewname)) {
				//	System.out.println("view name verified");
			///	//}
	}

}