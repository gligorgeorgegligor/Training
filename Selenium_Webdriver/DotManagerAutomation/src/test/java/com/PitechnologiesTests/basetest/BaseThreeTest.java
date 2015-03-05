package com.PitechnologiesTests.basetest;

import com.PitechnologiesTests.page.obj.SuperSpeedPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

/**
 * Created by george.gligor on 3/3/2015.
 */
public class BaseThreeTest extends BaseTwotest {

    @BeforeMethod
    public void setupSocialPage() {
        SuperSpeedPage superSpeedPage = PageFactory.initElements(driver, SuperSpeedPage.class);
        superSpeedPage.clickOnSocialLinkButton();

        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
    }
}