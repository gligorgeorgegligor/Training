package com.PitechnologiesTests.page.obj;

import com.PitechnologiesTests.page.Wait.utils.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by george.gligor on 2/6/2015.
 */
public class SuperSpeedPage {

    final WebDriver driver;

    @FindBy(how = How.XPATH, using = "//ul[@class='nav pull-right']//li[2]//a")
    private WebElement logoutButton;
    @FindBy(how = How.XPATH, using = "//div[@class='title-text left-column']")
    private WebElement newLogText;

    //My account link-button
    @FindBy(how = How.XPATH, using = "//ul[@class='nav pull-right']//li//a")
    private WebElement myAccountLinkButton;

    //elements - create a new log
    @FindBy(how = How.XPATH, using = "//input[@class='ui-autocomplete-input ui-widget ui-widget-content ui-corner-left']")
    private WebElement selectCompanyField;
    @FindBy(how = How.XPATH, using = "//a[@class='ui-corner-all']//span")
    private WebElement selectCompanyFirstField;
    @FindBy(how = How.XPATH, using = "//div[@id='projectField']//input")
    private WebElement setProjectField;
    @FindBy(how = How.XPATH, using = "//body//ul[3]//li//a//span")
    private WebElement selectProjectFirstField;
    @FindBy(how = How.XPATH, using = "//div[@id='taskField']//input")
    private WebElement setTaskField;
    @FindBy(how = How.XPATH, using = "//body//ul[4]//li//a//span")
    private WebElement selectTaskFirstField;

    //set date elements
    @FindBy(how = How.ID, using = "startDate")
    private WebElement setStartDate;
    @FindBy(how = How.XPATH, using = "//tbody//tr[3]//td//a")
    private WebElement selectStartDate;
    @FindBy(how = How.ID, using = "endDate")
    private WebElement setEndDate;
    @FindBy(how = How.XPATH, using = "//tbody//tr[3]//td[5]//a")
    private WebElement selectEndDate;

    //set hours element
    @FindBy(how = How.ID, using = "hours")
    private WebElement setHours;
    //set description element
    @FindBy(how = How.ID, using = "description")
    private WebElement setDescription;
    //create new log button
    @FindBy(how = How.ID, using = "create")
    private WebElement createNewLogButton;
    //description text after a new log create
    @FindBy(how = How.XPATH, using = "//div[@class='logDesc content infoRow clickable']")
    private WebElement descriptionTextInNewLog;

    //elements for creating a new holiday
    @FindBy(how = How.XPATH, using = "//body//div[2]//div//div//div//form[2]//div[5]//input")
    private WebElement setTypeField;
    @FindBy(how = How.XPATH, using = "//body//ul[2]//li//a//span")
    private WebElement selectTypeField;
    @FindBy(how = How.ID, using = "holidayStartDate")
    private WebElement setHolidayStartDate;
    @FindBy(how = How.ID, using = "holidayEndDate")
    private WebElement setHolidayEndtDate;

    //insert holiday Button (element)
    @FindBy(how = How.ID, using = "createHoliday")
    private WebElement insertHolidayButton;
    //type button after you create a new holiday
    @FindBy(how = How.XPATH, using = "//tbody//tr[21]//td[2]//div")
    private WebElement typeText;

    //edit holiday button element
    @FindBy(how = How.XPATH, using = "//button[@class='editHoliday icon-edit content clickable']")
    private WebElement editHolidayButton;
    @FindBy(how = How.ID, using = "deleteHoliday")
    private WebElement deleteHolidayButton;
    //print holiday button
    @FindBy(how = How.XPATH, using = "//button[@class='printHoliday icon-print content clickable']")
    private WebElement printHolidayButton;

    //remaining/total holiday days elements
    @FindBy(how = How.XPATH, using = "//a[@title='remaining holidays / total holidays + remaining holidays from last year']/strong")
    private WebElement remainingHolidayDays;
    @FindBy(how = How.XPATH, using = "//a[@title='remaining holidays / total holidays + remaining holidays from last year']//strong[2]")
    private WebElement totalHolidayDays;

    //You have holidays or logs in this period
    @FindBy(how = How.ID, using = "modalText")
    private WebElement alertHoliday;
    //submit alert holiday
    @FindBy(how = How.XPATH, using = "//a[@class='btn']")
    private WebElement submitAlertHolidayButton;

    //your holiday date is wrong
    @FindBy(how = How.ID, using = "holidayDateError")
    private WebElement holidayDateErrorAlert;
    //hours error locator
    @FindBy(how = How.ID, using = "hoursError")
    private WebElement hoursErrorMessage;

    // description error
    @FindBy(how = How.ID, using = "descriptionError")
    private WebElement descriptionErrorMessage;

    //hide button using to hide logs
    @FindBy(how = How.ID, using = "hide")
    private WebElement hideButton;

    //delete log button locator
    @FindBy(how = How.XPATH, using = "//button[@class='delete deleteButton icon-trash content clickable']")
    private WebElement deleteLogButton;

    //after you create a log , check the color of the row in the superSpeed(element)
    @FindBy(how = How.XPATH, using = "//tbody//tr[16]//td")
    private WebElement completeLog;

    //show button using to show all the options
    @FindBy(how = How.ID, using = "show")
    private WebElement showButton;

    //next month button
    @FindBy(how = How.ID, using = "nextMonth")
    private WebElement nextMonthButton;

    //previous month button
    @FindBy(how = How.ID, using = "prevMonth")
    private WebElement previousMonthButton;

    // view more button
    @FindBy(how = How.ID, using = "viewMore")
    private WebElement viewMoreButton;

    //remove view more button
    @FindBy(how = How.ID, using = "removeMore")
    private WebElement removeMoreButton;

    // holiday error locator
    @FindBy(how = How.ID, using = "holidayError")
    private WebElement holidayErrorMessage;

    //edit log button locator
    @FindBy(how = How.XPATH, using = "//button[@class='edit editButton icon-edit content clickable']")
    private WebElement editLog;

    //save edit new holiday button
    @FindBy(how = How.ID, using = "saveHoliday")
    private WebElement saveHoliday;
    //holidayType content infoRow clickable
    @FindBy(how = How.XPATH, using = "//div[@class='holidayType content infoRow clickable']")
    private WebElement holidayTypeInfoRow;
    //holiday type error
    @FindBy(how = How.ID, using = "holidayTypeError")
    private WebElement holidayTypeError;
    //holiday date error
    @FindBy(how = How.ID, using = "holidayDateError")
    private WebElement holidayDateError;

    //cancel a holiday button
    @FindBy(how = How.ID, using = "cancelHoliday")
    private WebElement cancelHolidayButton;

    // total holiday days from another page
    @FindBy(how = How.XPATH, using = "//div[@class='holidays-left pull-left text-blue']//span[2]")
    private WebElement totalDaysHolidayFinal;

    //save new log button after yo you access the auto complete button
    @FindBy(how = How.ID, using = "save")
    private WebElement saveNewLogButton;

    //cancel creating a new log button
    @FindBy(how = How.ID, using = "cancel")
    private WebElement cancelLogButton;

    //totalHours - on log creation
    @FindBy(how = How.ID, using = "workedHours")
    private WebElement workedHoursField;

    // Log Type content infoRow clickable
    @FindBy(how = How.XPATH, using = "//div[@class='logName content infoRow clickable']")
    private WebElement logTypeInfoRow;

    // logDate content dayRow
    @FindBy(how = How.XPATH, using = "//tbody//tr[27]//td//div")
    private WebElement logDateContentDayRow;

    // task error message
    @FindBy(how = How.ID, using = "taskError")
    private WebElement taskErrorMessage;

    //task error message get text
    public String taskErrorMessageGetText() {
        return taskErrorMessage.getText();
    }


/*    //total hours/day of a log right content
    @FindBy(how = How.XPATH, using = "//tbody//tr[17]//td[2]//div")
    private WebElement logHoursContent;*/

    public SuperSpeedPage(WebDriver driver) {
        this.driver = driver;

        if (!(driver.getPageSource().contains("Insert Holiday"))) {
            throw new IllegalStateException("This is not the SuperSpeed page");
        }
    }

    public boolean isNewLogTextDisplayed() {
        if (newLogText.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    // getter new log text
    public WebElement getnewLogText() {
        return newLogText;
    }

    //Create the list for external links
    public List<WebElement> getAllLinks() {
        List<WebElement> links = driver.findElements(By.xpath("//div[@id='externalLinks']/div/a"));
        System.out.println(links.size());
        for (int i = 1; i < links.size(); i++) {
        }
        return links;
    }

    //Create the list for all links
    public List<WebElement> getAllPageLinks() {
        List<WebElement> links = driver.findElements(By.tagName("a"));
        for (int i = 1; i < links.size(); i++) {
        }
        return links;
    }

    //check the logout button
    public void logoutSuperspeedPage() {
        logoutButton.click();
    }

    //create a new log
    public SuperSpeedPage setCompany(String company) {
        selectCompanyField.clear();
        selectCompanyField.sendKeys(company);
        selectCompanyFirstField.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return this;
    }

    // get text for select Company field
    public String getTextselectCompanyField() {
        return selectCompanyField.getText();
    }

    public SuperSpeedPage setProject(String project) {
        setProjectField.clear();
        setProjectField.sendKeys(project);
        selectProjectFirstField.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return this;
    }

    // get text for set Project field
    public String getTextsetProjectField() {
        return setProjectField.getText();
    }

    public SuperSpeedPage setTask(String task) {
        setTaskField.clear();
        setTaskField.sendKeys(task);
        selectTaskFirstField.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return this;
    }

    public SuperSpeedPage setStartDate(String day) {
        setStartDate.click();
        List<WebElement> taskList = driver.findElements(By.xpath("//a[contains(@href,'#')]"));
        for (WebElement element : taskList) {
            if (element.getText().contains(day)) {
                element.click();
                break;
            }
        }
        return this;
    }

    public SuperSpeedPage setEndDate(String day) {
        setEndDate.click();
        List<WebElement> taskList = driver.findElements(By.xpath("//a[contains(@href,'#')]"));
        for (WebElement element : taskList) {
            if (element.getText().contains(day)) {
                element.click();
                break;
            }
        }
        return this;
    }

    public SuperSpeedPage setHours(String hours) {
        setHours.clear();
        setHours.sendKeys(hours);
        return this;
    }

    // get text set hours
    public String setHoursGetText() {
        return setHours.getText();
    }

    public SuperSpeedPage setDescription(String desc) {
        setDescription.clear();
        setDescription.sendKeys(desc);
        return this;
    }

    //create a valid Log
    public SuperSpeedPage createValidLog(String company, String project, String task, String hours, String desc, String day, String endDay) {
        setCompany(company);
        setProject(project);
        setTask(task);
        setStartDate(day);
        setEndDate(endDay);
        setHours(hours);
        setDescription(desc);
        createNewLogButton.click();
        return this;
    }

    //getter select type field
    public WebElement getTypeField() {
        return selectTypeField;
    }

    //getter select type field
    public WebElement getSetTypeField() {
        return setTypeField;
    }

    // type field get text
    public String getTextTypeField() {
        return selectTypeField.getText();
    }

    //create a new holiday
    public SuperSpeedPage setType(String type) {
        setTypeField.clear();
        setTypeField.sendKeys(type);
        Wait.waitForElementToBeClickable(getTypeField(), driver, 15);
        selectTypeField.click();
        return this;
    }

    public SuperSpeedPage setType1(String type) throws InterruptedException {
        setTypeField.clear();
        setTypeField.sendKeys(type);
//        Wait.waitForElementTextToBeVisible(getTypeField(),"Concediu fara salariu", driver, 2);
        selectTypeField.click();

        return this;
    }

    public SuperSpeedPage setType2(String type) {
        setTypeField.clear();
        setTypeField.sendKeys(type);
        return this;
    }

    public SuperSpeedPage setStartDateHoliday(String day) {
        setHolidayStartDate.click();

        List<WebElement> taskList = driver.findElements(By.xpath("//a[contains(@href,'#')]"));
        for (WebElement element : taskList) {
            if (element.getText().contains(day)) {
                element.click();
                break;
            }
        }
        return this;
    }

    public SuperSpeedPage setEndDateHoliday(String day) {
        setHolidayEndtDate.click();

        List<WebElement> taskList = driver.findElements(By.xpath("//a[contains(@href,'#')]"));
        for (WebElement element : taskList) {
            if (element.getText().contains(day)) {
                element.click();
                break;
            }
        }
        return this;
    }

    public SuperSpeedPage insertHoliday() {
        insertHolidayButton.click();
        return this;
    }

    //delete a holiday
    public SuperSpeedPage deleteHoliday() {
        Wait.waitForElementToBeClickable(editHolidayButton, driver, 100);
        editHolidayButton.click();
        Wait.waitForElementToBeClickable(deleteHolidayButton, driver, 100);
        deleteHolidayButton.click();
        return this;
    }

    //click on edit holiday button
    public SuperSpeedPage clickEditHolidayButton() {
        editHolidayButton.click();
        Wait.waitForElementToBeClickable(deleteHolidayButton, driver, 100);
        return this;

    }

    //getter   editHolidayButton
    public WebElement getEditHolidayButton() {
        return editHolidayButton;
    }

    //create a holiday (over a new holiday)
    public SuperSpeedPage createNewHolidayOverHoliday(String day, String Endday) {
        setStartDateHoliday(day);
        setEndDateHoliday(Endday);
        insertHoliday();
        return this;
    }

    //refresh the page
    public SuperSpeedPage refresh() {
        driver.navigate().refresh();
        return this;
    }

    //return text from the description after a new log is created
    public String descriptionTextInNewLogGetText() {
        return descriptionTextInNewLog.getText();
    }

    //click on descriptionTextIn new log
    public SuperSpeedPage clickdescriptionTextInNewLog() {
        descriptionTextInNewLog.click();
        return this;
    }

    //getter for descriptionTextInNewLog
    public WebElement getDescriptionTextInNewLog() {
        return descriptionTextInNewLog;
    }

    //delete log button is displayed
    public boolean deleteLogButtonIsDisplayed() {
        if (deleteLogButton.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    //click on hide button
    public void clickOnHideButton() {
        hideButton.click();
    }

    //click on show button
    public void clickOnShowButton() {
        showButton.click();
    }

    //hours error method
    public String hoursErrorGetText() {
        return hoursErrorMessage.getText();
    }

    //print holiday button is displayed
    public boolean printHolidayButtonIsDisplayed() {
        if (printHolidayButton.isDisplayed()) {
            return false;
        } else {
            return true;
        }
    }

    //alert error message get text , only when the user creates a holiday over an already holiday
    public String alertHolidayGetText() {
        return alertHoliday.getText();
    }

    //getter for alert holiday
    public WebElement getAlertHoliday() {
        return alertHoliday;
    }

    //return the holiday text /remaining days
    public String remainingHolidayDaysGetText() {
        return remainingHolidayDays.getText();
    }

    //return the holiday text/total days
    public String totalHolidayDaysGetText() {
        return totalHolidayDays.getText();
    }

    //getter for alert remaining holiday days
    public WebElement getRemainingHolidayDays() {
        return remainingHolidayDays;
    }

    // create a new log button (click)
    public SuperSpeedPage clickToCreateNewLog() {
        // Wait.waitForElementToBeClickable(createNewLogButton,driver,3);
        createNewLogButton.click();
        return this;
    }

    //after you create a log , check the color of the row in the superSpeed(element)"get the color method"
    public String checkIfLogIsComplete() {
        return completeLog.getAttribute("class");
    }

    // click on next month button
    public SuperSpeedPage clickNextMonthButton() {
        nextMonthButton.click();
        return this;
    }

    // click on next month button
    public SuperSpeedPage clickPreviousMonthButton() {
        previousMonthButton.click();
        return this;
    }

    // get url text
    public String getUrlText() {
        return driver.getCurrentUrl();
    }

    //get holiday error message
    public String getHolidayErrorMessage() {
        return holidayErrorMessage.getText();
    }

    //getter for holiday error
    public WebElement getHolidayError() {
        return holidayErrorMessage;
    }

    //click to print the holiday
    public SuperSpeedPage clickToPrintHolidayButton() {
        printHolidayButton.click();
        return this;
    }

    //getter for print the holiday
    public WebElement getPrintHolidayButton() {
        // Wait.waitForElementToBeVisible(getPrintHolidayButton(), driver, 5);
        return printHolidayButton;
    }

    //delete a log method
    public SuperSpeedPage deleteLog(String day) {
        String dateStr = "//tr[contains(@name, '" + day + "-')]//td//div/button[2]";
        WebElement clickDeleteLogButton = driver.findElement(By.xpath(dateStr));
        clickDeleteLogButton.click();
        return this;
    }

    //delete all the logs method
    public SuperSpeedPage deleteAllLog(String day) {
        String dateStr = "//tr[contains(@name, '" + day + "-')]//button[starts-with(@class, 'delete deleteButton')]";
        for (WebElement element : driver.findElements(By.xpath(dateStr))) {
            element.click();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Sleep failed.");
            }
        }
        return this;
    }

    //click on view more button method
    public SuperSpeedPage clickViewMore() {
        viewMoreButton.click();
        return this;
    }

    //click on remove view more button method
    public SuperSpeedPage clickRemoveMore() {
        removeMoreButton.click();
        return this;
    }

    //getter remove view more button method
    public WebElement getRemoveMore() {
        return removeMoreButton;
    }

    //getter view more button method
    public WebElement getViewMore() {
        return viewMoreButton;
    }

    //click on edit button method
    public SuperSpeedPage clickEditLog() {
        editLog.click();
        return this;
    }

    //click on submit alert Holiday button method
    public SuperSpeedPage clickSubmitHolidayAlertButton() {
        Wait.waitForElementToBeClickable(submitAlertHolidayButton, driver, 15);
        submitAlertHolidayButton.click();
        return this;
    }

    //holiday date error alert text
    public String holidayDateErrorAlertText() {
        return holidayDateErrorAlert.getText();
    }

    //getter for holiday date error alert
    public WebElement getHolidayDateError() {
        return holidayErrorMessage;
    }

    //description error text field
    public String getDescriptionTextErrorField() {
        Wait.waitForElementToBeVisible(descriptionErrorMessage, driver, 15);
        return descriptionErrorMessage.getText();
    }

    //if you create multiple logs on the same day the total hours should be less than 25
    public Integer getTotalLogHoursContentText(String day) {
        String dateStr = "//tr[contains(@id, '" + day + "-')]//td[2]//div";
        WebElement nrHours = driver.findElement(By.xpath(dateStr));
        System.out.println("number: " + nrHours.getText());
        return Integer.parseInt(nrHours.getText());
    }

    //click on save holiday method
    public SuperSpeedPage clickSaveHoliday() {
        //Wait.waitForElementToBeVisible(getSaveHoliday(), driver, 5);
        saveHoliday.click();
        return this;
    }

    //getter for holiday save edit
    public WebElement getSaveHoliday() {
        return saveHoliday;
    }

    //holiday type info row get text
    public String getTextholidayTypeInfoRow() {
        return holidayTypeInfoRow.getText();
    }

    //getter holidayTypeInfoRow
    public WebElement getHolidayType() {
        return holidayTypeInfoRow;
    }

    // holiday type error get text
    public String getTextHolidayTypeError() {
        return holidayTypeError.getText();
    }

    // holiday date error get text
    public String getTextHolidayDateError() {
        return holidayDateError.getText();
    }

    //click on cancel holiday button method
    public SuperSpeedPage clickCancelHoliday() {
        cancelHolidayButton.click();
        return this;
    }

    //holiday  total days from another page get text
    public String getTextTotalHolidayDaysFinal() {
        return totalDaysHolidayFinal.getText();
    }

    //click save new log method
    public SuperSpeedPage clickSaveNewLog() {
        saveNewLogButton.click();
        return this;
    }

    // getter save new log
    public WebElement getSaveNewLogButton() {
        return saveNewLogButton;
    }

    //click cancel creating a new log method
    public SuperSpeedPage clickCancelNewLog() {
        cancelLogButton.click();
        return this;
    }

    //set description get text
    public String getSetDescriptionText() {
        return setDescription.getText();
    }

    //set description get text
    public String getSetProjectFieldText() {
        return setProjectField.getText();
    }

    //set description get text
    public String getSetCompanyFieldText() {
        return selectCompanyField.getText();
    }

    //worked hours field get text
    public String getWorkedHoursText() {
        return workedHoursField.getText();
    }

    //click  logTypeInfoRow
    public SuperSpeedPage clickLogTypeInfoRow() {
        logTypeInfoRow.click();
        //Wait.waitForElementTextToBeVisible(setTaskField,"Pool",driver, 5);
        return this;
    }

    // get text set holiday start date
    public String getTextSetHolidayStartDate() {
        return setHolidayStartDate.getText();
    }

    // logDate content dayRow
    public String logDateContentDayRowText() {
        return logDateContentDayRow.getText();
    }

    // go to the social page by clicking on the social link

    @FindBy(how = How.XPATH, using = "//div[@id=\"externalLinks\"]//div[2]//a")
    private WebElement socialLinkButton;

    public SuperSpeedPage clickOnSocialLinkButton() {
        Wait.waitForElementToBeVisible(socialLinkButton,driver,2);
        socialLinkButton.click();
        return this;
    }
}