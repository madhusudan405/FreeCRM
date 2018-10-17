package com.CRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.CRM.qa.base.Base;
import com.CRM.qa.pages.HomePage;
import com.CRM.qa.pages.LoginPage;

public class LoginPageTest extends Base {
	LoginPage loginpageobj;
	HomePage homepage;
	
	
	public LoginPageTest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		initialization();
		loginpageobj=new LoginPage();
	}
	
	
	@Test(priority=1)
	public void loginpageTitleTest() {
		String title=loginpageobj.validateLoginPageTitle();
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
	}
	
	@Test(priority=2)
	public void CRMlogoTest() {
		boolean flag=loginpageobj.validateCRMLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest() {
		homepage=loginpageobj.loginToCRM(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
