package com.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;


import com.qa.orangehrm.base.DriverManager;
import com.qa.orangehrm.pages.FreeTrail;
import com.qa.orangehrm.pages.HomePage;

public class HomePageTest extends DriverManager {

	HomePage homePage;
		
		FreeTrail freeTrail;
		
		
		//using super keyword to reference parent class
		
	public HomePageTest() {
			
			super();
			
			
		}

	@BeforeMethod
	public void setUp() {
			
		instantiate();
		homePage = new HomePage(driver);

			
			
		}
		
		@Test(priority = 1)
		public void verifyHomePageTitleTest() {
			
			String actualTitleOHM = homePage.verifyHomePageTitle();
			String expectTitleOHM = "OrangeHRM HR Software | Free & Open Source HR Software | HRMS | HRIS";
			
			
			Assert.assertEquals(actualTitleOHM, expectTitleOHM, "The title is incorrect");
			
			System.out.println("The correct title is displayed in the home page" +actualTitleOHM);
		}
			

		@Test (priority = 2)
		public void freeTrailTest() {
			
		freeTrail = homePage.verifyGetFreeTrail(prop.getProperty("email"));
		
			
		}
		
		
		
		@AfterMethod

		public void tearDown() {
			
			
			driver.quit();
			
		}
		
		
		
	}
	


