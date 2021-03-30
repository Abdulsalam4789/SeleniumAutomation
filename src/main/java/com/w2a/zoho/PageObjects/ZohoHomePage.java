package com.w2a.zoho.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.w2a.zoho.utilities.DriverManager;

public class ZohoHomePage extends BasePage {

//	WebDriver driver;
//	public ZohoHomePage(WebDriver driver) {
//		
//		this.driver=driver;
//		PageFactory.initElements(driver,this);
//	}
	
	@FindBy(xpath="//*[@class='zh-login']")
	public WebElement logIn;
	
	public ZohoHomePage open(String url) {
		DriverManager.getDriver().navigate().to(url);
		return (ZohoHomePage) openPage(ZohoHomePage.class);
		
	}	
	
	public ZohoLoginPage gotoLogin() {
		
		click(logIn, "Login Link");
		return (ZohoLoginPage) openPage(ZohoLoginPage.class);				
	}

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(logIn);
	}
	
}
