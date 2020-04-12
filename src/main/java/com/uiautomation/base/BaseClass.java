package com.uiautomation.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.uiautomation.util.TestUtil;
import com.uiautomation.util.WebEventListener;


public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;
	public static WebEventListener eventListner;
	public static EventFiringWebDriver fireDriver;


	public BaseClass()
	{
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("src\\main\\java\\com\\uiautomation\\config\\config.properties");
			prop.load(ip);
		}catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}


	public static void initialization()
	{
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
			options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));
			options.setExperimentalOption("useAutomationExtension", false);
			options.setPageLoadStrategy(PageLoadStrategy.EAGER);

			driver = new ChromeDriver(options);
		}
		
		eventListner = new WebEventListener();
		fireDriver = new EventFiringWebDriver(driver);
		fireDriver.register(eventListner);
		driver = fireDriver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
	}

	
}
