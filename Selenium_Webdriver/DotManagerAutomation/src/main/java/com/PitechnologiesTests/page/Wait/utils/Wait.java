package com.PitechnologiesTests.page.Wait.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by george.gligor on 2/11/2015.
 */
public class Wait {

    public static void waitForElementToBeVisible(WebElement element, WebDriver driver, int sec) {
        WebDriverWait wWait = new WebDriverWait(driver, sec);
        WebElement element1 = wWait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementToBeClickable(WebElement element, WebDriver driver, int sec) {
        WebDriverWait wWait = new WebDriverWait(driver, sec);
        WebElement element1 = wWait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
