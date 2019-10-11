package JeeniePomDriverOne;

import DriverAppium.DriverAndroidOne;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.util.List;

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

    public List<MobileElement> btnSignInClick() {
        //return driverOne.findElementsByAndroidUIAutomator("new UiSelector().description(\"Sign in\")");
        //return driverOne.findElementsByAndroidUIAutomator("text(\"Forgot password?\")");
        return driverOne.findElementsByAccessibilityId("Sign in");
    }

    public MobileElement btnSignnInClick() {
        //return driverOne.findElementByAndroidUIAutomator("new UiSelector().description(\"Sign in\")");
        //return driverOne.findElementByAndroidUIAutomator("text(\"Forgot password?\")");
        return driverOne.findElementByAccessibilityId("Sign in");
    }

    public List<MobileElement> checkLocation() {
        return driverOne.findElementsByAndroidUIAutomator("text(\"Skip\")");
    }
}
