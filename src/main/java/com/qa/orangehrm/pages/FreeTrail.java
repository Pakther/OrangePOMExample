package com.qa.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.orangehrm.base.DriverManager;

public class FreeTrail extends DriverManager{
	
	
	WebDriver driver;
	
	
	By userNameField = By.xpath("//input[@id='Form_submitForm_subdomain']");
	By fullNameField = By.xpath("//input[@id='Form_submitForm_Name']");
	By emailField = By.xpath("//input[id='Form_submitForm_Email']");
	By phoneNumberField = By.xpath("//input[id='Form_submitForm_Contact']");
	By countryField = By.xpath("//input[id='Form_submitForm_Country']");
	By submitBtn = By.xpath("//input[id='Form_submitForm_action_request']");
	
	
	// create page constructor
	
	
	public FreeTrail (WebDriver driver) {
		
		this.driver= driver;
		
	}
	
	
	
	//Actions
	
	
	public String verifyFreeTrailTitle() {
		
		return driver.getTitle();
		
	}
	
	public void verifyFreeTail(String un, String fn, String eF, String pN, String cF) {
		
		driver.findElement(userNameField).sendKeys(un);
		driver.findElement(fullNameField).sendKeys(fn);
		driver.findElement(emailField).sendKeys(eF);;
		driver.findElement(phoneNumberField).sendKeys(pN);
		
		
		driver.findElement(countryField).sendKeys(cF);;
		driver.findElement(submitBtn).click();
		
		
	}
	
	public FreeTrailSuccess gotoFreeTrailSuccessPage() {
		
		
		return new FreeTrailSuccess();
	}
	
	

}
