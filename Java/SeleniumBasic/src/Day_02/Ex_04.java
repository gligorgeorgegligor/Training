package Day_02;

import Selenium.MyException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

/**
 * Created by george.gligor on 2/2/2015.
 */
public class Ex_04 {


    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("http://testdotmanager.loki.pitechnologies.ro/login");


        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("FONICA");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("pitech123");

        WebElement submitLoginButton = driver.findElement(By.xpath("//button[@class='btn btn-info']"));
        submitLoginButton.click();

        Assert.assertEquals(driver.getCurrentUrl(),"http://testdotmanager.loki.pitchnologies.ro/", "Failed!");
      /*  if (driver.getCurrentUrl().equals("http://testdotmanager.loki.pitechnologies.ro/login"))
            System.out.println("failed!");
            else
            System.out.println("success!");
        */
        driver.quit();
        }
    }
