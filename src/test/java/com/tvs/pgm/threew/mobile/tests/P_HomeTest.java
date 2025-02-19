package com.tvs.pgm.threew.mobile.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.tvs.pgm.threew.mobile.pages.HomePage;

public class P_HomeTest extends BaseTest{

    private HomePage homePage;

    @BeforeClass
    public void setup(){
        homePage = new HomePage();
    }

    @Test(priority = 8, description = "Verify that the setting Icon is present on the Homepage")
    public void settingIconpresent(){
        Assert.assertEquals(homePage.verifySettingPresent(), true);
    }

    @Test(priority = 9, description = "Verify that the profile Icon is present on the Homepage")
    public void profileIconePresent(){
        Assert.assertEquals(homePage.verifyProfilePresent(), true);
    }

    @Test(priority = 10, description = "Verify that the Need Any Help tile is present on the screen")
    public void verifyNeedAnyHelpTileVisible(){
        homePage.checkHelpTile();
    }

    @Test(priority = 11,description = "Verify that the Find a Dealer tile is present on the screen")
    public void verifyFindDealerTileVisible(){
        homePage.checkFindDealerTile();
    }

    @Test(priority = 12, description = "Verify that the Vehicle_Services tile is present on the screen")
    public void verifyVehicleServicesTileVisible(){
        homePage.vehicleServiesTile();
    }

    @Test(priority = 13, description = "Verify that the Traingin and Troubleshooting tile is present on the screen")
    public void verifyTrainingTileVisible(){
        homePage.checkTraingTile();
    }

    @Test(priority = 14, description = "Verify that the Referral tile is present on the screen")
    public void verifyReferralTileVisible(){
        homePage.checkRefferalTile();
    }

    @Test(priority = 15, dependsOnMethods = {"verifyNeedAnyHelpTileVisible"}, description = "Verify that the user can click on the Need Help tile is present on the screen")
    public void verifyHelpButtonClickable() throws InterruptedException{        
        homePage.clickonHelpTile();
        Thread.sleep(2000);
    }

}
