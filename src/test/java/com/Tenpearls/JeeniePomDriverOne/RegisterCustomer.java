package com.Tenpearls.JeeniePomDriverOne;

import com.Tenpearls.DriverAppium.MainConfiguration;
import com.Tenpearls.DriverAppium.MainDriverCalling;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class RegisterCustomer extends MainDriverCalling {

    public RegisterCustomer(AndroidDriver<MobileElement> driver) {
        this.driverOne = driver;
    }

    public MobileElement btnGetStarted() {
        return driverOne.findElementByAccessibilityId("welcomeGetStartedId");
    }

    public MobileElement txtFirstName() {
        return driverOne.findElementByAccessibilityId("regNameId");
    }

    public MobileElement txtEmail() {
        return driverOne.findElementByAccessibilityId("regEmailId");
    }

    public MobileElement txtCreatePassword() {
        return driverOne.findElementByAccessibilityId("regCreatePasswordId");
    }

    public MobileElement btnCreateAccount() {
        return driverOne.findElementByAccessibilityId("regCreateAccountId");
    }


}
