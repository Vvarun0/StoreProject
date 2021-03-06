package com.mystore.testcases;

import com.mystore.base.Base;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginPageTest extends Base {
    IndexPage indexPage ;
    LoginPage loginPage;
    HomePage homepage;

    @Parameters("browser")
    @BeforeMethod(groups = {"Smoke","Sanity","Regression"})
    public void setup(String browser) {
        launchApp(browser);
    }
    @AfterMethod(groups = {"Smoke","Sanity","Regression"})
    public void tearDown(){
        getDriver().quit();
    }

    @Test(groups = {"Smoke","Sanity"},dataProvider = "credentials", dataProviderClass = DataProviders.class)
    public void loginTest(String uname,String pswd) throws Throwable {
        Log.startTestCase("loginTest");
        indexPage= new IndexPage();
        Log.info("user is going to click on SignIn");
        loginPage=indexPage.clickOnSignIn();
        Log.info("Enter Username and Password");
       // homepage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"),homepage);
        homepage=loginPage.login(uname,pswd,homepage);
        String actualURL=homepage.getCurrURL();
        String expectedURL="http://automationpractice.com/index.php?controller=my-account";
        Log.info("Verifying if user is able to login");
        Assert.assertEquals(actualURL, expectedURL);
        Log.info("Login is Sucess");
        Log.endTestCase("loginTest");
    }
}
