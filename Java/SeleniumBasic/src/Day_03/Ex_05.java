package Day_03;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.Point;

/**
 * Created by george.gligor on 2/2/2015.
 */
public class Ex_05 {
    public static void main(String[] args) throws InterruptedException, AWTException {

        WebDriver driver = new FirefoxDriver();
        driver.get("http://demoqa.com/resizable/");

        WebElement resize = driver.findElement(By.id("resizable"));
        resize.getSize();


        System.out.println("Before: " + resize.getLocation());

        WebElement drop = driver.findElement(By.xpath("//div[@id='resizable']//div[3]"));

        new Actions(driver).dragAndDropBy(drop, 200, 300).build().perform();

        System.out.println("After: " + resize.getLocation());


        driver.quit();
    }
}
