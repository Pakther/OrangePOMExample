package com.qa.orangehrm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public DriverManager() {
		
		try {
		prop = new Properties();
		FileInputStream ip = new FileInputStream( System.getProperty("user.dir")+ "/src/main/java/com/qa/orangehrm/config/confiq.orangehrm.properties");
		
			prop.load(ip);		
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {	
			e.printStackTrace();
		}	
		
	}
	

	
	
	
	
	public void instantiate() {
		
		String browserName = prop.getProperty("browser");
		
		
		
		System.out.println("Browser name is : " + browserName);

		if (browserName.equalsIgnoreCase("Chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		

		} else if (browserName.equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

			

		} else if (browserName.equalsIgnoreCase("Edge")) {

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		

		} else if (browserName.equalsIgnoreCase("safari")) {

			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();

			

		} else {

			System.out.println("Wrong Browser selected");
		}

		
		driver.get(prop.getProperty("url"));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
	}	

}
