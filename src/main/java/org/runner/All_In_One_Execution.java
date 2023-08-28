package org.runner;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import baseclass.BaseClass;
import excel.ExcelUtils2;
import com.aventstack.extentreports.ExtentTest;

public class All_In_One_Execution extends BaseClass {

	@DataProvider
	public Iterator<Object[]> getTestData() {

		ArrayList<Object[]> testData = ExcelUtils2.getDataFromexcel();
		return testData.iterator();

	}

	@BeforeTest
	public static void extentReport() {

		extReportConfig();
	}

	@Test(dataProvider = "getTestData")
	private void allExecution(String INDEX, String Flow_Type, String NB_Sub_FlowType, String Bank_name,
			String VISA_DCNumber, String ValidTill, String CVV_No, String UPI_id, String UPI_Bank_name, String Payment)
			throws Exception {

		ExtentTest Browser_Launch = ext.createTest("Browser Launch Funtionality");

		try {

			launchBrowser("FIREFOX");

			Browser_Launch.pass("Browser launched successfully");

			int parseInt = Integer.parseInt(INDEX);
			ExcelUtils2.writeinexcel("PASS", parseInt);

		} catch (Exception e) {

			System.out.println(e);

			String Issue_Reason = "Selenium Can't Launch Browser";

			Browser_Launch.fail(Issue_Reason);

			int parseInt = Integer.parseInt(INDEX);
			ExcelUtils2.writeinexcel("FAIL", parseInt);
			ExcelUtils2.writeinexcelForReasons(Issue_Reason, parseInt);

		}

		initElements();

		ExtentTest URL_Launch = ext.createTest("URL Launch Funtionality");

		try {
			loadUrl("https://sitsfl.stfc.in/pg-initiate");

			URL_Launch.pass("User landed URL successfully");

			int parseInt = Integer.parseInt(INDEX);
			ExcelUtils2.writeinexcel("PASS", parseInt);

		} catch (Exception e) {

			System.out.println(e);

			String Issue_Reason = "User can't load the URL";

			URL_Launch.fail(Issue_Reason);

			int parseInt = Integer.parseInt(INDEX);
			ExcelUtils2.writeinexcel("FAIL", parseInt);
			ExcelUtils2.writeinexcelForReasons(Issue_Reason, parseInt);
		}

		String Flowtype = Flow_Type;

		switch (Flowtype) {

		case "Net Banking":

			String NB_Sub_Flow_Type = NB_Sub_FlowType;

			switch (NB_Sub_Flow_Type) {

			case "CTA_Click":

				Pre_Payment_Flow.execution(INDEX);

				Netbanking_Flow.radio_Btn_Execution(INDEX);

				Netbanking_Flow.cta_Click_Flow(Bank_name, Payment, INDEX);

				break;

			case "Dropdown_Click":

				Pre_Payment_Flow.execution(INDEX);

				Netbanking_Flow.radio_Btn_Execution(INDEX);

				Netbanking_Flow.searchByBankName(Bank_name, Payment, INDEX);

				break;
			}

		case "UPI":

			Pre_Payment_Flow.execution(INDEX);

			UPI_Flow.execution(UPI_id, UPI_Bank_name, Payment, INDEX);

			break;

		case "Debit Card":

			Pre_Payment_Flow.execution(INDEX);

			Debit_Card_Flow.radio_Btn_Execution(INDEX);

			Debit_Card_Flow.debit_Card_Number(VISA_DCNumber, INDEX);

			Debit_Card_Flow.valid_till(ValidTill, INDEX);

			Debit_Card_Flow.cvv(CVV_No, Payment, INDEX);

			break;
		}

	}

	@AfterTest
	private void browserQuit() {

		ext.flush();

		driver.quit();

	}

}
