package DriverAppium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverAndroidOne {

    public AndroidDriver<MobileElement> driverOne;
    FileInputStream fs;
    Properties prop = new Properties();

    public AndroidDriver deviceDriverOne() {

        MainConfiguration objConfig = new MainConfiguration(driverOne);
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,objConfig.getDeviceNameOne());
        caps.setCapability(MobileCapabilityType.UDID, objConfig.getDeviceIdOne()); //Give Device ID of your mobile phone
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, objConfig.getDevicePlatform());
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, objConfig.getDeviceVersionOne());
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "800");
        caps.setCapability("appPackage", objConfig.getPackageName());
        caps.setCapability("appActivity", objConfig.getActivityName());
        //caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        caps.setCapability(MobileCapabilityType.NO_RESET, true);

        try {
            driverOne = new AndroidDriver<>(new URL("http://127.0.0.1:4766/wd/hub"), caps);
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
}
