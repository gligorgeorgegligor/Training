package com.PitechnologiesTests.page.obj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by george.gligor on 3/2/2015.
 */
public class SocialPage {

    final WebDriver driver;

    public SocialPage(WebDriver driver) {
        this.driver = driver;
        if (!(driver.getPageSource().contains("Events"))) {
            throw new IllegalStateException("This is not the social page");
        }
    }

    public List<WebElement> getAlllPageLinks() {
        List<WebElement> links = driver.findElements(By.tagName("a"));
        for (int i = 1; i < links.size(); i++) {
        }
        return links;
    }

}
