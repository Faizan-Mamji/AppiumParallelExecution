package com.Tenpearls.JeeniePomDriverTwo;

import com.Tenpearls.DriverAppium.MainConfiguration;
import com.Tenpearls.DriverAppium.MainDriverCalling;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.util.List;

public class HomeLinguistD2 extends MainDriverCalling {

    public HomeLinguistD2(IOSDriver<MobileElement> driver) {
        this.driverTwo = driver;
    }

    public List<MobileElement> checkLocationPermissionRequest() {
        return driverTwo.findElementsByAccessibilityId("permissionRequestLabelId");
    }

    public List<MobileElement> btnContinueCheck() {
        return driverTwo.findElementsByAccessibilityId("Continue");
    }

    public List<MobileElement> permssionFeaturesiOSPopup() {
        return driverTwo.findElementsByAccessibilityId("OK");
    }

    public List<MobileElement> permissionMobilePopup() {
        return driverTwo.findElementsByAccessibilityId("Allow");
    }

    public List<MobileElement> checkLinguistText() {
        return driverTwo.findElementsByName("Offline");
    }

    public MobileElement changeToOnline() {
        return driverTwo.findElementByXPath
                ("(//XCUIElementTypeOther[@name=\"Offline\"])[3]/XCUIElementTypeSwitch");
    }
}
