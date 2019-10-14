package DriverAppium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class MainDriverCalling {

    public AndroidDriver<MobileElement> driverOne;
    public AndroidDriver<MobileElement> driverTwo;
    MainConfiguration objConfig;

    public AndroidDriver deviceDriverOne() {

        objConfig = new MainConfiguration();
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, objConfig.getDeviceNameOne());
        caps.setCapability(MobileCapabilityType.UDID, objConfig.getDeviceIdOne()); //Give Device ID of your mobile phone
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, objConfig.getDevicePlatform());
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, objConfig.getDeviceVersionOne());
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "800");
        caps.setCapability("appPackage", objConfig.getPackageName());
        caps.setCapability("appActivity", objConfig.getActivityName());
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        caps.setCapability(MobileCapabilityType.NO_RESET, true);

        try {
            driverOne = new AndroidDriver<>(new URL(objConfig.getUrlDriverOne()), caps);
            driverOne.manage().timeouts().implicitlyWait(Integer.parseInt(objConfig.GetImplicitWait()), TimeUnit.SECONDS);
            TimeUnit.SECONDS.sleep(8);
            System.out.println("Driver Line passed");

        } catch (NullPointerException ex) {
            ex.getMessage();
        } catch (IOException ex) {
            ex.getMessage();
        } catch (Exception ex) {
            ex.getMessage();
        }
        return driverOne;
    }


    public AndroidDriver deviceDriverTwo() {

        MainConfiguration objConfig = new MainConfiguration();
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, objConfig.getDeviceNameTwo());
        caps.setCapability(MobileCapabilityType.UDID, objConfig.getDeviceIdTwo()); //Give Device ID of your mobile phone
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, objConfig.getDevicePlatform());
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, objConfig.getDeviceVersionTwo());
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "800");
        caps.setCapability("appPackage", objConfig.getPackageName());
        caps.setCapability("appActivity", objConfig.getActivityName());
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        caps.setCapability(MobileCapabilityType.NO_RESET, false);

        try {
            driverTwo = new AndroidDriver<>(new URL(objConfig.getUrlDriverTwo()), caps);
            driverTwo.manage().timeouts().implicitlyWait(Integer.parseInt(objConfig.GetImplicitWait()), TimeUnit.SECONDS);
            TimeUnit.SECONDS.sleep(8);
            System.out.println("Driver Line passed");

        } catch (NullPointerException ex) {
            ex.getMessage();
        } catch (IOException ex) {
            ex.getMessage();
        } catch (Exception ex) {
            ex.getMessage();
        }
        return driverTwo;
    }

}
