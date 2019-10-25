package JeeniePomDriverOne;

import DriverAppium.MainConfiguration;
import DriverAppium.MainDriverCalling;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.util.List;

public class LogoutCustomer extends MainDriverCalling {

    MainConfiguration objConf = new MainConfiguration();

    public LogoutCustomer(AndroidDriver<MobileElement> driver) {
        this.driverOne = driver;
    }

    public List<MobileElement> openNavigation() {
        return driverOne.findElementsByXPath("//android.widget.TextView[@index='0']");
    }

    public MobileElement navSettings() {
        return driverOne.findElementByAndroidUIAutomator("text(\"" + objConf.getNavSettings() + "\")");
    }

    public MobileElement btnLogout() {
        return driverOne.findElementByAndroidUIAutomator("text(\"" + objConf.getTextLogout() + "\")");
    }

    public MobileElement logoutPopUp() {
        return driverOne.findElementById("" + objConf.getLogoutPopupID() + "");
    }
}
