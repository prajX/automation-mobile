package com.tvs.pgm.threew.mobile.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ReferralPage extends BasePage{

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView")
    private WebElement backArrow;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Private Garage\"]")
    private WebElement pageTitle;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Refer a Customer\"]")
    private WebElement info;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Invite your friends and family to explore our exclusive TVS products!\"]")
    private WebElement genericTextOfPage;

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[1]")
    private WebElement customerName;

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[2]")
    private WebElement contactNumber;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Product Interested In*\"]")
    private WebElement productDropdown;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Refer Now\"]")
    private WebElement referNowButton;


    public ReferralPage() {        
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    
    public boolean checkBackArrowPresent(){
        try {
            WebElement backbutton = wait.until(ExpectedConditions.visibilityOf(backArrow));
            return backbutton.isDisplayed();
        } catch (TimeoutException e) {
            System.out.println("BACK Arrow of Refer screen did not appear in time!");
            return false;
        }   
    }

    public String checkInfoText(){
        WebElement InfoText = wait.until(ExpectedConditions.visibilityOf(info));
        return InfoText.getText();                
    }

    public String checkGenericText(){    
        WebElement GenericText = wait.until(ExpectedConditions.visibilityOf(genericTextOfPage));
        return GenericText.getText();       
    }

    public String checkNameField(){    
        WebElement nameField = wait.until(ExpectedConditions.visibilityOf(customerName));
        return nameField.getText();       
    }

    public String checkNumberField(){    
        WebElement numberield = wait.until(ExpectedConditions.visibilityOf(contactNumber));
        return numberield.getText();       
    }

    public String checkProductField(){    
        WebElement productValues = wait.until(ExpectedConditions.visibilityOf(productDropdown));
        return productValues.getText();       
    }

    public void clickOnBackArrow(){    
        backArrow.click();              
    }

    public void clickOnCustomerNameField(){    
        customerName.click(); 
        customerName.clear();         
    }

    public void clickOnContactNumberField(){
        contactNumber.click();
        contactNumber.clear();
    }

    public void clickOnProductsDropdown(){
        productDropdown.click();
    }

    public void clickOnReferButton(){
        referNowButton.click();
    }

    public void enterCustomerName(String name){
        customerName.sendKeys(name);
    }

    public void enterCustomerNumber(String CustomerMobileNumber){
        customerName.sendKeys(CustomerMobileNumber);
    }
}
