package Day_04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by george.gligor on 2/4/2015.
 */
public class Bonus {

    public WebDriver driver;

    @BeforeMethod
    public void setupPag() {



        driver = new FirefoxDriver();
        driver.get("http://testdotmanager.loki.pitechnologies.ro/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void quito(){
        driver.quit();
    }

    public void login(String username, String pass){
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys(username);

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(pass);

        WebElement submitLoginButton = driver.findElement(By.xpath("//button[@class='btn btn-info']"));
        submitLoginButton.click();
    }

    public void social(){
        WebElement socialLink = driver.findElement(By.xpath("//div[@id='externalLinks']//div[2]//a"));
        socialLink.click();
    }

    public void switchBack(){

        String originalHandle= driver.getWindowHandle();

        for(String handle : driver.getWindowHandles()){
            driver.switchTo().window(handle);
        }

        newWindow();
        eEmail();

        driver.switchTo().window(originalHandle);
    }

    public void newWindow(){
        WebElement employees = driver.findElement(By.xpath("//body//div[3]//div[2]//div//div//div//div//div//li[3]//a"));
        employees.click();

        WebElement searchButoon = driver.findElement(By.id("edit-name"));
        searchButoon.sendKeys("Gligor");
    }
    public void eEmail(){
        WebElement email = driver.findElement(By.xpath("//article [@id='node-employee-profile-531']//div//div[2]//div[4]//div//div//a"));
        String mail = email.getText();
        System.out.println(mail);

    }

    public void logout(){
        WebElement log = driver.findElement(By.xpath("//ul[@class='nav pull-right']//li[2]/a"));
        log.click();
    }

    public void failedLogout(String badUsername, String badPass){
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys(badUsername);

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(badPass);

        WebElement submitLoginButton = driver.findElement(By.xpath("//button[@class='btn btn-info']"));
        submitLoginButton.click();
        WebElement credit = driver.findElement(By.xpath("//div[@class='alert alert-error']"));
        System.out.println(credit.getText());

    }
    @Test
    public void mainMethod(){
        login("FONICA","pitech123");
        social();
        switchBack();
        logout();
        failedLogout("pitech123","FONICA");

    }
}
