package com.PitechnologiesTests.logintest;

import com.PitechnologiesTests.basetest.Basetest;
import com.PitechnologiesTests.page.obj.LoginPage;
import com.PitechnologiesTests.page.obj.SuperSpeedPage;
import com.PitechnologiesTests.page.Wait.utils.Wait;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.PitechnologiesTests.page.datafortest.ValidData.PASSWORD;
import static com.PitechnologiesTests.page.datafortest.ValidData.USERNAME;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


/**
 * Created by george.gligor on 2/6/2015.
 */
public class LoginPositiveTest extends Basetest {


    @DataProvider(name = "loginPositive")
    public Object[][] dataForLogin() {
        return new Object[][]{
                {USERNAME, PASSWORD},//Login with a valid username and an valid password
                {USERNAME, PASSWORD},//Login with a valid username(Case-sensitive) and an valid password
        };
    }

    @Test(dataProvider = "loginPositive")
    public void loginTest(String login, String password) {

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.enterUsername(login)
                .enterPassword(password)
                .clickLoginButton();
        SuperSpeedPage superSpeedPage = PageFactory.initElements(driver, SuperSpeedPage.class);
        Wait.waitForElementToBeVisible(superSpeedPage.getnewLogText(), driver, 15);
        assertThat(superSpeedPage.isNewLogTextDisplayed(), equalTo(true));
    }
}
