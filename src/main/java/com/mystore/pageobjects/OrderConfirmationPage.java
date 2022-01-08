package com.mystore.pageobjects;

import com.mystore.actiondriver.ActionClass;
import com.mystore.base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage extends Base {
    ActionClass action= new ActionClass();

    @FindBy(xpath="//p/strong[contains(text(),'Your order on My Store is complete.')]")
    private WebElement confirmMessag;

    public OrderConfirmationPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public String validateConfirmMessage() {
        String confirmMsg=confirmMessag.getText();
        return confirmMsg;
    }
}
