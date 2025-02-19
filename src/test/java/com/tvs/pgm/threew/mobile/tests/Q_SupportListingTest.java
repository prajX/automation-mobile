package com.tvs.pgm.threew.mobile.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.tvs.pgm.threew.mobile.pages.SupportListingPage;
import com.tvs.pgm.threew.mobile.pages.SupportPage;

public class Q_SupportListingTest {
    
    private SupportListingPage supportListingPage;

    @BeforeClass
    public void setup(){
        supportListingPage = new SupportListingPage();
    }

    @Test(priority = 16)
    public void verifyCreateQueryButtonClicksON_SupportListingScreen(){
        supportListingPage.clickOnCreateQueryButton();
    }
}
