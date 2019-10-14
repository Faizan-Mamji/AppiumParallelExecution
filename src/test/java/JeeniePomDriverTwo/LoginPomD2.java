package JeeniePomDriverTwo;

import DriverAppium.MainDriverCalling;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.util.List;

public class LoginPomD2 extends MainDriverCalling {

    public LoginPomD2(AndroidDriver<MobileElement> driver) {
        this.driverTwo = driver;
    }

    public List<MobileElement> btnSignInExist() {
        return driverTwo.findElementsByAndroidUIAutomator("text(\"Sign In\")");
    }

    public MobileElement btnSignInDriverTwo() {
        return driverTwo.findElementByAndroidUIAutomator("text(\"Sign In\")");
    }

    public MobileElement txtEmail() {
        return driverTwo.findElementByAndroidUIAutomator("text(\"Email\")");
    }

    public MobileElement txtPassword() {
        return driverTwo.findElementByAndroidUIAutomator("text(\"Password\")");
    }

    public MobileElement btnSignInClick() {
        return driverTwo.findElementByAccessibilityId("Sign in");
    }

    public List<MobileElement> checkLocation() {
        return driverTwo.findElementsByAndroidUIAutomator("text(\"Skip\")");
    }

}
