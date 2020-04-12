package com.uiautomation.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.uiautoamtion.pages.LaunchPage;
import com.uiautoamtion.pages.LoginPage;
import com.uiautomation.base.BaseClass;

public class LoginPageTests extends BaseClass {
	
	LaunchPage launchPage;
	LoginPage loginPage;

	 public LoginPageTests() {
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		launchPage = new LaunchPage();
		loginPage = launchPage.clickOnLoginButton();
		
	}
	
	@Test
	public void logintoApp()
	{
		loginPage.provideCreds(prop.getProperty("username"), prop.getProperty("password"));
		loginPage.clickLoginbutton();
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
