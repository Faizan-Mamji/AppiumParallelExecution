package com.Tenpearls.JeeniePomDriverTwo;

import com.Tenpearls.DriverAppium.MainDriverCalling;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.util.List;

public class LinguistCallPick extends MainDriverCalling {
    public LinguistCallPick(AndroidDriver<MobileElement> driver) {
        this.driverTwo = driver;
    }

    public List<MobileElement> callPickingLinguist() {
        return driverTwo.findElementsByXPath("//android.widget.TextView[@index='0']");
    }
}
