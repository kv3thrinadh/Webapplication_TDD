package com.uiautoamtion.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uiautomation.base.BaseClass;

public class ItemPage extends BaseClass{
	
	
	@FindBy(xpath = "//input[@name=\"title\"]")
	WebElement titleTextField;
	
	@FindBy(xpath = "//textarea[@name=\"description\"]")
	WebElement descriptionTextField;
	
	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveButton;
	
	@FindBy(xpath = "//button[text()='New']")
	WebElement newButton ;
	
	public ItemPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnNewButton()
	{
		newButton.click();
	}
	public void fillDetails(String taskName,String taskDescription)
	{
		titleTextField.sendKeys(taskName);
		descriptionTextField.sendKeys(taskDescription);
	}
	
	public void clickOnSaveButton()
	{
		saveButton.click();
	}
	

}
