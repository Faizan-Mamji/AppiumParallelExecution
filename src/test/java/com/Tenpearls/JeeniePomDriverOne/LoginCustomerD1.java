package com.Tenpearls.JeeniePomDriverOne;

import com.Tenpearls.DriverAppium.MainConfiguration;
import com.Tenpearls.DriverAppium.MainDriverCalling;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.util.List;

public class LoginCustomerD1 extends MainDriverCalling {

    MainConfiguration objConf = new MainConfiguration();

    public LoginCustomerD1(AndroidDriver<MobileElement> driver) {
        this.driverOne = driver;
    }

    public List<MobileElement> checkLaunchPopup() {
        return driverOne.findElementsByAccessibilityId("Allow");
    }

    public List<MobileElement> btnSignInDriverOne() {
        return driverOne.findElementsByAccessibilityId("welcomeSignInId");
    }

    public MobileElement txtEmail() {
        return driverOne.findElementByAccessibilityId("loginEmailId");
    }

    public MobileElement txtPassword() {
        return driverOne.findElementByAccessibilityId("loginPasswordId");
    }

    public MobileElement btnSignInClick() {
        return driverOne.findElementByAccessibilityId("signInBtnId");
    }
}
