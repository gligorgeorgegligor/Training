package Day_04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

/**
 * Created by george.gligor on 2/3/2015.
 */
public class Ex_02_doi {


/*
    WebElement verif = wait.until(ExpectedConditions.presenceOfElementLocated((By.id("message"))){
        public WebElement apply(WebDriver driver) {

            return driver.findElement(By.id("foo"));

        }
    }*/
    public static void main(String[] args){

        WebDriver driver = new FirefoxDriver();
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");


        //first part
        WebElement removeButtton = driver.findElement(By.id("btn"));
        removeButtton.click();



        // WebDriverWait wait = new WebDriverWait(driver, 10);
        //WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("message")));



        //System.out.println(element.getText());


       //second part

        WebElement addButtton = driver.findElement(By.id("btn"));
        addButtton.click();

        WebDriverWait wWait = new WebDriverWait(driver, 10);

        WebElement element1 = wWait.until(ExpectedConditions.presenceOfElementLocated(By.id("message")));

        System.out.println(element1.getText());

        //third part
        WebElement checkButtton = driver.findElement(By.xpath("//div[@id='checkbox']//input"));
        checkButtton.click();

        if (checkButtton.isSelected())
            System.out.println("Success!");

        driver.close();
    }
}
