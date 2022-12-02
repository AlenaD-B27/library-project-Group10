package com.LibraryCT.step_definitions;


import com.LibraryCT.utilities.ConfigurationReader;
import com.LibraryCT.utilities.DB_Util;
import com.LibraryCT.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;
// PLEASE DO NOT MAKE ANY CHANGES IN THIS CLASS WITHOUT COMMUNICATION WITH THE TEAM! THANK YOU!
// PLEASE DO NOT MAKE ANY CHANGES IN THIS CLASS WITHOUT COMMUNICATION WITH THE TEAM! THANK YOU!
// PLEASE DO NOT MAKE ANY CHANGES IN THIS CLASS WITHOUT COMMUNICATION WITH THE TEAM! THANK YOU!


public class Hooks {

    @Before
    public void setUp(){

        System.out.println("this is coming from BEFORE");
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get(ConfigurationReader.getProperty("library_url"));

    }

    @After
    public void tearDown(Scenario scenario){
        System.out.println("this is coming from AFTER");

        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }

        Driver.closeDriver();

    }

    @Before("@db")
    public void setupDB(){
        DB_Util.createConnection();
        System.out.println("connecting to database.....");

    }

    @After("@db")
    public void destroyDB(){
        DB_Util.destroy();
        System.out.println("closing connection....");

    }

    /*
    when we run different feature do we need to change tagName from hooks class? from before and after
        - if we have @db tag over feature/scenario this Hooks (After/Before with db) wil run
    Since we are doing database if you add @db over related features you dont need change anything from Hook class
     */

}
