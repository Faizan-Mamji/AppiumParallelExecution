package com.Tenpearls.JeeniePomDriverOne;

import com.Tenpearls.DriverAppium.MainDriverCalling;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.util.List;

public class CustomerFeedbackLinguist extends MainDriverCalling {

    public CustomerFeedbackLinguist(IOSDriver<MobileElement> driver) {
        this.driverOne = driver;
    }

    public List<MobileElement> feedbackStepForLinguist() {
        return driverOne.findElementsByXPath("//android.widget.TextView[@index='0']");
    }

    public MobileElement feedbackNextBtn() {
    return driverOne.findElementByXPath("//android.widget.TextView[@text='Next']");
}

    public MobileElement feedbackSubmitBtn() {
        return driverOne.findElementByXPath("//android.widget.TextView[@text='Submit']");
    }
}
