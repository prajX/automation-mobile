package com.tvs.pgm.threew.mobile.pages;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    

    @FindBy(xpath = "//android.view.View[@content-desc=\"Enter Mobile Number\"]")
    private WebElement enterMobileNumberText;
    @FindBy(xpath = "//android.widget.EditText")
    private WebElement enterMobileNumberField;
    @FindBy(xpath="//android.widget.Button[@content-desc=\"Verify Number\"]")
    private WebElement verifyNumberButton;

    public LoginPage() {
        
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    
    public boolean isEnterMobileNumberDisplayed() {
        return enterMobileNumberText.isDisplayed();
    }

    public void enterMobileNumber(String mobileNumber){
        enterMobileNumberField.click();
        enterMobileNumberField.sendKeys(mobileNumber);
    }

    public boolean isverifyNumberButtonClickable(){
        return verifyNumberButton.isEnabled();
    }

    public void clickVerifyNumber(){
        wait.until(ExpectedConditions.elementToBeClickable(verifyNumberButton));
        verifyNumberButton.click();
    }
}
