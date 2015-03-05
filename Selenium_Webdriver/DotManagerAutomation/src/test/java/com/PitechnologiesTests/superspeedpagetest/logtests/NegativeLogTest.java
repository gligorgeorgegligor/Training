package com.PitechnologiesTests.superspeedpagetest.logtests;

import com.PitechnologiesTests.basetest.BaseTwotest;
import com.PitechnologiesTests.page.obj.SuperSpeedPage;
import com.PitechnologiesTests.page.Wait.utils.Wait;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import static com.PitechnologiesTests.page.datafortest.ValidData.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by george.gligor on 2/9/2015.
 */
public class NegativeLogTest extends BaseTwotest {

    @Test(description = "Complete the \"hours\" field with value \"0\" and an error message is displayed")
    public void hoursFieldTest() {
        SuperSpeedPage superSpeedPage = PageFactory.initElements(driver, SuperSpeedPage.class);
        superSpeedPage.createValidLog(COMPANY, PROJECT, TASK, "0", DESCRIPTION, START_DATE_NEW_LOG, END_DATE_NEW_LOG)
                .clickToCreateNewLog();
        assertThat(superSpeedPage.hoursErrorGetText(), equalTo(HOUR_NOT_VALID));
    }

    @Test(description = "Complete the \"hours\" field with value \"25\" and an error message is displayed")
    public void hoursErrorFieldTest() {
        SuperSpeedPage superSpeedPage = PageFactory.initElements(driver, SuperSpeedPage.class);
        superSpeedPage.createValidLog(COMPANY, PROJECT, TASK, "25", DESCRIPTION, START_DATE_NEW_LOG, END_DATE_NEW_LOG)
                .clickToCreateNewLog();
        assertThat(superSpeedPage.hoursErrorGetText(), equalTo(HOUR_NOT_VALID));
    }

    @Test(description = "Complete the \"description\" field with \"empty \"  value and an error message is displayed")
    public void hoursEmptyFieldTest() throws InterruptedException {
        SuperSpeedPage superSpeedPage = PageFactory.initElements(driver, SuperSpeedPage.class);
        superSpeedPage.createValidLog(COMPANY, PROJECT, TASK, HOURS, "", START_DATE_NEW_LOG, END_DATE_NEW_LOG);
        Thread.sleep(2000);
        assertThat(superSpeedPage.getDescriptionTextErrorField(), equalTo(REQUIRED_DESCRIPTION));
    } //TODO sleep

    @Test(description = "Create a Log event over an already registered Holiday")
    public void logOverHolidayTest() throws InterruptedException {
        SuperSpeedPage superSpeedPage = PageFactory.initElements(driver, SuperSpeedPage.class);
        superSpeedPage.setType(TYPE)
                .setStartDateHoliday(START_DATE_NEW_HOLIDAY)
                .setEndDateHoliday(END_DATE_NEW_HOLIDAY)
                .insertHoliday();
        superSpeedPage.createValidLog(COMPANY, PROJECT, TASK, HOURS, DESCRIPTION, START_DATE_NEW_LOG, END_DATE_NEW_LOG);
        Wait.waitForElementToBeVisible(superSpeedPage.getAlertHoliday(), driver, 15);
        assertThat(superSpeedPage.alertHolidayGetText(), equalTo(ALERT_HOLIDAY1));
        superSpeedPage.clickSubmitHolidayAlertButton().refresh();
        superSpeedPage.deleteHoliday();
    }

    @Test(description = "Create multiple logs on the same day")
    public void CreateMultipleLogsOnTheSameDayTest() {
        SuperSpeedPage superSpeedPage = PageFactory.initElements(driver, SuperSpeedPage.class);
        superSpeedPage.createValidLog(COMPANY, PROJECT, TASK, HOURS, DESCRIPTION, START_DATE_NEW_LOG, END_DATE_NEW_LOG)
                .refresh()
                .createValidLog(COMPANY, PROJECT, TASK, "1", DESCRIPTION, START_DATE_NEW_LOG, END_DATE_NEW_LOG)
                .refresh()
                .createValidLog(COMPANY, PROJECT, TASK, "3", DESCRIPTION, START_DATE_NEW_LOG, END_DATE_NEW_LOG);
        assertThat(superSpeedPage.descriptionTextInNewLogGetText(), equalTo("Framework"));
        int i = Integer.parseInt(START_DATE_NEW_LOG);
        int j = Integer.parseInt(END_DATE_NEW_LOG);
        while (i < j + 1) {
            superSpeedPage.refresh();
            superSpeedPage.deleteAllLog("" + i);
            i++;
        }
    }

    @Test(description = "check cancel on log creation -must empty the fields")
    public void checkCancelOnLogCreationTest() throws InterruptedException {
        SuperSpeedPage superSpeedPage = PageFactory.initElements(driver, SuperSpeedPage.class);
        superSpeedPage.setCompany(COMPANY)
                .setProject(PROJECT)
                .setTask(TASK)
                .setStartDate(START_DATE_NEW_LOG)
                .setEndDate("9")
                .setHours(HOURS)
                .setDescription(DESCRIPTION)
                .clickCancelNewLog();
        assertThat(superSpeedPage.getSetDescriptionText(), equalTo(""));
        assertThat(superSpeedPage.getSetProjectFieldText(), equalTo(""));
        assertThat(superSpeedPage.getSetCompanyFieldText(), equalTo(""));
    }

    @Test(description = "try to create a new log with empty fields")
    public void createLogEmptyFieldsTest() {
        SuperSpeedPage superSpeedPage = PageFactory.initElements(driver, SuperSpeedPage.class);
        superSpeedPage.clickToCreateNewLog();
        assertThat(superSpeedPage.getDescriptionTextErrorField().contains("Required."), equalTo(true));
        assertThat(superSpeedPage.hoursErrorGetText().contains("Required."), equalTo(true));
        assertThat(superSpeedPage.taskErrorMessageGetText().contains("Task: required."), equalTo(true));
    }

    @Test(description = "try to create a new log with empty fields")
    public void createLogTskFieldEmptyTest() {
        SuperSpeedPage superSpeedPage = PageFactory.initElements(driver, SuperSpeedPage.class);
        superSpeedPage.setCompany(COMPANY)
                .setProject(PROJECT)
                .setStartDate(START_DATE_NEW_LOG)
                .setHours(HOURS)
                .setDescription("hhaha")
                .clickToCreateNewLog();
        assertThat(superSpeedPage.taskErrorMessageGetText().contains("Task: required."), equalTo(true));
    }
}