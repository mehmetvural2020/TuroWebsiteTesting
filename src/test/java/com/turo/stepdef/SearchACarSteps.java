package com.turo.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SearchACarSteps {
    Logger logger = LoggerFactory.getLogger(MainPageSteps.class);


    @Then("User enter <{string}> in Where text box")
    public void userEnterInWhereTextBox(String arg0) {
    }

    @Then("User select <{string}> and <{string}> under From")
    public void userSelectAndUnderFrom(String arg0, String arg1) {
    }

    @Then("User select <{string}> and <{string}> under Until")
    public void userSelectAndUnderUntil(String arg0, String arg1) {
    }

    @Then("User clicks Search button")
    public void userClicksSearchButton() {
    }

    @And("User clicks on Sort By menu and select an option then clicks on apply")
    public void userClicksOnSortByMenuAndSelectAnOptionThenClicksOnApply() {
    }

    @And("User clicks on Price menu and adjust the price range then clicks on view results")
    public void userClicksOnPriceMenuAndAdjustThePriceRangeThenClicksOnViewResults() {
    }

    @And("User clicks on Book instantly menu and clicks on view results")
    public void userClicksOnBookInstantlyMenuAndClicksOnViewResults() {
    }

    @And("User clicks on Delivery menu and adjust the distance range then clicks on view results")
    public void userClicksOnDeliveryMenuAndAdjustTheDistanceRangeThenClicksOnViewResults() {
    }

    @And("User clicks on More filters menu and select All-Star Host")
    public void userClicksOnMoreFiltersMenuAndSelectAllStarHost() {
    }

    @And("select <Vehicle_types> and clicks on upper arrow")
    public void selectVehicle_typesAndClicksOnUpperArrow() {
    }

    @And("adjust the Vehicle years range and select the Transmission")
    public void adjustTheVehicleYearsRangeAndSelectTheTransmission() {
    }

    @Then("User clicks on view results")
    public void userClicksOnViewResults() {
    }

    @Then("User selects the first car in the list")
    public void userSelectsTheFirstCarInTheList() {
    }

    @And("Verify that Pickup & return location is present")
    public void verifyThatPickupReturnLocationIsPresent() {
    }

    @Then("User selects Pickup & return location")
    public void userSelectsPickupReturnLocation() {
    }

    @And("User clicks on Continue button")
    public void userClicksOnContinueButton() {
    }
}
