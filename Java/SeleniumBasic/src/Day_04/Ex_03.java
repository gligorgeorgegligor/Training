package Day_04;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by george.gligor on 2/3/2015.
 */
public class Ex_03 {

    public WebDriver driver;

    @BeforeClass
    public void setupPag() {
        this.driver = new FirefoxDriver();
    }

    @AfterClass
    public void quito(){
        this.driver.quit();
    }

    //ex 03
    @Test
    public void upload() {

        driver.get("http://the-internet.herokuapp.com/upload");

        WebElement chooseButton = driver.findElement(By.id("file-upload"));
        chooseButton.sendKeys("C:\\Users\\george.gligor\\Desktop\\testing.doc\\Bug.docx");

        WebElement upload = driver.findElement(By.id("file-submit"));
        upload.click();

        WebElement name = driver.findElement(By.id("uploaded-files"));
        name.getText();

        WebElement message = driver.findElement(By.xpath("//div[@class='example']//h3"));
        message.getText();

        System.out.println(name.getText() + " / " + message.getText());
        Assert.assertEquals(message.getText(),"File Uploaded!","Failed!");

    }

    //ex 04
    @Test
    public void enable(){

        driver.get("http://the-internet.herokuapp.com/jqueryui/menu");

        WebElement disable = driver.findElement(By.id("ui-id-1"));

        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("document.getElementsByClassName('ui-state-disabled ui-menu-item')[0].className='ui-menu-item';", disable);
        disable.click();

        WebElement notSee = driver.findElement(By.id("ui-id-3"));
        notSee.getText();

        System.out.println(notSee.getText());

    }


}
