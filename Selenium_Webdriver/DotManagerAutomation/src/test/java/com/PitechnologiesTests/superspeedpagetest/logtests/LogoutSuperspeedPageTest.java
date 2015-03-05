package com.PitechnologiesTests.superspeedpagetest.logtests;

import com.PitechnologiesTests.basetest.BaseTwotest;
import com.PitechnologiesTests.page.obj.LoginPage;
import com.PitechnologiesTests.page.obj.SuperSpeedPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by george.gligor on 2/9/2015.
 */
public class LogoutSuperspeedPageTest extends BaseTwotest {
    @Test
    public void logoutTest() {
        SuperSpeedPage superSpeedPage = PageFactory.initElements(driver, SuperSpeedPage.class);
        superSpeedPage.logoutSuperspeedPage();
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        assertThat(loginPage.Url(), equalTo("http://testdotmanager.loki.pitechnologies.ro/login"));
    }
}