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

public class AddToCartPageTest extends Base {
    IndexPage indexPage ;
    AddToCartPage addtocartpage;
    SearchResultsPage searchresultpage;

    @Parameters("browser")
    @BeforeMethod(groups = {"Smoke","Sanity","Regression"})
    public void setup(String browser) {
        launchApp(browser);
    }

    @AfterMethod(groups = {"Smoke","Sanity","Regression"})
    public void tearDown(){
        getDriver().quit();
    }

    @Test(groups = {"Regression","Sanity"}, dataProvider = "getProduct", dataProviderClass = DataProviders.class)
    public void addToCartTest(String productName, String qty, String size) throws Throwable {
        Log.startTestCase("addToCartTest");
        indexPage= new IndexPage();
        searchresultpage=indexPage.searchProduct(productName);
        addtocartpage=searchresultpage.clickOnProduct();
        addtocartpage.enterQuantity(qty);
        addtocartpage.selectSize(size);
        addtocartpage.clickOnAddToCart();
        boolean result=addtocartpage.validateAddtoCart();
        Assert.assertTrue(result);
        Log.endTestCase("addToCartTest");
    }
}
