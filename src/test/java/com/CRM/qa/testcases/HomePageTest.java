package com.CRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.CRM.qa.base.Base;
import com.CRM.qa.pages.HomePage;
import com.CRM.qa.pages.LoginPage;

public class HomePageTest extends Base{
	
	LoginPage loginpageobj;
	HomePage homePage;
	
	public HomePageTest() {
		super();
	}

	
	@BeforeMethod
	public void setup() {
		initialization();
		loginpageobj=new LoginPage();
		homePage=loginpageobj.loginToCRM(prop.getProperty("username"), prop.getProperty("password"));

	}
	
	
	@Test
	public void verifyHomePageTitleTest() {
		String title=homePage.verifyHomePageTitle();
		Assert.assertEquals(title, "CRMPRO","HomePage Title not matching");
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
}
