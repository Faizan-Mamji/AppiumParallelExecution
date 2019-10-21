package JeenieImplementation;

import DriverAppium.MainConfiguration;
import DriverAppium.MainDriverCalling;
import JeeniePomDriverTwo.HomeLinguistD2;
import JeeniePomDriverTwo.LoginLinguistD2;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.concurrent.TimeUnit;

public class ImpMainDriverTwo extends MainDriverCalling {
    LoginLinguistD2 objLoginD2;
    HomeLinguistD2 objLinguist;
    MainConfiguration objMainConf;
    Boolean checkPermission, CheckContinueBtn, PermissionCheck, checkAllowBtn;
    Logger logg = LogManager.getLogger(ImpMainDriverTwo.class);
    String LinguistStatus;
    TouchAction ac;
    String StatusText = "Offline";

    public ImpMainDriverTwo(AndroidDriver<MobileElement> driver) {
        this.driverTwo = driver;
    }

    public void loginLinguist() {
        try {
            ac=new TouchAction(driverTwo);
            logg.info("LoginLinguist function starts here in " + LogManager.getLogger(ImpMainDriverTwo.class));
            objMainConf = new MainConfiguration();
            objLoginD2 = new LoginLinguistD2(driverTwo);
            TimeUnit.SECONDS.sleep(20);
            Boolean checkBtn = objLoginD2.btnSignInExist().size() > 0;
            objLoginD2.btnSignInDriverTwo().click();
            TimeUnit.SECONDS.sleep(10);
            logg.info("SignIn Button clicks successfully");
            objLoginD2.txtEmail().click();
            TimeUnit.SECONDS.sleep(3);
            logg.info("Email clicks successfully");
            objLoginD2.txtEmail().setValue(objMainConf.getLinguistEmail());
            TimeUnit.SECONDS.sleep(3);
            driverTwo.hideKeyboard();
            logg.info("Email entered successfully for linguist user");
            objLoginD2.txtPassword().click();
            TimeUnit.SECONDS.sleep(2);
            logg.info("Password clicks successfully");
            objLoginD2.txtPassword().setValue(objMainConf.getPassword());
            driverTwo.hideKeyboard();
            logg.info("Password entered successfully");
            ac.tap(TapOptions.tapOptions().withElement(ElementOption.element(objLoginD2.btnSignInClick()))).release().perform();
            ac.tap(TapOptions.tapOptions().withElement(ElementOption.element(objLoginD2.btnSignInClick()))).release().perform();
            //objLoginD2.btnSignInClick().click();
            TimeUnit.SECONDS.sleep(15);
            logg.info("SignIn Button clicked successfully & navigate to linguist homepage");
            logg.info("******** LoginLinguist test passed successfully in ImpMainDriverTwo ********");
        } catch (Exception ex) {
            logg.info("There is an issue in loginLinguist function in class ImpMainDriverTwo class - " + ex.getMessage());
        }
    }

    public void lingustPermissionCheck() {
        try {
            objLinguist = new HomeLinguistD2(driverTwo);
            logg.info("Receive Calling function starts here " + LogManager.getLogger(ImpMainDriverTwo.class));
            checkPermission = objLinguist.checkLocationPermissionRequest().size() > 0;
            logg.info("Location Permission pop up found " + checkPermission);
            if (checkPermission == true) {
                objLinguist.btnContinue().click();
                logg.info("Click continue in permission pop up");
                TimeUnit.SECONDS.sleep(2);
                objLinguist.permissionMobilePopup().click();
                logg.info("Permission pop up clicks successfully");
                TimeUnit.SECONDS.sleep(2);
            }
            checkAllowBtn = objLinguist.btnAllowCheck().size() > 0;
            logg.info("Allow button found in pop up " + checkPermission);
            if (checkAllowBtn == true) {
                objLinguist.btnAllowClick().click();
                logg.info("Allow button Click successfully");
                TimeUnit.SECONDS.sleep(2);
            }
            checkAllowBtn = objLinguist.btnAllowCheck().size() > 0;
            logg.info("Allow button found in pop up " + checkPermission);
            if (checkAllowBtn == true) {
                objLinguist.btnAllowClick().click();
                logg.info("Allow button Click successfully");
                TimeUnit.SECONDS.sleep(2);
            }
            LinguistStatus = objLinguist.checkLinguistText().getText();
            logg.info("Get the Linguist status whether its Online/ Offline " + LinguistStatus);
            if (LinguistStatus.contains(StatusText)) {
                objLinguist.changeToOnline().click();
                TimeUnit.SECONDS.sleep(2);
                logg.info("Linguist status Changed to Online");
            }
            CheckContinueBtn = objLinguist.btnContinueCheck().size() > 0;
            if (CheckContinueBtn == true) {
                objLinguist.btnContinue().click();
                TimeUnit.SECONDS.sleep(2);
                logg.info("Button continue clicks successfully");
                PermissionCheck = objLinguist.checkPermissionMobilePopup().size() > 0;
                if (PermissionCheck == true) {
                    objLinguist.permissionMobilePopup().click();
                    TimeUnit.SECONDS.sleep(3);
                    logg.info("Permission pop up clicks successfully");
                }
                PermissionCheck = objLinguist.checkPermissionMobilePopup().size() > 0;
                if (PermissionCheck == true) {
                    objLinguist.permissionMobilePopup().click();
                    TimeUnit.SECONDS.sleep(1);
                    logg.info("Permission pop up clicks successfully");
                }
                PermissionCheck = objLinguist.checkPermissionMobilePopup().size() > 0;
                if (PermissionCheck == true) {
                    objLinguist.permissionMobilePopup().click();
                    TimeUnit.SECONDS.sleep(1);
                    logg.info("Permission pop up clicks successfully");
                }
            }
            LinguistStatus = objLinguist.checkLinguistText().getText();
            if (LinguistStatus.contains(StatusText)) {
                Boolean check1 = objLinguist.chaneToOnline().size() > 0;
                logg.info("Linguist status Changed to Online " + check1);
                objLinguist.changeToOnline().click();
                TimeUnit.SECONDS.sleep(2);
                logg.info("Linguist status Changed to Online");
            }
            logg.info("******** lingustPermissionCheck test passed successfully in ImpMainDriverTwo ********");
        } catch (Exception ex) {
            logg.info("There is an issue in lingustPermissionCheck function in class ImpMainDriverTwo class - " + ex.getMessage());
        }
    }

    public void lingustCallCancelNotification() {
        try {
            objLinguist = new HomeLinguistD2(driverTwo);
            logg.info("lingust Call Cancel Notification function starts here " + LogManager.getLogger(ImpMainDriverTwo.class));
            objLinguist.cancelledCallNotification().click();
            TimeUnit.SECONDS.sleep(1);
            logg.info("Notification clicks successfully");
            logg.info("******** lingustCallCancelNotification test passed successfully in ImpMainDriverTwo ********");
        } catch (Exception ex) {
            logg.info("There is an issue in lingustCallCancelNotification function in class ImpMainDriverTwo class - " + ex.getMessage());
        }
    }
}
