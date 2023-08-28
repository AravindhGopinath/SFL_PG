package locators;

import baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class DC_Locators extends BaseClass {

	private static DC_Locators xpathsPageInstance;

	private DC_Locators() {

	}

	public static DC_Locators getInstance() {
		if (xpathsPageInstance == null) {
			xpathsPageInstance = new DC_Locators();
		}
		return xpathsPageInstance;
	}

	@CacheLookup

	@FindBy(xpath = "(//label[@for='debitCard'])[1]")
	private WebElement dc_radio_btn;

	@FindBy(xpath = "//label[text()='Debit card number ']")
	private WebElement dc_number_click;

	public WebElement getDc_number_click() {
		return dc_number_click;
	}

	@FindBy(xpath = "//input[@class='form__control card__inputIcon ng-untouched ng-pristine ng-invalid']")
	private WebElement dc_number;

	@FindBy(xpath = "//label[text()='Valid till (MM/YY)']")
	private WebElement dc_Expiry;

	@FindBy(xpath = "(//input[@class='form__control ng-untouched ng-pristine ng-invalid'])[1]")
	private WebElement dc_Expiry_input;

	@FindBy(xpath = "//input[@class='form__control ng-pristine ng-invalid ng-touched']")
	private WebElement dc_CVV_input;

	
	@FindBy(xpath = "//div[@class='form__group focused']")
	private WebElement dc_CVV_alternate_input;

	public WebElement getDc_CVV_alternate_input() {
		return dc_CVV_alternate_input;
	}

	public WebElement getDc_Expiry_input() {
		return dc_Expiry_input;
	}

	public WebElement getDc_CVV_input() {
		return dc_CVV_input;
	}

	@FindBy(xpath = "//label[text()='CVV ']")
	private WebElement dc_CVV;

	@FindBy(xpath = "(//button[@class='button button--orange button--large'])[1]")
	private WebElement dc_Pay_btn;

	@FindBy(xpath = "//div[@class='info']")
	private WebElement dc_info_content;

	@FindBy(xpath = "//div[@class='formIcon__right']")
	private WebElement dc_i_Icon_CVV;

	@FindBy(xpath = "//div[@class='img-card']")
	private WebElement Common_Card_logo;

	public WebElement getCommon_Card_logo() {
		return Common_Card_logo;
	}

	public WebElement getDc_radio_btn() {
		return dc_radio_btn;
	}

	public WebElement getDc_number() {
		return dc_number;
	}

	public WebElement getDc_Expiry() {
		return dc_Expiry;
	}

	public WebElement getDc_CVV() {
		return dc_CVV;
	}

	public WebElement getDc_Pay_btn() {
		return dc_Pay_btn;
	}

	public WebElement getDc_info_content() {
		return dc_info_content;
	}

	public WebElement getDc_i_Icon_CVV() {
		return dc_i_Icon_CVV;
	}
}
