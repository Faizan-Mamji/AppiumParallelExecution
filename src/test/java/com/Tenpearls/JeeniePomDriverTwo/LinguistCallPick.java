package com.Tenpearls.JeeniePomDriverTwo;

import com.Tenpearls.DriverAppium.MainDriverCalling;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.util.List;

public class LinguistCallPick extends MainDriverCalling {
    public LinguistCallPick(IOSDriver<MobileElement> driver) {
        this.driverTwo = driver;
    }

    public List<MobileElement> callPickingLinguist() {
        return driverTwo.findElementsByAccessibilityId("incomingCallAccept");
    }

    public List<MobileElement> menuNavigation() {
        return driverTwo.findElementsByXPath("(//XCUIElementTypeOther[@name='Home'])[3]/XCUIElementTypeOther[1]/XCUIElementTypeOther");
    }

    public MobileElement clickHistory() {
        return driverTwo.findElementByAccessibilityId("drawerHistoryId");
    }

    public MobileElement clickCrossIcon() {
        return driverTwo.findElementByXPath("(//XCUIElementTypeOther[@name='History'])[3]/XCUIElementTypeOther[2]/XCUIElementTypeOther");
    }
}
