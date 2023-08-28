package org.runner;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import baseclass.BaseClass;
import excel.ExcelUtils;

public class DC_Execution extends BaseClass {

	@DataProvider
	public Iterator<Object[]> dcTestData() {

		ArrayList<Object[]> testData = ExcelUtils.dcDataFromexcel();
		return testData.iterator();

	}

	@Test(dataProvider = "dcTestData", priority = 2)
	public static void dcExecution(String INDEX, String VISA_DCNumber, String ValidTill, String CVV_No, String Payment)
			throws Exception {

		System.out.println("Index -> " + INDEX);

		System.out.println("VISA_DCNumber -> " + VISA_DCNumber);

		System.out.println("ValidTill -> " + ValidTill);

		System.out.println("CVV_No -> " + CVV_No);

		System.out.println("Payment -> " + Payment);

		System.out.println("Debit Card @Test");

		launchBrowser("chrome");

		loadUrl("https://sitsfl.stfc.in/pg-initiate");

		initElements();

		Pre_Payment_Flow.execution(INDEX);

		Debit_Card_Flow.radio_Btn_Execution(INDEX);

		Debit_Card_Flow.debit_Card_Number(VISA_DCNumber, INDEX);

		Debit_Card_Flow.valid_till(ValidTill, INDEX);

		Debit_Card_Flow.cvv(CVV_No, Payment, INDEX);

//		driver.quit();

	}

}
