package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightsScreen {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "passCount")
    private WebElement passengersCount;

    @FindBy(name = "findFlights")
    private WebElement continueButton;

    public FlightsScreen(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void selectPassengersCount(String count) {
        this.wait.until(ExpectedConditions.elementToBeClickable(passengersCount));
        Select select = new Select(passengersCount);
        select.selectByValue(count);
    }

    public void clickContinueButton() {
        this.continueButton.click();
    }
}
