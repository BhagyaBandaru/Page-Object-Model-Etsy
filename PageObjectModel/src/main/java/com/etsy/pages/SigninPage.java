package com.etsy.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.etsy.testbase.TestBase;
import com.etsy.utils.TestUtils;
//inheritance concept
public class SigninPage extends TestBase {
	
		
		TestUtils utils = new TestUtils();
		
		//Encapsulation
		@FindBy(xpath="//*[@id=\"gnav-header-inner\"]/div[4]/nav/ul/li[1]/button")
		private WebElement signinImg;
		
		@FindBy(id="join_neu_email_field")
		private WebElement username;
		
		@FindBy(id="join_neu_password_field")
		private WebElement password;
		
		@FindBy(name="submit_attempt")
		 private WebElement submit;
		
		
		//constructor
		public SigninPage()
		{
			//pholymorphism...here pagefactory is a class and initElements is a static method
			//method overloading/polymorphism/static/Pagefactory 
			PageFactory.initElements(driver, this); 
			
		}
		//Defining the all user actions (methods) that can be performed on etsy sign in page 
		public void clickOnSignInImg() {
			signinImg.click();
		}
		public void enteredValidCreds() {
			username.sendKeys("bhagyalakshmi.bandaruj@gmail.com");
			password.sendKeys("Lucky@12345$");
		}
		public void clickOnSubmitBtn() {
			submit.click();
		}

	}


