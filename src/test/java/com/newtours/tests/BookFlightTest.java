package com.newtours.tests;

import com.newtours.pages.*;
import com.tests.BaseTests;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class BookFlightTest extends BaseTests {
    private String nuOfPassengers;
    private String expectedPrice;


    @BeforeTest
    @Parameters({"noOfPassengers", "expectedPrice"})
    public void setParameters(String nuOfPassengers, String expectedPrice) {
        this.expectedPrice = expectedPrice;
        this.nuOfPassengers = nuOfPassengers;
    }

    @Test
    public void registrationPageFunctionality() {
        RegistrationScreen registrationScreen = new RegistrationScreen(driver);
        registrationScreen.goToWebPage();
        registrationScreen.enterFirstLastNames("Vahan", "Gevorgyan");
        registrationScreen.enterUserCredentials("vahancho", "mishoFelo");
        registrationScreen.clickSubmitButton();
    }

    @Test(dependsOnMethods = "registrationPageFunctionality")
    public void registrationConfirmationFunctionality() {
        RegistrationConfirmationScreen registrationConfirmationScreen = new RegistrationConfirmationScreen(driver);
        registrationConfirmationScreen.goToFlightsDetailsPage();
    }

    @Test(dependsOnMethods = "registrationConfirmationFunctionality")
    public void flightDetailsPageFunctionality() {
        FlightsScreen flightsScreen = new FlightsScreen(driver);
        flightsScreen.selectPassengersCount(nuOfPassengers);
        flightsScreen.clickContinueButton();
    }

    @Test(dependsOnMethods = "flightDetailsPageFunctionality")
    public void findFlightPage() {
        FindFlightScreen findFlightScreen = new FindFlightScreen(driver);
        findFlightScreen.clickSubmitFlightButton();
        findFlightScreen.clickBuyFlightsButton();
    }

    @Test(dependsOnMethods = "findFlightPage")
    public void verifyBillingPriceOfTicket() {
        FlightConfirmationScreen flightConfirmationScreen = new FlightConfirmationScreen(driver);
        String actualPrice = flightConfirmationScreen.getBillingPrice();
        assertTrue(actualPrice.equals(expectedPrice), actualPrice + " is not equals to " + expectedPrice);
        flightConfirmationScreen.clickSignOffButton();
    }

}
