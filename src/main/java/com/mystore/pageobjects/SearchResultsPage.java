package com.mystore.pageobjects;

import com.mystore.actiondriver.ActionClass;
import com.mystore.base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage extends Base {
    ActionClass action= new ActionClass();

    @FindBy(xpath="//*[@id=\"center_column\"]//img")
    private WebElement productResult;

    public SearchResultsPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public boolean isProductAvailable() throws Throwable {
        return action.isDisplayed(getDriver(), productResult);
    }

    public AddToCartPage clickOnProduct() throws Throwable {
        action.click(getDriver(), productResult);
        return new AddToCartPage();
    }
}
