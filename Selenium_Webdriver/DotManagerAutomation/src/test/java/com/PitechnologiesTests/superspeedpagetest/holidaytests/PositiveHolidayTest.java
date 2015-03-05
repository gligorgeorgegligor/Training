package com.PitechnologiesTests.superspeedpagetest.holidaytests;

import com.PitechnologiesTests.basetest.BaseTwotest;
import com.PitechnologiesTests.page.obj.SuperSpeedPage;
import com.PitechnologiesTests.page.Wait.utils.Wait;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import static com.PitechnologiesTests.page.datafortest.ValidData.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by george.gligor on 2/10/2015.
 */
public class PositiveHolidayTest extends BaseTwotest {

    @Test(description = "create a new valid holiday")
    public void createNewHolidayTest() {

        SuperSpeedPage superSpeedPage = PageFactory.initElements(driver, SuperSpeedPage.class);
        superSpeedPage.setType(TYPE)
                .setStartDateHoliday(START_DATE_NEW_HOLIDAY)
                .setEndDateHoliday(END_DATE_NEW_HOLIDAY)
                .insertHoliday();
        Wait.waitForElementToBeVisible(superSpeedPage.getPrintHolidayButton(), driver, 15);
        assertThat(superSpeedPage.getPrintHolidayButton().isDisplayed(), equalTo(true));
        superSpeedPage.deleteHoliday();
    }

    @Test(description = "create a holiday and delete it")
    public void createNewHolidayAndDeleteItTest() {

        SuperSpeedPage superSpeedPage = PageFactory.initElements(driver, SuperSpeedPage.class);
        superSpeedPage.setType(TYPE)
                .setStartDateHoliday(START_DATE_NEW_HOLIDAY)
                .setEndDateHoliday(END_DATE_NEW_HOLIDAY)
                .insertHoliday()
                .deleteHoliday();
        assertThat(superSpeedPage.printHolidayButtonIsDisplayed(), equalTo(false));
    }

    @Test(description = "cancel a holiday")
    public void cancelHolidayTest() throws InterruptedException {

        SuperSpeedPage superSpeedPage = PageFactory.initElements(driver, SuperSpeedPage.class);
        superSpeedPage.setType(TYPE)
                .setStartDateHoliday(START_DATE_NEW_HOLIDAY)
                .setEndDateHoliday(END_DATE_NEW_HOLIDAY)
                .clickCancelHoliday();
        assertThat(superSpeedPage.getTextTypeField(), equalTo(""));
    }


    @Test(description = "create a new holiday and check the remaining days")
    public void createNewHoliday1Test() {

        SuperSpeedPage superSpeedPage = PageFactory.initElements(driver, SuperSpeedPage.class);
        int totalDays = Integer.parseInt(superSpeedPage.remainingHolidayDaysGetText());

        superSpeedPage.setType(TYPE)
                .setStartDateHoliday("9")
                .setEndDateHoliday("13")
                .insertHoliday()
                .refresh();
        int startDate = Integer.parseInt("9");
        int endDate = Integer.parseInt("13");
        int daysOfHoliday = (endDate + 1) - startDate;
        int expectedDaysRemaining = totalDays - daysOfHoliday;
        String expected = "" + expectedDaysRemaining;

        assertThat(superSpeedPage.remainingHolidayDaysGetText(), equalTo(expected));
        superSpeedPage.deleteHoliday();
    }


    @Test(description = "create a new holiday /Concediu medical/and check the remaining days")
    public void createNewHoliday2Test() {

        SuperSpeedPage superSpeedPage = PageFactory.initElements(driver, SuperSpeedPage.class);
        superSpeedPage.setType("Concediu medical")
                .setStartDateHoliday(START_DATE_NEW_HOLIDAY)
                .setEndDateHoliday(END_DATE_NEW_HOLIDAY)
                .insertHoliday()
                .refresh();
        assertThat(superSpeedPage.remainingHolidayDaysGetText(), equalTo(superSpeedPage.totalHolidayDaysGetText()));
        superSpeedPage.deleteHoliday();
    }

    @Test(description = "create a new holiday /Evenimente familiale/and check the remaining days")
    public void createNewHoliday3Test() {

        SuperSpeedPage superSpeedPage = PageFactory.initElements(driver, SuperSpeedPage.class);
        superSpeedPage.setType("Evenimente familiale")
                .setStartDateHoliday(START_DATE_NEW_HOLIDAY)
                .setEndDateHoliday(END_DATE_NEW_HOLIDAY)
                .insertHoliday()
                .refresh();
        assertThat(superSpeedPage.remainingHolidayDaysGetText(), equalTo(superSpeedPage.totalHolidayDaysGetText()));
        superSpeedPage.deleteHoliday();
    }
}
