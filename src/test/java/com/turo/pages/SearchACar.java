package com.turo.pages;

import com.turo.stepdef.MainPageSteps;
import com.turo.utils.MyDriver;
import org.apache.poi.xwpf.usermodel.BodyElementType;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.openqa.selenium.By.xpath;

public class SearchACar extends Base {
    Logger logger = LoggerFactory.getLogger(MainPageSteps.class);
    MyDriver myDriver = new MyDriver();

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
    public WebElement dateTable;

    @FindBy(xpath = "//div[@class='searchFilterBar']//div[1]//button[1]")
    public WebElement sortBy;

    @FindBy(css = "label[for='styledRadioButtonField-sortType-PRICE_LOW']")
    public WebElement lowToHigh;

    @FindBy(xpath = "//input[@type=\"radio\"]")
    public WebElement radioButton;

    @FindBy(xpath = "//div[@class='styledRadioButton styledRadioButton--purple is-selected']")
    public WebElement selectedRadioButton;

    @FindBy(xpath = "//button[@data-test='searchFilterPopupDesktop-submitButton']")
    public WebElement applyButton;

    @FindBy(xpath = "//div[@class='searchFilterBar']//div[2]//button[1]")
    public WebElement price;


    @FindBy(css = "div[class='rc-slider-handle rc-slider-handle-1']")
    public WebElement leftSlider;

    @FindBy(xpath = "//div[@class='rc-slider-handle rc-slider-handle-2']")
    public WebElement rightSlider;

    @FindBy(css = "button[class='buttonSchumi buttonSchumi--medium buttonSchumi--purple searchFilterPopupDesktop-submitButton']")
    public WebElement viewResult;

    @FindBy(xpath = "//div[@class='searchFilterBar']//div[3]//button[1]")
    public WebElement bookInstantly;

    @FindBy(css = "button[class='buttonSchumi buttonSchumi--medium buttonSchumi--purple searchFilterPopupDesktop-submitButton']")
    public WebElement viewResult2;

    @FindBy(xpath = "//div[@class='searchFilterBar']//div[4]//button[1]")
    public WebElement deliveryButton;

    @FindBy(xpath = "//div[@role='slider']")
    public WebElement deliveryRightSlider;

    @FindBy(css = "button[class='buttonSchumi buttonSchumi--medium buttonSchumi--purple searchFilterPopupDesktop-submitButton']")
    public WebElement viewResult3;

    @FindBy(xpath = "//span[contains(text(), 'Distance included')]")
    public WebElement distanceButton;

    @FindBy(css = "label[for='styledRadioButtonField-minimumMileage-200']")
    public WebElement distance200miles;

    @FindBy(css = "button[class='buttonSchumi buttonSchumi--medium buttonSchumi--purple searchFilterPopupDesktop-submitButton']")
    public WebElement applyButton1;

    @FindBy(xpath = "//div[@class='searchFilter desktopMoreFilters']")
    public WebElement moreFiltersButton;

    @FindBy(css = "label[for='allStarHost'] span[class='styledCheckbox-label']")
    public WebElement allStarHost;

    @FindBy(xpath = "//div[@class='searchFilterBar']//div[7]//div[2]//div[1]//span[1]")
    public WebElement vehicleTypesButton;

    @FindBy(xpath = "//span[@class='imageMultiSelectOption-icon typeIcon typeIcon--car']")
    public WebElement car;

    @FindBy(xpath = "//select[@id='makes']")
    public WebElement vehicleMakes;

    @FindBy(xpath = "//option[@value='Lexus']")
    public WebElement lexus;




    public void enterLocation(String location) {
        waitSomeTime(2L);
        locationUser.click();
        locationUser.sendKeys(location);
        selectLocation.click();
        logger.info("{} is entered.", location);
    }

    public void startDateAndTime(String dateFrom, String dateUntil) {
        //Clicking the calender element to open the calender.
        startDate.click();
        waitSomeTime(3L);

        while (!calendar.getText().contains("May 2021")) {
            //this will click till finding the moth April.
            waitSomeTime(3L);
            nextMonthClick.click();
            waitSomeTime(3L);
        }

        // SOLUTION 1 : Select date UNTIL - FROM and click

        //Grab common attribute and put it into list and iterate
        //using List to retrieve the class contains day in it.

        List<WebElement> dates2 = daysTable1.findElements(By.tagName("td"));

        for (WebElement day : dates2) {
//            System.out.println(day.getText());
            waitSomeTime(1L);
            if (day.getText().equals(dateFrom)) {

                day.click();
                logger.info("Start date {} is selected.", dateFrom);
            }
            waitSomeTime(3L);
            if (day.getText().equals(dateUntil)) {
                day.click();
                logger.info("End date {} is selected.", dateUntil);
                break;
            }
        }
        // SOLUTION 2 : Select date UNTIL - FROM and click
//        //counting the number of days inside the day class.
//        int count = daysTable1.findElements(By.xpath("//div[@class='CalendarDay_content CalendarDay_content__hover_as_highlight_color']")).size();
//
//        // iterating the days to find desired day which is equal to 23
//        for (int i = 0; i < count; i++) {
//            //We are getting the each day
//            String text = daysTable1.findElements(By.xpath("//div[@class='CalendarDay_content CalendarDay_content__hover_as_highlight_color']")).get(i).getText();
//
//            //comparing the day number with desired one. when it match the 23,
//            // it will execute and will break the loop.
//            //Select date FROM and click.
//            if (text.equals(dateFrom)) {
//                daysTable1.findElements(By.xpath("//div[@class='CalendarDay_content CalendarDay_content__hover_as_highlight_color']")).get(i).click();
//                logger.info("Start date {} is selected.",dateFrom);
//            }
//            //Select date UNTIL and click.
//            if (text.equals(dateUntil)) {
//                daysTable1.findElements(By.xpath("//div[@class='CalendarDay_content CalendarDay_content__hover_as_highlight_color']")).get(i).click();
//                logger.info("End date {} is selected.", dateUntil);
//                break;
//            }
//        }
    }

    public void endDateAndTime(String date, String time) {

    }

    public void clickSearchButton() {
        searchButton.click();
        logger.info("User clicked search button.");
    }

    public void clickOnSortBy() {
        waitSomeTime(5L);
        sortBy.click();
        lowToHigh.click();
        System.out.println(lowToHigh.getText() + " is Selected...");
        applyButton.click();
        waitSomeTime(2L);
    }


    public void clickOnPrice() {

        price.click();
        Actions move = new Actions(MyDriver.get());
        // We can get coordinate with coordinates extension in google chrome.
        // Left slider move to 50$. x coordinate is moving 68 pixel to right from left.
        Action actionLeft = move.dragAndDropBy(leftSlider, 68, 234).build();
        actionLeft.perform();

        // Right slider move to 200$. x coordinate is moving -90 pixel   to left from right.
        Action actionRight =  move.dragAndDropBy(rightSlider, -90, 234).build();
        actionRight.perform();

        viewResult.click();
        waitSomeTime(2L);
    }

    public void clickOnBookInstant() {
        bookInstantly.click();
        viewResult2.click();
        waitSomeTime(2L);
    }

    public void adjustDeliveryOption() {
        deliveryButton.click();
        Actions move = new Actions(MyDriver.get());

        Action actionRight =  move.dragAndDropBy(deliveryRightSlider, -105, 234).build();
        actionRight.perform();
        waitSomeTime(2L);
        viewResult3.click();
    }

    public void distanceIncludedOption() {
        waitSomeTime(2L);
        distanceButton.click();
        distance200miles.click();
        waitSomeTime(2L);
        applyButton1.click();
    }

    public void moreFilterOptions() {
        moreFiltersButton.click();
        allStarHost.click();
    }

    public void selectCarAndVehicleMakes(String vehicle_makes) {
        vehicleTypesButton.click();
        car.click();

//        vehicleMakes.findElement();
        waitSomeTime(2L);
        Select select = new Select(vehicleMakes);
        scrollDown(vehicleMakes);
        waitSomeTime(2L);
        select.selectByVisibleText(vehicle_makes);
    }
}



