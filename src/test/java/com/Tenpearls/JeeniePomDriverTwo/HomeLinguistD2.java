package com.Tenpearls.JeeniePomDriverTwo;

import com.Tenpearls.DriverAppium.MainConfiguration;
import com.Tenpearls.DriverAppium.MainDriverCalling;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.util.List;

public class HomeLinguistD2 extends MainDriverCalling {

    MainConfiguration objConf=new MainConfiguration();

    public HomeLinguistD2(AndroidDriver<MobileElement> driver) {
        this.driverTwo = driver;
    }


    public List<MobileElement> checkLocationPermissionRequest() {
        return driverTwo.findElementsByAccessibilityId("permissionRequestLabelId");
    }

    public List<MobileElement> btnContinueCheck() {
        return driverTwo.findElementsByAccessibilityId("continueBtnId");
    }

    public List<MobileElement> permssionFeaturesiOSPopup() {
        return driverTwo.findElementsByAccessibilityId("OK");
    }

    public List<MobileElement> permissionMobilePopup() {
        //return driverTwo.findElementsByAccessibilityId("Allow");
        return driverTwo.findElementsById("" + objConf.getMobilePopupID() + "");
    }

    public MobileElement checkLinguistText() {
        return driverTwo.findElementByAccessibilityId("linguistStatusId");
    }

    public List<MobileElement> btnCancelCall() {
        return driverTwo.findElementsByAccessibilityId("endCallBtnId");
    }

    public MobileElement confirmCancelCallPopup() {
        return driverTwo.findElementById("android:id/button2");
    }

    public MobileElement changeToOnline() {
        return driverTwo.findElementByAccessibilityId("linguistStatusSwitchId");
    }
}
