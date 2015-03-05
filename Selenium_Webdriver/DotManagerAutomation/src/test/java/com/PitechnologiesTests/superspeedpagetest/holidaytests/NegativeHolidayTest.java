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
public class NegativeHolidayTest extends BaseTwotest {

    @Test(description = "create a holiday over an already holiday")
    public void createNewHolidayOverAnAlredyHolidayTest() throws InterruptedException {

        SuperSpeedPage superSpeedPage = PageFactory.initElements(driver, SuperSpeedPage.class);
        superSpeedPage.setType(TYPE)
                .setStartDateHoliday(START_DATE_NEW_HOLIDAY)
                .setEndDateHoliday(END_DATE_NEW_HOLIDAY)
                .insertHoliday()
                .refresh()
                .setType(TYPE)
                .createNewHolidayOverHoliday(START_DATE_NEW_HOLIDAY, END_DATE_NEW_HOLIDAY);
        Wait.waitForElementToBeVisible(superSpeedPage.getAlertHoliday(), driver, 25);
        assertThat(superSpeedPage.alertHolidayGetText(), equalTo(ALERT_HOLIDAY));
        superSpeedPage.clickSubmitHolidayAlertButton()
                .refresh();
        superSpeedPage.deleteHoliday();
    }

    @Test(description = "Create a holiday event over an already registered Log")
    public void createNewHolidayATest() {

        SuperSpeedPage superSpeedPage = PageFactory.initElements(driver, SuperSpeedPage.class);
        superSpeedPage.createValidLog(COMPANY, PROJECT, TASK, HOURS, DESCRIPTION, START_DATE_NEW_LOG, END_DATE_NEW_LOG);
        superSpeedPage.setType(TYPE)
                .setStartDateHoliday(START_DATE_NEW_HOLIDAY)
                .setEndDateHoliday(END_DATE_NEW_HOLIDAY)
                .insertHoliday();

        Wait.waitForElementToBeVisible(superSpeedPage.getAlertHoliday(), driver, 15);
        assertThat(superSpeedPage.alertHolidayGetText(), equalTo(ALERT_HOLIDAY));

        int i = Integer.parseInt(START_DATE_NEW_LOG);
        int j = Integer.parseInt(END_DATE_NEW_LOG);
        while (i < j + 1) {
            superSpeedPage.refresh();
            superSpeedPage.deleteLog("" + i);
            i++;
        }
    }

    @Test(description = "Create a holiday event for weekend")
    public void createNewHoliday1Test() {

        SuperSpeedPage superSpeedPage = PageFactory.initElements(driver, SuperSpeedPage.class);
        superSpeedPage.setType(TYPE)
                .setStartDateHoliday("14")
                .setEndDateHoliday("15")
                .insertHoliday();
        Wait.waitForElementToBeVisible(superSpeedPage.getHolidayError(), driver, 15);
        assertThat(superSpeedPage.getHolidayErrorMessage(), equalTo(HOLIDAY_ERROR));
    }

    @Test(description = "The \"end date\" selected by the user is smallest than the \"start date\"")
    public void createNewHoliday2Test() {

        SuperSpeedPage superSpeedPage = PageFactory.initElements(driver, SuperSpeedPage.class);
        superSpeedPage.setType(TYPE)
                .setStartDateHoliday("13")
                .setEndDateHoliday("12")
                .insertHoliday();
        assertThat(superSpeedPage.holidayDateErrorAlertText(), equalTo(HOLIDAY_DATE_ERROR));
    }

    @Test(description = "The /Type/ field is empty")
    public void createNewHoliday3Test() {

        SuperSpeedPage superSpeedPage = PageFactory.initElements(driver, SuperSpeedPage.class);
        superSpeedPage.setType2("")
                .setStartDateHoliday("13")
                .setEndDateHoliday("13")
                .insertHoliday();
        assertThat(superSpeedPage.getTextHolidayTypeError(), equalTo(REQUIRED_TYPE));
    }

    @Test(description = "create a holiday without the end start")
    public void createNewHoliday4Test() {

        SuperSpeedPage superSpeedPage = PageFactory.initElements(driver, SuperSpeedPage.class);
        superSpeedPage.setType(TYPE)
                .setStartDateHoliday("13")
                .setEndDateHoliday("")
                .insertHoliday();
        assertThat(superSpeedPage.getTextHolidayDateError(), equalTo(HOLIDAY_DATE_ERROR_1));
    }

    @Test(description = "create a holiday without the start date")
    public void createNewHoliday5Test() {

        SuperSpeedPage superSpeedPage = PageFactory.initElements(driver, SuperSpeedPage.class);
        superSpeedPage.setType(TYPE)
                .setStartDateHoliday("")
                .setEndDateHoliday("13")
                .insertHoliday();
        assertThat(superSpeedPage.getTextHolidayDateError(), equalTo(HOLIDAY_DATE_ERROR_1));
    }


}
