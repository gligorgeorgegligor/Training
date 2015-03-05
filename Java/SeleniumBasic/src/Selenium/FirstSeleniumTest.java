package Selenium;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.GoogleChromeLauncher;

/**
 * Created by george.gligor on 1/30/2015.
 */
public class FirstSeleniumTest {


    public static void main(String[] args) throws MyException{

        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.youtube.com/");

        System.out.println(driver.getTitle());

        driver.manage().window().setSize(new Dimension(1440, 900));
        driver.manage().window().maximize();


        try {
            if(!driver.getTitle().equals("Google")) {

                throw new MyException("The page is not Google");
            }

        } catch (MyException e){

            System.out.println(e.getMessage());

        }

       System.out.println(driver.getCurrentUrl());

       driver.quit();
    }
}