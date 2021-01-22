package com.etsy.testcases;


import org.junit.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.etsy.pages.SigninPage;
import com.etsy.testbase.TestBase;

	public class SigninPageTestcases extends TestBase{
		//Here we are calling signinpage object
		SigninPage loginPage;
		
		public SigninPageTestcases() {
			super();
		}
		
		@BeforeTest
		public void setUp() {
			initialization();
			loginPage =new SigninPage();
		}
		
		@Test(priority=1)
		public void clickedOnSignInImage() {
			loginPage.clickOnSignInImg();
			System.out.println("User clicked on Sign in Image");
			
		}
		@Test(priority=2)
		public void enterValidUsername() {
			loginPage.enteredValidCreds();
			System.out.println("User entered valid credentials");
			Assert.assertTrue(false);
			
			
		}
		@Test(priority=3)
		public void clickedOnSubmitBtn() {
			loginPage.clickOnSubmitBtn();
		}
		
		@AfterTest
		public void teardown() {
			driver.close();
		}
		
			
		

	}


