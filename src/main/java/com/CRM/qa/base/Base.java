package com.CRM.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.CRM.qa.util.TestUtil;

public class Base {
	public static WebDriver driver;
	public static Properties prop;
	
	public Base(){
		
		prop=new Properties();
		try {
			FileInputStream ip=new FileInputStream("D:\\Coding-Workspace\\eclipse-workspace\\FreeCRMTest\\src\\main\\"
					+ "java\\com\\CRM\\config\\config.properties");
				prop.load(ip);
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
		 catch (IOException e) {
			
			 e.printStackTrace();
		}
		
		
	}
	
	public static void initialization() {
		String browserName=prop.getProperty("browser");
		
		if(browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "F:\\MySoftware\\Selenium With Java\\drivers\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "F:\\MySoftware\\Selenium With Java\\drivers\\geckodriver-v0.20.0-win64\\geckodriver.exe");
			driver=new FirefoxDriver(); 
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	

}
