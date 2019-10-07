package DriverAppium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverAndroidTwo {
    public AndroidDriver<MobileElement> driverTwo;
    FileInputStream fs;
    AppiumServiceBuilder builder;
    AppiumDriverLocalService service;
    Properties prop = new Properties();
    String localUrl = "127.0.0.1";
    int portConnect = 4726;

    public AndroidDriver deviceDriverTwo() {

        MainConfiguration objConfig = new MainConfiguration();

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, objConfig.getDeviceNameTwo());
        caps.setCapability(MobileCapabilityType.UDID, objConfig.getDeviceIdTwo()); //Give Device ID of your mobile phone
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, objConfig.getDevicePlatform());
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, objConfig.getDeviceVersionTwo());
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "300");
        caps.setCapability("appPackage", objConfig.getPackageName());
        caps.setCapability("appActivity", objConfig.getActivityName());
        //caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        builder = new AppiumServiceBuilder();
        builder.withIPAddress(localUrl);
        builder.usingPort(portConnect);
        builder.withCapabilities(caps);
        builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
        builder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");
        caps.setCapability(MobileCapabilityType.NO_RESET, false);
        service = AppiumDriverLocalService.buildService(builder);
        service.start();

        try {
            driverTwo = new AndroidDriver<>(new URL("http://" + localUrl + ":" + portConnect + "/wd/hub"), caps);
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
