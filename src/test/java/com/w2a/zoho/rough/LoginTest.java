package com.w2a.zoho.rough;


import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.w2a.zoho.PageObjects.ZohoHomePage;
import com.w2a.zoho.PageObjects.ZohoLoginPage;
import com.w2a.zoho.utilities.Constants;
import com.w2a.zoho.utilities.DataProviders;
import com.w2a.zoho.utilities.DataUtil;
import com.w2a.zoho.utilities.ExcelReader;

public class LoginTest extends BaseTest{
	
	
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void loginTest(Hashtable<String,String>data) {
		
		openBrowser(data.get("browser"));
		logInfo("Launched Browser :" +data.get("browser"));
//		DriverManager.getDriver().get("https://www.zoho.com/");
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "LoginTest", data.get("Runmode"), excel);
		ZohoHomePage home = new ZohoHomePage().open("https://www.zoho.com");
		ZohoLoginPage login = home.gotoLogin();
		login.doLogin(data.get("username"),data.get("password"));
//		getDriver().findElement(By.xpath("//*[@class='zh-login']")).click();
//		getDriver().findElement(By.name("LOGIN_ID")).sendKeys(username);
//		getDriver().findElement(By.xpath("//*[@id='nextbtn'][1]")).click();
//		getDriver().findElement(By.name("PASSWORD")).sendKeys(password);
//		getDriver().findElement(By.xpath("//*[@id='nextbtn'][1]")).click();
		logInfo("Username entered as :"+data.get("username")+"and Password entered as "+data.get("password"));
		//Assert.fail("Failing the login test !!!");
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		logInfo("Login Test Completed");
		quit();
	}
	
}
