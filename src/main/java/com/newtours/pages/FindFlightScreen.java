package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindFlightScreen {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "reserveFlights")
    private WebElement reserveFlightsButton;

    @FindBy(name = "buyFlights")
    private WebElement buyFlightsButton;

    public FindFlightScreen(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void clickSubmitFlightButton() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.reserveFlightsButton));
        this.reserveFlightsButton.click();
    }

    public void clickBuyFlightsButton() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.buyFlightsButton));
        this.buyFlightsButton.click();
    }
}
