package JeenieImplementation;

import DriverAppium.DriverAndroidOne;
import DriverAppium.MainConfiguration;
import JeeniePomDriverOne.LoginPomD1;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.util.concurrent.TimeUnit;

public class ImpDriverOne extends DriverAndroidOne {
    boolean testa;
    LoginPomD1 objLoginD1;
    MainConfiguration objMainConf;

    public ImpDriverOne(AndroidDriver<MobileElement> driver) {
        this.driverOne = driver;
    }

    public void loginCustomer() {
        try {
            objMainConf = new MainConfiguration();
            objLoginD1 = new LoginPomD1(driverOne);
            TimeUnit.SECONDS.sleep(5);
            objLoginD1.btnSignInDriverOne().click();
            TimeUnit.SECONDS.sleep(2);
            objLoginD1.txtEmail().click();
            TimeUnit.SECONDS.sleep(1);
            objLoginD1.txtEmail().sendKeys(objMainConf.getCustomerEmail());
            driverOne.hideKeyboard();
            objLoginD1.txtPassword().click();
            TimeUnit.SECONDS.sleep(1);
            objLoginD1.txtPassword().sendKeys(objMainConf.getPassword());
            TimeUnit.SECONDS.sleep(1);
            driverOne.hideKeyboard();
            TimeUnit.SECONDS.sleep(3);
            testa = objLoginD1.btnSignInClick().size() > 0;
            System.out.println(testa);
            if (testa == true) {
                objLoginD1.btnSignnInClick().click();
                TimeUnit.SECONDS.sleep(4);
            }
            //TimeUnit.SECONDS.sleep(20);

        } catch (Exception ex) {
            ex.getMessage();
        }
    }

}
