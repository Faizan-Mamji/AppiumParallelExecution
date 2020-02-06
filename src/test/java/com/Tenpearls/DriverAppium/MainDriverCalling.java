package com.Tenpearls.DriverAppium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
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
    File test = new File("DownloadJeenieipa/app-release.apk");
    Logger logg = LogManager.getLogger(MainDriverCalling.class);
    MainConfiguration objConfig;
    DesiredCapabilities caps;
    AppiumServiceBuilder builder;
    AppiumDriverLocalService service;
    String localAddress = "0.0.0.0";
    Random rnd;
    public int rand1;
    public int rand2;


    public AndroidDriver deviceDriverOne() {

        rnd = new Random();
        rand1 = 4725;
        objConfig = new MainConfiguration();
        caps = new DesiredCapabilities();
        logg.info("The path is " + test.getAbsolutePath());
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, objConfig.getDeviceNameOne());
        caps.setCapability(MobileCapabilityType.UDID, objConfig.getDeviceIdOne()); //Give Device ID of your mobile phone
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, objConfig.getDevicePlatform());
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, objConfig.getDeviceVersionOne());
        caps.setCapability("appPackage", objConfig.getPackageName());
        caps.setCapability("appActivity", objConfig.getActivityName());
        caps.setCapability("app", test.getAbsolutePath());
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        caps.setCapability(MobileCapabilityType.FULL_RESET, true);
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 700000);
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
        rand1 = 4724;
        objConfig = new MainConfiguration();
        caps = new DesiredCapabilities();
        logg.info("The path is " + test.getAbsolutePath());
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, objConfig.getDeviceNameTwo());
        caps.setCapability(MobileCapabilityType.UDID, objConfig.getDeviceIdTwo()); //Give Device ID of your mobile phone
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, objConfig.getDevicePlatform());
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, objConfig.getDeviceVersionTwo());
        caps.setCapability("appPackage", objConfig.getPackageName());
        caps.setCapability("appActivity", objConfig.getActivityName());
        caps.setCapability("app", test.getAbsolutePath());
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        caps.setCapability(MobileCapabilityType.FULL_RESET, true);
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 700000);
        logg.info("All Capabilities Passed Successfully for Driver 2");
        try {
            logg.info("DriverOne now try to opening on Device 1");
            System.out.println("http://" + objConfig.getLocalHostUrl() + ":" + rand1 + "/wd/hub");
            driverTwo = new AndroidDriver<>(new URL("http://" + objConfig.getLocalHostUrl() + ":" + rand1 + "/wd/hub"), caps);
            driverTwo.manage().timeouts().implicitlyWait(Integer.parseInt(objConfig.GetImplicitWait()), TimeUnit.SECONDS);
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

    public void appiumStartService(String ipAddress, int rndport) throws AppiumServerHasNotBeenStartedLocallyException {

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

    public void portKillingFromCode(int PortNumber) {
        try {
            Runtime rt = Runtime.getRuntime();
            String OSName = System.getProperty("os.name").toLowerCase();
            System.out.println("The OS is " + OSName);
            if (OSName.equalsIgnoreCase("mac os x")) {
                System.out.println("kill -9 " + PortNumber);
                rt.exec("kill -9 " + PortNumber);
                System.out.println("killedddddd");
            } else {
                rt.exec("taskkill /PID " + PortNumber + "/F");
            }
        } catch (Exception ex) {
            logg.info("There is an issue in class MainDriverCalling class - function - portKillingFromCode - " + ex.getMessage());
        }
    }
}