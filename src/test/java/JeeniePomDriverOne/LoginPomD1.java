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

}
