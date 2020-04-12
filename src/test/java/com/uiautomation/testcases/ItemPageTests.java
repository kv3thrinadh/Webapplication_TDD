package com.uiautomation.testcases;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.uiautoamtion.pages.HomePage;
import com.uiautoamtion.pages.ItemPage;
import com.uiautoamtion.pages.LaunchPage;
import com.uiautoamtion.pages.LoginPage;
import com.uiautomation.base.BaseClass;
import com.uiautomation.util.TestUtil;

public class ItemPageTests extends BaseClass{
	
	LaunchPage launchPg;
	LoginPage loginPg;
	HomePage homePg;
	ItemPage itemPg;
	
	public ItemPageTests()
	{
		super();
	}

	@BeforeMethod
	public void setup()
	{
		initialization();
		launchPg = new LaunchPage();
		loginPg = launchPg.clickOnLoginButton();
		loginPg.provideCreds(prop.getProperty("username"), prop.getProperty("password"));
		homePg = loginPg.clickLoginbutton();
		itemPg = homePg.clickOnItemtab();
	}
	
	@DataProvider
	public Iterator<Object[]> getTaskData()
	{
		ArrayList<Object[]> testData=TestUtil.getData_Tasks();
		return testData.iterator();
	}
	
	
	@Test(dataProvider="getTaskData")
	public void addItem(String task,String description) throws InterruptedException
	{
		itemPg.clickOnNewButton();
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(5000);
		itemPg.fillDetails(task, description);
		itemPg.clickOnSaveButton();

	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
