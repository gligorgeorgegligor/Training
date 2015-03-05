package Day_04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by george.gligor on 2/4/2015.
 */
public class Ex_05 {
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


    @Test
    public List<WebElement> getAllLinks() {
        List<WebElement> links = driver.findElements(By.tagName("a"));

        System.out.println(links.size());

        for (int i = 1; i < links.size(); i++){}
        return links;
    }

    @Test
    public static String isLinkBroken(URL url) throws Exception{
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        try  {
            connection.connect();
            String response = connection.getResponseMessage();
            int responseCode = connection.getResponseCode();
            connection.disconnect();
            return response + " " + responseCode;
        }
        catch(Exception exp) {
            return exp.getMessage();
        }
    }
    @Test
    public void mainMethod(){

        login("FONICA","pitech123");
        List<WebElement> all = getAllLinks();

        for( WebElement element : all)
            try {
                System.out.println("URL: " + element.getAttribute("href") + " returned " + isLinkBroken(new URL(element.getAttribute("href"))));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }


    }

}
