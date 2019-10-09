package JeeniePomDriverOne;

import DriverAppium.DriverAndroidOne;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class LoginPomD1 extends DriverAndroidOne {

    public LoginPomD1(AndroidDriver<MobileElement> driver) {
        this.driverOne = driver;
    }

    public MobileElement btnSignInDriverOne() {
        return driverOne.findElementByAndroidUIAutomator("text(\"Sign In\")");
    }

    public MobileElement txtEmail() {
        return driverOne.findElementByAndroidUIAutomator("text(\"Email\")");
    }

    public MobileElement txtPassword() {
        return driverOne.findElementByAndroidUIAutomator("text(\"Password\")");
    }

    public MobileElement btnSignInClick() {
        return driverOne.findElementByXPath("//android.view.ViewGroup[@index='6']");
    }
}
