package com.mystore.pageobjects;

import com.mystore.actiondriver.ActionClass;
import com.mystore.base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSummaryPage extends Base {
    ActionClass action= new ActionClass();

    @FindBy(xpath="//span[contains(text(),'I confirm my order')]")
    private WebElement confirmOrderBtn;

    public OrderSummaryPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public OrderConfirmationPage clickOnconfirmOrderBtn() throws Throwable {
        action.click(getDriver(), confirmOrderBtn);
        return new OrderConfirmationPage();
    }
}
