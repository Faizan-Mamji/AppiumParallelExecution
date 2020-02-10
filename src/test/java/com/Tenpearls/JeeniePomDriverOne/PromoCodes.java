package com.Tenpearls.JeeniePomDriverOne;

import com.Tenpearls.DriverAppium.MainDriverCalling;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class PromoCodes extends MainDriverCalling {

    public PromoCodes(AndroidDriver driver) {
        this.driverOne = driver;
    }

    public MobileElement enterPromoCode() {
        return driverOne.findElementByAndroidUIAutomator("text(\"Promo code\")");
    }

    public MobileElement btnNext() {
        return driverOne.findElementByAndroidUIAutomator("text(\"Next\")");
    }

    public MobileElement closeModal() {
        return driverOne.findElementById("android:id/button1");
    }
}
