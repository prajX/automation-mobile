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

    @Test(priority = 8)
    public void settingIconpresent(){
        Assert.assertEquals(homePage.verifySettingPresent(), true);
    }

    @Test(priority = 9)
    public void profileIconePresent(){
        Assert.assertEquals(homePage.verifyProfilePresent(), true);
    }

    @Test(priority = 10)
    public void verifyNeedAnyHelpTileVisible(){
        homePage.checkHelpTile();
    }

    @Test(priority = 11)
    public void verifyFindDealerTileVisible(){
        homePage.checkFindDealerTile();
    }

    @Test(priority = 12)
    public void verifyVehicleServicesTileVisible(){
        homePage.vehicleServiesTile();
    }

    @Test(priority = 13)
    public void verifyTrainingTileVisible(){
        homePage.checkTraingTile();
    }

    @Test(priority = 14)
    public void verifyReferralTileVisible(){
        homePage.checkRefferalTile();
    }

    @Test(priority = 15, dependsOnMethods = {"verifyNeedAnyHelpTileVisible"})
    public void verifyHelpButtonClickable() throws InterruptedException{        
        homePage.clickonHelpTile();
        Thread.sleep(2000);
    }

}
