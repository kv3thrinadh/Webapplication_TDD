package com.uiautoamtion.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uiautomation.base.BaseClass;

public class HomePage extends BaseClass{

	@FindBy(xpath = "//*[text() = 'Tasks' and @class = 'item-text']")
	WebElement item;
	
	
	public HomePage()
	{
	 PageFactory.initElements(driver, this);
	}
	
	
	public ItemPage clickOnItemtab()
	{
		item.click();
		return new ItemPage();
	}
	
}
