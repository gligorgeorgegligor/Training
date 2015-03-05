package com.PitechnologiesTests.basetest;

import com.PitechnologiesTests.page.datafortest.ValidData;
import com.PitechnologiesTests.page.environment.Env;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static com.PitechnologiesTests.page.datafortest.ValidData.*;


/**
 * Created by george.gligor on 2/6/2015.
 */
public abstract class Basetest {

    public WebDriver driver;

    @BeforeMethod
    public void setupPag() {

        Env.loadProp();
        setDriver(ValidData.BROWSER, ValidData.URL);
    }

    @AfterMethod
    public void screenShot(ITestResult testResult) throws Exception {
        Thread.sleep(1000);
        if (testResult.getStatus() == ITestResult.FAILURE) {
            takeScreenShot(testResult);
        }
       // driver.quit();
    }

    protected void takeScreenShot(ITestResult testResult) throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("dd_MMM_yyyy__hh_mm_ssaa");
        System.out.println(testResult.getStatus());
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String destFile = dateFormat.format(new Date());
        FileUtils.copyFile(scrFile, new File("./test-output/screenshot/"
                + testResult.getMethod().getMethodName() + "_" + destFile + ".png"));
    }

    protected void setDriver(String browser, String url) {
        Browser browser1 = Browser.valueOf(browser);

        switch (browser1) {
            case firefox:
                driver = new FirefoxDriver();
                break;
            case chrome:
                System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
                driver = new ChromeDriver();
                break;
            default:
                System.out.println("The browser is not correct");
                break;
        }
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

}
