package com.mystore.testcases;

import com.mystore.base.Base;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.*;
import com.mystore.utility.Log;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class EndToEndTest extends Base {
    IndexPage indexPage ;
    AddToCartPage addtocartpage;
    SearchResultsPage searchresultpage;
    OrderPage orderpage;
    LoginPage  loginPage;
    AddressPage addressPage;
    ShippingPage shippingPage;
    PaymentPage paymentPage;
    OrderSummaryPage orderSummaryPage;
    OrderConfirmationPage orderConfirmationPage;

    @Parameters("browser")
    @BeforeMethod(groups = {"Smoke","Sanity","Regression"})
    public void setup(String browser) {
        launchApp(browser);
    }
    @AfterMethod(groups = {"Smoke","Sanity","Regression"})
    public void tearDown(){
        getDriver().quit();
    }

    @Test(groups = "Regression",dataProvider = "getProduct", dataProviderClass = DataProviders.class)
    public void endToEndTest(String productName, String qty, String size) throws Throwable {
        Log.startTestCase("endToEndTest");
        indexPage= new IndexPage();
        searchresultpage=indexPage.searchProduct(productName);
        addtocartpage=searchresultpage.clickOnProduct();
        addtocartpage.enterQuantity(qty);
        addtocartpage.selectSize(size);
        addtocartpage.clickOnAddToCart();
        orderpage=addtocartpage.clickOnCheckOut();
        loginPage=orderpage.clickOnCheckOut();
        addressPage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"),addressPage);
        shippingPage=addressPage.clickOnCheckOut();
        shippingPage.checkTheTerms();
        paymentPage=shippingPage.clickOnProceedToCheckOut();
        orderSummaryPage=paymentPage.clickOnPaymentMethod();
        orderConfirmationPage=orderSummaryPage.clickOnconfirmOrderBtn();
        String actualMessage=orderConfirmationPage.validateConfirmMessage();
        String expectedMsg="Your order on My Store is complete.";
        Assert.assertEquals(actualMessage, expectedMsg);
        Log.endTestCase("endToEndTest");
    }

}
