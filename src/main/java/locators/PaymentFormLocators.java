package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class PaymentFormLocators   {


    private static PaymentFormLocators xpathsPageInstance;

    private PaymentFormLocators() {

    }

    public static PaymentFormLocators getInstance() {
        if (xpathsPageInstance == null) {
            xpathsPageInstance = new PaymentFormLocators();
        }
        return xpathsPageInstance;
    }

    @CacheLookup

    @FindBy(id="company_code")
    private WebElement company_code;

    @FindBy(id="product_code")
    private WebElement product_code;

    @FindBy(id="customer_name")
    private WebElement customer_name;

    @FindBy(id="customer_mobile")
    private WebElement customer_mobile;

    @FindBy(id="customer_email")
    private WebElement customer_email;

    @FindBy(id="amount")
    private WebElement amount;

    @FindBy(id="curreny")
    private WebElement curreny;

    @FindBy(id="txn_id")
    private WebElement txn_id;

    @FindBy(id="callback_url")
    private WebElement callback_url;

    @FindBy(id="callback_method")
    private WebElement callback_method;

    @FindBy(xpath="//input[@class='button primary-btn']")
    private WebElement pay_button;


    public WebElement getCompany_code() {
        return company_code;
    }

    public WebElement getProduct_code() {
        return product_code;
    }

    public WebElement getCustomer_name() {
        return customer_name;
    }

    public WebElement getCustomer_mobile() {
        return customer_mobile;
    }

    public WebElement getCustomer_email() {
        return customer_email;
    }

    public WebElement getAmount() {
        return amount;
    }

    public WebElement getCurreny() {
        return curreny;
    }

    public WebElement getTxn_id() {
        return txn_id;
    }

    public WebElement getCallback_url() {
        return callback_url;
    }

    public WebElement getCallback_method() {
        return callback_method;
    }

    public WebElement getPay_button() {
        return pay_button;
    }
}
