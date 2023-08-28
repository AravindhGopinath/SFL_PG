package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class NB_Locators {

	private static NB_Locators xpathsPageInstance;

	private NB_Locators() {

	}

	public static NB_Locators getInstance() {
		if (xpathsPageInstance == null) {
			xpathsPageInstance = new NB_Locators();
		}
		return xpathsPageInstance;
	}

	@CacheLookup

	@FindBy(xpath = "//li[@class='radio last']")
	private WebElement nb_radio_btn;

	@FindBy(xpath = "(//input[@class='gridCard__boxInput'])[1]")
	private WebElement canara_CTA;

	@FindBy(xpath = "(//input[@class='gridCard__boxInput'])[2]")
	private WebElement IOB_CTA;

	@FindBy(xpath = "(//input[@class='gridCard__boxInput'])[3]")
	private WebElement SBI_CTA;

	@FindBy(xpath = "//div[@class='gridCard__box']")
	private WebElement dynamic_Popular_CTA_CLick;

	public WebElement getDynamic_Popular_CTA_CLick() {
		return dynamic_Popular_CTA_CLick;
	}

	@FindBy(id = "netbanking")
	private WebElement search_By_Bank;

	@FindBy(xpath = "//ul[@class='bankList']")
	private WebElement dropdown_list;

	@FindBy(xpath = "//p[@class='bankList__name']")
	private WebElement alternate_dropdown_list;

	@FindBy(xpath = "//input[@class='button button--orange button--large']")
	private WebElement pay_btn;

	public WebElement getNb_radio_btn() {
		return nb_radio_btn;
	}

	public WebElement getCanara_CTA() {
		return canara_CTA;
	}

	public WebElement getIOB_CTA() {
		return IOB_CTA;
	}

	public WebElement getSBI_CTA() {
		return SBI_CTA;
	}

	public WebElement getSearch_By_Bank() {
		return search_By_Bank;
	}

	public WebElement getDropdown_list() {
		return dropdown_list;
	}

	public WebElement getAlternate_dropdown_list() {
		return alternate_dropdown_list;
	}

	public WebElement getPay_btn() {
		return pay_btn;
	}
}
