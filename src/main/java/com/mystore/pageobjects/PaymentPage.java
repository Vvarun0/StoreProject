package com.mystore.pageobjects;

import com.mystore.actiondriver.ActionClass;
import com.mystore.base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends Base {
    ActionClass action= new ActionClass();

    @FindBy(xpath = "//a[contains(text(),'Pay by bank wire')]")
    private WebElement bankWireMethod;

    @FindBy(xpath = "//a[contains(text(),'Pay by check')]")
    private WebElement payByCheckMethod;

    public PaymentPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public OrderSummaryPage clickOnPaymentMethod() throws Throwable {
        action.click(getDriver(), bankWireMethod);
        return new OrderSummaryPage();
    }
}
