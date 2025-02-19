package com.tvs.pgm.threew.mobile.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SupportPage extends BasePage{

    @FindBy(xpath = "//android.widget.ScrollView/android.widget.EditText[1]")
    private WebElement titleTextbox;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Select Category\"]")
    private WebElement categoryDropdown;

    @FindBy(xpath = "//android.widget.ScrollView/android.widget.EditText[2]")
    private WebElement descriptionTextbox;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Add Attachment\"]")
    private WebElement addAttachmentBox;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Share Voice Message\"]")
    private WebElement voiceMessageBox;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Attachment\"]")
    private WebElement attachmentSection;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Support\"]")
    private WebElement supportPageTitleName;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Create Query / Request\"]")
    private WebElement finalcreateQueryButton;

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView")
    private WebElement supportPageBackArrow;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Parts Related\"]")
    private WebElement Support_category;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Please add description\"]")
    private WebElement errorForDescritpion;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Please enter required field\"]")
    private WebElement errorForTitle;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Please select category\"]")
    private WebElement errorForSelectCategory;

    public SupportPage() {        
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean backArrowPresentOnSupportPage(){
        return supportPageBackArrow.isDisplayed();
    }

    public void clickOnTitle(){
        titleTextbox.click();
        titleTextbox.clear();
    }
    public void enterTitle(String title) {
        try{
            titleTextbox.sendKeys(title);
        }catch(Exception e){
            System.out.println("User is not able to enter the Title");
        }
    }

    public void clickOnCategories(){
        categoryDropdown.click();
    }

    public void enterDescription(String descritpion) throws InterruptedException{
        try{
        descriptionTextbox.sendKeys(descritpion);
        }catch(Exception e){
            System.out.println("User is not able to Add Description");
        }
    }     

    public void clickOnQueryButton(){
        try{
        finalcreateQueryButton.click();
        }catch(Exception e){
            System.out.println("User is not able to click on the Query Button");
        }
    }

    public void selectCategoryValue_Support(){
        Support_category.click();
    }

    public String getErrorMessage_Title() throws InterruptedException{
        WebElement element = wait.until(ExpectedConditions.visibilityOf(errorForTitle));
        Thread.sleep(1000);
        return element.getAttribute("content-desc");
    }

    public String getErrorMessage_Category(){
        WebElement element = wait.until(ExpectedConditions.visibilityOf(errorForSelectCategory));
        return element.getAttribute("content-desc");
    }

    public String getErrorMessage_Descritpion(){
        WebElement element = wait.until(ExpectedConditions.visibilityOf(errorForDescritpion));
        return element.getAttribute("content-desc");
    }
    
}
