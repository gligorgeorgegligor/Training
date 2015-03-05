package com.PitechnologiesTests.superspeedpagetest.defectstest;

import com.PitechnologiesTests.basetest.BaseTwotest;
import com.PitechnologiesTests.page.obj.SuperSpeedPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by george.gligor on 2/19/2015.
 */
public class DefectHoliday3Test extends BaseTwotest {

    @AfterClass(description = "delete the holiday")

    public void deleteTheHolidayTest() throws Exception {
        SuperSpeedPage superSpeedPage = PageFactory.initElements(driver, SuperSpeedPage.class);
        superSpeedPage.deleteHoliday()
                .refresh();
        driver.quit();
    }

    /**
     * When the user create a "Concediu fara salariu" holiday for 1 week the remaining days are less than 1
     * @throws InterruptedException
     */

    @Test(description = "The user create a holiday event /Concediu fara salariu/ and check the remaining days")
    public void createHoliday1Test() throws InterruptedException {

        SuperSpeedPage superSpeedPage = PageFactory.initElements(driver, SuperSpeedPage.class);
        superSpeedPage.setType("Concediu fara salariu")
                .setStartDateHoliday("1")
                .setEndDateHoliday("9")
                .insertHoliday();
        Thread.sleep(5000);
        assertThat("The remaining days should be equal to total days", superSpeedPage.remainingHolidayDaysGetText(), equalTo(superSpeedPage.totalHolidayDaysGetText()));

    }
}
