package Day_03;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by george.gligor on 2/2/2015.
 */
public class Ex_03 {
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");


        String originalHandle= driver.getWindowHandle();

        WebElement jsAlertButton = driver.findElement(By.xpath("//div[@class='example']//li//button"));
        jsAlertButton.click();

        Alert alert = driver.switchTo().alert();
        alert.getText();

        System.out.print(alert.getText());
        alert.accept();

        driver.switchTo().window(originalHandle);

        WebElement rezultat = driver.findElement(By.id("result"));
        rezultat.getText();
        System.out.print(" / " + rezultat.getText() + "\n");



        WebElement jsConfirmButton = driver.findElement(By.xpath("//div//div//div//li[2]//button"));
        jsConfirmButton.click();

        Alert aalert = driver.switchTo().alert();
        aalert.getText();

        System.out.print(aalert.getText());
        aalert.accept();
        driver.switchTo().window(originalHandle);

        WebElement rezultatT = driver.findElement(By.id("result"));
        rezultatT.getText();
        System.out.println(" / " + rezultatT.getText());



        WebElement jsPromptButton = driver.findElement(By.xpath("//div//div//div//li[3]//button"));
        jsPromptButton.click();

        Alert aaalert = driver.switchTo().alert();
        aaalert.getText();
        aaalert.sendKeys("Alooooooooo!");


        System.out.print(aaalert.getText());
        aaalert.accept();
        driver.switchTo().window(originalHandle);

        WebElement rezultatTT = driver.findElement(By.id("result"));
        rezultatTT.getText();
        System.out.println(" / " + rezultatTT.getText());


        driver.close();
        driver.quit();
    }

}