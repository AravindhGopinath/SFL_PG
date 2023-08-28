package org.runner;

import java.util.ArrayList;
import java.util.Iterator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import baseclass.BaseClass;
import excel.ExcelUtils;

public class UPI_Execution extends BaseClass {

	@DataProvider
	public Iterator<Object[]> upiTestData() {

		ArrayList<Object[]> testData = ExcelUtils.upiDataFromexcel();
		return testData.iterator();

	}

	@Test(dataProvider = "upiTestData")
	public static void upiExecution(String INDEX, String UPI_id, String UPI_Bank_name, String Payment)
			throws Exception {

//		System.out.println("Index -> " + INDEX);
//		System.out.println("UPI_id -> " + UPI_id);

		System.out.println("UPI_Bank_name -> " + UPI_Bank_name);

		System.out.println("Payment -> " + Payment);

		System.out.println("UPI @Test");

		launchBrowser("chrome");

		loadUrl("https://sitsfl.stfc.in/pg-initiate");

		initElements();

		Pre_Payment_Flow.execution(INDEX);

		UPI_Flow.execution(UPI_id, UPI_Bank_name, Payment,INDEX);

//		driver.quit();
	}

}
