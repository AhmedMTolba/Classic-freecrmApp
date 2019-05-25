package com.freecrm.testcases;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.freecrm.base.TestBase;
import com.freecrm.util.TestUtils;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class LoginPage extends TestBase {

	public LoginPage() throws IOException {
		super();
		
	}
	@Parameters({"browser"})
	@BeforeMethod
	public void SetUp(String browser, Method method) throws ATUTestRecorderException{
	
		intialization(browser);
		 recorder = new ATUTestRecorder("D:\\Testing\\FreeCrmApplication\\Videos", method.getName(), false);
		recorder.start();
	}

	@Test(priority=1 )
	public void TitleTest() {
	
	String Expectedresult= "Free CRM for Small Businesses - HubSpot";
	String Actualresult =driver.getTitle();
	System.out.println(Expectedresult);
//Hard Assert
	Assert.assertEquals(Actualresult, Expectedresult);
	
	}

	@Test(priority=2)
	public void URLcheck() {
		String Expectedresult ="https://www.hubspot.com/products/crm";
		String Actualresult =driver.getCurrentUrl();
		
		System.out.println(Actualresult);
		Assert.assertEquals(Actualresult, Expectedresult);
	
	}
	

   @Test(priority=3)
	public void logoChek() {
	   
		WebElement logo = driver.findElement(By.xpath("//img[@src='https://www.hubspot.com/hubfs/HubSpot_Logos/HSLogo_color.svg']"));
		boolean  ExpectedResult = true;
		boolean  ActualResult =	logo.isDisplayed();
		Assert.assertEquals(ActualResult, ExpectedResult);
		
   }

   @Test(priority=4 ) 
 	public void loginTest() {
 	   
	   
	  driver.findElement(By.id("hs-eu-confirmation-button")) .click();
	
	   driver.findElement(By.xpath("//li[@class='hsg-nav__group-item hsg-nav__group-item--login signed-out']")).click();
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	  
	   WebElement username = driver.findElement(By.cssSelector("#username"));
	   username.sendKeys(prop.getProperty("Username"));
 		WebElement password = driver.findElement(By.cssSelector("#password"));
 		password.sendKeys(prop.getProperty("Password"));
 		
 		
 		 WebElement Seclogin = driver.findElement(By.id("loginBtn"));
 		Seclogin.click();
 	    WebElement text  = driver.findElement(By.cssSelector("#nav-primary-contacts-branch"));
 			boolean ActualResult = text.isDisplayed();
 			boolean ExpectedResult = true;
 	        Assert.assertEquals(ActualResult, ExpectedResult);
 			System.out.println(ActualResult);
 			
   }


   @AfterMethod
   public void TearDown(Method method) throws ATUTestRecorderException, IOException
   {
   	TestUtils.TakeSnapshots(method.getName());
   	driver.quit();		
   	recorder.stop();
   	
   }

}
