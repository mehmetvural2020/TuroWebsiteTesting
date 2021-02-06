package com.turo.stepdef;

import com.turo.utils.ConfigurationReader;
import com.turo.utils.MyDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class Hooks {
    Logger logger = LoggerFactory.getLogger(Hooks.class);

    @Before
    public void setup() {
        logger.info("##### SETUP STARTED (HOOK) ######");
        MyDriver.get().manage().window().maximize();
        MyDriver.get().get(ConfigurationReader.getProperty("baseUrl"));
        MyDriver.get().manage().deleteAllCookies();
        MyDriver.get().navigate().refresh();

        MyDriver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @After
    public void after(Scenario scenario){
        if(scenario.isFailed()){
            logger.error("!!!!Test Failed! check the screenshot!!!!");
            byte[] screenshot= ((TakesScreenshot)MyDriver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","Screenshot");
            //scenario.embed(screenshot,"image/png"); versiyon 4.7.4

        }else {
            logger.info("Test Completed");
        }
        logger.info("###### END OF TESTS #####");

        MyDriver.close();
    }
}
