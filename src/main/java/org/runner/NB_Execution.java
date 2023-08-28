package org.runner;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import baseclass.BaseClass;
import excel.ExcelUtils;

public class NB_Execution extends BaseClass {

	@DataProvider
	public Iterator<Object[]> nbTestData() {

		ArrayList<Object[]> testData = ExcelUtils.nbDataFromexcel();
		return testData.iterator();

	}

	@Test(dataProvider = "nbTestData", priority = 1)

	public static void nbExecution(String INDEX, String NB_Sub_FlowType, String Bank_name, String Bank_suggestion,
			String Payment, String Parent) throws Exception {

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

			Netbanking_Flow.searchByBankName(Bank_name, Parent, INDEX);
		}

//		driver.quit();

	}

}
