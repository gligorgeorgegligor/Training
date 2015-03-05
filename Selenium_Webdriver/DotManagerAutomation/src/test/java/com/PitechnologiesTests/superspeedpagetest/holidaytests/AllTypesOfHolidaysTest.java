package com.PitechnologiesTests.superspeedpagetest.holidaytests;

import com.PitechnologiesTests.basetest.BaseTwotest;
import com.PitechnologiesTests.page.obj.SuperSpeedPage;
import com.PitechnologiesTests.page.Wait.utils.Wait;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.PitechnologiesTests.page.datafortest.ValidData.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by george.gligor on 2/13/2015.
 */
public class AllTypesOfHolidaysTest extends BaseTwotest {

    @DataProvider(name = "allTypesOfHolidayTest")
    public Object[][] dataForLogin() {
        return new Object[][]{
                {TYPE}, //Create a holiday with type "Concediu de odihna"
                {"Concediu fara salariu"}, //Create a holiday with type "Concediu fara salariu"
                {"Concediu medical"}, //Create a holiday with type "Concediu medical"
                {"Evenimente familiale"},//Create a holiday with type "Evenimente familiale"
        };
    }

    @Test(dataProvider = "allTypesOfHolidayTest", description = "create all types of holidays")
    public void createNewHolidayTest(String TYPE) {

        SuperSpeedPage superSpeedPage = PageFactory.initElements(driver, SuperSpeedPage.class);
        superSpeedPage.setType(TYPE)
                .setStartDateHoliday(START_DATE_NEW_HOLIDAY)
                .setEndDateHoliday(END_DATE_NEW_HOLIDAY)
                .insertHoliday()
                .refresh();
        Wait.waitForElementToBeVisible(superSpeedPage.getPrintHolidayButton(), driver, 30);
        assertThat(superSpeedPage.getPrintHolidayButton().isDisplayed(), equalTo(true));
        superSpeedPage.deleteHoliday();
    }
}
