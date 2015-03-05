package com.PitechnologiesTests.superspeedpagetest.linktest;

import com.PitechnologiesTests.basetest.BaseTwotest;
import com.PitechnologiesTests.page.obj.SuperSpeedPage;
import com.PitechnologiesTests.page.utils.IsLinkBroken;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by george.gligor on 2/10/2015.
 */

@Test
public class AllLinkTest extends BaseTwotest {

    public void allLinksTest() {

        SuperSpeedPage superSpeedPage = PageFactory.initElements(driver, SuperSpeedPage.class);
        List<WebElement> all = superSpeedPage.getAllPageLinks();

        for (WebElement element : all)
            try {
                System.out.println("URL: " + element.getAttribute("href") + " returned " + IsLinkBroken.isLinkBroken(new URL(element.getAttribute("href"))));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }


        for (WebElement element : all)
            try {
                if (superSpeedPage.getAllPageLinks().contains(element.getAttribute("href"))) {
                    assertThat(IsLinkBroken.isLinkBroken(new URL(element.getAttribute("href"))), equalTo("OK 200"));
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("This link is broken");
            }
    }
}
