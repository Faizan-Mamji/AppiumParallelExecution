package com.Tenpearls.JeeniePomDriverOne;

import com.Tenpearls.DriverAppium.MainConfiguration;
import com.Tenpearls.DriverAppium.MainDriverCalling;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.util.List;

public class HomeCustomerD1 extends MainDriverCalling {

    MainConfiguration objConf = new MainConfiguration();

    public HomeCustomerD1(AndroidDriver<MobileElement> driver) {
        this.driverOne = driver;
    }

    public List<MobileElement> checkLocationPermissionRequest() {
        return driverOne.findElementsByAccessibilityId("permissionRequestLabelId");
    }

    public MobileElement btnContinue() {
        return driverOne.findElementByAccessibilityId("continueBtnId");
    }

    public MobileElement permissionMobilePopup() {
        return driverOne.findElementById("" + objConf.getMobilePopupID() + "");
    }

    public MobileElement drpSelectValueTranslateTo() {
        return driverOne.findElementByAccessibilityId("secondaryLang_1");
    }

    public List<MobileElement> selectOnBoardingList() {
        return driverOne.findElementsByAccessibilityId("scenarioItemsId0");
    }

    public MobileElement continueOnBoardingBtn() {
        return driverOne.findElementByAccessibilityId("scenarioContinueBtnId");
    }

    public MobileElement getScenerioValueHomePage() {
        return driverOne.findElementByAccessibilityId("homeScenarioId");
    }

    public MobileElement drpNeedHelpWith() {
        return driverOne.findElementByAccessibilityId("homeSecondaryLangId");
    }

    public MobileElement btnAudioCall() {
        return driverOne.findElementByAndroidUIAutomator("text(\"" + objConf.getBtnAudioText() + "\")");
    }

    public List<MobileElement> checkAccountMinutes() {
        return driverOne.findElementsById("android:id/alertTitle");
    }

    public MobileElement btnContinuePopupBalance() {
        return driverOne.findElementById("android:id/button1");
    }

    public List<MobileElement> btnCancelCall() {
        return driverOne.findElementsByXPath("//android.widget.TextView[@index='0']");
    }

    public MobileElement confirmCancelCallPopup() {
        return driverOne.findElementById("android:id/button2");
    }


}
