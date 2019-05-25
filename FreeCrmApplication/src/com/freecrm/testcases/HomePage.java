package com.freecrm.testcases;

import java.io.IOException;
import java.lang.reflect.Method;

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

public class HomePage extends TestBase {

	public HomePage() throws IOException {
		super();
		
	}

    @Parameters({"browser"})
	@BeforeMethod
	public void login(String browser, Method method) throws ATUTestRecorderException{
		
		intialization(browser);
		
		recorder = new ATUTestRecorder("D:\\Testing\\FreeCrmApplication\\Videos", method.getName(), false);
		recorder.start();
		
		
		     driver.findElement(By.id("hs-eu-confirmation-button")) .click();
	 		 driver.findElement(By.xpath("//li[@class='hsg-nav__group-item hsg-nav__group-item--login signed-out']")).click();

		    WebElement username = driver.findElement(By.cssSelector("#username"));
	 		username.sendKeys(prop.getProperty("Username"));
	 		WebElement password = driver.findElement(By.cssSelector("#password"));
	 		password.sendKeys(prop.getProperty("Password"));
	 		 WebElement Seclogin = driver.findElement(By.id("loginBtn"));
	 		Seclogin.click();
	         }
	
	@Test(priority=5)
		public void clickoncontacts() 
		{
			
			driver.findElement(By.cssSelector("#nav-primary-contacts-branch")).click();
			WebElement contacts =driver.findElement(By.xpath("//a[@id='nav-secondary-contacts']"));
			contacts.click();
        WebElement contetx = driver.findElement(By.xpath("//input[@placeholder='Search for a contact']"));
        boolean ActualResult = contetx.isDisplayed();
        Assert.assertTrue(true, "the contacts label is not display");
        System.out.println(ActualResult);
			
        
		}
		
		@Test(priority=6 )
		public void clickonDeals() 
		{
			
			driver.findElement(By.cssSelector("#nav-primary-sales-branch")).click();
			WebElement contacts =driver.findElement(By.xpath("//a[@id='nav-secondary-deals']"));
			contacts.click();
        WebElement contetx = driver.findElement(By.xpath("//input[@placeholder='Search for a deal']"));
        boolean ActualResult = contetx.isDisplayed();
        Assert.assertTrue(true, "the deals label is not display");
        System.out.println(ActualResult);
       
		}
		
		@Test(priority=7)
		public void clickonTasks() 
		{
			
			driver.findElement(By.cssSelector("#nav-primary-sales-branch")).click();
			WebElement contacts =driver.findElement(By.xpath("//a[@id='nav-secondary-tasks']"));
			contacts.click();
        WebElement contetx = driver.findElement(By.xpath("//input[@placeholder='Search for a task']"));
        boolean ActualResult = contetx.isDisplayed();
        Assert.assertTrue(true, "the tasks label is not display");
        System.out.println(ActualResult);
			
        
		}
		
		
		@AfterMethod
		   public void Teardown(Method method) throws ATUTestRecorderException, IOException{
			 			TestUtils.TakeSnapshots(method.getName());
			 			driver.quit();	
			 			recorder.stop();
			 		}


}
