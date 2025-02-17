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

    
    @Test(priority =1)
    public void testTextField() {
        Assert.assertTrue(loginPage.isEnterMobileNumberDisplayed(), "Enter Mobile Number text is NOT present on the screen!");
    }

    @Test(priority = 2)
    public void enterMob(){
        loginPage.enterMobileNumber("1122334455");
    }

    @Test(priority = 3)
    public void clickVerifyNumberButton(){
        System.out.println(loginPage.isverifyNumberButtonClickable());
        loginPage.clickVerifyNumber();
    }
}
