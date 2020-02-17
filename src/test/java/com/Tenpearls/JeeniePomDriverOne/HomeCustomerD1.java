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

    public List<MobileElement> permissionMobilePopup() {
        return driverOne.findElementsById("" + objConf.getMobilePopupID() + "");
    }

    public List<MobileElement> drpSelectValueTranslateTo(String NeedHelpDropdown) {
        return driverOne.findElementsByAndroidUIAutomator("text(\"" + NeedHelpDropdown + "\")");
        //return driverOne.findElementByAccessibilityId("secondaryLang_1");
    }

    public List<MobileElement> selectOnBoardingList() {
        return driverOne.findElementsByAccessibilityId("scenarioItemsId0");
    }

    public MobileElement selectListValue(String drplistvalue) {
        return driverOne.findElementByAndroidUIAutomator("text(\"" + drplistvalue + "\")");
    }

    public MobileElement continueOnBoardingBtn() {
        return driverOne.findElementByAccessibilityId("scenarioContinueBtnId");
    }

    public MobileElement drpSpeak() {
        return driverOne.findElementByAccessibilityId("homePrimaryLangTextId");
    }

    public MobileElement drpNeedHelpWithText() {
        return driverOne.findElementByAccessibilityId("homeSecondaryLangTextId");
    }

    public MobileElement drpISpeak() {
        return driverOne.findElementByAccessibilityId("homePrimaryLangId");
    }

    public MobileElement drpScenario() {
        return driverOne.findElementByAccessibilityId("homeScenarioId");
    }

    public List<MobileElement> drpSelectValueISpeak(String ISpeakDropdown) {
        return driverOne.findElementsByAndroidUIAutomator("text(\"" + ISpeakDropdown + "\")");
        //return driverOne.findElementByAccessibilityId("secondaryLang_1");
    }

    public MobileElement drpNeedHelpWith() {
        return driverOne.findElementByAccessibilityId("homeSecondaryLangId");
    }

    public MobileElement btnAudioCall() {
        return driverOne.findElementByAccessibilityId("homeAudioCallBtnId");
    }

    public List<MobileElement> btnCancelCall() {
        return driverOne.findElementsByAccessibilityId("endCallBtnId");
    }

    public MobileElement confirmCancelCallPopup() {
        return driverOne.findElementById("android:id/button2");
    }

    public List<MobileElement> accountBalance() {
        return driverOne.findElementsByAccessibilityId("customerBalance");
    }

    public List<MobileElement> packageReloadAvailable() {
        return driverOne.findElementsByAccessibilityId("autoReload");
    }
}
