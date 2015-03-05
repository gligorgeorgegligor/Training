package com.PitechnologiesTests.basetest;

import com.PitechnologiesTests.page.obj.LoginPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

/**
 * Created by george.gligor on 2/9/2015.
 */
public abstract class BaseTwotest extends Basetest {

    @BeforeMethod
    public void setupPagAfterLogin() throws InterruptedException {

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.login("FONICA", "pitech123");
    }
}
