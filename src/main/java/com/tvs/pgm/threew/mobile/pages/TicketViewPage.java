package com.tvs.pgm.threew.mobile.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TicketViewPage extends BasePage{

    @FindBy(xpath="//android.widget.Button[@content-desc=\"Close Ticket\"]")
    private WebElement closeTicketButton;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Support\"]")
    private WebElement viewTicketScreenTitle;

    @FindBy(xpath = "//android.widget.ImageView")
    private WebElement viewTicketBackArrow;
    
    public TicketViewPage() {        
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void cliCkOnCloseTicket(){
        WebElement element = wait.until(ExpectedConditions.visibilityOf(closeTicketButton));
        element.click();
    }

    public void clickOnBackArrowOfViewTicketScreen(){
        try{
        WebElement element = wait.until(ExpectedConditions.visibilityOf(viewTicketBackArrow));
        if(element.isDisplayed()==true){
            element.click();
        }
        }catch(Exception e){
            e.getMessage();
        }     
    }

    public void checkviewTicketScreenTitle(){
        WebElement element = wait.until(ExpectedConditions.visibilityOf(viewTicketScreenTitle));
        element.getAttribute("content-desc");
    }
}
