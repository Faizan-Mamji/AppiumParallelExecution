package com.Tenpearls.JeeniePomDriverOne;

import com.Tenpearls.DriverAppium.MainConfiguration;
import com.Tenpearls.DriverAppium.MainDriverCalling;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import java.util.List;

public class LogoutCustomer extends MainDriverCalling {

    MainConfiguration objConf = new MainConfiguration();

    public LogoutCustomer(IOSDriver<MobileElement> driver) {
        this.driverOne = driver;
    }

    public MobileElement openNavigation() {
        return driverOne.findElementByAccessibilityId("homeMenuId");
    }

    public MobileElement navSettings() {
        return driverOne.findElementByAccessibilityId("drawerSettingsId");
    }

    public MobileElement btnLogout() {
        return driverOne.findElementByAccessibilityId("Log Out \uE5CC\n");
    }

    public MobileElement logoutPopUp() {
        return driverOne.findElementByAccessibilityId("Yes");
    }
}
