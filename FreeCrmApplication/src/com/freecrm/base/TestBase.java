package com.freecrm.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.freecrm.util.WebListener;

import atu.testrecorder.ATUTestRecorder;


public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebListener weblistener;
	public static ATUTestRecorder recorder;
	
	public TestBase() throws IOException {
		
		 prop = new Properties();
	     FileInputStream fis = new FileInputStream ("D:\\Testing\\FreeCrmApplication\\src\\com\\freecrm\\config\\config.properties");
		 prop.load(fis);
		
	}

	
	public static void intialization(String browser)
	{
     if(browser.equalsIgnoreCase("chrome"))
     {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\Downloads\\chromedriver_win32\\chromedriver.exe");
	 driver = new ChromeDriver();
      }
		
    else if(browser.equalsIgnoreCase("firfox"))
      {
	System.setProperty("webdriver.firefox.driver","C:\\Users\\Administrator\\Downloads\\selenium-firefox-driver-3.13.0.jar");
	 driver = new FirefoxDriver();
      }
	
     e_driver= new EventFiringWebDriver(driver);
	    weblistener= new WebListener();
	  e_driver.register(weblistener);
	    driver = e_driver;

     
	
     driver.get(prop.getProperty("URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	   
	

	
	}



	
}
