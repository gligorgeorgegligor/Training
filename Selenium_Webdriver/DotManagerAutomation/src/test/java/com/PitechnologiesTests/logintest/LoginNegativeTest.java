package com.PitechnologiesTests.logintest;

import com.PitechnologiesTests.basetest.Basetest;
import com.PitechnologiesTests.page.obj.LoginPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static com.PitechnologiesTests.page.datafortest.ValidData.*;

/**
 * Created by george.gligor on 2/6/2015.
 */
public class LoginNegativeTest extends Basetest {


    @DataProvider(name = "loginNegativeTest")
    public Object[][] dataForLogin() {
        return new Object[][]{
                {"FONIC", "pitech12"}, //Login with a invalid username and an invalid password
                {"", ""}, //Login with empty values
                {USERNAME, "pitech"}, //Login with a valid username and an invalid password
                {"FONI", PASSWORD},// Login with a invalid username and an valid password
                {USERNAME, "piTech123"},// Login with a valid username and an invalid password(Case-sensitive)
        };
    }

    @Test(dataProvider = "loginNegativeTest", description = "Login with different username and password, for negative tests")
    public void loginFailedTest(String login, String password) {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.enterUsername(login)
                .enterPassword(password)
                .clickLoginButton();
        assertThat(loginPage.getLoginError(), containsString("Bad credentials"));
    }
}
