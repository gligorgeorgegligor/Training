package com.PitechnologiesTests.superspeedpagetest.defectstest;

import com.PitechnologiesTests.basetest.BaseTwotest;
import com.PitechnologiesTests.page.obj.SuperSpeedPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static com.PitechnologiesTests.page.datafortest.ValidData.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThan;

/**
 * Created by george.gligor on 2/12/2015.
 */
public class DefectLogTest extends BaseTwotest {


    @AfterClass
    public void deleteLog() throws InterruptedException {
        SuperSpeedPage superSpeedPage = PageFactory.initElements(driver, SuperSpeedPage.class);
        superSpeedPage.refresh();
        int i = Integer.parseInt(START_DATE_NEW_LOG);
        int j = Integer.parseInt(END_DATE_NEW_LOG);
        while (i < j + 1) {
            superSpeedPage.refresh();
            superSpeedPage.deleteAllLog("" + i);
            i++;
        }
        driver.quit();
    }

    @Test(description = "Create a Log event over an already registered Log event with the amount of \"hours\" more than \"24\"")
    public void tryToCreateLogTest() {
        SuperSpeedPage superSpeedPage = PageFactory.initElements(driver, SuperSpeedPage.class);
        superSpeedPage.createValidLog(COMPANY, PROJECT, TASK, HOURS, DESCRIPTION, START_DATE_NEW_LOG, END_DATE_NEW_LOG)
                .refresh()
                .createValidLog(COMPANY, PROJECT, TASK, "17", DESCRIPTION, START_DATE_NEW_LOG, END_DATE_NEW_LOG)
                .refresh();

        assertThat(superSpeedPage.getTotalLogHoursContentText(START_DATE_NEW_LOG), lessThan(25));
    }
}
