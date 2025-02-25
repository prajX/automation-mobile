package com.tvs.pgm.threew.mobile.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.tvs.pgm.threew.mobile.pages.HomePage;
import com.tvs.pgm.threew.mobile.pages.LoginPage;
import com.tvs.pgm.threew.mobile.pages.ReferralPage;
import com.tvs.pgm.threew.mobile.pages.Settings;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class SettingsTest extends BaseTest{

     private Settings settingPage;
     private HomePage homePage;
     private LoginPage loginPage;

    @BeforeClass
    public void setup(){
        homePage = new HomePage();
        settingPage = new Settings();
        loginPage=new LoginPage();
    }

    @Test(priority=1, description= "Verify that the can see 'Security' section on Setting screen")
    public void checkSecuritySection() throws InterruptedException
    {       Thread.sleep(2000);
          homePage.clickOnSetting();
        Assert.assertEquals(settingPage.getSecurityText(), "Security");        
    }

    @Test(priority=2, description="Verify that the Enable FingerPrint auth section found on Setting screen")
    public void checkFingerPrintSection()
    { 
        Assert.assertEquals(settingPage.getEnableFingerprintText(), "Enable Fingerprint Authentication");        
    }

    @Test(priority=3, description="Verify that the Passcode Settings section present on Setting screen")
    public void checkPasscodeSection()
    { 
        Assert.assertEquals(settingPage.getPassCode(), "Passcode Settings");        
    }

    @Test(priority = 4, description = "Verify the user can click on the Passcode setting option and land on the Passcode settings screen")
    public void landOnPasscodeSettingScreen(){
        settingPage.clickOnPassCode();
    }

    @Test(priority = 5, description = "Verify the Passcode enabling section present on the Passcode setting screen")
    public void checkPasscodeSectionPresent(){
        Assert.assertEquals(settingPage.getPasscodeEnablingSection(), "Passcode Enabling");
    }

    @Test(priority = 6, description = "Verify that the  Enable/Disable Option present on the Passcode Enabling section")
    public void landsOnPassSetupScreen() throws InterruptedException{
        Assert.assertEquals(settingPage.getTextOnEnable_disable(), "Enable/Disable");
        
    }

    @Test(priority = 6, description = "Verify that the Change Passcode Option present on the Passcode Enabling section")
    public void m_checkChangePasscodeOption() throws InterruptedException{
        Assert.assertEquals(settingPage.getTextPasscodeChange(), "Change Passcode");  
        settingPage.backOnSettingFromPasscode();      
    }



    @Test(priority=7, description="Verify that the Change Language section present on Setting screen")
    public void checkChangeLanguageSection()
    { 
        Assert.assertEquals(settingPage.getLangaugeText(), "Change Language");        
    }

    @Test(priority=8, description="Verify that the select Language section present on Setting screen")
    public void checkSelectLanguageSection()
    { 
        Assert.assertEquals(settingPage.checkSelectLangaugeSection(), "Select Language");        
    }

    @Test(priority=9, description="Verify that the Privacy and Terms of Use section present on Setting screen")
    public void checkPrivacyAndTermsSection()
    { 
        Assert.assertEquals(settingPage.checkPrivacyTermsSection(), "Privacy and Terms of Use");        
    }

    @Test(priority=10, description="Verify that the Privacy Policy section present on Setting screen")
    public void checkPrivacySection()
    { 
        Assert.assertEquals(settingPage.checkPrivacyPolicy(), "Privacy Policy");        
    }

    @Test(priority=11, description="Verify that the Terms of Use section present on Setting screen")
    public void checkTermsSection()
    { 
        Assert.assertEquals(settingPage.checkTerms(), "Terms of Use");        
    }

    @Test(priority=12, description="Verify that the Delete Account section present on Setting screen")
    public void checkDeleteAccountSection()
    { 
        Assert.assertEquals(settingPage.deleteAccountSection(), "Delete Account");        
    }

    @Test(priority=13, description="Verify that the user can land on the Terms of Use section from Setting screen")
    public void clickOnTerms()
    { 
        settingPage.clickOnTerms();
        Assert.assertEquals(settingPage.checkTermsTitle(), "Terms of Use");
    }

    @Test(priority=14, description="Verify the Terms of Use are present as per requirement")
    public void verifyTerms() throws InterruptedException
    { 
        Assert.assertEquals(settingPage.checkTermsTitle(), "Terms of Use");
        homePage.scrollUp();
        homePage.scrollUp();
        Thread.sleep(1000);
    }

    @Test(priority=15, description="Verify the user can move back from Terms of Use screen")
    public void verifyBackArrowWorking()
    { 
        settingPage.clickOnBackArrowOfTerms();
        Assert.assertEquals(settingPage.checkPrivacyTermsSection(), "Privacy and Terms of Use");
    }

    @Test(priority=16, description="Verify the user can land on check Privacy Policy")
    public void verifyPrivacyPolicyTitle()
    {   settingPage.clickOncheckPrivacyPolicy();
        Assert.assertEquals(settingPage.checkPolicyTitle(), "Privacy Policy");
    }

    @Test(priority=17, description="Verify the user can check Decline button present on the Privacy Policy screen")
    public void DeclineButtonshown() throws InterruptedException
    {   homePage.scrollUp();
        homePage.scrollUp();
        homePage.scrollUp();
        Thread.sleep(1000);
        Assert.assertEquals(settingPage.declineButtonPresent(), true);        
    }

    @Test(priority = 18, description = "Verify the system will hide the pop-up if user click on the Cnacel button ")
    public void verifyPolicyDeclineCancelflow(){
        settingPage.clickOndecline();
        Assert.assertEquals(settingPage.checkDeclinePopUpTitle(), "TRUCHAMP");
        Assert.assertEquals(settingPage.checkDeclinePopUpText(), "If you decline the privacy policy, then you are automatically logged out.");
        settingPage.clickOnPopUpCancelButton();
        Assert.assertEquals(settingPage.declineButtonPresent(), true);

    }

    @Test(priority = 19, description = "Verify the system will redirect on the Login page if user decline the policy")
    public void verifyDeclineflow(){
        settingPage.clickOndecline();
        Assert.assertEquals(settingPage.checkDeclinePopUpTitle(), "TRUCHAMP");
        test.info("user found Decline Pop-Up");
        Assert.assertEquals(settingPage.checkDeclinePopUpText(), "If you decline the privacy policy, then you are automatically logged out.");
        test.info("Found Informative text over the pop-up");
        settingPage.clickOnPopUpConfirmButton();
        Assert.assertEquals(loginPage.isEnterMobileNumberDisplayed(), true);
        test.info("User Landed on the Login screen--Enter Mobile Number");

    }
}


