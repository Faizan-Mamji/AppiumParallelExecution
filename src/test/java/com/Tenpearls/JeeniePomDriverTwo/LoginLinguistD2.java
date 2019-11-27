package com.Tenpearls.JeeniePomDriverTwo;

import com.Tenpearls.DriverAppium.MainConfiguration;
import com.Tenpearls.DriverAppium.MainDriverCalling;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

import java.util.List;

public class LoginLinguistD2 extends MainDriverCalling {

    MainConfiguration objConf = new MainConfiguration();

    public LoginLinguistD2(IOSDriver<MobileElement> driver) {
        this.driverTwo = driver;
    }

    public List<MobileElement> checkLaunchPopup() {
        return driverTwo.findElementsByXPath("//XCUIElementTypeButton[@name='Allow']");
    }

    public List<MobileElement> btnSignInExist() {
        return driverTwo.findElementsByAccessibilityId("welcomeSignInId");
    }

    public MobileElement txtEmail() {
        return driverTwo.findElementByName("loginEmailId");
    }

    public MobileElement txtPassword() {
        return driverTwo.findElementByName("loginPasswordId");
    }

    public MobileElement btnSignInClick() {
        return driverTwo.findElementByAccessibilityId("signInBtnId");
    }
}
