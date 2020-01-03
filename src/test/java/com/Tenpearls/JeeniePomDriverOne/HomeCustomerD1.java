package com.Tenpearls.JeeniePomDriverOne;

import com.Tenpearls.DriverAppium.MainConfiguration;
import com.Tenpearls.DriverAppium.MainDriverCalling;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

import java.util.List;

public class HomeCustomerD1 extends MainDriverCalling {

    MainConfiguration objConf = new MainConfiguration();

    public HomeCustomerD1(IOSDriver<MobileElement> driver) {
        this.driverOne = driver;
    }

    public List<MobileElement> checkLocationPermissionRequest() {
        return driverOne.findElementsByAccessibilityId("permissionRequestLabelId");
    }

    public MobileElement btnContinue() {
        return driverOne.findElementByAccessibilityId("continueBtnId");
    }

    public List<MobileElement> permissionMobilePopup() {
        return driverOne.findElementsByAccessibilityId("Allow");
        //return driverOne.findElementsById("" + objConf.getMobilePopupID() + "");
    }

    public List<MobileElement> permssionFeaturesiOSPopup() {
        return driverOne.findElementsByAccessibilityId("OK");
    }

    public MobileElement drpSelectValueTranslateTo(String NeedHelpDropdown) {
        return driverOne.findElementByAccessibilityId("" + NeedHelpDropdown + "");
        //return driverOne.findElementByAccessibilityId("secondaryLang_1");
    }

    public List<MobileElement> selectOnBoardingList() {
        return driverOne.findElementsByAccessibilityId("scenarioItemsId0");
    }

    public MobileElement selectListValue(String drplistvalue) {
        return driverOne.findElementByAccessibilityId("" + drplistvalue + "");
    }

    public MobileElement continueOnBoardingBtn() {
        return driverOne.findElementByAccessibilityId("scenarioContinueBtnId");
    }

    public MobileElement drpNeedHelpWith() {
        return driverOne.findElementByAccessibilityId("homeSecondaryLangId");
    }

    public MobileElement btnAudioCall() {
        return driverOne.findElementByAccessibilityId("homeAudioCallBtnId");
    }
}
