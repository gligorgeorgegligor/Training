package com.PitechnologiesTests.page.datafortest;

import static com.PitechnologiesTests.page.environment.Env.getProp;
import static com.PitechnologiesTests.page.utils.CurrentDate.date2;
import static com.PitechnologiesTests.page.utils.CurrentDate.dateFormat2;

/**
 * Created by george.gligor on 2/11/2015.
 */
public class ValidData {

    //Valid data for login
    public static final String USERNAME = "FONICA";
    public static final String PASSWORD = "pitech123";

    //Get the current date
    public static String CURRENT_START_DATE = dateFormat2.format(date2);

    //Valid data for a  new log
    public static final String COMPANY = "PITECH+PLUS";
    public static final String PROJECT = "[P] Academy Plus";
    public static final String TASK = "Development and testing";
    public static final String DESCRIPTION = "Framework";
    public static final String START_DATE_NEW_LOG = "13";
    public static final String END_DATE_NEW_LOG = "13";
    public static final String HOURS = "8";
    public static final String START_DATE_NEW_LOG_1 = "24";

    //Valid data for holiday
    public static final String TYPE = "Concediu odihna";
    public static final String START_DATE_NEW_HOLIDAY = "10";
    public static final String END_DATE_NEW_HOLIDAY = "13";

    //Error message
    public static final String HOUR_NOT_VALID = "Not valid.";
    public static final String REQUIRED_DESCRIPTION = "Required.";
    public static final String ALERT_HOLIDAY = "You have holidays or logs in this period";
    public static final String ALERT_HOLIDAY1 = "You have holidays in this period";
    public static final String HOLIDAY_ERROR = "Holiday must contain at least one work day.";
    public static final String HOLIDAY_DATE_ERROR = "Period not valid.";
    public static final String REQUIRED_TYPE = "Required.";
    public static final String HOLIDAY_DATE_ERROR_1 = "Start Date and End Date required.";

    // constants for changing the environment
    public static final String BROWSER = getProp("browser");
    public static final String URL = getProp("url");
    public static final String USER = getProp("user");
    public static final String PASS = getProp("pass");

    public static enum Browser {
        firefox, chrome
    }
}
