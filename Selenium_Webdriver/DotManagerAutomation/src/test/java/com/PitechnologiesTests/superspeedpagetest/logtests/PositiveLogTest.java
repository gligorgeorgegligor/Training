package com.PitechnologiesTests.superspeedpagetest.logtests;

import com.PitechnologiesTests.basetest.BaseTwotest;
import com.PitechnologiesTests.page.obj.SuperSpeedPage;
import com.PitechnologiesTests.page.Wait.utils.Wait;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static com.PitechnologiesTests.page.datafortest.ValidData.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


/**
 * Created by george.gligor on 2/9/2015.
 */
public class PositiveLogTest extends BaseTwotest {


    @AfterMethod
    public void deleteLog() {
        SuperSpeedPage superSpeedPage = PageFactory.initElements(driver, SuperSpeedPage.class);

        int i = Integer.parseInt(START_DATE_NEW_LOG);
        int j = Integer.parseInt(END_DATE_NEW_LOG);
        while (i < j + 1) {
            superSpeedPage.refresh();
            superSpeedPage.deleteAllLog("" + i);
            i++;
        }
    }

    @Test(description = "Create a new valid log")
    public void createNewLogTest() {

        SuperSpeedPage superSpeedPage = PageFactory.initElements(driver, SuperSpeedPage.class);
        superSpeedPage.createValidLog(COMPANY, PROJECT, TASK, HOURS, DESCRIPTION, START_DATE_NEW_LOG, END_DATE_NEW_LOG);
        Wait.waitForElementToBeVisible(superSpeedPage.getDescriptionTextInNewLog(), driver, 15);
        assertThat(superSpeedPage.descriptionTextInNewLogGetText(), equalTo("Framework"));
    }

    @Test(description = "Create a Log and each date selected from the report should be coloured in green because the field \"hours\" was completed with the value \"8\"")
    public void createCompleteLogTest() {

        SuperSpeedPage superSpeedPage = PageFactory.initElements(driver, SuperSpeedPage.class);
        superSpeedPage.createValidLog(COMPANY, PROJECT, TASK, "8", DESCRIPTION, START_DATE_NEW_LOG, END_DATE_NEW_LOG);

        Wait.waitForElementToBeVisible(superSpeedPage.getDescriptionTextInNewLog(), driver, 15);
        assertThat(superSpeedPage.checkIfLogIsComplete(), equalTo("complete"));
    }

    @Test(description = "Create a Log and each date selected from the report should be coloured in red because the field \"hours\" was completed with the value \"3\"")
    public void createIncompleteLogTest() {

        SuperSpeedPage superSpeedPage = PageFactory.initElements(driver, SuperSpeedPage.class);
        superSpeedPage.createValidLog(COMPANY, PROJECT, TASK, "3", DESCRIPTION, START_DATE_NEW_LOG, END_DATE_NEW_LOG);

        Wait.waitForElementToBeVisible(superSpeedPage.getDescriptionTextInNewLog(), driver, 15);
        assertThat(superSpeedPage.checkIfLogIsComplete(), equalTo("incomplete"));
    }

    @Test(description = "Create a Log and each date selected from the report should be coloured in yellow because the field \"hours\" was completed with the value \"10\"")
    public void createExtraTimeLogTest() {

        SuperSpeedPage superSpeedPage = PageFactory.initElements(driver, SuperSpeedPage.class);
        superSpeedPage.createValidLog(COMPANY, PROJECT, TASK, "10", DESCRIPTION, START_DATE_NEW_LOG, END_DATE_NEW_LOG);

        Wait.waitForElementToBeVisible(superSpeedPage.getDescriptionTextInNewLog(), driver, 15);
        assertThat(superSpeedPage.checkIfLogIsComplete(), equalTo("extratime"));
    }

    @Test(description = "create new log by clicking on existing log - check auto complete by clicking on edit button")
    public void checkAutoCompleteTest() throws InterruptedException {

        SuperSpeedPage superSpeedPage = PageFactory.initElements(driver, SuperSpeedPage.class);
        superSpeedPage.createValidLog(COMPANY, PROJECT, TASK, "10", DESCRIPTION, START_DATE_NEW_LOG, END_DATE_NEW_LOG);
        superSpeedPage.clickEditLog()
                .setDescription("frame");
        Thread.sleep(2000);
        superSpeedPage.clickSaveNewLog();
        Thread.sleep(1000);
        assertThat(superSpeedPage.descriptionTextInNewLogGetText(), equalTo("frame"));
    }

    @Test(description = "create new log by clicking on existing log - check auto complete")
    public void checkAutoComplete1Test() throws InterruptedException {

        SuperSpeedPage superSpeedPage = PageFactory.initElements(driver, SuperSpeedPage.class);
        superSpeedPage.createValidLog(COMPANY, PROJECT, TASK, "12", DESCRIPTION, START_DATE_NEW_LOG, END_DATE_NEW_LOG);
        superSpeedPage.refresh();
        superSpeedPage.clickdescriptionTextInNewLog()
                .clickLogTypeInfoRow();
        Thread.sleep(1000);
        superSpeedPage.setHours("8")
                .setDescription("frame")
                .clickToCreateNewLog();
        Thread.sleep(1000);
        assertThat(superSpeedPage.descriptionTextInNewLogGetText(), equalTo("frame"));
        int i = Integer.parseInt(CURRENT_START_DATE);
        int j = Integer.parseInt(CURRENT_START_DATE);
        while (i < j + 1) {
            superSpeedPage.refresh();
            superSpeedPage.deleteAllLog("" + i);
            i++;
        }

    }


    @Test(description = "check log hours (completed / total) on log creation")
    public void checkCompleteTotalTest() {

        SuperSpeedPage superSpeedPage = PageFactory.initElements(driver, SuperSpeedPage.class);
        superSpeedPage.createValidLog(COMPANY, PROJECT, TASK, HOURS, DESCRIPTION, START_DATE_NEW_LOG, END_DATE_NEW_LOG);
        Wait.waitForElementToBeVisible(superSpeedPage.getDescriptionTextInNewLog(), driver, 15);
        assertThat(superSpeedPage.getWorkedHoursText(), equalTo(HOURS));
    }
}
