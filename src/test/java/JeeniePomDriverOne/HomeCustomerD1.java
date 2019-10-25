package JeeniePomDriverOne;

import DriverAppium.MainConfiguration;
import DriverAppium.MainDriverCalling;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.util.List;

public class HomeCustomerD1 extends MainDriverCalling {

    MainConfiguration objConf = new MainConfiguration();

    public HomeCustomerD1(AndroidDriver<MobileElement> driver) {
        this.driverOne = driver;
    }

    public List<MobileElement> checkLocationPermissionRequest() {
        return driverOne.findElementsByAndroidUIAutomator("text(\"" + objConf.getPermissionPopUpText() + "\")");
    }

    public MobileElement btnContinue() {
        return driverOne.findElementByAndroidUIAutomator("text(\"" + objConf.getContinueBtn() + "\")");
    }

    public MobileElement permissionMobilePopup() {
        return driverOne.findElementById("" + objConf.getMobilePopupID() + "");
    }

    public MobileElement drpTranslateTo() {
        return driverOne.findElementByAndroidUIAutomator("text(\"" + objConf.getSelectTranslate() + "\")");
    }

    public MobileElement drpSelectValueTranslateTo() {
        return driverOne.findElementByAndroidUIAutomator("text(\"" + objConf.getLanguageTranslateTo() + "\")");
    }

    public MobileElement drpNeedHelpWith() {
        return driverOne.findElementByAndroidUIAutomator("text(\"" + objConf.getSelectNeedHelp() + "\")");
    }

    public MobileElement drpSelectValueNeedHelpWith() {
        return driverOne.findElementByAndroidUIAutomator("text(\" " + objConf.getNeedHelp() + "\")");
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
