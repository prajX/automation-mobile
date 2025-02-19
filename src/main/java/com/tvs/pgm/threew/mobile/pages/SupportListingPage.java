package com.tvs.pgm.threew.mobile.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SupportListingPage extends BasePage {
    
    @FindBy(xpath="//android.widget.ImageView")
    private WebElement backButton;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Create Query / Request\"]")
    private WebElement createQueryButton;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Support\"]")
    private WebElement filterIcon;

    public SupportListingPage() {        
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean checkBackIcon(){
        try {
            WebElement backArrow = wait.until(ExpectedConditions.visibilityOf(backButton));
            return backArrow.isDisplayed();
        } catch (TimeoutException e) {
            System.out.println("BACK arrow Icon did not appear in time!");
            return false;
        }   
    }

    public boolean checkCreateQueryButton(){
        try {
            WebElement queryButton= wait.until(ExpectedConditions.visibilityOf(createQueryButton));
            return queryButton.isDisplayed();
        } catch (TimeoutException e) {
            System.out.println("queryButton did not appear in time!");
            return false;
        }   
    }

    public boolean checkFilterButton(){
        try {
            WebElement filter= wait.until(ExpectedConditions.visibilityOf(filterIcon));
            return filter.isDisplayed();
        } catch (TimeoutException e) {
            System.out.println("FilterIcon did not appear in time!");
            return false;
        }   
    }

    public boolean isCreateQueryButtonClickable(){
        return createQueryButton.isEnabled();
    }

    public boolean isBackArrowClickable(){
       return backButton.isEnabled();
    }

    public void clickOnBackButton(){
        backButton.click();
    }

    public void clickOnCreateQueryButton(){
        createQueryButton.click();
    }

    public void clickOnFilterIcon(){
        filterIcon.click();
    }
}
