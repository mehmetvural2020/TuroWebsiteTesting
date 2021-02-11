package com.turo.pages;

import com.turo.stepdef.MainPageSteps;
import com.turo.utils.MyDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Watchable;

public class AdvancedSearch extends Base{
    Logger logger = LoggerFactory.getLogger(AdvancedSearch.class);
    MyDriver myDriver = new MyDriver();

    @FindBy(xpath = "//div[@class='searchFilter desktopMoreFilters']")
    public WebElement moreFiltersButton;

    @FindBy(xpath = "//div[@class='rc-slider-handle rc-slider-handle-1']")
    public WebElement left;

    @FindBy(xpath = "//div[@class='rc-slider-handle rc-slider-handle-1 rc-slider-handle-click-focused']")
    public WebElement leftSlider;

    @FindBy(xpath = "//div[@class='rc-slider-handle rc-slider-handle-2']")
    public WebElement right;

    @FindBy(xpath = "//div[@class='rc-slider-handle rc-slider-handle-2 rc-slider-handle-click-focused']")
    public WebElement rightSlider;

    @FindBy(xpath = "//div[@class='rc-slider-track rc-slider-track-1']")
    public WebElement slider;

    @FindBy(xpath = "//span[@class='rangeSliderField-label']")
    public WebElement yearText;





    public void moreFilterOptions() {
        moreFiltersButton.click();
        waitSomeTime(5L);
        scrollDown(yearText);

//        right.click();
//        waitSomeTime(5L);
        Actions move = new Actions(MyDriver.get());
        waitSomeTime(2L);
//        Action slider1 = (Action) move.dragAndDropBy(right, 0, -15).release().build();
//        waitSomeTime(2L);
//        ((Action) slider1).perform();


//        left.click();
        waitSomeTime(3L);


        Action actionLeft = (Action) move.dragAndDropBy(right, -15, 0).build();
        waitSomeTime(2L);
        ((Action) actionLeft).perform();

//        Actions move = new Actions(MyDriver.get());
        waitSomeTime(2L);
        Action actionLeft1 = (Action) move.dragAndDropBy(left, 430, 0).release().build();
        waitSomeTime(2L);
        ((Action) actionLeft1).perform();

        waitSomeTime(3L);
        yearText.click();
        MyDriver.get().navigate().refresh();
        moreFiltersButton.click();
        scrollDown(yearText);

//        Actions move = new Actions(MyDriver.get());
        waitSomeTime(5L);


    }


}
