package org.runner;

import baseclass.BaseClass;
import excel.ExcelUtils;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Execution extends BaseClass {

	@DataProvider
	public Iterator<Object[]> upiTestData() {

		ArrayList<Object[]> testData = ExcelUtils.upiDataFromexcel();
		return testData.iterator();

	}

	@DataProvider
	public Iterator<Object[]> dcTestData() {

		ArrayList<Object[]> testData = ExcelUtils.dcDataFromexcel();
		return testData.iterator();

	}

	@DataProvider
	public Iterator<Object[]> nbTestData() {

		ArrayList<Object[]> testData = ExcelUtils.nbDataFromexcel();
		return testData.iterator();

	}

	@Test(dataProvider = "upiTestData", priority = 0)
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

	@Test(dataProvider = "dcTestData", priority = 1)
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

		Debit_Card_Flow.debit_Card_Number(VISA_DCNumber,INDEX);

		Debit_Card_Flow.valid_till(ValidTill,INDEX);

		Debit_Card_Flow.cvv(CVV_No, Payment,INDEX);

//		driver.quit();

	}

	@Test(dataProvider = "nbTestData", priority = 2)

	public static void nbExecution(String INDEX, String NB_Sub_FlowType, String Bank_name, String Bank_suggestion,
			String Payment) throws Exception {

		System.out.println("INDEX -> " + INDEX);

		System.out.println("NB_Sub_FlowType -> " + NB_Sub_FlowType);

		System.out.println("Bank_name -> " + Bank_name);

		System.out.println("Bank_suggestion -> " + Bank_suggestion);

		System.out.println("Payment -> " + Payment);

		System.out.println("Netbanking @Test");

		launchBrowser("chrome");

		loadUrl("https://sitsfl.stfc.in/pg-initiate");

		initElements();

		Pre_Payment_Flow.execution(INDEX);

//		String Flow_Type = FlowType;

		String NB_Sub_Flow_Type = NB_Sub_FlowType;

		if (NB_Sub_Flow_Type.equalsIgnoreCase("CTA_Click")) {

			Netbanking_Flow.radio_Btn_Execution(INDEX);

			Netbanking_Flow.cta_Click_Flow(Bank_name, Payment, INDEX);

		} else if (NB_Sub_Flow_Type.equalsIgnoreCase("Dropdown_Click")) {

			Netbanking_Flow.radio_Btn_Execution(INDEX);

			Netbanking_Flow.searchByBankName(Bank_name, Payment, INDEX);
		}

//		driver.quit();

	}

}
