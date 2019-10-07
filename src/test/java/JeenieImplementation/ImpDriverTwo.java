package JeenieImplementation;

import DriverAppium.DriverAndroidTwo;
import JeeniePomDriverTwo.LoginPomD2;
import com.sun.org.apache.xpath.internal.operations.Bool;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.util.concurrent.TimeUnit;

public class ImpDriverTwo extends DriverAndroidTwo {
    LoginPomD2 objLoginD2;

    public ImpDriverTwo(AndroidDriver<MobileElement> driver) {
        this.driverTwo = driver;
    }

    public void loginLinguist() {
        try {
            objLoginD2 = new LoginPomD2(driverTwo);
            TimeUnit.SECONDS.sleep(20);
            Boolean checkBtn = objLoginD2.btnSignInExist().size() > 0;
            objLoginD2.btnSignInDriverTwo().click();
            TimeUnit.SECONDS.sleep(10);
        } catch (Exception ex) {
            ex.getMessage();
        }
    }
}
