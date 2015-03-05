package com.PitechnologiesTests.superspeedpagetest.holidaytests;

import com.PitechnologiesTests.basetest.BaseTwotest;
import com.PitechnologiesTests.page.obj.SuperSpeedPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.PitechnologiesTests.page.datafortest.ValidData.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by george.gligor on 2/10/2015.
 */
public class DeleteHolidayTest extends BaseTwotest {

    @BeforeMethod
    public void createHoliday() {

        SuperSpeedPage superSpeedPage = PageFactory.initElements(driver, SuperSpeedPage.class);
        superSpeedPage.setType(TYPE)
                .setStartDateHoliday(START_DATE_NEW_HOLIDAY)
                .setEndDateHoliday(END_DATE_NEW_HOLIDAY)
                .insertHoliday();
    }

    @Test
    public void deleteHolidayTest() throws InterruptedException {
        SuperSpeedPage superSpeedPage = PageFactory.initElements(driver, SuperSpeedPage.class);
        superSpeedPage.deleteHoliday()
                .refresh();
        assertThat(superSpeedPage.remainingHolidayDaysGetText(), equalTo(superSpeedPage.totalHolidayDaysGetText()));
    }
}
