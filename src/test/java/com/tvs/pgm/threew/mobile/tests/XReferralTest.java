package com.tvs.pgm.threew.mobile.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.tvs.pgm.threew.mobile.pages.HomePage;
import com.tvs.pgm.threew.mobile.pages.ReferralPage;

public class XReferralTest extends BaseTest{
    

    private ReferralPage referPage;
    private HomePage homePage;


    @BeforeClass
    public void setup(){
        referPage = new ReferralPage();
        homePage=new HomePage();
    }

    // @Test (priority = 0, description = "Verify that the Back arrow working fine")
    // public void landOnReferralTile(){
    //     homePage.clickOnReferCustomer();
    //     Assert.assertEquals(referPage.checkTitle(), "Private Garage");
    // }
    
    
    @Test(priority = 1, description = "Verify that arrow button is present on the Referral screen")
    public void verifyBackArrowPresent(){  
        System.out.println("-----------------------");
        homePage.clickOnReferCustomer();      
        Assert.assertEquals(referPage.checkBackArrowPresent(), true);
    }

    @Test (priority = 2, description = "Verify that the Back arrow is clickable")
    public void verifyBackArrorWorks(){
        referPage.clickOnBackArrow();
        Assert.assertEquals(homePage.verifySettingPresent(), true);
        homePage.clickOnReferCustomer();
    }

    @Test(priority = 3, description = "Verify that Refer a customer text present on the Referral screen")
    public void verifyInfoTextPresent(){
        Assert.assertEquals(referPage.checkInfoText(), "Refer a Customer");
    }

    @Test(priority = 4, description = "Verify that Generic text present on the Referral screen")
    public void verifyGenericText(){
        Assert.assertEquals(referPage.checkGenericText(), "Invite your friends and family to explore our exclusive TVS products!");
    }

    @Test(priority = 5, description = "Verify that Customer Name field present on the Referral screen")
    public void verifyCustomerNameFieldPresent(){
        Assert.assertEquals(referPage.checkNameField(), "Customer Name");
    }

    @Test (priority = 6, description = "Verify that Customer Number field present on the Referral screen")
    public void verifyCustomerNumberFieldPresent(){
        Assert.assertEquals(referPage.checkNumberField(), "Contact Number");
    }

    @Test (priority = 7,description = "Verify that Products field present on the Referral screen")
    public void verifyDropdown(){
        Assert.assertEquals(referPage.checkProductField(), "Product Interested In");
    }

    @Test (priority=8, description = "Verify tha the button text is correct - Refer Now")
    public void verifyReferButton(){
        Assert.assertEquals(referPage.checkButtonValue(), "Refer Now");
    }
}
