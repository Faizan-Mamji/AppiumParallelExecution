package com.Tenpearls.JeeniePomDriverTwo;

import com.Tenpearls.DriverAppium.MainConfiguration;
import com.Tenpearls.DriverAppium.MainDriverCalling;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.util.List;

public class LinguistFeedbackCustomer extends MainDriverCalling {

    MainConfiguration objConf = new MainConfiguration();

    public LinguistFeedbackCustomer(IOSDriver<MobileElement> driver) {
        this.driverTwo = driver;
    }

    public List<MobileElement> feedbackStep1ForCustomer() {
        return driverTwo.findElementsByXPath("(//XCUIElementTypeOther[@name=\"\uF4B3\"])[8]");
    }

    public List<MobileElement> feedbackThumbsSign() {
        return driverTwo.findElementsByXPath("//XCUIElementTypeOther[@name=\"\uF256\"]");
    }

    public MobileElement feedbackNextBtn() {
        return driverTwo.findElementByName("" + objConf.getNextbtnText() + "");
    }

    public MobileElement feedbackStep2SelectTypeOfCall() {
        return driverTwo.findElementByName("" + objConf.getCallTypeText() + "");
    }

    public MobileElement clickCallDetailsSection() {
        return driverTwo.findElementByName("" + objConf.getCallDetailsText() + "");
    }

    public List<MobileElement> typeComments() {
        return driverTwo.findElementsByIosUIAutomation("text(\"" + objConf.getCommentsMessageText() + "\")");
    }

    public List<MobileElement> closeCommentsEvent() {
        return driverTwo.findElementsByIosUIAutomation("text(\"" + objConf.getCloseEventMessageText() + "\")");
    }

    public MobileElement feedbackSubmitBtn() {
        return driverTwo.findElementByXPath("//android.widget.TextView[@text='Submit']");
    }
}
