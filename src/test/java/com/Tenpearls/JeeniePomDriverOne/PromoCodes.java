package com.Tenpearls.JeeniePomDriverOne;

import com.Tenpearls.DriverAppium.MainDriverCalling;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class PromoCodes extends MainDriverCalling {

    public PromoCodes(AndroidDriver driver) {
        this.driverOne = driver;
    }

    public MobileElement enterPromoCode() {
        return driverOne.findElementByAccessibilityId("promoCodeForm");
    }

    public MobileElement btnNext() {
        return driverOne.findElementByAccessibilityId("next");
    }

    public MobileElement closeModal() {
        return driverOne.findElementById("android:id/button1");
    }

    public MobileElement callCancel() {
        return driverOne.findElementByAccessibilityId("cancel");
    }

    public MobileElement acceptPopup() {
        return driverOne.findElementById("android:id/button2");
    }
}
