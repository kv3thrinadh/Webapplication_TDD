package com.uiautomation.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.uiautoamtion.pages.LaunchPage;
import com.uiautoamtion.pages.LoginPage;
import com.uiautomation.base.BaseClass;

public class LaunchPageTests extends BaseClass{
	
	LaunchPage launchPage;
	
	public LaunchPageTests()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		launchPage = new LaunchPage();
	}
	
	@Test
	public void clickOnLoginButton()
	{
		launchPage.clickOnLoginButton();
		
	}

	@AfterMethod
	public void Teardown()
	{
		driver.quit();
	}
}
