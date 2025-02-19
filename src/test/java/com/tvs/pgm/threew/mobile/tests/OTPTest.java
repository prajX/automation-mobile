package com.tvs.pgm.threew.mobile.tests;

import org.testng.annotations.BeforeClass;
import com.tvs.pgm.threew.mobile.pages.OtpPage;
import org.testng.annotations.Test;



public class OTPTest extends BaseTest{


    private OtpPage otpPage;

    @BeforeClass
    public void setup(){
        otpPage = new OtpPage();
    }
     
    // @Test(priority = 5)
    // public void verifyScrrenTextvalue(){
    //     org.testng.Assert.assertEquals(otpPage.verifyScreenText(), "Enter OTP sent to");        
    // }

    @Test(priority = 5)
    public void VerifyWithlessThanFiveDigit(){
        otpPage.clickOnOTPBox();
        otpPage.enterOTP("52");  
        org.testng.Assert.assertEquals(otpPage.submitButtonEnable(), true);      

    }


    @Test(priority = 6)
    public void verifyOTPEnteredSuccess(){
        otpPage.clickOnOTPBox();
        otpPage.enterOTP("54321");
    }

    @Test(priority = 7)
    public void VerifyOTPSubmitSuccess(){
        otpPage.clickSubmitButton();
    }

    
}
