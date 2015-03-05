package com.PitechnologiesTests.socialpagetest.linktest;

import com.PitechnologiesTests.basetest.BaseThreeTest;
import com.PitechnologiesTests.page.obj.SocialPage;
import com.PitechnologiesTests.page.utils.IsLinkBroken;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by george.gligor on 3/2/2015.
 */

@Test
public class AllLinkTestSocialPageTest extends BaseThreeTest {

    public void allLinks1Test() {

        SocialPage socialPage = PageFactory.initElements(driver, SocialPage.class);
        List<WebElement> all = socialPage.getAlllPageLinks();

        for (WebElement element : all)
            try {
                System.out.println("URL: " + element.getAttribute("href") + " returned " + IsLinkBroken.isLinkBroken(new URL(element.getAttribute("href"))));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }


        for (WebElement element : all)
            try {
                if (socialPage.getAlllPageLinks().contains(element.getAttribute("href"))) {
                    assertThat(IsLinkBroken.isLinkBroken(new URL(element.getAttribute("href"))), equalTo("OK 200"));
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("This link is broken");
            }
    }
}
