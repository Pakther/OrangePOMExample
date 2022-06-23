package com.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.orangehrm.base.DriverManager;
import com.qa.orangehrm.pages.FreeTrail;
import com.qa.orangehrm.pages.FreeTrailSuccess;
import com.qa.orangehrm.pages.HomePage;
import com.qa.orangehrm.util.ReadExcelOrange;

public class FreeTrailTest extends DriverManager{
	
	HomePage homePage;
	
	FreeTrail freeTrail;
	
	FreeTrailSuccess freeTrailSuccess;
	
	
	public FreeTrailTest() {
		
		super();
		
	}
	
	
	@BeforeMethod
	public void setUp() {
		instantiate();
		homePage = new HomePage(driver);
		freeTrail=homePage.verifyGetFreeTrail(prop.getProperty("email"));
		freeTrail = new FreeTrail(driver);
	}
	
	
	
	public Object[][] getData(String excelPath, String sheetName){
		
		
		ReadExcelOrange excel = new ReadExcelOrange(excelPath, sheetName);
		
		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();
		
		Object [][] data = new Object[rowCount-1][colCount];
		
		for(int i = 1; i <rowCount; i ++) {
			
			for (int j = 0; j<colCount; j ++) {
				
				Object testData = excel.getCellValue(i, j);
				data[i-1][j] = testData;

				System.out.println(data[i-1][j] + " | ");
				
				
			}
			
			System.out.println();
			
			
		}
		
		return data;	
		
		
	}
	
	
	@DataProvider(name = "FreeTrailData")
	public Object[][] getFreeTrailData(){
		
		String excelPath = "./src/main/java/com/qa/orangehrm/util/FreeTrailData.xlsx";
		String sheetName = "ClientDummyData";
		
		Object data[][]= getData(excelPath, sheetName);
		
		return data;
		
		
	}
	
	@Test(priority = 2 , dataProvider = "FreeTrailData")
	public void freeTrailTest(String Username, String fullname, String email, String PhoneNumber, String Country) {
		
		freeTrail.verifyFreeTail(Country, fullname, email, PhoneNumber, Country);
		
		
		
	}
	
	
	
	
	
	
	@AfterMethod
	public void tearDown() {
		
		
		driver.quit();
		
	}

}
