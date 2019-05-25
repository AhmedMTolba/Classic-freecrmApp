package com.freecrm.testcases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import com.freecrm.base.TestBase;
import com.freecrm.util.TestUtils;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class ContactPage extends TestBase{

	public ContactPage() throws IOException {
		super();
		
	}
	@Parameters({"browser"})
	@BeforeMethod
	public void login(String browser, Method method) throws ATUTestRecorderException{
		
		intialization(browser);
		
		recorder = new ATUTestRecorder("D:\\Testing\\FreeCrmApplication\\Videos", method.getName(), false);
		recorder.start();
		
		
		     driver.findElement(By.id("hs-eu-confirmation-button")) .click();
	 		 driver.findElement(By.xpath("//li[@class='hsg-nav__group-item hsg-nav__group-item--login']")).click();

		    WebElement username = driver.findElement(By.cssSelector("#username"));
	 		username.sendKeys(prop.getProperty("Username"));
	 		WebElement password = driver.findElement(By.cssSelector("#password"));
	 		password.sendKeys(prop.getProperty("Password"));
	 		 WebElement Seclogin = driver.findElement(By.id("loginBtn"));
	 		Seclogin.click();
	         }



 @Test(dataProvider="Testdata")
 public void addContact(String email , String fname , String lname )
 {
	 
	  WebElement FirstContat = driver.findElement(By.cssSelector("#nav-primary-contacts-branch"));
	  Actions action = new Actions(driver);
	  action.moveToElement(FirstContat).build().perform();
	   FirstContat.click() ;

		WebElement contacts =driver.findElement(By.xpath("//a[@id='nav-secondary-contacts']"));
		contacts.click();
	  driver.findElement(By.xpath("//*[text()='Create contact']")).click();
	WebElement Email =  driver.findElement(By.cssSelector("#uid-ctrl-1"));
	WebElement FirstName =  driver.findElement(By.cssSelector("#uid-ctrl-2"));
	WebElement Lastname =  driver.findElement(By.xpath("//input[@data-field='lastname']"));
	 
	  Email.sendKeys(email);
	  FirstName.sendKeys(fname);
	  Lastname.sendKeys(lname);
	  
	  WebElement add= driver.findElement(By.xpath("//button[@data-selenium-test='base-dialog-confirm-btn']"));
	  add.click();

 }
 
 
 @DataProvider
 public Object[][] Testdata() throws Throwable {
	 
Object data [][] =	 TestUtils.getDataFromExcel("Sheet1");
return data;
 }
 
 
 
 
@AfterMethod
   public void Teardown(Method method) throws ATUTestRecorderException, IOException{
	 			TestUtils.TakeSnapshots(method.getName());
	 			driver.quit();	
	 			recorder.stop();
	 		}

}
