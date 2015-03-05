package com.PitechnologiesTests.page.obj;

import com.PitechnologiesTests.page.Wait.utils.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by george.gligor on 2/6/2015.
 */
public class LoginPage {

    final WebDriver driver;

    @FindBy(how = How.ID, using = "username")
    private static WebElement usernameField;

    @FindBy(how = How.ID, using = "password")
    private static WebElement passwordField;

    @FindBy(how = How.XPATH, using = "//button[@class='btn btn-info']")
    private WebElement loginButton;

    @FindBy(how = How.XPATH, using = "//div[@class='alert alert-error']")
    private static WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        if (!(driver.getPageSource().contains("Login"))) {
            throw new IllegalStateException("This is not the login page");
        }
    }

    public LoginPage enterUsername(String username) {
        usernameField.clear();
        usernameField.sendKeys(username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPage clickLoginButton() {
        Wait.waitForElementToBeVisible(getLoginButton(), driver, 2);
        loginButton.click();
        return this;
    }

    public void login(String login, String password) {

        enterUsername(login);
        enterPassword(password);
        clickLoginButton();
    }

    //getter for login click button
    public WebElement getLoginButton() {
        return loginButton;
    }

    public String getLoginError() {
        return errorMessage.getText();
    }

    public String Url() {
        return driver.getCurrentUrl();
    }

}
