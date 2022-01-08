package com.mystore.testcases;

import com.mystore.base.Base;
import com.mystore.pageobjects.IndexPage;
import com.mystore.utility.Log;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class IndexpageTest extends Base {
    IndexPage indexPage ;

    @Parameters("browser")
    @BeforeMethod(groups = {"Smoke","Sanity","Regression"})
    public void setup(String browser) {
        launchApp(browser);
    }

    @Test(groups = "Smoke")
    public void verifyLogo() throws Throwable {
        Log.startTestCase("verifyLogo");
        indexPage= new IndexPage();
        boolean result=indexPage.validateLogo();
        Assert.assertTrue(result);
        Log.endTestCase("verifyLogo");
    }

    @Test(groups = "Smoke")
    public void verifyTitle() {
        Log.startTestCase("verifyTitle");
        String actTitle=indexPage.getMyStoreTitle();
        Assert.assertEquals(actTitle, "My Store1");
        Log.endTestCase("verifyTitle");
    }
    @AfterMethod(groups = {"Smoke","Sanity","Regression"})
    public void tearDown(){
        getDriver().quit();
    }
}
