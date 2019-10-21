package JeenieImplementation;

import DriverAppium.MainDriverCalling;
import DriverAppium.MainConfiguration;
import JeeniePomDriverOne.HomeCustomerD1;
import JeeniePomDriverOne.LoginCustomerD1;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class ImpMainDriverOne extends MainDriverCalling {
    Boolean checkCustomerPermission, checkPermission, balanceAlert;
    MainConfiguration objMainConf;
    LoginCustomerD1 objLoginD1;
    HomeCustomerD1 objHomeCustomer;
    Logger logg = LogManager.getLogger(ImpMainDriverOne.class);
    TouchAction ac;

    public ImpMainDriverOne(AndroidDriver<MobileElement> driver) {
        this.driverOne = driver;
    }

    public void loginCustomer() {
        try {
            ac=new TouchAction(driverOne);
            logg.info("LoginCustomer function starts here in " + LogManager.getLogger(ImpMainDriverOne.class));
            objMainConf = new MainConfiguration();
            objLoginD1 = new LoginCustomerD1(driverOne);
            TimeUnit.SECONDS.sleep(5);
            objLoginD1.btnSignInDriverOne().click();
            logg.info("SignIn Button clicks successfully");
            TimeUnit.SECONDS.sleep(2);
            objLoginD1.txtEmail().click();
            logg.info("Email clicks successfully");
            TimeUnit.SECONDS.sleep(1);
            objLoginD1.txtEmail().setValue(objMainConf.getCustomerEmail());
            driverOne.hideKeyboard();
            logg.info("Email entered successfully for customer user");
            objLoginD1.txtPassword().click();
            TimeUnit.SECONDS.sleep(1);
            logg.info("Password clicks successfully");
            objLoginD1.txtPassword().setValue(objMainConf.getPassword());
            TimeUnit.SECONDS.sleep(2);
            driverOne.hideKeyboard();
            logg.info("Password entered successfully");
            //testa = objLoginD1.btnSignInClick().size() > 0;
            logg.info("Value getting of boolean for element present");
            ac.tap(TapOptions.tapOptions().withElement(ElementOption.element(objLoginD1.btnSignInClick()))).release().perform();
            ac.tap(TapOptions.tapOptions().withElement(ElementOption.element(objLoginD1.btnSignInClick()))).release().perform();
            TimeUnit.SECONDS.sleep(15);
            logg.info("SignIn Button clicked successfully & navigate to homepage");
            logg.info("******** LoginCustomer test passed successfully in ImpMainDriverOne ********");
        } catch (Exception ex) {
            logg.info("There is an issue in loginCustomer function in class ImpMainDriverOne class - " + ex.getMessage());
        }
    }

    public void callAudio() {
        try {
            objHomeCustomer = new HomeCustomerD1(driverOne);
            logg.info("Audio Calling function starts here " + LogManager.getLogger(ImpMainDriverOne.class));
            checkPermission = objHomeCustomer.checkLocationPermissionRequest().size() > 0;
            logg.info("Location Permission pop up found" + checkPermission);
            if (checkPermission == true) {
                objHomeCustomer.btnContinue().click();
                logg.info("Click continue in permission pop up");
                TimeUnit.SECONDS.sleep(2);
                objHomeCustomer.permissionMobilePopup().click();
                logg.info("Permission pop up clicks successfully");
                TimeUnit.SECONDS.sleep(2);
            }
            objHomeCustomer.drpTranslateTo().click();
            logg.info("Translate Dropdown opens successfully");
            TimeUnit.SECONDS.sleep(1);
            objHomeCustomer.drpSelectValueTranslateTo().click();
            TimeUnit.SECONDS.sleep(1);
            logg.info("Translate dropdown value selects successfully");
            objHomeCustomer.drpNeedHelpWith().click();
            TimeUnit.SECONDS.sleep(1);
            logg.info("Need help Dropdown opens successfully");
            objHomeCustomer.drpSelectValueNeedHelpWith().click();
            TimeUnit.SECONDS.sleep(1);
            logg.info("Need help Dropdown value selects successfully");
            objHomeCustomer.btnAudioCall().click();
            logg.info("Audio Call button clicks successfully & Call starts connecting");
            checkCustomerPermission = objHomeCustomer.checkLocationPermissionRequest().size() > 0;
            logg.info("Boolean value returns is: " + checkCustomerPermission);
            balanceAlert = objHomeCustomer.checkAccountMinutes().size() > 0;
            logg.info("Boolean value returns is: " + balanceAlert);
            if (balanceAlert == true) {
                objHomeCustomer.btnContinuePopupBalance().click();
                logg.info("Button continue clicks successfully");
            }
            if (checkCustomerPermission == true) {
                objHomeCustomer.btnContinue().click();
                TimeUnit.SECONDS.sleep(1);
                logg.info("Button continue clicks successfully");
                objHomeCustomer.permissionMobilePopup().click();
                TimeUnit.SECONDS.sleep(1);
                logg.info("Permission pop up clicks successfully");
                objHomeCustomer.permissionMobilePopup().click();
                logg.info("Permission pop up clicks successfully & call connecting starts");
            }
            TimeUnit.SECONDS.sleep(25);
            objHomeCustomer.btnCancelCall().click();
            logg.info("Call cancel button clicks successfully");
            TimeUnit.SECONDS.sleep(3);
            objHomeCustomer.confirmCancelCallPopup().click();
            logg.info("Call cancel yes button clicks successfully & call canceled");
            TimeUnit.SECONDS.sleep(6);
            logg.info("******** callAudio test passed successfully in ImpMainDriverOne ********");
        } catch (Exception ex) {
            logg.info("There is an issue in callAudio function in class ImpMainDriverOne class - " + ex.getMessage());
        }
    }
}
