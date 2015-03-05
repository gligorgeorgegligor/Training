package com.PitechnologiesTests.superspeedpagetest.defectstest;

import com.PitechnologiesTests.basetest.BaseTwotest;
import com.PitechnologiesTests.page.Wait.utils.Wait;
import com.PitechnologiesTests.page.obj.SuperSpeedPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by george.gligor on 2/19/2015.
 */
public class Plus7DaysTest extends BaseTwotest {

    /**
     * only manual 3 bug-uri ->check test cases -> check last year
     */
    @Test(description = "Check the \"+7days\" extend report button")
    public void editLog4Test() {
        SuperSpeedPage superSpeedPage = PageFactory.initElements(driver, SuperSpeedPage.class);
        superSpeedPage.clickViewMore().clickViewMore().clickViewMore().clickViewMore().clickViewMore()
                .clickViewMore().clickViewMore().clickViewMore().clickViewMore().clickViewMore().clickViewMore()
                .clickViewMore().clickViewMore().clickViewMore();
        Wait.waitForElementToBeVisible(superSpeedPage.getRemoveMore(), driver, 15);
        assertThat(superSpeedPage.getRemoveMore().isDisplayed(), equalTo(true));
    }
}
