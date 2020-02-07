package com.Tenpearls.JeeniePomDriverTwo;

import com.Tenpearls.DriverAppium.MainConfiguration;
import com.Tenpearls.DriverAppium.MainDriverCalling;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.util.List;

public class LinguistFeedbackCustomer extends MainDriverCalling {

    MainConfiguration objConf = new MainConfiguration();

    public LinguistFeedbackCustomer(AndroidDriver<MobileElement> driver) {
        this.driverTwo = driver;
    }

    public List<MobileElement> feedbackStep1ForCustomer() {
        return driverTwo.findElementsByAccessibilityId("starRating");
    }

    public List<MobileElement> feedbackThumbsSign() {
        return driverTwo.findElementsByAccessibilityId("thumbsUpId");
    }

    public MobileElement feedbackNextBtn() {
        return driverTwo.findElementByAccessibilityId("nextId");
    }

    public MobileElement feedbackStep2SelectTypeOfCall() {
        return driverTwo.findElementByName("" + objConf.getCallTypeText() + "");
    }

    public MobileElement clickCallDetailsSection() {
        return driverTwo.findElementByAccessibilityId("AddCallDetailsId");
    }

    public MobileElement feedbackSubmitBtn() {
        return driverTwo.findElementByAccessibilityId("submitId");
    }
}
