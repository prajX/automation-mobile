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

    public OtpPage() {        
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public String verifyTextForOTP(){
        String text=OTPtext.getText();
        return text;
    }

    public void clickOnOTPBox(){
        OtpField.click();
    }

    public void enterOTP(String OTP){
        OtpField.sendKeys(OTP);
    }

    public void clickSubmitButton(){
        submitButton.click();
    }

}
