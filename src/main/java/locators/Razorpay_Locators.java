package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class Razorpay_Locators {

	private static Razorpay_Locators xpathsPageInstance;

	private Razorpay_Locators() {

	}

	public static Razorpay_Locators getInstance() {
		if (xpathsPageInstance == null) {
			xpathsPageInstance = new Razorpay_Locators();
		}
		return xpathsPageInstance;
	}

	@CacheLookup

	@FindBy(xpath = "//h3[text()='Welcome to Razorpay Software Private Ltd Bank']")
	private WebElement Razorpay_Welcome_text;

	@FindBy(xpath = "//button[@class='success']")
	private WebElement success_btn;

	@FindBy(xpath = "//button[@class='danger']")
	private WebElement failure_btn;

	@FindBy(id = "cancel-btn")
	private WebElement UPI_cancel_btn;

	@FindBy(id = "cancel-action")
	private WebElement DC_cancel_btn;

	@FindBy(id = "confirm-secondary")
	private WebElement DC_secondary_cancel_btn;

	public WebElement getDC_secondary_cancel_btn() {
		return DC_secondary_cancel_btn;
	}

	@FindBy(xpath = "//input[@placeholder='OTP']")
	private WebElement DC_OTP_Input;

	@FindBy(id = "submit-action")
	private WebElement DC_submit_btn;

	@FindBy(xpath = "//h4[text()='Enter OTP']")
	private WebElement DC_text;

	public WebElement getDC_text() {
		return DC_text;
	}

	public WebElement getDC_cancel_btn() {
		return DC_cancel_btn;
	}

	public WebElement getDC_OTP_Input() {
		return DC_OTP_Input;
	}

	public WebElement getDC_submit_btn() {
		return DC_submit_btn;
	}

	public WebElement getUPI_cancel_btn() {
		return UPI_cancel_btn;
	}

	public WebElement getRazorpay_Welcome_text() {
		return Razorpay_Welcome_text;
	}

	public WebElement getSuccess_btn() {
		return success_btn;
	}

	public WebElement getFailure_btn() {
		return failure_btn;
	}

}
