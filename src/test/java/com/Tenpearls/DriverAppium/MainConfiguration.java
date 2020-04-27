package com.Tenpearls.DriverAppium;

import java.io.FileInputStream;
import java.util.Properties;

public class MainConfiguration {

    FileInputStream fs;
    Properties prop = new Properties();

    public MainConfiguration() {
        try {
            fs = new FileInputStream("JeenieConfiguration/MainConfig.properties");
            prop.load(fs);
        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    public String getResponse(String valResponse) {
        return prop.getProperty(valResponse);
    }
}
