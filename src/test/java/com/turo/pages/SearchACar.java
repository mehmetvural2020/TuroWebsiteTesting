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

    @FindBy(xpath = "//div[@class='seo-pages-19ve007-SuggestionTextTitle ee6ccll1'][normalize-space()='Los Angeles, CA']")
    public WebElement selectLocation;

    @FindBy(xpath = "//input[@placeholder='Start date']")
    public WebElement startDate;

    @FindBy(xpath = "//div[@aria-label='Calendar']")
    public WebElement calendar;

    @FindBy(xpath = "//div[@aria-label='Move forward to switch to the next month']")
    public WebElement nextMonthClick;

    @FindBy(xpath = "//div[@class='DateRangePicker_picker DateRangePicker_picker__horizontal DateRangePicker_picker__with_header seo-pages-jonmmy']")
    public WebElement daysTable1;

    @FindBy(xpath = "//input[@placeholder='End date']")
    public WebElement endDate;

    @FindBy(xpath = "//input[@aria-label='End date']")
    public WebElement endCalendar;

    @FindBy(xpath = "//div[@aria-label='Move forward to switch to the next month']")
    public WebElement endNextMonthClick;

    @FindBy(xpath = "//div[@aria-label='Calendar']")
    public WebElement daysTable2;



    @FindBy(xpath = "//button[@type='submit']")
    public WebElement searchButton;

    //This is from date picker table
    @FindBy(css = "div[data-visible='true']")
    WebElement dateTable;



    public void enterLocation(String location) {
        waitSomeTime(2L);
        locationUser.click();
        locationUser.sendKeys(location);
        selectLocation.click();
        logger.info("{} is entered.", location);
    }

    public void startDateAndTime(String date, String time) {
        //Clicking the calender element to open the calender.
        startDate.click();
        waitSomeTime(3L);

        while (!calendar.getText().contains("May")) {
            //this will click till finding the moth April.
            waitSomeTime(3L);
            nextMonthClick.click();
            waitSomeTime(3L);
        }
        //Grab common attribute and put it into list and iterate
        //using List to retrieve the class contains day in it.
//        List<WebElement> dates = driver.findElements(By.className("day"));
//        List<WebElement> dates = daysTable1.findElements(By.tagName("div"));
        List<WebElement> dates1 = daysTable1.findElements(By.xpath("//td[@class='CalendarDay CalendarDay_1 CalendarDay__default CalendarDay__default_2']"));
        dates1.addAll(daysTable1.findElements(By.xpath("//td[@class=\"CalendarDay CalendarDay_1 CalendarDay__default CalendarDay__default_2 CalendarDay__firstDayOfWeek CalendarDay__firstDayOfWeek_3\"]")));
//        for(int i = 0; i< 15; i++ ) {
//            System.out.println("Weekend days :" + daysTable1.findElements(By.xpath("//td[@class=\"CalendarDay CalendarDay_1 CalendarDay__default CalendarDay__default_2 CalendarDay__firstDayOfWeek CalendarDay__firstDayOfWeek_3\"]")).get(i).getText());
//        }

//        for (WebElement day:dates1) {
//            System.out.println(day.getText());
//            if(day.getText().equals(date)) {
//                day.click();
//                break;
//            }
//        }

        //counting the number of days inside the day class.
        int count = daysTable1.findElements(By.xpath("//div[@class='CalendarDay_content CalendarDay_content__hover_as_highlight_color']")).size();

// iterating the days to find desired day which is equal to 23
        for (int i = 0; i < count; i++) {
            //We are getting the each day
//            String text = driver.findElements(By.className("day")).get(i).getText();
            String text = daysTable1.findElements(By.xpath("//div[@class='CalendarDay_content CalendarDay_content__hover_as_highlight_color']")).get(i).getText();

            //comparing the day number with desired one. when it match the 23,
            // it will execute and will break the loop.
            if (text.equals(date)) {
                daysTable1.findElements(By.xpath("//div[@class='CalendarDay_content CalendarDay_content__hover_as_highlight_color']")).get(i).click();
                logger.info("Start {} and {} are selected.",date, time);
            }
            if (text.equals(time)) {
                daysTable1.findElements(By.xpath("//div[@class='CalendarDay_content CalendarDay_content__hover_as_highlight_color']")).get(i).click();
                logger.info("Start {} and {} are selected.",date, time);
                break;
            }
        }
    }

    public void endDateAndTime(String date, String time) {
//        endDate.click();
//
//        while (!calendar.getText().contains("May")) {
//            waitSomeTime(3L);
//            endNextMonthClick.click();
//            waitSomeTime(3L);
//        }
//
//        List<WebElement> dates2 = daysTable2.findElements(By.xpath("//td[@class='CalendarDay CalendarDay_1 CalendarDay__default CalendarDay__default_2']"));
//        int count2 = daysTable2.findElements(By.xpath("//div[@class='CalendarDay_content CalendarDay_content__hover_as_highlight_color']")).size();
//
//        for (int i = 0; i < count2; i++) {
//            String text = daysTable2.findElements(By.xpath("//div[@class='CalendarDay_content CalendarDay_content__hover_as_highlight_color']")).get(i).getText();
//
//            if (text.equals(date)) {
//                daysTable2.findElements(By.xpath("//div[@class='CalendarDay_content CalendarDay_content__hover_as_highlight_color']")).get(i).click();
//                logger.info("End {} and {} are selected.",date, time);
//                break;
//            }
//        }
    }

    public void clickSearchButton() {
        searchButton.click();
        logger.info("User clicked search button.");
    }
}
