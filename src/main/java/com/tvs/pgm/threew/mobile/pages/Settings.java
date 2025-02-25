package com.tvs.pgm.threew.mobile.pages;

import java.lang.annotation.ElementType;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Settings extends BasePage {

    @FindBy(xpath="//android.view.View[@content-desc=\"Security\"]")
    private WebElement text_Security;

    @FindBy(xpath = "//android.widget.Switch[@content-desc=\"Enable Fingerprint Authentication\"]")
    private WebElement enableFingerPrint;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Passcode Settings\"]")
    private WebElement text_Passcode;

    @FindBy(xpath="//android.view.View[@content-desc=\"Passcode Enabling\"]")
    private WebElement passcodeEnableText;

    @FindBy(xpath="//android.widget.Switch[@content-desc=\"Enable/Disable\"]")
    private WebElement enableDisableText;

    @FindBy(xpath="//android.view.View[@content-desc=\"Change Passcode\"]")
    private WebElement changePasscode;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Change Language\"]")
    private WebElement text_changeLanguage;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Select Language\"]")
    private WebElement selectLangauge;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Privacy and Terms of Use\"]")
    private WebElement privacyTermSection;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Privacy Policy\"]")
    private WebElement privacyPolicy;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Terms of Use\"]")
    private WebElement terms;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Delete Account\"]")
    private WebElement deleteAccount;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Passcode Settings\"]")
    private WebElement Passcode;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Terms of Use\"]")
    private WebElement termsOfUseTitle;

    @FindBy(xpath = "//android.widget.ImageView")
    private WebElement backArrowOftTermsOfUse;

    @FindBy(xpath="//android.view.View[@content-desc=\"Privacy Policy\"]")
    private WebElement privacyPolicyTitle;

    @FindBy(xpath="//android.view.View[@content-desc=\"TRUCHAMP\"]")
    private WebElement declinePopupTitle;

    @FindBy(xpath="//android.widget.Button[@content-desc=\"Decline\"]")
    private WebElement DeclineButton;

    @FindBy(xpath="//android.view.View[@content-desc=\"If you decline the privacy policy, then you are automatically logged out.\"]")
    private WebElement declinePopUpText;

    @FindBy(xpath="//android.widget.Button[@content-desc=\"Cancel\"]")
    private WebElement declinePopUpCancelButton;

    @FindBy(xpath="//android.widget.Button[@content-desc=\"Confirm\"]")
    private WebElement declinePopUpConfirmButton;

    public Settings() {        
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public String getSecurityText(){
        return text_Security.getAttribute("content-desc");
    }

    public String getEnableFingerprintText(){
        return enableFingerPrint.getAttribute("content-desc");
    }

    public String getLangaugeText(){
        return text_changeLanguage.getAttribute("content-desc");
    }

    public String checkSelectLangaugeSection(){
        return selectLangauge.getAttribute("content-desc");
    }

    public void clickOnSelectLangauge(){
        selectLangauge.click();
    }

    public String checkPrivacyTermsSection(){
        return privacyTermSection.getAttribute("content-desc");
    }

    public String checkPrivacyPolicy(){
       return privacyPolicy.getAttribute("content-desc");
    }

    public void clickOncheckPrivacyPolicy(){
        privacyPolicy.click();
    }

    public String checkTerms(){
       return terms.getAttribute("content-desc");
    }

    public void clickOnTerms(){
        WebElement element = wait.until(ExpectedConditions.visibilityOf(terms));
        element.click();
    }

    public String deleteAccountSection(){
        WebElement element = wait.until(ExpectedConditions.visibilityOf(deleteAccount));
        return element.getAttribute("content-desc");
    }

    public void clicOnDeleteAccount(){
        deleteAccount.click();
    }

    public String getPassCode(){
        return Passcode.getAttribute("content-desc");
    }

    public void clickOnPassCode(){
         Passcode.click();
    }

    public String checkTermsTitle(){
        WebElement element = wait.until(ExpectedConditions.visibilityOf(termsOfUseTitle));
        return element.getAttribute("content-desc");
    }

    public void clickOnBackArrowOfTerms(){
        WebElement element = wait.until(ExpectedConditions.visibilityOf(backArrowOftTermsOfUse));
        element.click();
    }

    public String checkPolicyTitle(){
        WebElement element = wait.until(ExpectedConditions.visibilityOf(privacyPolicyTitle));
        return element.getAttribute("content-desc");
   }

   public boolean  declineButtonPresent(){
        return DeclineButton.isDisplayed(); 
   }

   public void  clickOndecline(){
            WebElement element = wait.until(ExpectedConditions.visibilityOf(DeclineButton));
            element.click();
   }

   public String checkDeclinePopUpTitle(){
    WebElement element = wait.until(ExpectedConditions.visibilityOf(declinePopupTitle));
        return element.getAttribute("content-desc");
   }

   public String checkDeclinePopUpText(){
    WebElement element = wait.until(ExpectedConditions.visibilityOf(declinePopUpText));
    return element.getAttribute("content-desc");
   }

   public void clickOnPopUpCancelButton(){
    WebElement element = wait.until(ExpectedConditions.visibilityOf(declinePopUpCancelButton));
    element.click();
   }

   public void clickOnPopUpConfirmButton(){
    WebElement element = wait.until(ExpectedConditions.visibilityOf(declinePopUpConfirmButton));
    element.click();
   }

   public void clickOnPassCodeSetting(){
    WebElement element=wait.until(ExpectedConditions.visibilityOf(Passcode));
    element.click();
   }

   public String getPasscodeEnablingSection(){
    WebElement element=wait.until(ExpectedConditions.visibilityOf(passcodeEnableText));
    return element.getAttribute("content-desc");
   }

   public String getTextOnEnable_disable() throws InterruptedException{
    WebElement element=wait.until(ExpectedConditions.visibilityOf(enableDisableText));
    return element.getAttribute("content-desc");
   }

   public void backOnSettingFromPasscode(){
    driver.pressKey(new KeyEvent(AndroidKey.BACK));

   }

   public String getTextPasscodeChange(){
    WebElement element=wait.until(ExpectedConditions.visibilityOf(changePasscode));
    return  element.getAttribute("content-desc");
   }

   public void  clickOnchangePasscodeChange(){
    WebElement element=wait.until(ExpectedConditions.visibilityOf(changePasscode));
      element.click();
    }


    
}
