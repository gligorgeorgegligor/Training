package com.PitechnologiesTests.superspeedpagetest.defectstest;

import com.PitechnologiesTests.basetest.BaseTwotest;
import com.PitechnologiesTests.page.obj.SuperSpeedPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static com.PitechnologiesTests.page.datafortest.ValidData.CURRENT_START_DATE;
import static com.PitechnologiesTests.page.datafortest.ValidData.TYPE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

/**
 * Created by george.gligor on 2/19/2015.
 */
public class DefectHolidayYesterday extends BaseTwotest {


    /**
     * You shouldn't be able to create any type of holiday yesterday
     * @return
     */

    @AfterClass
    public void delete(){
        SuperSpeedPage superSpeedPage = PageFactory.initElements(driver, SuperSpeedPage.class);
        superSpeedPage.deleteHoliday().refresh();

        driver.quit();
    }

    @Test
    public void createNewHolidayTest() throws InterruptedException {

        SuperSpeedPage superSpeedPage = PageFactory.initElements(driver, SuperSpeedPage.class);

        superSpeedPage//.clickPreviousMonthButton()
                .setType(TYPE)
                .setStartDateHoliday("18")
                .setEndDateHoliday("18")
                .insertHoliday();
        assertThat("18 is smallest than current date", superSpeedPage.getTextSetHolidayStartDate(), greaterThan(CURRENT_START_DATE));
        Thread.sleep(5000);
    }
}
