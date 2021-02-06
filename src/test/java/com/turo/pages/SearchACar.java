package com.turo.pages;

import com.turo.stepdef.MainPageSteps;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.PublicKey;

public class SearchACar {
    Logger logger = LoggerFactory.getLogger(MainPageSteps.class);

    @FindBy(xpath = "//input[@id='searchFormLocationTypeahead-input']")
    public WebElement location;

    @FindBy(xpath = "//input[@placeholder='Start date']")
    public WebElement startDate;

    @FindBy(xpath = "//select[@aria-label='Start time']")
    public WebElement startTime;

    @FindBy(xpath = "//input[@placeholder='End date']")
    public WebElement endDate;

    @FindBy(xpath = "//select[@aria-label='End time']")
    public WebElement endTime;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement searchButton;


    public void enterLocation(String location) {
        this.location.sendKeys(location);
        logger.info("{} is entered.", location);
    }

    public void startDateAndTime(String date, String time) {
        startDate.sendKeys(date);
        startTime.sendKeys(time);
        logger.info("Start {} and {} are selected.",date, time);
    }

    public void endDateAndTime(String date, String time) {
        endDate.sendKeys(date);
        endTime.sendKeys(time);
        logger.info("End {} and {} are selected.", date, time);
    }

    public void clickSearchButton() {
        searchButton.submit();
        logger.info("User clicked search button.");
    }
}
