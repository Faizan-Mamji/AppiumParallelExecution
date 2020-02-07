package com.Tenpearls.JeeniePomDriverOne;

import com.Tenpearls.DriverAppium.MainConfiguration;
import com.Tenpearls.DriverAppium.MainDriverCalling;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.util.List;

public class LogoutCustomer extends MainDriverCalling {

    MainConfiguration objConf = new MainConfiguration();

    public LogoutCustomer(AndroidDriver<MobileElement> driver) {
        this.driverOne = driver;
    }

    public MobileElement openNavigation() {
        return driverOne.findElementByAccessibilityId("homeMenuBtnId");
    }

    public MobileElement navSettings() {
        return driverOne.findElementByAccessibilityId("drawerSettingsId");
    }

    public MobileElement navPaymentDetails() {
        return driverOne.findElementByAccessibilityId("drawerPaymentDetailId");
    }

    public MobileElement btnLogout() {
        return driverOne.findElementByAccessibilityId("logout");
    }

    public MobileElement logoutPopUp() {
        return driverOne.findElementById("" + objConf.getLogoutPopupID() + "");
    }
}
