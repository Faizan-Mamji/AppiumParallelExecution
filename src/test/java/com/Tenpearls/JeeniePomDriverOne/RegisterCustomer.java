package com.Tenpearls.JeeniePomDriverOne;

import com.Tenpearls.DriverAppium.MainConfiguration;
import com.Tenpearls.DriverAppium.MainDriverCalling;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

import java.util.List;

public class RegisterCustomer extends MainDriverCalling {


    MainConfiguration objConf = new MainConfiguration();

    public RegisterCustomer(IOSDriver<MobileElement> driver) {
        this.driverOne = driver;
    }

    public List<MobileElement> checkLaunchPopup() {
        return driverOne.findElementsByAccessibilityId("Allow");
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
