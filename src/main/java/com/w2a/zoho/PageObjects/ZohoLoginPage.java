package com.w2a.zoho.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ZohoLoginPage extends BasePage {
	

	@FindBy(name="LOGIN_ID")
	public WebElement email;
	
	@FindBy(xpath="//*[@id='nextbtn'][1]")
	public WebElement nexta;
	
	@FindBy(name="PASSWORD")
	public WebElement pass;
	
	@FindBy(xpath="//*[@id='nextbtn'][1]")
	public WebElement logIn;
	
	
	public ZohoLoginPage doLogin(String username, String password) {
		
		
		
		type(email, username, "Username textbox");
		click(nexta, "Click on next button");
		type(email, password, "Password textbox");
		click(logIn, "Click on Login Button");
		return this;
	}


	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(email);
	}

}
