// package com.tvs.pgm.threew.mobile.tests;

// import org.testng.Assert;
// import org.testng.annotations.BeforeClass;
// import org.testng.annotations.Test;

// import com.tvs.pgm.threew.mobile.pages.ReferralPage;

// public class ReferralTest extends ReferralPage{
    

//     private ReferralPage referPage;

//     @BeforeClass
//     public void setup(){
//         referPage = new ReferralPage();
//     }

//     @Test
//     public void verifyBackArrowPresent(){        
//         Assert.assertEquals(referPage.checkBackArrowPresent(), true);
//     }

//     @Test
//     public void verifyInfoTextPresent(){
//         Assert.assertEquals(referPage.checkInfoText(), "Refer a Customer");
//     }

//     @Test
//     public void verifyGenericText(){
//         Assert.assertEquals(referPage.checkGenericText(), "Invite your friends and family to explore our exclusive TVS products!");
//     }

//     @Test
//     public void verifyCustomerNameFieldPresent(){
//         Assert.assertEquals(referPage.checkNameField(), "Customer Name");
//     }

//     @Test 
//     public void verifyCustomerNumberFieldPresent(){
//         Assert.assertEquals(referPage.checkNumberField(), "Contact Number");
//     }

//     @Test
//     public void verifyDropdown(){
//         Assert.assertEquals(referPage.checkProductField(), "Product Interested In");
//     }
// }
