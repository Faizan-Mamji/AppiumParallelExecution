package com.Tenpearls.JeeniePomDriverOne;

import com.Tenpearls.DriverAppium.MainDriverCalling;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

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

    public List<MobileElement> clickViewPackages() {
        return driverOne.findElementsByAccessibilityId("viewPackages");
    }

    public MobileElement selectPackage() {
        return driverOne.findElementByAccessibilityId("discountPackage_0");
    }

    public List<MobileElement> addCard() {
        return driverOne.findElementsByAccessibilityId("creditCard");
    }

    public MobileElement accountdetailCardNumber() {
        return driverOne.findElementByAccessibilityId("cardNumber");
    }

    public MobileElement accountdetailExpirationDate() {
        return driverOne.findElementByAccessibilityId("expiryDate");
    }

    public MobileElement accountdetailCvv() {
        return driverOne.findElementByAccessibilityId("cvv");
    }

    public MobileElement accountdetail_SaveBtn() {
        return driverOne.findElementByAccessibilityId("save");
    }

    public MobileElement btnPurchasePackage() {
        return driverOne.findElementByAccessibilityId("purchase");
    }

    public MobileElement btnOkPaymentSuccessfull() {
        return driverOne.findElementByAccessibilityId("okButton");
    }

    public List<MobileElement> btnAddCard() {
        return driverOne.findElementsByAccessibilityId("offersBtnText");
    }

    public MobileElement btnAddPayments() {
        return driverOne.findElementByAccessibilityId("addPaymentMethodBtn");
    }

    public MobileElement btnEditPayments() {
        return driverOne.findElementByAccessibilityId("editPaymentMethodBtn");
    }

    public MobileElement btnRemoveCardPayment() {
        return driverOne.findElementByAccessibilityId("removeCard");
    }

    public MobileElement confirmRemoveCardPopup() {
        return driverOne.findElementById("android:id/button1");
    }
}
