package Day_04;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.Assert.assertEquals;

/**
 * Created by george.gligor on 2/3/2015.
 */
public class ExperimentTestNG {

    @Test
    public void firstTestNG (){

        WebDriver driver1 = new FirefoxDriver();
        try {
            WebDriver driver = new RemoteWebDriver(
                    new URL("http://localhost:4444/wd/hub"),
                    DesiredCapabilities.firefox());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        System.out.println("dsfghjk");
        assertEquals(2+2,4, "failed");

        driver1.quit();

    }

    @Test
    public void secondTestNg(){

        WebDriver driver1 = new FirefoxDriver();

        System.out.println("sfdghjk");
        driver1.quit();

    }

}
