package com.PitechnologiesTests.page.environment;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by george.gligor on 2/17/2015.
 */
public class Env {


    private static Properties properties = new Properties();

    public static void loadProp() {

        try {
            properties.load(Env.class.getResourceAsStream("/loki.properties"));
        } catch (IOException e) {
            System.out.println("Invalid properties file");
            e.printStackTrace();
        }
    }

    public static String getProp(String prop) {

        return properties.getProperty(prop);
    }
}

