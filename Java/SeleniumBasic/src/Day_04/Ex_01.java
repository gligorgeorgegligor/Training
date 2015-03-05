package Day_04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by george.gligor on 2/3/2015.
 */
public class Ex_01 {
    public static void main(String[] args){

        WebDriver driver = new FirefoxDriver();
        driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");

        WebElement start = driver.findElement(By.xpath("//div[@id='start']//button"));
        start.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='finish']//h4")));

        //WebElement helloText = driver.findElement(By.xpath("//div[@id='finish']//h4"));

        System.out.println(element.getText());

        driver.close();
    }
}
