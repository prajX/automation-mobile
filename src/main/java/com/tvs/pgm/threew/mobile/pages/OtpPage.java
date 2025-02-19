package com.tvs.pgm.threew.mobile.pages;


import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OtpPage extends BasePage {

    @FindBy(xpath="//android.widget.EditText")
    private WebElement OTPtext;

    @FindBy(xpath = "//android.widget.EditText")
    private WebElement OtpField;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Submit\"]")
    private WebElement submitButton;

    @FindBy(using ="Enter OTP sent to")
    private WebElement text;

    public OtpPage() {        
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public String verifyTextForOTP(){
        String text=OTPtext.getAccessibleName();
        return text;
    }

    public void clickOnOTPBox(){
        wait.until(ExpectedConditions.elementToBeClickable(OtpField));

        OtpField.click();
        OtpField.clear();
    }

    public void enterOTP(String OTP){
        
        OtpField.sendKeys(OTP);
    }

    public void clickSubmitButton(){
        submitButton.click();
    }

    public boolean submitButtonEnable(){
        return submitButton.isEnabled();
    }

    public String verifyScreenText(){
        String text_value=text.getText();
        return text_value;

    }

}
