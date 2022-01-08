package com.mystore.testcases;

import com.mystore.base.Base;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;
import org.testng.Assert;
import org.testng.annotations.*;

public class HomePageTest extends Base {
    IndexPage indexpage;
    LoginPage loginpage;
    HomePage homepage;


    @BeforeMethod(groups = {"Smoke","Sanity","Regression"})
    @Parameters("browser")
    public void setup(String browser) {
        launchApp(browser);
    }


    @AfterMethod(groups = {"Smoke","Sanity","Regression"})
    public void tearDown(){
        getDriver().quit();
    }

    @Test(groups = "Smoke", dataProvider = "credentials", dataProviderClass = DataProviders.class)
    public void wishListTest(String uname, String pswd) throws Throwable {
        Log.startTestCase("wishListTest");
        indexpage= new IndexPage();
        loginpage=indexpage.clickOnSignIn();
        homepage=loginpage.login(uname,pswd,homepage);
        boolean result=homepage.validateMyWishList();
        Assert.assertTrue(result);
        Log.endTestCase("wishListTest");
    }

    @Test(groups = "Smoke",dataProvider = "credentials", dataProviderClass = DataProviders.class)
    public void orderHistoryandDetailsTest(String uname, String pswd) throws Throwable {
        Log.startTestCase("orderHistoryandDetailsTest");
        indexpage= new IndexPage();
        loginpage=indexpage.clickOnSignIn();
        homepage=loginpage.login(uname,pswd,homepage);
        boolean result=homepage.validateOrderHistory();
        Assert.assertTrue(result);
        Log.endTestCase("orderHistoryandDetailsTest");
    }
}
