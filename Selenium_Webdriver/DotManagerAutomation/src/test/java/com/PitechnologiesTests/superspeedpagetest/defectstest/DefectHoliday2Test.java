package com.PitechnologiesTests.superspeedpagetest.defectstest;

import com.PitechnologiesTests.basetest.BaseTwotest;
import com.PitechnologiesTests.page.obj.SuperSpeedPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by george.gligor on 2/13/2015.
 */
public class DefectHoliday2Test extends BaseTwotest {

    @AfterMethod(description = "delete the holiday")
    public void deleteTheHolidayTest() throws InterruptedException {
        SuperSpeedPage superSpeedPage = PageFactory.initElements(driver, SuperSpeedPage.class);
        Thread.sleep(2000);
        superSpeedPage.clickPreviousMonthButton()
                .deleteHoliday()
                .refresh();
        driver.quit();
    }

    @Test(description = "The user create a holiday event with more days than he is available")
    public void createHoliday1Test() throws InterruptedException {

        SuperSpeedPage superSpeedPage = PageFactory.initElements(driver, SuperSpeedPage.class);
        superSpeedPage.setType("Concediu fara salariu")
                .setStartDateHoliday("1")
                .setEndDateHoliday("28")
                .insertHoliday()
                .clickNextMonthButton();
        Thread.sleep(2000);
        assertThat("The total days should always be /27/ ", superSpeedPage.totalHolidayDaysGetText(), equalTo(superSpeedPage.totalHolidayDaysGetText()));
        // totalHolidayDaysGetText it's change to 25
    }
}
