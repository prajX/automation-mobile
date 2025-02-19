package com.tvs.pgm.threew.mobile.tests;

import com.tvs.pgm.threew.mobile.pages.LoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

public class LoginTest extends BaseTest {

    private LoginPage loginPage;

    @BeforeClass
    public void setup(){
       loginPage = new LoginPage();
    }

    // @Test(priority = 1)
    // public void verifyLangauge(){
    //     Assert.assertEquals(loginPage.verifyLaungaugeText(), "English");
    // }

    @Test(priority =1)
    public void testTextField() {
        test.info("Checking Login page Text........");
        try{
            Assert.assertTrue(loginPage.isEnterMobileNumberDisplayed(), "Enter Mobile Number text is NOT present on the screen!");
            test.pass("Verify that text found successfully");
        }catch(Exception e){
            test.fail("Enter Mobile Number text not found" + e.getMessage());
            throw e;
        }
    }

    // @Test(priority = 2)
    // public void verifyMobileNumberPlaceholderValue(){
    //     Assert.assertEquals(loginPage.verifyPlaceHoldervalue(), "Enter your Mobile number here");
    // }

    @Test(priority=2)
    public void wrongMobileNumber(){
        loginPage.enterMobileNumber("1223334");        
        Assert.assertFalse(loginPage.isverifyNumberButtonNotClickable());

    }

    @Test(priority = 3)
    public void enterMob(){
        loginPage.enterMobileNumber("1223334444");
        
    }

    @Test(priority = 4)
    public void clickVerifyNumberButton(){
        System.out.println(loginPage.isverifyNumberButtonClickable());
        loginPage.clickVerifyNumber();
    }
}
