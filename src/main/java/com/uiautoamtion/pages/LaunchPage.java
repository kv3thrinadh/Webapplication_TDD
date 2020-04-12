package com.uiautoamtion.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uiautomation.base.BaseClass;


public class LaunchPage extends BaseClass{

	@FindBy(xpath = "//*[text()='Log In']")
	WebElement LoginButton;


	public LaunchPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage clickOnLoginButton()
	{
		LoginButton.click();
		return new LoginPage();
	}
}
