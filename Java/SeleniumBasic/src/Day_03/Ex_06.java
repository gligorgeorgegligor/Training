package Day_03;

import bsh.This;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;

/**
 * Created by george.gligor on 2/3/2015.
 */
public class Ex_06 {

    public static void main(String[] args) throws AWTException {


        WebDriver driver = new FirefoxDriver();
        driver.get("http://demoqa.com/tooltip/");


        WebElement age = driver.findElement(By.id("age"));

        Actions builder = new Actions(driver);
        builder.moveToElement(age).build().perform();

        WebElement tip = driver.findElement(By.xpath("//div[@class='ui-tooltip-content']"));
        System.out.println("Tooltip text: " + tip.getText());


        driver.close();
    }
}