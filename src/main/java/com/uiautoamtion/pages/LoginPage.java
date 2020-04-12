package com.uiautoamtion.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uiautomation.base.BaseClass;

public class LoginPage extends BaseClass{
	
	@FindBy(name="email")
	WebElement usernameTextField;
	
	@FindBy(name="password")
	WebElement passwordTextField;
	
	@FindBy(xpath = "//*[text()='Login']")
	WebElement LoginButton;
	
	@FindBy(xpath = "//*[text()='Something went wrong...']")
	WebElement invalidLogindetails;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void provideCreds(String username,String password)
	{
		usernameTextField.clear();
		usernameTextField.sendKeys(username);
		passwordTextField.clear();
		passwordTextField.sendKeys(password);
	}

	public HomePage clickLoginbutton() {
		
		LoginButton.click();
		return new HomePage();
	}
}
