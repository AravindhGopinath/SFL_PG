package org.runner;

import baseclass.BaseClass;
import excel.ExcelUtils2;
import locators.Other_Locators_PG_Page;
import locators.PaymentFormLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import java.time.Duration;

public class Pre_Payment_Flow extends BaseClass {

	public static void execution(String INDEX) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));

		ExtentTest Pay_Button = ext.createTest("Pay Button Funtionality");

		try {
			WebElement Pay_button = wait
					.until(ExpectedConditions.visibilityOf(PaymentFormLocators.getInstance().getPay_button()));

			Pay_button.click();

			Pay_Button.pass("User clicked pay button successfully");

			int parseInt = Integer.parseInt(INDEX);

			ExcelUtils2.writeinexcel("PASS", parseInt);

		} catch (Exception e) {
			System.out.println(e);

			String Issue_Reason = "User can't able to click pay button";

			Pay_Button.fail(Issue_Reason);

			int parseInt = Integer.parseInt(INDEX);
			ExcelUtils2.writeinexcel("FAIL", parseInt);
			ExcelUtils2.writeinexcelForReasons(Issue_Reason, parseInt);
		}

		ExtentTest Send_Anyway_btn = ext.createTest("Send Anyway Button Funtionality");

		try {
			WebElement Send_anyway_btn = wait
					.until(ExpectedConditions.visibilityOf(Other_Locators_PG_Page.getInstance().getSend_anyway_btn()));

			Send_anyway_btn.click();

			Send_Anyway_btn.pass("User clicked send anyway button successfully");

			int parseInt = Integer.parseInt(INDEX);

			ExcelUtils2.writeinexcel("PASS", parseInt);

		} catch (Exception e) {
			System.out.println(e);

			String Issue_Reason = "User can't able to click send anyway  button";

			Pay_Button.fail(Issue_Reason);

			int parseInt = Integer.parseInt(INDEX);
			ExcelUtils2.writeinexcel("FAIL", parseInt);
			ExcelUtils2.writeinexcelForReasons(Issue_Reason, parseInt);

		}

	}

}
