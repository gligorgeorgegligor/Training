package Day_03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by george.gligor on 2/2/2015.
 */
public class Ex_02 {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("http://adam.goucher.ca/parkcalc/");

        WebElement valetParking = driver.findElement(By.xpath("//select[@id='Lot']//option[5]"));
        valetParking.click();

        WebElement chooseEntryTime = driver.findElement(By.id("EntryTime"));
        chooseEntryTime.clear();
        chooseEntryTime.sendKeys("8:30");

        //switch page

        String originalHandle= driver.getWindowHandle();
        WebElement calendar = driver.findElement(By.xpath("//tbody//tr[2]//td[2]//a//img"));
        calendar.click();

        for(String handle : driver.getWindowHandles()){
            driver.switchTo().window(handle);
        }
        WebElement date_number = driver.findElement(By.xpath("//tbody//tr[4]//td[2]//a"));
        date_number.click();


        driver.switchTo().window(originalHandle);



        WebElement chooseLivingTime = driver.findElement(By.id("ExitTime"));
        chooseLivingTime.clear();
        chooseLivingTime.sendKeys("2:30");

        WebElement pmButton = driver.findElement(By.xpath("//tbody//tr[3]//td[2]//input[3]"));
        pmButton.click();

        //switch page

        String originalLHandle= driver.getWindowHandle();
        WebElement calendarR = driver.findElement(By.xpath("//tbody//tr[3]//td[2]//a//img"));
        calendarR.click();

        for(String handle : driver.getWindowHandles()){
            driver.switchTo().window(handle);
        }
        WebElement dateNumber = driver.findElement(By.xpath("//tbody//tr[4]//td[2]//a"));
        dateNumber.click();


        driver.switchTo().window(originalLHandle);




        WebElement calculateButton = driver.findElement(By.xpath("//input[@name='Submit']"));
        calculateButton.click();

        WebElement price = driver.findElement(By.xpath("//tbody//tr[4]//td[2]//b"));
        WebElement time = driver.findElement(By.xpath("//tbody//tr[4]//td[2]//span[2]//b"));

        System.out.println(price.getText());
        System.out.println(time.getText());

        driver.close();
        driver.quit();
    }
}

