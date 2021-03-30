package com.w2a.zoho.rough;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.zoho.PageObjects.ZohoHomePage;
import com.w2a.zoho.PageObjects.ZohoLoginPage;
import com.w2a.zoho.utilities.DataProviders;

public class TestCase2 extends BaseTest{
	

	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void doLogin(String username, String password, String browser) {
		openBrowser(browser);
	//	getDriver().get("https://www.zoho.com/");
		ZohoHomePage home = new ZohoHomePage();
		ZohoLoginPage login = home.gotoLogin();
		login.doLogin("abdsalam4789@gmail.com","Duster@159");
		quit();
	}

}
