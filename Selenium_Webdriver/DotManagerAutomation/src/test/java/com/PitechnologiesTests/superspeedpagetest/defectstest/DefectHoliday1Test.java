package com.PitechnologiesTests.superspeedpagetest.defectstest;

import com.PitechnologiesTests.basetest.BaseTwotest;
import com.PitechnologiesTests.page.obj.SuperSpeedPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static com.PitechnologiesTests.page.datafortest.ValidData.TYPE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

/**
 * Created by george.gligor on 2/13/2015.
 */
public class DefectHoliday1Test extends BaseTwotest {


    @AfterClass(description = "delete the holiday")
    public void deleteTheHolidayTest() {

        SuperSpeedPage superSpeedPage = PageFactory.initElements(driver, SuperSpeedPage.class);
        superSpeedPage.deleteHoliday().refresh()
                .clickPreviousMonthButton()
                .deleteHoliday()
                .refresh();
        driver.quit();
    }


    @Test(description = "The user create a holiday event with more days than he is available")
    public void createHolidayTest() throws InterruptedException {

        SuperSpeedPage superSpeedPage = PageFactory.initElements(driver, SuperSpeedPage.class);
        superSpeedPage.setType(TYPE)
                .setStartDateHoliday("1")
                .setEndDateHoliday("28")
                .insertHoliday();
        superSpeedPage.clickNextMonthButton()
                .refresh().setType(TYPE)
                .setStartDateHoliday("1")
                .setEndDateHoliday("28")
                .insertHoliday().refresh();
        assertThat(superSpeedPage.remainingHolidayDaysGetText(), greaterThan("0"));
    }
}
