package com.Tenpearls.JeeniePomDriverOne;

import com.Tenpearls.DriverAppium.MainConfiguration;
import com.Tenpearls.DriverAppium.MainDriverCalling;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class LoginCustomerD1 extends MainDriverCalling {

    MainConfiguration objConf = new MainConfiguration();

    public LoginCustomerD1(AndroidDriver<MobileElement> driver) {
        this.driverOne = driver;
    }

    public MobileElement btnSignInDriverOne() {
        return driverOne.findElementByAndroidUIAutomator("text(\" " + objConf.getSignInText() + "\")");
    }

    public MobileElement txtEmail() {
        return driverOne.findElementByAndroidUIAutomator("text(\"" + objConf.getEmailText() + "\")");
    }

    public MobileElement txtPassword() {
        return driverOne.findElementByAndroidUIAutomator("text(\"" + objConf.getPasswordText() + "\")");
    }

    public MobileElement btnSignInClick() {
        return driverOne.findElementByXPath("//android.widget.TextView[@text='Sign in']");
    }
}
