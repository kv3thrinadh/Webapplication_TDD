package com.uiautomation.util;

import java.io.File;
import java.util.ArrayList;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.uiautomation.util.Xls_Reader;

public class TestUtil {

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;

	public static Xls_Reader reader;

	public static ArrayList<Object[]> getData_Tasks()
	{

		ArrayList<Object[]> data = new ArrayList<Object[]>();
		try {
			reader = new Xls_Reader("C:\\Users\\divya\\eclipse-workspace\\WebAutomation_TDD\\src\\main\\resources\\TestData.xlsx");
		}
		catch (Exception e){
			e.printStackTrace();}

		for (int rowCount = 2 ; rowCount<=reader.getRowCount("Tasks");rowCount++){
			String tasks = reader.getCellData("Tasks", "Task Name", rowCount);
			String description = reader.getCellData("Tasks", "Description", rowCount);
			Object ob[] = {tasks,description};
			data.add(ob);

		}

		return data;
	}


}
