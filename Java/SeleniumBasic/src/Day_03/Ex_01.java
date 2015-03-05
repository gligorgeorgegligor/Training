package Day_03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by george.gligor on 2/2/2015.
 */
public class Ex_01 {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("http://adam.goucher.ca/parkcalc/");

        WebElement valetParking = driver.findElement(By.xpath("//select[@id='Lot']//option[5]"));
        valetParking.click();

        WebElement chooseEntryTime = driver.findElement(By.id("EntryTime"));
        chooseEntryTime.clear();
        chooseEntryTime.sendKeys("8:30");

        WebElement chooseEntryDate = driver.findElement(By.id("EntryDate"));
        chooseEntryDate.clear();
        chooseEntryDate.sendKeys("03/02/2015");

        WebElement chooseLivingTime = driver.findElement(By.id("ExitTime"));
        chooseLivingTime.clear();
        chooseLivingTime.sendKeys("2:30");

        WebElement pmButton = driver.findElement(By.xpath("//tbody//tr[3]//td[2]//input[3]"));
        pmButton.click();

        WebElement chooseLivingdate = driver.findElement(By.id("ExitDate"));
        chooseLivingdate.clear();
        chooseLivingdate.click();
        chooseLivingdate.sendKeys("03/02/2015");

        WebElement calculateButton = driver.findElement(By.xpath("//input[@name='Submit']"));
        calculateButton.click();

        WebElement price = driver.findElement(By.xpath("//tbody//tr[4]//td[2]//b"));
        WebElement time = driver.findElement(By.xpath("//tbody//tr[4]//td[2]//span[2]//b"));

        System.out.println(price.getText());
        System.out.println(time.getText());

        //driver.quit();
    }
}