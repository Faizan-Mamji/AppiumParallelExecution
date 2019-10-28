package com.Tenpearls.DriverAppium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MainDriverCalling {

    public AndroidDriver<MobileElement> driverOne;
    public AndroidDriver<MobileElement> driverTwo;
    Logger logg = LogManager.getLogger(MainDriverCalling.class);
    MainConfiguration objConfig;
    DesiredCapabilities caps;
    AppiumServiceBuilder builder;
    AppiumDriverLocalService service;
    String localAddress = "127.0.0.1";
    Random rnd;
    int rand1;
    int rand2;


    public AndroidDriver deviceDriverOne() {

        rnd = new Random();
        rand1 = rnd.nextInt(9999);
        objConfig = new MainConfiguration();
        caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, objConfig.getDeviceNameOne());
        caps.setCapability(MobileCapabilityType.UDID, objConfig.getDeviceIdOne()); //Give Device ID of your mobile phone
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, objConfig.getDevicePlatform());
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, objConfig.getDeviceVersionOne());
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "1000");
        caps.setCapability("appPackage", objConfig.getPackageName());
        caps.setCapability("appActivity", objConfig.getActivityName());
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        caps.setCapability(MobileCapabilityType.NO_RESET, false);
        appiumStartService(localAddress, rand1);
        logg.info("All Capabilities Passed Successfully for Driver 1");

        try {
            logg.info("DriverOne now try to opening on Device 1");
            System.out.println("http://" + objConfig.getLocalHostUrl() + ":" + rand1 + "/wd/hub");
            driverOne = new AndroidDriver<>(new URL("http://" + objConfig.getLocalHostUrl() + ":" + rand1 + "/wd/hub"), caps);
            driverOne.manage().timeouts().implicitlyWait(Integer.parseInt(objConfig.GetImplicitWait()), TimeUnit.SECONDS);
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
        rand2 = rnd.nextInt(8888);
        objConfig = new MainConfiguration();
        caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, objConfig.getDeviceNameTwo());
        caps.setCapability(MobileCapabilityType.UDID, objConfig.getDeviceIdTwo()); //Give Device ID of your mobile phone
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, objConfig.getDevicePlatform());
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, objConfig.getDeviceVersionTwo());
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "1000");
        caps.setCapability("appPackage", objConfig.getPackageName());
        caps.setCapability("appActivity", objConfig.getActivityName());
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        caps.setCapability(MobileCapabilityType.NO_RESET, false);
        appiumStartService(localAddress, rand2);
        logg.info("All Capabilities Passed Successfully for Driver 2");

        try {
            logg.info("DriverTwo now try to opened on Device 2");
            System.out.println("http://" + objConfig.getLocalHostUrl() + ":" + rand2 + "/wd/hub");
            driverTwo = new AndroidDriver<>(new URL("http://" + objConfig.getLocalHostUrl() + ":" + rand2 + "/wd/hub"), caps);
            driverTwo.manage().timeouts().implicitlyWait(Integer.parseInt(objConfig.GetImplicitWait()), TimeUnit.SECONDS);
            logg.info("DriverTwo Opened Successfully on Device 2");

        } catch (NullPointerException ex) {
            logg.info("There is an issue in class MainDriverCalling class - function - deviceDriverTwo - " + ex.getMessage());
        } catch (IOException ex) {
            logg.info("There is an issue in class MainDriverCalling class - function - deviceDriverTwo - " + ex.getMessage());
        } catch (Exception ex) {
            logg.info("There is an issue in class MainDriverCalling class - function - deviceDriverTwo - " + ex.getMessage());
        }
        return driverTwo;
    }

    public void appiumStartService(String ipAddress, int rndport) {

        builder = new AppiumServiceBuilder();
        builder = new AppiumServiceBuilder();
        builder.withIPAddress(ipAddress);
        builder.usingPort(rndport);
        builder.withCapabilities(caps);
        builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
        builder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");

        //Start the server with the builder
        service = AppiumDriverLocalService.buildService(builder);
        service.start();
    }

    public void quitAppiumService() {
        service.stop();
    }

}
