package org.runner;

import baseclass.BaseClass;
import excel.ExcelUtils2;
import locators.DC_Locators;
import locators.Other_Locators_PG_Page;
import locators.Razorpay_Locators;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class Debit_Card_Flow extends BaseClass {

	public static void radio_Btn_Execution(String INDEX) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));

		ExtentTest Radio_Button_Functionality = ext.createTest("Debit Card Radio Button Functionality");

		try {
			WebElement dcRadioBtn = DC_Locators.getInstance().getDc_radio_btn();

			WebElement until = wait.until(ExpectedConditions.visibilityOf(dcRadioBtn));

			until.click();

			Radio_Button_Functionality.pass("User clicked DC-Radio button successfully");

			int parseInt = Integer.parseInt(INDEX);

			ExcelUtils2.writeinexcel("PASS", parseInt);

			Thread.sleep(1500);

		} catch (InterruptedException e) {
			System.out.println(e);

			String Issue_Reason = "User can't able to click DC-Radio button";

			Radio_Button_Functionality.fail(Issue_Reason);

			int parseInt = Integer.parseInt(INDEX);

			ExcelUtils2.writeinexcel("FAIL", parseInt);

			ExcelUtils2.writeinexcelForReasons(Issue_Reason, parseInt);
		}
	}

	public static void debit_Card_Number(String VISA_DCNumber, String INDEX) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));

		WebElement until2 = wait.until(ExpectedConditions.visibilityOf(DC_Locators.getInstance().getDc_number_click()));

		WebElement until1 = wait.until(ExpectedConditions.visibilityOf(DC_Locators.getInstance().getDc_number()));

		ExtentTest DC_Textbox_Click = ext.createTest("Debit Card textbox click Funtionality");

		try {
			doubleClick(until2);

			DC_Textbox_Click.pass("User clicked Debit Card textbox field successfully");

			int parseInt = Integer.parseInt(INDEX);

			ExcelUtils2.writeinexcel("PASS", parseInt);

		} catch (Exception e) {
			System.out.println(e);

			String Issue_Reason = "User can't able to click Debit Card textbox field";

			DC_Textbox_Click.fail(Issue_Reason);

			int parseInt = Integer.parseInt(INDEX);
			ExcelUtils2.writeinexcel("FAIL", parseInt);
			ExcelUtils2.writeinexcelForReasons(Issue_Reason, parseInt);
		}

		String VISA_DC_Number = VISA_DCNumber;

//		String VISA_DC_Number = "4160211517426012";

		String Master_Card_DC_Number = "5242720013468293";

		String Rupay_DC_Number = "6522600009615314";

		if (VISA_DC_Number.startsWith("4")) {

			ExtentTest Debit_Card_textbox_field_click_data_enter = ext
					.createTest("Debit Card textbox field data enter Funtionality");

			try {
				until1.sendKeys(VISA_DC_Number);

				Debit_Card_textbox_field_click_data_enter
						.pass("User entered data in Debit Card textbox field successfully");

				int parseInt = Integer.parseInt(INDEX);

				ExcelUtils2.writeinexcel("PASS", parseInt);

			} catch (Exception e) {

				System.out.println(e);

				String Issue_Reason = "User can't able to enter data in Debit Card textbox field";

				Debit_Card_textbox_field_click_data_enter.fail(Issue_Reason);

				int parseInt = Integer.parseInt(INDEX);
				ExcelUtils2.writeinexcel("FAIL", parseInt);
				ExcelUtils2.writeinexcelForReasons(Issue_Reason, parseInt);
			}

			WebElement until = wait
					.until(ExpectedConditions.visibilityOf(DC_Locators.getInstance().getCommon_Card_logo()));

			ExtentTest VISA_Logo = ext.createTest("VISA Card logo display Funtionality");

			try {
				if (until.isDisplayed()) {

					System.out.println("Visa card logo is dispalyed");

					VISA_Logo.pass("VISA Card logo displayed successfully");

					int parseInt = Integer.parseInt(INDEX);

					ExcelUtils2.writeinexcel("PASS", parseInt);
				}
			} catch (Exception e) {
				System.out.println(e);

				String Issue_Reason = "VISA Card logo isn't displayed";

				VISA_Logo.fail(Issue_Reason);

				int parseInt = Integer.parseInt(INDEX);
				ExcelUtils2.writeinexcel("FAIL", parseInt);
				ExcelUtils2.writeinexcelForReasons(Issue_Reason, parseInt);
			}

		} else if (Master_Card_DC_Number.startsWith("5")) {

			ExtentTest Debit_Card_textbox_field_click_data_enter = ext
					.createTest("Debit Card textbox field data enter Funtionality");

			try {
				until1.sendKeys(Master_Card_DC_Number);

				Debit_Card_textbox_field_click_data_enter
						.pass("User entered data in Debit Card textbox field successfully");

				int parseInt = Integer.parseInt(INDEX);

				ExcelUtils2.writeinexcel("PASS", parseInt);

			} catch (Exception e) {

				System.out.println(e);

				String Issue_Reason = "User can't able to enter data in Debit Card textbox field";

				Debit_Card_textbox_field_click_data_enter.fail(Issue_Reason);

				int parseInt = Integer.parseInt(INDEX);
				ExcelUtils2.writeinexcel("FAIL", parseInt);
				ExcelUtils2.writeinexcelForReasons(Issue_Reason, parseInt);
			}

			WebElement until = wait
					.until(ExpectedConditions.visibilityOf(DC_Locators.getInstance().getCommon_Card_logo()));

			ExtentTest Master_Logo = ext.createTest("Master Card logo display Funtionality");

			try {
				if (until.isDisplayed()) {

					System.out.println("Master card logo is dispalyed");

					Master_Logo.pass("Master Card logo displayed successfully");

					int parseInt = Integer.parseInt(INDEX);

					ExcelUtils2.writeinexcel("PASS", parseInt);
				}
			} catch (Exception e) {

				System.out.println(e);

				String Issue_Reason = "Master Card logo isn't displayed";

				Master_Logo.fail(Issue_Reason);

				int parseInt = Integer.parseInt(INDEX);
				ExcelUtils2.writeinexcel("FAIL", parseInt);
				ExcelUtils2.writeinexcelForReasons(Issue_Reason, parseInt);
			}

		} else if (Rupay_DC_Number.startsWith("6")) {

			ExtentTest Debit_Card_textbox_field_click_data_enter = ext
					.createTest("Debit Card textbox field data enter Funtionality");

			try {
				until1.sendKeys(Rupay_DC_Number);

				Debit_Card_textbox_field_click_data_enter
						.pass("User entered data in Debit Card textbox field successfully");

				int parseInt = Integer.parseInt(INDEX);

				ExcelUtils2.writeinexcel("PASS", parseInt);

			} catch (Exception e) {
				System.out.println(e);

				String Issue_Reason = "User can't able to enter data in Debit Card textbox field";

				Debit_Card_textbox_field_click_data_enter.fail(Issue_Reason);

				int parseInt = Integer.parseInt(INDEX);
				ExcelUtils2.writeinexcel("FAIL", parseInt);
				ExcelUtils2.writeinexcelForReasons(Issue_Reason, parseInt);
			}

			WebElement until = wait
					.until(ExpectedConditions.visibilityOf(DC_Locators.getInstance().getCommon_Card_logo()));

			ExtentTest Rupay_Logo = ext.createTest("Master Card logo display Funtionality");

			try {
				if (until.isDisplayed()) {

					System.out.println("Rupay card logo is dispalyed");

					Rupay_Logo.pass("Rupay Card logo displayed successfully");

					int parseInt = Integer.parseInt(INDEX);

					ExcelUtils2.writeinexcel("PASS", parseInt);

				}
			} catch (Exception e) {
				System.out.println(e);

				String Issue_Reason = "Rupay Card logo isn't displayed";

				Rupay_Logo.fail(Issue_Reason);

				int parseInt = Integer.parseInt(INDEX);
				ExcelUtils2.writeinexcel("FAIL", parseInt);
				ExcelUtils2.writeinexcelForReasons(Issue_Reason, parseInt);
			}
		}

	}

	public static void valid_till(String INDEX, String ValidTill) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));

		ExtentTest Radio_Button_Functionality = ext.createTest("Valid Till textbox click Functionality");

		try {
			WebElement Dc_Expiry = wait
					.until(ExpectedConditions.visibilityOf(DC_Locators.getInstance().getDc_Expiry()));

			doubleClick(Dc_Expiry);

			Radio_Button_Functionality.pass("User clicked Valid till textbox successfully");

			int parseInt = Integer.parseInt(INDEX);

			ExcelUtils2.writeinexcel("PASS", parseInt);

		} catch (Exception e) {

			System.out.println(e);

			String Issue_Reason = "User can't able to click Valid till textbox";

			Radio_Button_Functionality.fail(Issue_Reason);

			int parseInt = Integer.parseInt(INDEX);

			ExcelUtils2.writeinexcel("FAIL", parseInt);

			ExcelUtils2.writeinexcelForReasons(Issue_Reason, parseInt);
		}

		String Valid_till = ValidTill;

//		String Valid_till = "1223";

		ExtentTest Valid_till_textbox_field_data_enter = ext.createTest("Valid till field data enter Funtionality");

		try {
			WebElement Expiry_input = wait
					.until(ExpectedConditions.visibilityOf(DC_Locators.getInstance().getDc_Expiry_input()));

			Expiry_input.sendKeys(Valid_till);

			Expiry_input.sendKeys(Keys.TAB);

			Valid_till_textbox_field_data_enter.pass("User entered data in Valid till textbox field successfully");

			int parseInt = Integer.parseInt(INDEX);

			ExcelUtils2.writeinexcel("PASS", parseInt);
		} catch (Exception e) {

			System.out.println(e);

			String Issue_Reason = "User can't able to enter data in Valid till textbox field";

			Valid_till_textbox_field_data_enter.fail(Issue_Reason);

			int parseInt = Integer.parseInt(INDEX);
			ExcelUtils2.writeinexcel("FAIL", parseInt);
			ExcelUtils2.writeinexcelForReasons(Issue_Reason, parseInt);

		}

	}

	public static void cvv(String CVV_No, String Payment, String INDEX) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));

//		String CVV = "518";

		String CVV = CVV_No;

		Thread.sleep(1500);

		ExtentTest CVV_textbox_field_data_enter = ext.createTest("CVV field data enter Funtionality");

		try {
			WebElement CVV_input = wait
					.until(ExpectedConditions.visibilityOf(DC_Locators.getInstance().getDc_CVV_input()));

			scrollDown(CVV_input);

			CVV_input.sendKeys(CVV);

			CVV_textbox_field_data_enter.pass("User entered data in CVV textbox field successfully");

			int parseInt = Integer.parseInt(INDEX);

			ExcelUtils2.writeinexcel("PASS", parseInt);

		} catch (Exception e) {
			System.out.println(e);

			String Issue_Reason = "User can't able to enter data in CVV textbox field";

			CVV_textbox_field_data_enter.fail(Issue_Reason);

			int parseInt = Integer.parseInt(INDEX);
			ExcelUtils2.writeinexcel("FAIL", parseInt);
			ExcelUtils2.writeinexcelForReasons(Issue_Reason, parseInt);

		}

		try {
			WebElement CVV_alternate_input = wait
					.until(ExpectedConditions.visibilityOf(DC_Locators.getInstance().getDc_CVV_alternate_input()));

			scrollDown(CVV_alternate_input);

			CVV_alternate_input.sendKeys(CVV);

			CVV_textbox_field_data_enter.pass("User entered data in CVV textbox field successfully");

			int parseInt = Integer.parseInt(INDEX);

			ExcelUtils2.writeinexcel("PASS", parseInt);

		} catch (Exception e) {

			System.out.println(e);

			String Issue_Reason = "User can't able to enter data in CVV textbox field";

			CVV_textbox_field_data_enter.fail(Issue_Reason);

			int parseInt = Integer.parseInt(INDEX);
			ExcelUtils2.writeinexcel("FAIL", parseInt);
			ExcelUtils2.writeinexcelForReasons(Issue_Reason, parseInt);
		}

		WebElement Dc_Pay_btn = wait.until(ExpectedConditions.visibilityOf(DC_Locators.getInstance().getDc_Pay_btn()));

		String parent = driver.getWindowHandle();

		ExtentTest DC_pay_btn_click = ext.createTest("DC - Pay button click Functionality");

		try {
			Dc_Pay_btn.click();

			DC_pay_btn_click.pass("User clicked Debit Card Pay button successfully");

			int parseInt = Integer.parseInt(INDEX);

			ExcelUtils2.writeinexcel("PASS", parseInt);

		} catch (Exception e) {
			System.out.println(e);

			String Issue_Reason = "User can't able to click Net Banking Pay button";

			DC_pay_btn_click.fail(Issue_Reason);

			int parseInt = Integer.parseInt(INDEX);
			ExcelUtils2.writeinexcel("FAIL", parseInt);
			ExcelUtils2.writeinexcelForReasons(Issue_Reason, parseInt);
		}

		Thread.sleep(1500);

		Set<String> s = driver.getWindowHandles();

		Iterator<String> I1 = s.iterator();

		while (I1.hasNext()) {

			Thread.sleep(1500);

			String child_window = I1.next();

			if (!parent.equals(child_window)) {

				WebDriver window = driver.switchTo().window(child_window);

				System.out.println("Child Title -> " + window.getTitle());

//				String Do_payment = "Success";

				String Do_payment = Payment;

				try {
					WebElement Razorpay_Welcome_text = wait.until(ExpectedConditions
							.visibilityOf(Razorpay_Locators.getInstance().getRazorpay_Welcome_text()));

//					System.out.println("In razorpay text try");

					if (Razorpay_Welcome_text.isDisplayed()) {

						System.out.println("User landed to Razorpay Payments");

						System.out.println("Do payment print -> " + Do_payment);

						if (Do_payment.equalsIgnoreCase("Success")) {
							System.out.println("In success if condition");
//							try {
							System.out.println("In 1st success try condition");

							WebElement Success_btn = wait.until(
									ExpectedConditions.visibilityOf(Razorpay_Locators.getInstance().getSuccess_btn()));

							if (displayed(Success_btn)) {

								ExtentTest Success_Button_Click = ext
										.createTest("Payment Success Button Click Funtionality");

								try {
									Success_btn.click();

									Success_Button_Click.pass("User clicked Success button successfully");

									int parseInt = Integer.parseInt(INDEX);

									ExcelUtils2.writeinexcel("PASS", parseInt);

								} catch (Exception e) {
									System.out.println(e);

									String Issue_Reason = "User can't able to click payment success button";

									Success_Button_Click.fail(Issue_Reason);

									int parseInt = Integer.parseInt(INDEX);
									ExcelUtils2.writeinexcel("FAIL", parseInt);
									ExcelUtils2.writeinexcelForReasons(Issue_Reason, parseInt);

								}
							}

//							} catch (Exception e) {
//								System.out.println(e);
							System.out.println("In 1st success catch condition");
//							}
						}

						else if (Do_payment.equalsIgnoreCase("Success")) {
							System.out.println("In success else if condition");
//							try {

							System.out.println("In 2nd success else if try condition");

							WebElement Success_btn2 = wait.until(ExpectedConditions
									.visibilityOf(Razorpay_Locators.getInstance().getDC_submit_btn()));

							WebElement DC_OTP_Input = wait.until(
									ExpectedConditions.visibilityOf(Razorpay_Locators.getInstance().getDC_OTP_Input()));

							if (Success_btn2.isDisplayed()) {

								ExtentTest Success_Button_Click = ext
										.createTest("Payment Success Button Click Funtionality");

								try {
									DC_OTP_Input.click();

									DC_OTP_Input.sendKeys("1111");

									Success_Button_Click.pass("User clicked Success button successfully");

									int parseInt = Integer.parseInt(INDEX);

									ExcelUtils2.writeinexcel("PASS", parseInt);

								} catch (Exception e) {
									System.out.println(e);

									String Issue_Reason = "User can't able to click payment success button";

									Success_Button_Click.fail(Issue_Reason);

									int parseInt = Integer.parseInt(INDEX);
									ExcelUtils2.writeinexcel("FAIL", parseInt);
									ExcelUtils2.writeinexcelForReasons(Issue_Reason, parseInt);
								}

							}
//							}

//							catch (Exception e) {
//								System.out.println(e);
							System.out.println("In 2nd success else if catch condition");
//							}

						}

						else if (Do_payment.equalsIgnoreCase("Failure")) {
//							try {

							ExtentTest Failure_Button_Click = ext.createTest("Payment Failure Click Funtionality");

							try {
								WebElement Failure_btn = wait.until(ExpectedConditions
										.visibilityOf(Razorpay_Locators.getInstance().getFailure_btn()));

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
//							} catch (Exception e) {
//								System.out.println(e);
//							}

						}

						else if (Do_payment.equalsIgnoreCase("Failure")) {

//							try {

							ExtentTest Failure_Button_Click = ext.createTest("Payment Failure Click Funtionality");

							try {
								WebElement DC_cancel_btn = wait.until(ExpectedConditions
										.visibilityOf(Razorpay_Locators.getInstance().getDC_cancel_btn()));

								DC_cancel_btn.click();

								WebElement DC_secondary_cancel_btn = wait.until(ExpectedConditions
										.visibilityOf(Razorpay_Locators.getInstance().getDC_secondary_cancel_btn()));

								DC_secondary_cancel_btn.click();

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

//							} catch (Exception e) {
//								System.out.println(e);

//							}
						}

					} else {
						System.out.println("Razorpay payment isn't working");
					}

				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println(e);
				}

				try {

					WebElement Page_text = wait
							.until(ExpectedConditions.visibilityOf(Razorpay_Locators.getInstance().getDC_text()));

					System.out.println("In page text try");

					if (displayed(Page_text)) {

						System.out.println("In page text if condition");

						System.out.println("User landed to Razorpay Payments");

						System.out.println("Do payment print -> " + Do_payment);

						if (Do_payment.equalsIgnoreCase("Success")) {
							System.out.println("In success if condition");

							ExtentTest Success_Button_Click = ext
									.createTest("Payment Success Button Click Funtionality");

							try {
								System.out.println("In 1st success try condition");

								WebElement Success_btn = wait.until(ExpectedConditions
										.visibilityOf(Razorpay_Locators.getInstance().getSuccess_btn()));

								if (displayed(Success_btn)) {

									Success_btn.click();

									Success_Button_Click.pass("User clicked Success button successfully");

									int parseInt = Integer.parseInt(INDEX);

									ExcelUtils2.writeinexcel("PASS", parseInt);
								}

							} catch (Exception e) {
								System.out.println(e);
								System.out.println("In 1st success catch condition");
								System.out.println(e);

								String Issue_Reason = "User can't able to click payment success button";

								Success_Button_Click.fail(Issue_Reason);

								int parseInt = Integer.parseInt(INDEX);
								ExcelUtils2.writeinexcel("FAIL", parseInt);
								ExcelUtils2.writeinexcelForReasons(Issue_Reason, parseInt);
							}
						}

						if (Do_payment.equalsIgnoreCase("Success")) {
							System.out.println("In success else if condition");

							ExtentTest Success_Button_Click = ext
									.createTest("Payment Success Button Click Funtionality");
							try {

								System.out.println("In 2nd success else if try condition");

								WebElement Success_btn2 = wait.until(ExpectedConditions
										.visibilityOf(Razorpay_Locators.getInstance().getDC_submit_btn()));

								WebElement DC_OTP_Input = wait.until(ExpectedConditions
										.visibilityOf(Razorpay_Locators.getInstance().getDC_OTP_Input()));

								if (Success_btn2.isDisplayed()) {

									DC_OTP_Input.click();

									DC_OTP_Input.sendKeys("1111");

									Success_btn2.click();

									Success_Button_Click.pass("User clicked Success button successfully");

									int parseInt = Integer.parseInt(INDEX);

									ExcelUtils2.writeinexcel("PASS", parseInt);
								}
							}

							catch (Exception e) {
								System.out.println(e);
								System.out.println("In 2nd success else if catch condition");

								String Issue_Reason = "User can't able to click payment success button";

								Success_Button_Click.fail(Issue_Reason);

								int parseInt = Integer.parseInt(INDEX);
								ExcelUtils2.writeinexcel("FAIL", parseInt);
								ExcelUtils2.writeinexcelForReasons(Issue_Reason, parseInt);
							}

						}

						if (Do_payment.equalsIgnoreCase("Failure")) {
							try {
								WebElement Failure_btn = wait.until(ExpectedConditions
										.visibilityOf(Razorpay_Locators.getInstance().getFailure_btn()));

								Failure_btn.click();
							} catch (Exception e) {
								System.out.println(e);
							}

						}

						if (Do_payment.equalsIgnoreCase("Failure")) {

							ExtentTest Failure_Button_Click = ext.createTest("Payment Failure Click Funtionality");

							try {
								WebElement DC_cancel_btn = wait.until(ExpectedConditions
										.visibilityOf(Razorpay_Locators.getInstance().getDC_cancel_btn()));

								DC_cancel_btn.click();

								WebElement DC_secondary_cancel_btn = wait.until(ExpectedConditions
										.visibilityOf(Razorpay_Locators.getInstance().getDC_secondary_cancel_btn()));

								DC_secondary_cancel_btn.click();

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
						}

					} else {
						System.out.println("Razorpay payment isn't working");
					}

				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
				}

			}

			else {

				System.out.println("Windows handle issue");
			}

			continue;
		}

		driver.switchTo().window(parent);
	}

}
