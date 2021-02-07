package com.turo.pages;

import com.turo.stepdef.MainPageSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.openqa.selenium.By.xpath;

public class SearchACar extends Base {
    Logger logger = LoggerFactory.getLogger(MainPageSteps.class);

    @FindBy(xpath = "//input[@id='searchFormLocationTypeahead-input']")
    public WebElement locationUser;

    @FindBy(xpath = "//input[@placeholder='Start date']")
    public WebElement startDate;

    @FindBy(xpath = "//div[@aria-label='Calendar']")
    public WebElement calendar;

    @FindBy(xpath = "//div[@aria-label='Move forward to switch to the next month']")
    public WebElement nextMonthClick;

    @FindBy(xpath = "//div[@class='CalendarMonthGrid_month__horizontal CalendarMonthGrid_month__horizontal_1 CalendarMonthGrid_month__hideForAnimation CalendarMonthGrid_month__hideForAnimation_2 CalendarMonthGrid_month__hidden CalendarMonthGrid_month__hidden_3']//table[@role='presentation']")
    public  WebElement daysTable;

//    @FindBy(xpath = "//td[@class='CalendarDay CalendarDay_1 CalendarDay__default CalendarDay__default_2']")
//    public WebElement days;





    @FindBy(xpath = "//select[@aria-label='Start time']")
    public WebElement startTime;

    @FindBy(xpath = "//input[@placeholder='End date']")
    public WebElement endDate;

    @FindBy(xpath = "//select[@aria-label='End time']")
    public WebElement endTime;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement searchButton;

    //This is from date picker table
    @FindBy(css = "div[data-visible='true']")
    WebElement dateTable;

//    WebElement dateWidgetFrom = driver.findElement(By.xpath(".//*[@id='calendar-100000000']/div[3]/table/tbody"));




    public void enterLocation(String location) {
        locationUser.sendKeys(location);
        logger.info("{} is entered.", location);
    }

    public void startDateAndTime(String date, String time) {
        //Clicking the calender element to open the calender.
        startDate.click();

        while (!calendar.getText().contains("May")) {
            //this will click till finding the moth April.
            nextMonthClick.click();
        }
        //Grab common attribute and put it into list and iterate
        //using List to retrieve the class contains day in it.
//        List<WebElement> dates = driver.findElements(By.className("day"));
        List<WebElement> dates = daysTable.findElements(By.tagName("td"));
        List<WebElement> dates1 = daysTable.findElements(By.xpath("//td[@class='CalendarDay CalendarDay_1 CalendarDay__default CalendarDay__default_2']"));

//        if(days.getText() == "3");

        //counting the number of days inside the day class.
        int count = daysTable.findElements(By.xpath("//td[@class='CalendarDay CalendarDay_1 CalendarDay__default CalendarDay__default_2']")).size();

// iterating the days to find desired day which is equal to 23
        for (int i = 0; i < count; i++) {
            //We are getting the each day
//            String text = driver.findElements(By.className("day")).get(i).getText();
            String text = daysTable.findElements(By.xpath("//td[@class='CalendarDay CalendarDay_1 CalendarDay__default CalendarDay__default_2']")).get(i).getText();

            //comparing the day number with desired one. when it match the 23,
            // it will execute and will break the loop.
            if (text.equalsIgnoreCase("23")) {
                daysTable.findElements(By.xpath("//td[@class='CalendarDay CalendarDay_1 CalendarDay__default CalendarDay__default_2']")).get(i).click();
                break;
            }
        }

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
