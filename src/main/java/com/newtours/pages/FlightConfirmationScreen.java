package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FlightConfirmationScreen {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//font[contains(text(), 'Flight Confirmation')]")
    private WebElement flightConfirmationHeader;

    @FindBy(xpath = "//font[contains(text(), 'USD')]")
    private List<WebElement> billingPrices;

    @FindBy( linkText = "SIGN-OFF")
    private WebElement signOffButton;

    public FlightConfirmationScreen(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public String getBillingPrice() {
        this.wait.until(ExpectedConditions.visibilityOf(this.flightConfirmationHeader));
        return this.billingPrices.get(1).getText();
    }

    public void clickSignOffButton() {
        this.signOffButton.click();
    }
}
