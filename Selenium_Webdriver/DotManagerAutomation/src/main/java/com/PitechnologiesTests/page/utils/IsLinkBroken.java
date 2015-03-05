package com.PitechnologiesTests.page.utils;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by george.gligor on 2/11/2015.
 */
public class IsLinkBroken {

    public static String isLinkBroken(URL url) throws Exception {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        try {
            connection.connect();
            String response = connection.getResponseMessage();
            int responseCode = connection.getResponseCode();
            connection.disconnect();
            return response + " " + responseCode;
        } catch (Exception exp) {
            return exp.getMessage();
        }
    }
}
