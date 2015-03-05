package com.PitechnologiesTests.superspeedpagetest.defectstest;

import com.PitechnologiesTests.basetest.BaseTwotest;
import com.PitechnologiesTests.page.obj.SuperSpeedPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static com.PitechnologiesTests.page.datafortest.ValidData.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by george.gligor on 2/18/2015.
 */
public class DefectLog1Test extends BaseTwotest {


    @AfterClass
    public void deleteLog() {
        SuperSpeedPage superSpeedPage = PageFactory.initElements(driver, SuperSpeedPage.class);
        int i = Integer.parseInt("11");
        int j = Integer.parseInt("12");
        while (i < j + 1) {
            superSpeedPage.refresh();
            superSpeedPage.deleteAllLog("" + i);
            i++;
        }
        superSpeedPage.refresh();
        driver.quit();
    }

    @Test(description = "Create a log and delete it , notice that you cannot delete more than 1 day")
    public void tryToCreateLogTestAndDeleteItTest() {
        SuperSpeedPage superSpeedPage = PageFactory.initElements(driver, SuperSpeedPage.class);
        superSpeedPage.createValidLog(COMPANY, PROJECT, TASK, HOURS, DESCRIPTION, "11", "13");


        int i = Integer.parseInt(START_DATE_NEW_LOG);
        int j = Integer.parseInt(END_DATE_NEW_LOG);
        while (i < j + 1) {
            superSpeedPage.refresh();
            superSpeedPage.deleteLog("" + i);
            i++;
        }
        assertThat(superSpeedPage.getDescriptionTextInNewLog().isDisplayed(), equalTo(false));
    }
}
