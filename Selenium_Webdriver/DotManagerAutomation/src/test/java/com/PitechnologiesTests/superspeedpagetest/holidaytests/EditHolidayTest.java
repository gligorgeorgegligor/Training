package com.PitechnologiesTests.superspeedpagetest.holidaytests;

import com.PitechnologiesTests.basetest.BaseTwotest;
import com.PitechnologiesTests.page.obj.SuperSpeedPage;
import com.PitechnologiesTests.page.Wait.utils.Wait;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.PitechnologiesTests.page.datafortest.ValidData.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by george.gligor on 2/13/2015.
 */
public class EditHolidayTest extends BaseTwotest {

    @BeforeMethod(description = "create a holiday")
    public void createNewHolidayTest() {

        SuperSpeedPage superSpeedPage = PageFactory.initElements(driver, SuperSpeedPage.class);
        superSpeedPage.setType(TYPE)
                .setStartDateHoliday(START_DATE_NEW_HOLIDAY)
                .setEndDateHoliday(END_DATE_NEW_HOLIDAY)
                .insertHoliday();
    }

    @AfterMethod(description = "delete the holiday")
    public void deleteTheHolidayTest() {
        SuperSpeedPage superSpeedPage = PageFactory.initElements(driver, SuperSpeedPage.class);
        superSpeedPage.deleteHoliday();
    }

    @Test(description = "edit holiday change type")
    public void editHolidayChangeType() throws InterruptedException {
        SuperSpeedPage superSpeedPage = PageFactory.initElements(driver, SuperSpeedPage.class);
        Wait.waitForElementToBeVisible(superSpeedPage.getEditHolidayButton(), driver, 15);
        superSpeedPage.clickEditHolidayButton();
        superSpeedPage.setType1("Concediu fara salariu");
        Wait.waitForElementToBeVisible(superSpeedPage.getSaveHoliday(), driver, 15);
        superSpeedPage.clickSaveHoliday().refresh();
        assertThat(superSpeedPage.getTextholidayTypeInfoRow(), equalTo("Concediu fara salariu"));
    }

    @Test(description = "edit holiday change date")
    public void editHolidayChangeDate() throws InterruptedException {
        SuperSpeedPage superSpeedPage = PageFactory.initElements(driver, SuperSpeedPage.class);
        superSpeedPage.clickEditHolidayButton()
                .setType1("Concediu fara salariu")
                .setStartDateHoliday("2")
                .setEndDateHoliday("2");
        Wait.waitForElementToBeVisible(superSpeedPage.getSaveHoliday(), driver, 15);
        superSpeedPage.clickSaveHoliday().refresh();
        assertThat(superSpeedPage.getTextholidayTypeInfoRow(), equalTo("Concediu fara salariu"));
    }
}
