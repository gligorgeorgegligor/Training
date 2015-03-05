package Day_5_Test;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
/**
 * Created by george.gligor on 2/5/2015.
 */
public class Ex1Test {

    public WebDriver driver;

    @BeforeMethod
    public void setupPag() {

        driver = new FirefoxDriver();
        driver.get("http://mediawiki.loki.pitechnologies.ro/index.php?title=Main_Page");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @AfterMethod

    public void screenShot(ITestResult tr) throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        DateFormat dateFormat = new SimpleDateFormat("dd_MMM_yyyy__hh_mm_ssaa");

        String destDir = "C:\\Users\\george.gligor\\Desktop\\testing.doc\\Screenshots";
        new File(destDir).mkdirs();
        String destFile = dateFormat.format(new Date()) + tr.getMethod() + ".png";

        FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));


        driver.quit();
    }

    public void findPdfTest() {
        WebElement testingButton = driver.findElement(By.xpath("//a[@title='Testing']"));
        testingButton.click();

        WebElement autoTesting = driver.findElement(By.xpath("//a[@title='Automated testing']"));
        autoTesting.click();
    }

    @Test (description = "Verify if the 'Locators table 1 0 2.pdf' is on the page and is taking a screenshot if the test fails")
    public void mainTest(){
        findPdfTest();

        WebElement pdf = driver.findElement(By.xpath("//a[@title='Locators table 1 0 2.pdf']"));
        System.out.println(pdf.getText());

        Assert.assertEquals(pdf.getText(),"Media: Locators_table_1_0_2.pdf", "False");
        Assert.assertEquals(driver.getPageSource().contains("Media: Locators_table_1_0_2.pdf"),true, "False");

    }


}
