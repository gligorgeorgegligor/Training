package com.GarminTests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class LoginTest {

    @Test
    public void startWebDriverr(){

        WebDriver driver = new FirefoxDriver();

        driver.get("https://connect.garmin.com/en-US/");

        driver.close();
        driver.quit();
    }

}
