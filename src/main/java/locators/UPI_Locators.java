package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class UPI_Locators {

    private static UPI_Locators xpathsPageInstance;

    private UPI_Locators() {

    }

    public static UPI_Locators getInstance() {
        if (xpathsPageInstance == null) {
            xpathsPageInstance = new UPI_Locators();
        }
        return xpathsPageInstance;
    }

    @CacheLookup

    @FindBy(id="UPI")
    private WebElement Upi_radio_btn;

    @FindBy(id="UPI-Number")
    private WebElement Enter_UPI_ID_UPI_Number_textbox;

    @FindBy(xpath="(//button[@class='button button--orange button--large'])[1]")
    private WebElement UPI_Pay_btn;

    public WebElement getUPI_Pay_btn() {
        return UPI_Pay_btn;
    }

    @FindBy(xpath="//span[text()='Verify']")
    private WebElement Enter_UPI_ID_UPI_Number_Verify_button;

    @FindBy(xpath="//div[text()='Verified']")
    private WebElement Enter_UPI_ID_Verified_content;

    public WebElement getEnter_UPI_ID_Verified_content() {
        return Enter_UPI_ID_Verified_content;
    }

    @FindBy(xpath="//li[text()='@oksbi']")
    private WebElement sbi_upi_id;

    @FindBy(xpath="//li[text()='@okicici']")
    private WebElement icici_upi_id;

    @FindBy(xpath="//li[text()='@okhdfcbank']")
    private WebElement hdfc_upi_id;

    @FindBy(xpath="//li[text()='@ybl']")
    private WebElement ybl_upi_id;

    public WebElement getYbl_upi_id() {
        return ybl_upi_id;
    }

    @FindBy(xpath="(//li[@class='payment__card'])[1]")
    private WebElement Gpay_btn;

    @FindBy(xpath="(//li[@class='payment__card'])[2]")
    private WebElement Phonepe_btn;

    public WebElement getUpi_radio_btn() {
        return Upi_radio_btn;
    }

    public WebElement getEnter_UPI_ID_UPI_Number_textbox() {
        return Enter_UPI_ID_UPI_Number_textbox;
    }

    public WebElement getEnter_UPI_ID_UPI_Number_Verify_button() {
        return Enter_UPI_ID_UPI_Number_Verify_button;
    }

    public WebElement getSbi_upi_id() {
        return sbi_upi_id;
    }

    public WebElement getIcici_upi_id() {
        return icici_upi_id;
    }

    public WebElement getHdfc_upi_id() {
        return hdfc_upi_id;
    }

    public WebElement getGpay_btn() {
        return Gpay_btn;
    }

    public WebElement getPhonepe_btn() {
        return Phonepe_btn;
    }
}
