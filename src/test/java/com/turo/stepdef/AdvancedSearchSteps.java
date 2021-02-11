package com.turo.stepdef;

import com.turo.pages.AdvancedSearch;
import com.turo.utils.ConfigurationReader;
import com.turo.utils.MyDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.turo.pages.Base.waitSomeTime;

public class AdvancedSearchSteps {
    Logger logger = LoggerFactory.getLogger(AdvancedSearchSteps.class);
    AdvancedSearch advancedSearch = new AdvancedSearch();

    @Given("user is on landing page to advanced search")
    public void userIsOnLandingPageToAdvancedSearch() {
//        MyDriver.get().get(ConfigurationReader.getProperty("advancedUrl"));

//        MyDriver.get().manage().deleteAllCookies();
//        MyDriver.get().navigate().refresh();
        waitSomeTime(5L);
    }

    @And("User adjust the Vehicle years range under more filters menu")
    public void userAdjustTheVehicleYearsRangeUnderMoreFiltersMenu() {
        advancedSearch.moreFilterOptions();
    }


}
