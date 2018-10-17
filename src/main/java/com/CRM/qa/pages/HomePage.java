package com.CRM.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CRM.qa.base.Base;

public class HomePage extends Base{
	
	//Page Factory- web element
	
	@FindBy(xpath="//td[contains(text(),'User: Naveen K')]")
	WebElement usernameLabel;
	
	@FindBy(xpath="//a[contains(@title,'Contacts')]")
	WebElement contactslink;
	
	@FindBy(xpath="//a[contains(@title,'Deals')]")
	WebElement dealslink;
	
	@FindBy(xpath="//a[contains(@title,'Tasks')]")
	WebElement tasksLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
		
	}
	
	//Actions:
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
		
	}
	
	public ContactsPage clickOnContacts() {
		contactslink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink() {
		dealslink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink() {
		tasksLink.click();
		return new TasksPage();
	}
	
	
	
	
	

}

