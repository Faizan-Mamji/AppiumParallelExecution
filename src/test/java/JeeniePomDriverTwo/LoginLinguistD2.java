package JeeniePomDriverTwo;

import DriverAppium.MainConfiguration;
import DriverAppium.MainDriverCalling;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.util.List;

public class LoginLinguistD2 extends MainDriverCalling {

    MainConfiguration objConf = new MainConfiguration();

    public LoginLinguistD2(AndroidDriver<MobileElement> driver) {
        this.driverTwo = driver;
    }

    public List<MobileElement> btnSignInExist() {
        return driverTwo.findElementsByAndroidUIAutomator("text(\""+objConf.getSignInText()+"\")");
    }

    public MobileElement btnSignInDriverTwo() {
        return driverTwo.findElementByAndroidUIAutomator("text(\""+objConf.getSignInText()+"\")");
    }

    public MobileElement txtEmail() {
        return driverTwo.findElementByAndroidUIAutomator("text(\""+objConf.getEmailText()+"\")");
    }

    public MobileElement txtPassword() {
        return driverTwo.findElementByAndroidUIAutomator("text(\""+objConf.getPasswordText()+"\")");
    }

    public MobileElement btnSignInClick() {
        return driverTwo.findElementByXPath("//android.widget.TextView[@text='Sign in']");
    }
}
