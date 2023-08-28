package org.runner;

import baseclass.BaseClass;
import excel.ExcelUtils2;
import locators.NB_Locators;
import locators.Razorpay_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Netbanking_Flow extends BaseClass {

	public static void radio_Btn_Execution(String INDEX) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));

		ExtentTest Radio_Button_Functionality = ext.createTest("NB - Radio Button Functionality");

		try {
			WebElement nbRadioBtn = NB_Locators.getInstance().getNb_radio_btn();

			WebElement until = wait.until(ExpectedConditions.elementToBeClickable(nbRadioBtn));

			scrollDown(until);

			Thread.sleep(1500);

			until.click();

			Radio_Button_Functionality.pass("User clicked NB-Radio button successfully");

			int parseInt = Integer.parseInt(INDEX);

			ExcelUtils2.writeinexcel("PASS", parseInt);

		} catch (InterruptedException e) {

			System.out.println(e);

			String Issue_Reason = "User can't able to click NB-Radio button";

			Radio_Button_Functionality.fail(Issue_Reason);

			int parseInt = Integer.parseInt(INDEX);

			ExcelUtils2.writeinexcel("FAIL", parseInt);

			ExcelUtils2.writeinexcelForReasons(Issue_Reason, parseInt);
		}

	}

	public static void cta_Click_Flow(String Bank_name, String Payment, String INDEX) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));

		String NB_CTA = Bank_name;

//		String NB_CTA = "Canara Bank";

		WebElement until = wait
				.until(ExpectedConditions.visibilityOf(NB_Locators.getInstance().getDynamic_Popular_CTA_CLick()));

		if (until.isDisplayed()) {

			System.out.println("Pouplar banks CTA's are displayed ");
		}

		else {

			System.out.println("There's no CTA's displayed");
		}

		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='gridCard__box']"));

//        System.out.println("Elements Print  ->"+elements);

		for (WebElement Text : elements) {

			Thread.sleep(1000);
			try {

				String text = Text.getText();

				System.out.println(text + " --> Print");

				if (text.matches(NB_CTA)) {

					ExtentTest nb_cta_click = ext.createTest("Net Banking pouplar banks click Functionality");

					try {
						Text.click();

						nb_cta_click.pass("User clicked Net Banking Popular banks CTA button successfully");

						int parseInt = Integer.parseInt(INDEX);

						ExcelUtils2.writeinexcel("PASS", parseInt);

					} catch (Exception e) {

						System.out.println(e);

						String Issue_Reason = "User can't able to click Net Banking - Popular banks CTA button";

						nb_cta_click.fail(Issue_Reason);

						int parseInt = Integer.parseInt(INDEX);
						ExcelUtils2.writeinexcel("FAIL", parseInt);
						ExcelUtils2.writeinexcelForReasons(Issue_Reason, parseInt);

					}

					WebElement pay_btn = wait
							.until(ExpectedConditions.visibilityOf(NB_Locators.getInstance().getPay_btn()));

					String parent = driver.getWindowHandle();

					ExtentTest nb_pay_btn_click = ext.createTest("NB - Pay button click Functionality");

					try {
						pay_btn.click();

						nb_pay_btn_click.pass("User clicked Net Banking Pay button successfully");

						int parseInt = Integer.parseInt(INDEX);

						ExcelUtils2.writeinexcel("PASS", parseInt);

					} catch (Exception e) {
						System.out.println(e);

						String Issue_Reason = "User can't able to click Net Banking Pay button";

						nb_pay_btn_click.fail(Issue_Reason);

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

//						System.out.println("Child Title -> "+window.getTitle());

//							String Do_payment = "Success";

							String Do_payment = Payment;

							if (Do_payment.equalsIgnoreCase("Success")) {

								ExtentTest Success_Button_Click = ext
										.createTest("Payment Success Button Click Funtionality");

								try {
									WebElement Success_btn = wait.until(ExpectedConditions
											.visibilityOf(Razorpay_Locators.getInstance().getSuccess_btn()));

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

							} else if (Do_payment.equalsIgnoreCase("Failure")) {

								ExtentTest Failure_Button_Click = ext
										.createTest("Payment Failure Click Funtionality");

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

							}

						}

						else {

							System.out.println("Windows handle issue");

//						test.log(LogStatus.FAIL, "User can't able to report a problem");
						}
					}

					driver.switchTo().window(parent);

				}
			} catch (StaleElementReferenceException e) {
				System.out.println(e);
			}

		}

	}

	public static void searchByBankName(String Bank_name, String Payment, String INDEX) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));

		WebElement searchByBank = wait
				.until(ExpectedConditions.visibilityOf(NB_Locators.getInstance().getSearch_By_Bank()));

//		String Bank_Name = "a";

//		String Bank_Name = Bank_suggestion;

//		String Bank_name = "Canara Bank";

		String Bankname = Bank_name;

		if (searchByBank.isDisplayed()) {

			System.out.println("Search by bank name option is available");

			ExtentTest Search_by_bank_name_field_click = ext.createTest("Search by bank name field click Funtionality");

			try {
				searchByBank.click();

				Search_by_bank_name_field_click.pass("User clicked Search by bank name field successfully");

				int parseInt = Integer.parseInt(INDEX);

				ExcelUtils2.writeinexcel("PASS", parseInt);
			}

			catch (Exception e) {

				System.out.println(e);

				String Issue_Reason = "User can't able to click Search by bank name field";

				Search_by_bank_name_field_click.fail(Issue_Reason);

				int parseInt = Integer.parseInt(INDEX);
				ExcelUtils2.writeinexcel("FAIL", parseInt);
				ExcelUtils2.writeinexcelForReasons(Issue_Reason, parseInt);

			}

			ExtentTest Search_by_bank_name_field_click_data_enter = ext
					.createTest("Search by bank name field data enter Funtionality");

			try {
				searchByBank.sendKeys(Bankname);

				Search_by_bank_name_field_click_data_enter
						.pass("User entered data in Search by bank name field successfully");

				int parseInt = Integer.parseInt(INDEX);

				ExcelUtils2.writeinexcel("PASS", parseInt);

			} catch (Exception e) {

				System.out.println(e);

				String Issue_Reason = "User can't able to enter data in Search by bank name field";

				Search_by_bank_name_field_click_data_enter.fail(Issue_Reason);

				int parseInt = Integer.parseInt(INDEX);
				ExcelUtils2.writeinexcel("FAIL", parseInt);
				ExcelUtils2.writeinexcelForReasons(Issue_Reason, parseInt);

			}

			WebElement scroll = wait.until(ExpectedConditions.visibilityOf(NB_Locators.getInstance().getPay_btn()));

			scrollDown(scroll);

			List<WebElement> dropdown = driver.findElements(By.xpath("//p[@class='bankList__name']"));

			System.out.println("Dropdown list -> " + dropdown);

			for (WebElement text : dropdown) {

//				System.out.println("In loop");

				WebElement get_text = wait.until(ExpectedConditions.visibilityOf(text));

				String text2 = get_text.getText();

//				System.out.println("Search by bank name print -> " + text2);

				if (text2.matches(Bankname)) {

//					System.out.println("In If");

					Thread.sleep(2000);

					scrollDown(get_text);

					ExtentTest Net_Banking_Dropdown_List_Click = ext
							.createTest("Net Banking Dropdown List CTA Click Funtionality");

					try {
						doubleClick(get_text);

						Net_Banking_Dropdown_List_Click
								.pass("User clicked CTA in Net Banking Dropdown List successfully");

						int parseInt = Integer.parseInt(INDEX);

						ExcelUtils2.writeinexcel("PASS", parseInt);

					} catch (Exception e) {

						System.out.println(e);

						String Issue_Reason = "User can't able to click CTA in Net Banking Dropdown List";

						Net_Banking_Dropdown_List_Click.fail(Issue_Reason);

						int parseInt = Integer.parseInt(INDEX);
						ExcelUtils2.writeinexcel("FAIL", parseInt);
						ExcelUtils2.writeinexcelForReasons(Issue_Reason, parseInt);

					}

					WebElement pay_btn = wait
							.until(ExpectedConditions.visibilityOf(NB_Locators.getInstance().getPay_btn()));

					String parent = driver.getWindowHandle();

					ExtentTest nb_pay_btn_click = ext.createTest("NB - Pay button click Functionality");

					try {
						pay_btn.click();

						nb_pay_btn_click.pass("User clicked Net Banking Pay button successfully");

						int parseInt = Integer.parseInt(INDEX);

						ExcelUtils2.writeinexcel("PASS", parseInt);

					} catch (Exception e) {

						System.out.println(e);

						String Issue_Reason = "User can't able to click Net Banking Pay button";

						nb_pay_btn_click.fail(Issue_Reason);

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

							String Do_payment = Payment;

							if (Do_payment.equalsIgnoreCase("Success")) {

								ExtentTest Success_Button_Click = ext
										.createTest("Payment Success Button Click Funtionality");

								try {
									WebElement Success_btn = wait.until(ExpectedConditions
											.visibilityOf(Razorpay_Locators.getInstance().getSuccess_btn()));

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

							} else if (Do_payment.equalsIgnoreCase("Failure")) {

								ExtentTest Failure_Button_Click = ext
										.createTest("Payment Failure button Click Funtionality");

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

							}

						}

						else {

//							System.out.println("Issue");

//							test.log(LogStatus.FAIL, "User can't able to report a problem");
						}
					}

					driver.switchTo().window(parent);

					String title = driver.getTitle();

					System.out.println("Parent title -> " + title);

				}

			}

		} else {

			System.out.println("There's no Search by bank name option is avialable ");
		}

	}

}
