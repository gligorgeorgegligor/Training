package com.PitechnologiesTests.superspeedpagetest.logtests;

import com.PitechnologiesTests.basetest.BaseTwotest;
import com.PitechnologiesTests.page.obj.SuperSpeedPage;
import com.PitechnologiesTests.page.Wait.utils.Wait;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import static com.PitechnologiesTests.page.datafortest.ValidData.*;

/**
 * Created by george.gligor on 2/10/2015.
 */
public class EditLogTest extends BaseTwotest {

    @BeforeMethod
    public void createLogTest() {

        SuperSpeedPage superSpeedPage = PageFactory.initElements(driver, SuperSpeedPage.class);
        superSpeedPage.createValidLog(COMPANY, PROJECT, TASK, HOURS, DESCRIPTION, START_DATE_NEW_LOG, END_DATE_NEW_LOG);
    }

    @AfterMethod
    public void deleteLog() {
        SuperSpeedPage superSpeedPage = PageFactory.initElements(driver, SuperSpeedPage.class);

        int i = Integer.parseInt(START_DATE_NEW_LOG);
        int j = Integer.parseInt(END_DATE_NEW_LOG);
        while (i < j + 1) {
            superSpeedPage.refresh();
            superSpeedPage.deleteLog("" + i);
            i++;
        }
    }

    @Test(description = "After the log was successfully created and the user clicks on the \"-\" button \" +\n" +
            "            \"and the report should compress and displayed fewer options")
    public void editLogHideButtonTest() {

        SuperSpeedPage superSpeedPage = PageFactory.initElements(driver, SuperSpeedPage.class);
        Wait.waitForElementToBeVisible(superSpeedPage.getDescriptionTextInNewLog(), driver, 15);
        superSpeedPage.clickOnHideButton();
        assertThat(superSpeedPage.deleteLogButtonIsDisplayed(), equalTo(false));
    }

    @Test(description = "After the log was successfully created and the user clicks on the \"-\" button \" +\n" +
            "            \"and the report should compress and displayed fewer options, than the user clicks on the \"+\" button to reactivate all the options")
    public void editLogShowButtonTest() {

        SuperSpeedPage superSpeedPage = PageFactory.initElements(driver, SuperSpeedPage.class);
        Wait.waitForElementToBeVisible(superSpeedPage.getDescriptionTextInNewLog(), driver, 15);
        superSpeedPage.clickOnHideButton();
        superSpeedPage.clickOnShowButton();
        assertThat(superSpeedPage.deleteLogButtonIsDisplayed(), equalTo(true));
    }

    @Test(description = "Click on the \"next button\" for the next month")
    public void editLogNextMonthTest() {
        SuperSpeedPage superSpeedPage = PageFactory.initElements(driver, SuperSpeedPage.class);
        superSpeedPage.clickNextMonthButton();
        assertThat(superSpeedPage.getUrlText(), equalTo("http://testdotmanager.loki.pitechnologies.ro/superspeed/report/index/2015/3"));
        superSpeedPage.clickPreviousMonthButton();
    }

    @Test(description = "Click on the \"previous button\" for the previously month")
    public void editLogPreviouslyMonthTest() {
        SuperSpeedPage superSpeedPage = PageFactory.initElements(driver, SuperSpeedPage.class);
        superSpeedPage.clickPreviousMonthButton();
        assertThat(superSpeedPage.getUrlText(), equalTo("http://testdotmanager.loki.pitechnologies.ro/superspeed/report/index/2015/1"));
        superSpeedPage.clickNextMonthButton();
    }

    @Test(description = "Check the \"+7days\" extend report button")
    public void editLogPlusSevenDaysExtendButtonTest() {
        SuperSpeedPage superSpeedPage = PageFactory.initElements(driver, SuperSpeedPage.class);
        superSpeedPage.clickViewMore();
        Wait.waitForElementToBeVisible(superSpeedPage.getRemoveMore(), driver, 15);
        assertThat(superSpeedPage.getRemoveMore().isDisplayed(), equalTo(true));
    }

    @Test(description = "Check the \"+7days\" extend report remove button")
    public void editLogPlusSevenDaysRemoveButtonTest() {
        SuperSpeedPage superSpeedPage = PageFactory.initElements(driver, SuperSpeedPage.class);
        superSpeedPage.clickViewMore();
        Wait.waitForElementToBeVisible(superSpeedPage.getRemoveMore(), driver, 15);
        superSpeedPage.clickRemoveMore();
        Wait.waitForElementToBeVisible(superSpeedPage.getViewMore(), driver, 15);
        assertThat(superSpeedPage.getViewMore().isDisplayed(), equalTo(true));
    }

    @Test(description = "Click on the edit log")
    public void editLogButtonTest() {
        SuperSpeedPage superSpeedPage = PageFactory.initElements(driver, SuperSpeedPage.class);
        superSpeedPage.clickEditLog();
        Wait.waitForElementToBeVisible(superSpeedPage.getDescriptionTextInNewLog(), driver, 15);
        assertThat(superSpeedPage.getDescriptionTextInNewLog().isDisplayed(), equalTo(true));
    }
}
