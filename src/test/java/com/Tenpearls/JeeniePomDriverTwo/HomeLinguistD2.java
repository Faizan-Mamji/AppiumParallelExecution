package com.Tenpearls.JeeniePomDriverTwo;

import com.Tenpearls.DriverAppium.MainConfiguration;
import com.Tenpearls.DriverAppium.MainDriverCalling;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.util.List;

public class HomeLinguistD2 extends MainDriverCalling {

    MainConfiguration objConf = new MainConfiguration();

    public HomeLinguistD2(AndroidDriver<MobileElement> driver) {
        this.driverTwo = driver;
    }

    public List<MobileElement> checkLocationPermissionRequest() {
        return driverTwo.findElementsByAndroidUIAutomator("text(\"" + objConf.getPermissionPopUpText() + "\")");
    }

    public List<MobileElement> btnContinueCheck() {
        return driverTwo.findElementsByAndroidUIAutomator("text(\"" + objConf.getContinueBtn() + "\")");
    }

    public MobileElement btnContinue() {
        return driverTwo.findElementByAndroidUIAutomator("text(\"" + objConf.getContinueBtn() + "\")");
    }

    public List<MobileElement> checkPermissionMobilePopup() {
        return driverTwo.findElementsById("" + objConf.getMobilePopupID() + "");
    }

    public MobileElement permissionMobilePopup() {
        return driverTwo.findElementById("" + objConf.getMobilePopupID() + "");
    }

    public MobileElement checkLinguistText() {
        return driverTwo.findElementByXPath("//android.widget.TextView[@index='3']");
    }

    public List<MobileElement> chaneToOnline() {
        return driverTwo.findElementsByXPath("//android.widget.Switch[@index='4']");
    }


    public MobileElement changeToOnline() {
        return driverTwo.findElementByXPath("//android.widget.Switch[@index='4']");
    }

    public MobileElement cancelledCallNotification() {
        return driverTwo.findElementById("android:id/button1");
    }

    public List<MobileElement> btnAllowCheck() {
        return driverTwo.findElementsById("com.android.packageinstaller:id/permission_allow_button");
    }

    public MobileElement btnAllowClick() {
        return driverTwo.findElementById("com.android.packageinstaller:id/permission_allow_button");
    }


}
