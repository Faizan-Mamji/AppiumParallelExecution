package com.Tenpearls.JeeniePomDriverOne;

import com.Tenpearls.DriverAppium.MainDriverCalling;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.util.List;

public class CustomerFeedbackLinguist extends MainDriverCalling {

    public CustomerFeedbackLinguist(AndroidDriver<MobileElement> driver) {
        this.driverOne = driver;
    }

    public MobileElement selectStarFive() {
        return driverOne.findElementByAccessibilityId("ratingStar5");
    }

    public MobileElement addComments() {
        return driverOne.findElementByAccessibilityId("AddCommentsId");
    }

    public MobileElement feedbackSubmitBtn() {
        return driverOne.findElementByAccessibilityId("submit");
    }
}
