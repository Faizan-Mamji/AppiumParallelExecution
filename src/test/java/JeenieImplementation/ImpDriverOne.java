package JeenieImplementation;

import DriverAppium.DriverAndroidOne;
import DriverAppium.MainConfiguration;
import JeeniePomDriverOne.LoginPomD1;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.util.concurrent.TimeUnit;

public class ImpDriverOne extends DriverAndroidOne {

    LoginPomD1 objLoginD1;
    String emailCustomer;
    MainConfiguration objMainConf;

    public ImpDriverOne(AndroidDriver<MobileElement> driver) {
        this.driverOne=driver;
    }

    public void loginCustomer() {
        try {
            objMainConf=new MainConfiguration(driverOne);
            objLoginD1 = new LoginPomD1(driverOne);
            TimeUnit.SECONDS.sleep(20);
            objLoginD1.btnSignInDriverOne().click();
            TimeUnit.SECONDS.sleep(10);
            objLoginD1.txtEmail().click();
            TimeUnit.SECONDS.sleep(3);
            objLoginD1.txtEmail().sendKeys(objMainConf.getCustomerEmail());
            driverOne.hideKeyboard();
            objLoginD1.txtPassword().click();
            TimeUnit.SECONDS.sleep(3);
            objLoginD1.txtPassword().sendKeys(objMainConf.getPassword());
            TimeUnit.SECONDS.sleep(3);
            driverOne.hideKeyboard();
            TimeUnit.SECONDS.sleep(3);
            objLoginD1.btnSignInClick().click();
            TimeUnit.SECONDS.sleep(10);

        } catch (Exception ex) {
            ex.getMessage();
        }
    }

}
