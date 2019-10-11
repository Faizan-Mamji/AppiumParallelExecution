package JeenieImplementation;

import DriverAppium.DriverAndroidTwo;
import DriverAppium.MainConfiguration;
import JeeniePomDriverTwo.LoginPomD2;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.util.concurrent.TimeUnit;

public class ImpDriverTwo extends DriverAndroidTwo {
    LoginPomD2 objLoginD2;
    MainConfiguration objMainConf;


    public ImpDriverTwo(AndroidDriver<MobileElement> driver) {
        this.driverTwo = driver;
    }

    public void loginLinguist() {
        try {
            objMainConf=new MainConfiguration();
            objLoginD2 = new LoginPomD2(driverTwo);
            TimeUnit.SECONDS.sleep(20);
            Boolean checkBtn = objLoginD2.btnSignInExist().size() > 0;
            objLoginD2.btnSignInDriverTwo().click();
            TimeUnit.SECONDS.sleep(10);
            objLoginD2.txtEmail().click();
            TimeUnit.SECONDS.sleep(3);
            objLoginD2.txtEmail().sendKeys(objMainConf.getLinguistEmail());
            TimeUnit.SECONDS.sleep(3);
            driverTwo.hideKeyboard();
            objLoginD2.txtPassword().click();
            TimeUnit.SECONDS.sleep(3);
            objLoginD2.txtPassword().sendKeys(objMainConf.getPassword());
            TimeUnit.SECONDS.sleep(3);
            driverTwo.hideKeyboard();
            TimeUnit.SECONDS.sleep(3);
            objLoginD2.btnSignInClick().click();
            TimeUnit.SECONDS.sleep(10);
        } catch (Exception ex) {
            ex.getMessage();
        }
    }
}
