package com.tvs.pgm.threew.mobile.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.tvs.pgm.threew.mobile.pages.HomePage;
import com.tvs.pgm.threew.mobile.pages.SupportPage;

public class SupportTest extends BaseTest {

    private SupportPage supportPage;

    @BeforeClass
    public void setup(){
        supportPage = new SupportPage();
    }

    @Test(priority = 17, description = "Verify that the Back arrow is present on the  Support screen")
    public void verifyBackArrowVisibleOnSupportScreeen(){
        Assert.assertEquals(supportPage.backArrowPresentOnSupportPage(), true);
    }

    @Test(priority = 18, description = "Verify that the system is giving an error message if user is trying to create query without Title and Description")
    public void verifyErrorMesage_Without_TitleAndDescritpion() throws InterruptedException{
        supportPage.clickOnQueryButton();
        supportPage.clickOnCategories();
        supportPage.selectCategoryValue_Support();
        Assert.assertEquals(supportPage.getErrorMessage_Title(), "Please enter required field");
        //Assert.assertEquals(supportPage.getErrorMessage_Category(), "Please select category");
        Assert.assertEquals(supportPage.getErrorMessage_Descritpion(), "Please add description");
    }

    @Test(priority = 19, description = "Verify that the system is giving an error message if user is trying to create query without category and Description")
    public void verifyErrorMessage_without_Category_Description() throws InterruptedException{
        supportPage.clickOnTitle();
        supportPage.enterTitle("Need a help regarding support");
        supportPage.clickOnQueryButton();
        Assert.assertEquals(supportPage.getErrorMessage_Category(), "Please select category");
        Assert.assertEquals(supportPage.getErrorMessage_Descritpion(), "Please add description");
    }

    @Test(priority = 20, description = "Verify that the Query Generated successfully")
    public void verifyQueryCreatedSuccessfully() throws InterruptedException{
        supportPage.clickOnTitle();
        supportPage.enterTitle("Having a issue");
        supportPage.clickOnCategories();
        supportPage.selectCategoryValue_Support();
        supportPage.enterDescription("This description added related to Support, so can you please provide suggestion?");
        supportPage.clickOnQueryButton();
       
        
    }
}
