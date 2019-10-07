package JeenieImplementation;

import DriverAppium.DriverAndroidOne;
import JeeniePomDriverOne.LoginPomD1;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.util.concurrent.TimeUnit;

public class ImpDriverOne extends DriverAndroidOne {

    LoginPomD1 objLoginD1;

    public ImpDriverOne(AndroidDriver<MobileElement> driver) {
        this.driverOne=driver;
    }

    public void loginCustomer() {
        try {
            objLoginD1 = new LoginPomD1(driverOne);
            TimeUnit.SECONDS.sleep(20);
            objLoginD1.btnSignInDriverOne().click();
            TimeUnit.SECONDS.sleep(10);
        } catch (Exception ex) {
            ex.getMessage();
        }
    }

}
