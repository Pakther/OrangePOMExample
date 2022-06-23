package com.qa.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.orangehrm.base.DriverManager;

public class HomePage extends DriverManager{
	 
	WebDriver driver;
	
	By emailField = By.xpath("//input[@id='myText']");
	By freeTrailSubmit = By.xpath("//input[@id='linkadd']");
	

	// initialize page constructor
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		
	}	
	
	
	// Page actions
	
	public String verifyHomePageTitle() {
		
		return driver.getTitle();
		
	}
	
	public FreeTrail verifyGetFreeTrail(String em) {
		
		
		driver.findElement(emailField).sendKeys(em);
		driver.findElement(freeTrailSubmit).click();
		
		return new FreeTrail(driver);
		
	}
	
	
	
	

}
