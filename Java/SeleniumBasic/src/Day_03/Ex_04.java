package Day_03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

/**
 * Created by george.gligor on 2/2/2015.
 */
public class Ex_04 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        driver.get("http://demoqa.com/droppable/");

        WebElement dragMe = driver.findElement(By.xpath("//div[@id='draggableview']/p"));
        WebElement dropMe = driver.findElement(By.id("droppableview"));

        Actions builder = new Actions(driver);


        Action dragAndDrop = builder.clickAndHold(dragMe).moveToElement(dropMe).release(dragMe).build();
        Thread.sleep(1000L);
        dragAndDrop.perform();

        Assert.assertEquals(dropMe.getText(),"Dropped!", "Failed!");
        /*if (dropMe.getText().equals("Dropped!")){
            System.out.print("Success!");
        }
        else
            System.out.print("Failed!");
*/
       driver.quit();





    }
}