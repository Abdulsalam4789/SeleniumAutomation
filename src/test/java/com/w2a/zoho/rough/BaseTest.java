package com.w2a.zoho.rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;

import com.w2a.zoho.ExtentListners.ExtentListeners;
import com.w2a.zoho.utilities.DriverFactory;
import com.w2a.zoho.utilities.DriverManager;

public class BaseTest {
	
	private WebDriver driver;
	private Properties config = new Properties();
	private FileInputStream fis;
	public Logger log = Logger.getLogger(BaseTest.class);
	
	@BeforeSuite
	public void setUpFramework() {
		
		configureLogging();
		DriverFactory.setConfigPropertyFile(System.getProperty("user.dir")+"//src//test//resources//properties//Config.properties");
		if(System.getProperty("os.name").contains("mac")){
			
			DriverFactory.setChomeDriverExePath(System.getProperty("user.dir")+"//src//test//resources//executables//chromedriver");
			DriverFactory.setGeckoDriverExePath(System.getProperty("user.dir")+"//src//test//resources//executables//geckodriver");
		}else {
			DriverFactory.setChomeDriverExePath(System.getProperty("user.dir")+"//src//test//resources//executables//chromedriver.exe");
			DriverFactory.setGeckoDriverExePath(System.getProperty("user.dir")+"//src//test//resources//executables//geckodriver.exe");
			
		}
		
		try {
			fis = new FileInputStream(DriverFactory.getConfigPropertyFile());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			config.load(fis);
			log.info("Configuration file loaded !!!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void configureLogging() {
		
		String log4jConfigFile = System.getProperty("user.dir")+"//src//test//resources//properties//log4j.properties";
		PropertyConfigurator.configure(log4jConfigFile);
	}
	
	public void logInfo(String message) {
		
		ExtentListeners.testReport.get().info(message);
	}
	
	

	
	public void openBrowser(String browser) {
		
		DriverFactory.setRemote(true);
		if(DriverFactory.isRemote()) {
			if(browser.equals("chrome")) {
				System.out.println("Launching :"+browser);
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");
			driver = new ChromeDriver();
			log.info("Chrome Browser Launched");
			}else if(browser.equals("firefox")){
				System.out.println("Launching :"+browser);
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\geckodriver.exe");
			driver = new FirefoxDriver();
			log.info("firefox Browser Launched");
			}
			DriverManager.setWebDriver(driver);
			DriverManager.getDriver().manage().window().maximize();
			DriverManager.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			DesiredCapabilities cap=null;
			
		}else {
			
			System.out.println("Test execution failed");
		
		}

		DesiredCapabilities cap=null;
	}
	
	
	public void quit() {
		
		DriverManager.getDriver().quit();
	}

}
