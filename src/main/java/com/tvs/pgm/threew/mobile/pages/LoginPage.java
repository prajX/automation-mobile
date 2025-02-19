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

    @FindBy(xpath="//android.widget.ImageView[@content-desc=\"English\"]")
    private WebElement laungageDropdown;

    public LoginPage() {
        
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    
    public boolean isEnterMobileNumberDisplayed() {
       // wait.until(ExpectedConditions.elementToBeClickable(enterMobileNumberText));
        return enterMobileNumberText.isDisplayed();
        
    }

    public void enterMobileNumber(String mobileNumber){
       // wait.until(ExpectedConditions.elementToBeClickable(enterMobileNumberField));
        enterMobileNumberField.click();
        enterMobileNumberField.clear();
        enterMobileNumberField.sendKeys(mobileNumber);
    }

    public boolean isverifyNumberButtonClickable(){
        wait.until(ExpectedConditions.elementToBeClickable(verifyNumberButton));
        return verifyNumberButton.isEnabled();
    }

    public boolean isverifyNumberButtonNotClickable(){
        //wait.until(ExpectedConditions.elementToBeClickable(verifyNumberButton));
        return verifyNumberButton.isEnabled();
    }

   

    public void clickVerifyNumber(){
      //  wait.until(ExpectedConditions.elementToBeClickable(verifyNumberButton));
        verifyNumberButton.click();
    }

    // public String verifyPlaceHoldervalue(){
    //     String plcaeholderName=enterMobileNumberField.getAttribute("value");
    //     return plcaeholderName;
    // }

    // public String verifyLaungaugeText(){
    //     String text=laungageDropdown.getText();
    //     return text;
    // }
}
