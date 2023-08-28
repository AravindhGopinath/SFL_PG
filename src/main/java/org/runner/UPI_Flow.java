package org.runner;

import baseclass.BaseClass;
import excel.ExcelUtils;
import excel.ExcelUtils2;
import locators.Other_Locators_PG_Page;
import locators.Razorpay_Locators;
import locators.UPI_Locators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class UPI_Flow extends BaseClass {

	public static void execution(String UPI_id, String UPI_Bank_name, String Payment, String INDEX) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));

		WebElement enterUpiIdUpiNumberTextbox = UPI_Locators.getInstance().getEnter_UPI_ID_UPI_Number_textbox();

		WebElement until = wait.until(ExpectedConditions.visibilityOf(enterUpiIdUpiNumberTextbox));

		ExtentTest UPI_Textbox_Field = ext.createTest("Upi Number textbox field click Funtionality");

		try {
			until.click();

			UPI_Textbox_Field.pass("User clicked UPI number textbox field successfully");

			int parseInt = Integer.parseInt(INDEX);

			ExcelUtils2.writeinexcel("PASS", parseInt);

		} catch (Exception e) {
			System.out.println(e);

			String Issue_Reason = "User can't able to click UPI number textbox field";

			UPI_Textbox_Field.fail(Issue_Reason);

			int parseInt = Integer.parseInt(INDEX);
			ExcelUtils2.writeinexcel("FAIL", parseInt);
			ExcelUtils2.writeinexcelForReasons(Issue_Reason, parseInt);
		}

//		String UPI_Id = "test@";

		String UPI_Id = UPI_id;

		ExtentTest UPI_Textbox_data_Enter = ext.createTest("UPI number textbox field data enter Funtionality");

		try {
			until.sendKeys(UPI_Id);

			UPI_Textbox_data_Enter.pass("User entered data in UPI number textbox field successfully");

			int parseInt = Integer.parseInt(INDEX);

			ExcelUtils2.writeinexcel("PASS", parseInt);

		} catch (Exception e) {
			System.out.println(e);

			String Issue_Reason = "User can't able to enter data in UPI number textbox field";

			UPI_Textbox_data_Enter.fail(Issue_Reason);

			int parseInt = Integer.parseInt(INDEX);
			ExcelUtils2.writeinexcel("FAIL", parseInt);
			ExcelUtils2.writeinexcelForReasons(Issue_Reason, parseInt);
		}

//		String upi_suffix = "icici";

		String upi_suffix = UPI_Bank_name;

		if (upi_suffix.equalsIgnoreCase("icici")) {

			if (displayed(UPI_Locators.getInstance().getIcici_upi_id())) {

				ExtentTest ICICI_Click = ext.createTest("ICICI Instrument button click Funtionality");

				try {
					UPI_Locators.getInstance().getIcici_upi_id().click();

					ICICI_Click.pass("User clicked ICICI Instrument button successfully");

					int parseInt = Integer.parseInt(INDEX);

					ExcelUtils2.writeinexcel("PASS", parseInt);

				} catch (Exception e) {

					System.out.println(e);

					String Issue_Reason = "User can't able to click ICICI Instrument button";

					ICICI_Click.fail(Issue_Reason);

					int parseInt = Integer.parseInt(INDEX);
					ExcelUtils2.writeinexcel("FAIL", parseInt);
					ExcelUtils2.writeinexcelForReasons(Issue_Reason, parseInt);

				}

			} else {

				System.out.println("There is no ICICI network");
			}

		} else if (upi_suffix.equalsIgnoreCase("sbi")) {

			if (displayed(UPI_Locators.getInstance().getSbi_upi_id())) {

				ExtentTest SBI_Click = ext.createTest("SBI Instrument button click Funtionality");

				try {
					UPI_Locators.getInstance().getSbi_upi_id().click();

					SBI_Click.pass("User clicked SBI Instrument button successfully");

					int parseInt = Integer.parseInt(INDEX);

					ExcelUtils2.writeinexcel("PASS", parseInt);

				} catch (Exception e) {
					System.out.println(e);

					String Issue_Reason = "User can't able to click SBI Instrument button";

					SBI_Click.fail(Issue_Reason);

					int parseInt = Integer.parseInt(INDEX);
					ExcelUtils2.writeinexcel("FAIL", parseInt);
					ExcelUtils2.writeinexcelForReasons(Issue_Reason, parseInt);
				}
			} else {

				System.out.println("There is no SBI network");
			}

		} else if (upi_suffix.equalsIgnoreCase("hdfc")) {

			if (displayed(UPI_Locators.getInstance().getHdfc_upi_id())) {

				ExtentTest HDFC_Click = ext.createTest("HDFC Instrument button click Funtionality");

				try {
					UPI_Locators.getInstance().getHdfc_upi_id().click();

					HDFC_Click.pass("User clicked HDFC Instrument button successfully");

					int parseInt = Integer.parseInt(INDEX);

					ExcelUtils2.writeinexcel("PASS", parseInt);
				} catch (Exception e) {
					System.out.println(e);

					String Issue_Reason = "User can't able to click HDFC Instrument button";

					HDFC_Click.fail(Issue_Reason);

					int parseInt = Integer.parseInt(INDEX);
					ExcelUtils2.writeinexcel("FAIL", parseInt);
					ExcelUtils2.writeinexcelForReasons(Issue_Reason, parseInt);
				}
			} else {
				System.out.println("There is no HDFC network");
			}

		} else if (upi_suffix.equalsIgnoreCase("ybl")) {

			if (displayed(UPI_Locators.getInstance().getYbl_upi_id())) {

				ExtentTest Ybl_Click = ext.createTest("Ybl Instrument button click Funtionality");

				try {
					UPI_Locators.getInstance().getYbl_upi_id().click();

					Ybl_Click.pass("User clicked Ybl Instrument button successfully");

					int parseInt = Integer.parseInt(INDEX);

					ExcelUtils2.writeinexcel("PASS", parseInt);

				} catch (Exception e) {
					System.out.println(e);

					String Issue_Reason = "User can't able to click Ybl Instrument button";

					Ybl_Click.fail(Issue_Reason);

					int parseInt = Integer.parseInt(INDEX);
					ExcelUtils2.writeinexcel("FAIL", parseInt);
					ExcelUtils2.writeinexcelForReasons(Issue_Reason, parseInt);
				}
			} else {
				System.out.println("There is no YBL network");
			}
		}

		WebElement enterUpiIdUpiNumberVerifyButton = UPI_Locators.getInstance()
				.getEnter_UPI_ID_UPI_Number_Verify_button();

		if (displayed(enterUpiIdUpiNumberVerifyButton)) {

			ExtentTest Verify_btn = ext.createTest("UPI Id Verify button Funtionality");

			try {
				enterUpiIdUpiNumberVerifyButton.click();

				Verify_btn.pass("User verified UPI Id successfully");

				int parseInt = Integer.parseInt(INDEX);

				ExcelUtils2.writeinexcel("PASS", parseInt);

			} catch (Exception e) {
				System.out.println(e);

				String Issue_Reason = "User can't able to verify UPI Id";

				Verify_btn.fail(Issue_Reason);

				int parseInt = Integer.parseInt(INDEX);
				ExcelUtils2.writeinexcel("FAIL", parseInt);
				ExcelUtils2.writeinexcelForReasons(Issue_Reason, parseInt);
			}
		} else {

			System.out.println("There's no verify button to verify entered UPI Id");

		}

		WebElement enterUpiIdVerifiedContent = UPI_Locators.getInstance().getEnter_UPI_ID_Verified_content();

		WebElement until1 = wait.until(ExpectedConditions.visibilityOf(enterUpiIdVerifiedContent));

		if (until1.isDisplayed()) {

			System.out.println("Entered UPI ID is Valid and verified successfully");

			WebElement UPI_Pay_btn = wait
					.until(ExpectedConditions.visibilityOf(UPI_Locators.getInstance().getUPI_Pay_btn()));

			scrollDown(UPI_Pay_btn);

			String parent = driver.getWindowHandle();

//			System.out.println("Parent id -> " + parent);

			String parent_title = driver.getTitle();

			System.out.println("Parent window title -> " + parent_title);

			ExtentTest UPI_Pay_Btn = ext.createTest("UPI - Pay button click Functionality");
			
			try {
				UPI_Pay_btn.click();
				
				UPI_Pay_Btn.pass("User clicked UPI Pay button successfully");

				int parseInt = Integer.parseInt(INDEX);

				ExcelUtils2.writeinexcel("PASS", parseInt);
				
			} catch (Exception e) {
				System.out.println(e);

				String Issue_Reason = "User can't able to click UPI Pay button";

				UPI_Pay_Btn.fail(Issue_Reason);

				int parseInt = Integer.parseInt(INDEX);
				ExcelUtils2.writeinexcel("FAIL", parseInt);
				ExcelUtils2.writeinexcelForReasons(Issue_Reason, parseInt);
			}

			Thread.sleep(2000);

			Set<String> s = driver.getWindowHandles();

//			System.out.println("s -> " + s);

			Iterator<String> I1 = s.iterator();

			while (I1.hasNext()) {

				Thread.sleep(1500);

				String child_window = I1.next();

//				System.out.println("child_window -> " + child_window);

				if (!parent.equals(child_window)) {

					WebDriver window = driver.switchTo().window(child_window);

//					System.out.println("Within parent != if -> " + window);

					String title = window.getTitle();

					System.out.println("Child window -> " + title);

					String Do_payment = Payment;

//					WebElement Razorpay_Welcome_text = wait.until(ExpectedConditions
//							.visibilityOf(Razorpay_Locators.getInstance().getRazorpay_Welcome_text()));

					if (title.equals("Payment in progress • Razorpay")) {

						System.out.println("User landed to Razorpay Payments");

					} else {
						System.out.println("Razorpay payment isn't working");
					}

					if (Do_payment.equalsIgnoreCase("Success")) {

						System.out.println("User proceeding successful transaction");

					} else if (Do_payment.equalsIgnoreCase("Failure")) {
						
						ExtentTest Failure_Button_Click = ext
								.createTest("Payment Failure Button Click Funtionality");
						
						try {
							WebElement Failure_btn = wait.until(
									ExpectedConditions.visibilityOf(Razorpay_Locators.getInstance().getUPI_cancel_btn()));

							Failure_btn.click();
							
							Failure_Button_Click.pass("User clicked Failure button successfully");

							int parseInt = Integer.parseInt(INDEX);

							ExcelUtils2.writeinexcel("PASS", parseInt);
							
						} catch (Exception e) {
							System.out.println(e);

							String Issue_Reason = "User can't able to click payment Failure button";

							Failure_Button_Click.fail(Issue_Reason);

							int parseInt = Integer.parseInt(INDEX);
							ExcelUtils2.writeinexcel("FAIL", parseInt);
							ExcelUtils2.writeinexcelForReasons(Issue_Reason, parseInt);
						}

//						System.out.println("Button clicked");

					}

				}

				else {

					System.out.println("Windows handle Issue");

//				test.log(LogStatus.FAIL, "User can't able to report a problem");
				}

				continue;
			}

			WebDriver window = driver.switchTo().window(parent);

			String title = window.getTitle();

			System.out.println("title 2 -> " + title);

			try {
				WebElement Success_status_msg = wait.until(
						ExpectedConditions.visibilityOf(Other_Locators_PG_Page.getInstance().getSuccess_status()));

				WebElement failure_status_msg = wait.until(
						ExpectedConditions.visibilityOf(Other_Locators_PG_Page.getInstance().getFailure_status_msg()));

				if (displayed(Success_status_msg)) {

					System.out.println("Payment Successful");

				} else if (displayed(failure_status_msg)) {

					System.out.println("Payment Unsuccessful");
				}

				else {
					System.out.println("Issue in call back screen");
				}
			} catch (Exception e) {
				System.out.println(e);

			}

		} else {

			System.out.println("Entered UPI ID is In-Valid");
		}

	}

}
