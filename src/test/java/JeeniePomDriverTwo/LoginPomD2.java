package JeeniePomDriverTwo;

import DriverAppium.DriverAndroidTwo;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.util.List;

public class LoginPomD2 extends DriverAndroidTwo {

    public LoginPomD2(AndroidDriver<MobileElement> driver) {
        this.driverTwo = driver;
    }

    public List<MobileElement> btnSignInExist() {
        return driverTwo.findElementsByAndroidUIAutomator("text(\"Sign In\")");
    }

    public MobileElement btnSignInDriverTwo() {
        return driverTwo.findElementByAndroidUIAutomator("text(\"Sign In\")");
    }

}
