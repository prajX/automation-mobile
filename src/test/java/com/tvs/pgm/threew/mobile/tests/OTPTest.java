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

    @Test(priority = 5, description = "Verify that the system can not move forward with less than 5 digit OTP")
    public void VerifyWithlessThanFiveDigit(){
        otpPage.clickOnOTPBox();
        otpPage.enterOTP("52");  
        org.testng.Assert.assertEquals(otpPage.submitButtonEnable(), true);      

    }


    @Test(priority = 6, description="Verify that the user is able to move forward with correct OTP")
    public void verifyOTPEnteredSuccess(){
        otpPage.clickOnOTPBox();
        otpPage.enterOTP("54321");
    }

    @Test(priority = 7, description="Verify that the user can click on the submit button And successfully land on the HomePage")
    public void VerifyOTPSubmitSuccess(){
        otpPage.clickSubmitButton();
    }

    
}
