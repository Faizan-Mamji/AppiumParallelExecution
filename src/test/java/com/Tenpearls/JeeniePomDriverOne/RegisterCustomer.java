package com.Tenpearls.JeeniePomDriverOne;

import com.Tenpearls.DriverAppium.MainConfiguration;
import com.Tenpearls.DriverAppium.MainDriverCalling;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class RegisterCustomer extends MainDriverCalling {

    MainConfiguration objConf = new MainConfiguration();

    public RegisterCustomer(AndroidDriver<MobileElement> driver) {
        this.driverOne = driver;
    }

    public MobileElement btnGetStarted() {
        return driverOne.findElementByAndroidUIAutomator("text(\"" + objConf.getBtnGetStarted() + "\")");
    }

    public MobileElement txtFirstName() {
        return driverOne.findElementByAndroidUIAutomator("text(\"" + objConf.getTxtFirstName() + "\")");
    }

    public MobileElement txtEmail() {
        return driverOne.findElementByAndroidUIAutomator("text(\"" + objConf.getTxtEmail() + "\")");
    }

    public MobileElement txtCreatePassword() {
        return driverOne.findElementByAndroidUIAutomator("text(\"" + objConf.getTxtCreatePassword() + "\")");
    }

    public MobileElement btnCreateAccount() {
        return driverOne.findElementByAndroidUIAutomator("text(\"" + objConf.getBtnCreateAccount() + "\")");
    }


}
