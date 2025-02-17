package com.tvs.pgm.threew.mobile.tests;

import org.testng.annotations.BeforeClass;

import com.tvs.pgm.threew.mobile.pages.LoginPage;
import com.tvs.pgm.threew.mobile.pages.OtpPage;

import dev.failsafe.internal.util.Assert;
import org.testng.annotations.Test;


public class OTPTest extends BaseTest{


    private OtpPage otpPage;

    @BeforeClass
    public void setup(){
        otpPage = new OtpPage();
    }
     
    // @Test
    // public String verifyOTPScreenTextLine(){
    //     Assert.assertEquals(otpPage.verifyTextForOTP(),"Enter OTP sent to");
        
    // }

    @Test(priority =4)
    public void verifyOTPEnteredSuccess(){
        otpPage.clickOnOTPBox();
        otpPage.enterOTP("54321");
    }

    @Test(priority = 5)
    public void VerifyOTPSubmitSuccess(){
        otpPage.clickSubmitButton();
    }

    
}
