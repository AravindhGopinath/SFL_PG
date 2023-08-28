package locators;

import baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class Other_Locators_PG_Page extends BaseClass {


    private static Other_Locators_PG_Page xpathsPageInstance;

    private Other_Locators_PG_Page() {

    }

    public static Other_Locators_PG_Page getInstance() {
        if (xpathsPageInstance == null) {
            xpathsPageInstance = new Other_Locators_PG_Page();
        }
        return xpathsPageInstance;
    }

    @CacheLookup

    @FindBy(xpath="//p[text()='Something went wrong. please try again later!']")
    private WebElement Something_Wrong_Content;

    @FindBy(xpath="(//button[@class='button button--orange button--large text-center'])[2]")
    private WebElement Something_Wrong_Content_Okay_btn;

    @FindBy(id="proceed-button")
    private WebElement send_anyway_btn;

    @FindBy(id="primary-button")
    private WebElement go_back_btn;
    
    @FindBy(xpath="//h4[text()='Payment Successful']")
    private WebElement success_status_msg;
    
    @FindBy(xpath="//p[text()='Payment Unsuccessful']")
    private WebElement failure_status_msg;
    
    @FindBy(xpath="//div[@class='formIcon__right']")
    private WebElement footer_text;
    
  
    
	public WebElement getSuccess_status_msg() {
		return success_status_msg;
	}

	public WebElement getFooter_text() {
		return footer_text;
	}

	public WebElement getFailure_status_msg() {
		return failure_status_msg;
	}

	public WebElement getSuccess_status() {
		return success_status_msg;
	}

	public WebElement getSomething_Wrong_Content() {
		return Something_Wrong_Content;
	}

	public WebElement getSomething_Wrong_Content_Okay_btn() {
		return Something_Wrong_Content_Okay_btn;
	}

	public WebElement getSend_anyway_btn() {
		return send_anyway_btn;
	}

	public WebElement getGo_back_btn() {
		return go_back_btn;
	}





}
