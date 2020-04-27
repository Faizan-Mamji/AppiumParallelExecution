package com.Tenpearls.DriverAppium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MainDriverCalling {
    public AndroidDriver<MobileElement> driverOne;
    public AndroidDriver<MobileElement> driverTwo;
    File androidJeenie = new File("DownloadJeenieipa/app-release.apk");
    Logger logg = LogManager.getLogger(MainDriverCalling.class);
    MainConfiguration objConfig;
    DesiredCapabilities caps;
    Random rnd;
    public int portOne;
    public int portTwo;


    public AndroidDriver deviceDriverOne() {

        rnd = new Random();
        portOne = 4725;
        objConfig = new MainConfiguration();
        caps = new DesiredCapabilities();
        logg.info("The path is " + androidJeenie.getAbsolutePath());
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, objConfig.getResponse("deviceNameOne"));
        caps.setCapability(MobileCapabilityType.UDID, objConfig.getResponse("deviceIdOne")); //Give Device ID of your mobile phone
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, objConfig.getResponse("mobPlatformName"));
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, objConfig.getResponse("deviceVersionOne"));
        caps.setCapability("appPackage", objConfig.getResponse("applicationPackage"));
        caps.setCapability("appActivity", objConfig.getResponse("applicationActivity"));
        caps.setCapability("app", androidJeenie.getAbsolutePath());
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        caps.setCapability(MobileCapabilityType.FULL_RESET, true);
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 700000);
        logg.info("All Capabilities Passed Successfully for Driver 1");
        try {
            logg.info("DriverOne now try to opening on Device 1");
            System.out.println("http://" + objConfig.getResponse("localUrlD1") + ":" + portOne + "/wd/hub");
            driverOne = new AndroidDriver<>(new URL("http://" + objConfig.getResponse("localUrlD1") + ":" + portOne + "/wd/hub"), caps);
            driverOne.manage().timeouts().implicitlyWait(Integer.parseInt(objConfig.getResponse("waitImplicit")), TimeUnit.SECONDS);
            logg.info("DriverOne Opened Successfully on Device 1");
        } catch (NullPointerException ex) {
            logg.info("There is an issue in class MainDriverCalling class - function - deviceDriverOne - " + ex.getMessage());
        } catch (IOException ex) {
            logg.info("There is an issue in class MainDriverCalling class - function - deviceDriverOne - " + ex.getMessage());
        } catch (Exception ex) {
            logg.info("There is an issue in class MainDriverCalling class - function - deviceDriverOne - " + ex.getMessage());
        }
        return driverOne;
    }

    public AndroidDriver deviceDriverTwo() {

        rnd = new Random();
        portTwo = 4724;
        objConfig = new MainConfiguration();
        caps = new DesiredCapabilities();
        logg.info("The path is " + androidJeenie.getAbsolutePath());
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, objConfig.getResponse("deviceNameTwo"));
        caps.setCapability(MobileCapabilityType.UDID, objConfig.getResponse("deviceIdTwo")); //Give Device ID of your mobile phone
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, objConfig.getResponse("mobPlatformName"));
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, objConfig.getResponse("deviceVersionTwo"));
        caps.setCapability("appPackage", objConfig.getResponse("applicationPackage"));
        caps.setCapability("appActivity", objConfig.getResponse("applicationActivity"));
        caps.setCapability("app", androidJeenie.getAbsolutePath());
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        caps.setCapability(MobileCapabilityType.FULL_RESET, true);
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 700000);
        logg.info("All Capabilities Passed Successfully for Driver 2");
        try {
            logg.info("DriverTwo now try to opening on Device 2");
            System.out.println("http://" + objConfig.getResponse("localUrlD1") + ":" + portTwo + "/wd/hub");
            driverTwo = new AndroidDriver<>(new URL("http://" + objConfig.getResponse("localUrlD1") + ":" + portTwo + "/wd/hub"), caps);
            driverTwo.manage().timeouts().implicitlyWait(Integer.parseInt(objConfig.getResponse("waitImplicit")), TimeUnit.SECONDS);
            logg.info("DriverTwo Opened Successfully on Device 2");
        } catch (NullPointerException ex) {
            logg.info("There is an issue in class MainDriverCalling class - function - deviceDriverOne - " + ex.getMessage());
        } catch (IOException ex) {
            logg.info("There is an issue in class MainDriverCalling class - function - deviceDriverOne - " + ex.getMessage());
        } catch (Exception ex) {
            logg.info("There is an issue in class MainDriverCalling class - function - deviceDriverOne - " + ex.getMessage());
        }
        return driverOne;
    }

    public void stopDriverOne() {
        System.out.println("Stop driver");
        driverOne.quit();
        System.out.println("Driver Quit Successfully");
    }

    public void stopDriverTwo() {
        System.out.println("Stop driver");
        driverTwo.quit();
        System.out.println("Driver Quit Successfully");
    }
}