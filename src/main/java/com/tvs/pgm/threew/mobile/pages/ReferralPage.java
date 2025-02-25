package com.tvs.pgm.threew.mobile.pages;

import java.util.jar.Attributes.Name;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ReferralPage extends BasePage{

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView")
    private WebElement backArrow;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Private Garage\"]")
    private WebElement pageTitle;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Refer a Customer\"]")
    private WebElement info;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Invite your friends and family to explore our exclusive TVS products!\"]")
    private WebElement genericTextOfPage;

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[1]")
    private WebElement customerName;

    @FindBy(xpath = "//android.widget.ScrollView/android.widget.EditText[1]")
    private WebElement customerNameA;

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[2]")
    private WebElement contactNumber;

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\\\"android:id/content\\\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[2]")
    private WebElement contactNumberA;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Product Interested In*\"]")
    private WebElement productDropdown;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Refer Now\"]")
    private WebElement referNowButton;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Product 1\"]")
    private WebElement productDropdownValue;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Please enter customer name\"]")
    private WebElement errorForCustomerName;


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
        return InfoText.getAttribute("content-desc");             
    }

    public String checkTitle(){
        WebElement InfoText = wait.until(ExpectedConditions.visibilityOf(pageTitle));
        return pageTitle.getAttribute("content-desc");
    }

    public String checkGenericText(){    
        WebElement GenericText = wait.until(ExpectedConditions.visibilityOf(genericTextOfPage));
        return GenericText.getAttribute("content-desc");       
    }

    public boolean checkNameField(){    
        WebElement nameField = wait.until(ExpectedConditions.visibilityOf(customerName));
        return nameField.isDisplayed();  
    }

    public boolean checkNumberField(){    
        WebElement numberield = wait.until(ExpectedConditions.visibilityOf(contactNumber));
        return numberield.isDisplayed();
    }

    public String checkProductField(){    
        WebElement productValues = wait.until(ExpectedConditions.visibilityOf(productDropdown));
        return productValues.getAttribute("content-desc");       
    }

    public boolean checkReferButton(){    
        WebElement ReferButtonText = wait.until(ExpectedConditions.visibilityOf(referNowButton));
        return ReferButtonText.isDisplayed();  
    }

    // public String checkProductField(){    
    //     WebElement productValues = wait.until(ExpectedConditions.visibilityOf(productDropdown));
    //     return productValues.getAttribute("content-desc");       
    // }

    public void clickOnBackArrow(){    
        backArrow.click();              
    }

    public void clickOnCustomerNameField(){  
        WebElement element = wait.until(ExpectedConditions.visibilityOf(customerName));
  
        element.click(); 
        element.clear();         
    }

    public void clickOnContactNumberField(){
        WebElement element = wait.until(ExpectedConditions.visibilityOf(contactNumber));

        element.click();
        element.clear();

    }

    public void clickOnProductsDropdown(){
        WebElement element = wait.until(ExpectedConditions.visibilityOf(productDropdown));
        element.click();
    }

    public void clickOnReferButton(){
            WebElement element = wait.until(ExpectedConditions.visibilityOf(referNowButton));
        element.click();
    }

    public void enterCustomerName(String name){
        WebElement element = wait.until(ExpectedConditions.visibilityOf(customerNameA));
        element.sendKeys(name);
    }

    public void enterCustomerNumber(String CustomerMobileNumber){
        WebElement element = wait.until(ExpectedConditions.visibilityOf(contactNumberA));
        element.sendKeys(CustomerMobileNumber);
    }

    public void cickOnProductFromDropdown(){
        WebElement element = wait.until(ExpectedConditions.visibilityOf(productDropdownValue));
        element.click();
    }

    public String checkErrorForCustomerName(){
        WebElement element = wait.until(ExpectedConditions.visibilityOf(errorForCustomerName));
        return element.getAttribute("content-desc");
    }

}
