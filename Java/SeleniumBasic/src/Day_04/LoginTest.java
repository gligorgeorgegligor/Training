package Day_04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by george.gligor on 2/4/2015.
 */
public class LoginTest {

    @DataProvider(name = "login1", parallel = true)
    public Object[][] dataForLogin(){
        return new Object[][] {
                {"invalid user", "invalid pass"},
                {"FONICA", "pitech123"},
                {"aaaaaa", "ccccccc"}
        };
    }

    @Test(dataProvider = "login1")
    public void log(String username, String pass){

        WebDriver driver = new FirefoxDriver();
        driver.get("http://testdotmanager.loki.pitechnologies.ro/login");

        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys(username);

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(pass);

        WebElement submitLoginButton = driver.findElement(By.xpath("//button[@class='btn btn-info']"));
        submitLoginButton.click();

        driver.quit();
    }
}
