package com.Tenpearls.JeeniePomDriverOne;

import com.Tenpearls.DriverAppium.MainDriverCalling;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import javax.swing.*;
import java.util.List;

public class PackagePurchaseAccountDetails extends MainDriverCalling {

    public PackagePurchaseAccountDetails(AndroidDriver<MobileElement> driver) {
        this.driverOne = driver;
    }

    public MobileElement tapAccountBalance() {
        return driverOne.findElementByAccessibilityId("homePricingBtnId");
    }

    public List<MobileElement> packageReloadBusiness() {
        return driverOne.findElementsByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\")).scrollIntoView("
                        + "new UiSelector().text(\"Reloadable Minutes Package\"))");

    }

    public List<MobileElement> checkReload() {
        return driverOne.findElementsByAccessibilityId("removePackage");
    }

    public MobileElement removeReloadPackage() {
        return driverOne.findElementById("android:id/button2");
    }

    public MobileElement clickViewPackages() {
        return driverOne.findElementByAccessibilityId("viewPackages");
    }

    public MobileElement selectPackage() {
        return driverOne.findElementByAccessibilityId("discountPackage_0");
    }

    public List<MobileElement> addCard() {
        return driverOne.findElementsByAccessibilityId("creditCard");
    }

    public MobileElement accountdetail_CardNumber() {
        return driverOne.findElementByAccessibilityId("cardNumber");
    }

    public MobileElement accountdetail_ExpirationDate() {
        return driverOne.findElementByAccessibilityId("expiryDate");
    }

    public MobileElement accountdetail_Cvv() {
        return driverOne.findElementByAccessibilityId("cvv");
    }

    public MobileElement accountdetail_SaveBtn() {
        return driverOne.findElementByAccessibilityId("save");
    }

    public MobileElement btn_PurchasePackage() {
        return driverOne.findElementByAccessibilityId("purchase");
    }

    public MobileElement btnOk_PaymentSuccessfull() {
        return driverOne.findElementByAccessibilityId("okButton");
    }
}
