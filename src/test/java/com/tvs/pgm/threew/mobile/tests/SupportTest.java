package com.tvs.pgm.threew.mobile.tests;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.tvs.pgm.threew.mobile.pages.HomePage;
import com.tvs.pgm.threew.mobile.pages.SupportListingPage;
import com.tvs.pgm.threew.mobile.pages.SupportPage;
import com.tvs.pgm.threew.mobile.utils.SupportDataGenerator;

public class SupportTest extends BaseTest {

    private SupportPage supportPage;
    private HomePage homePage;
    private SupportListingPage supportlistingPage;



    @BeforeClass
    public void setup(){
        supportPage = new SupportPage();
        homePage=new HomePage();
        supportlistingPage=new SupportListingPage();
    }

    @Test(priority = 1, description = "Verify that the Back arrow is present on the  Support screen")
    public void verifyBackArrowVisibleOnSupportScreeen(){
        Assert.assertEquals(supportPage.backArrowPresentOnSupportPage(), true);
    }

    @Test(priority = 2, description = "Verify that the system is giving an error message if user is trying to create query without Title and Description")
    public void verifyErrorMesage_Without_TitleAndDescritpion() throws InterruptedException{
        supportPage.clickOnQueryButton();
        Assert.assertEquals(supportPage.getErrorMessage_Title(), "Please enter required field");
        Assert.assertEquals(supportPage.getErrorMessage_Description(), "Please add description");
    }

    @Test(priority = 3, description = "Verify that the system is giving an error message if user is trying to create query without category and Description")
    public void verifyErrorMessage_without_Category_Description() throws InterruptedException{
        supportPage.clickOnTitle();
        supportPage.enterTitle("Need a help regarding support");
        supportPage.clickOnQueryButton();
        Assert.assertEquals(supportPage.getErrorMessage_Category(), "Please select category");
        Assert.assertEquals(supportPage.getErrorMessage_Description(), "Please add description");
    }

    @Test(priority = 4, description = "Verify the Support page titleName found correct")
    public void verifyTitle(){
        Assert.assertEquals(supportPage.checkPageTitle(), "Support");
        
    }

    @Test(priority = 5, description = "Verify that the 'Create Query/Request' text found on above title box")
    public void verifyCreateQueryText(){
        Assert.assertEquals(supportPage.checkCreate_queryText(), "Create Query / Request");
    }

    @Test(priority = 6, description = "Verify that the Description section present on the support screen")
    public void verifyDescriptionBoxTitle(){
        Assert.assertEquals(supportPage.checkDescriptionSection(), "Description *");
    }

    @Test(priority = 7, description = "Verify that the Attachment section present on the support screen")
    public void verifyAttachmentSection(){
        Assert.assertEquals(supportPage.checkAttachmentSection(), "Attachment");

    }

    @Test(priority = 8, description = "Verify that the Add attachment box present on the support screen")
    public void verifyAttachmentBox(){
        Assert.assertEquals(supportPage.checkAttachmentBox(), true);
    }

    @Test(priority = 9, description = "Verify that the voice message box present on the support screen")
    public void verifyVoiceMessafeBox(){
        Assert.assertEquals(supportPage.checkVoiceBox(), true);
    }

    @Test(priority = 10, description = "Verify that the back button is working fine of support screen")
    public void verifySupporBackArrow(){
        supportPage.clickOnBackArr();
        supportlistingPage.clickOnCreateQueryButton();     
        Assert.assertEquals(supportPage.checkPageTitle(), "Support");
    }

    @Test(priority = 11, description = "Verify that the Query Generated successfully without Attachment")
    public void verifyQueryCreatedSuccessfully() throws InterruptedException{
        String randomTitle = SupportDataGenerator.generateRandomTitle();
        String randomDescription = SupportDataGenerator.generateRandomDescription();

        test.info("Generated Title: " + randomTitle);
        test.info("Generated Description: " + randomDescription);
        
        // supportPage.clickOnAttachment();
        // Thread.sleep(2000);
        // Map<String, Object> args = new HashMap<>();
        // args.put("finder", "ByType('Image')"); 
        // driver.executeScript("flutter:tap", args);

        supportPage.clickOnTitle();
        supportPage.enterTitle(randomTitle);
        supportPage.clickOnCategories();
        supportPage.selectCategoryValue_Support();
        supportPage.clickOnDescription();
        supportPage.enterDescription(randomDescription);
        supportPage.clickOnQueryButton();
        homePage.clickonHelpTile();
        WebElement dynamicXpath=supportlistingPage.getGeneratedQueryElement(randomTitle, randomDescription);
        Assert.assertTrue(dynamicXpath.isDisplayed(), "The generated query is not visible!");


    }
}
