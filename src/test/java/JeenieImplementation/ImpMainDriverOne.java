package JeenieImplementation;

import DriverAppium.MainDriverCalling;
import DriverAppium.MainConfiguration;
import JeeniePomDriverOne.*;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ImpMainDriverOne extends MainDriverCalling {
    Boolean checkCustomerPermission, checkPermission, balanceAlert;
    MainConfiguration objMainConf;
    LoginCustomerD1 objLoginD1;
    HomeCustomerD1 objHomeCustomer;
    CustomerFeedbackLinguist objCustFeedback;
    RegisterCustomer objRegister;
    LogoutCustomer objCustLogout;
    Logger logg = LogManager.getLogger(ImpMainDriverOne.class);
    TouchAction ac;
    int countButton;
    Random rnd;

    public ImpMainDriverOne(AndroidDriver<MobileElement> driver) {
        this.driverOne = driver;
    }

    public void loginCustomer() {
        try {
            ac = new TouchAction(driverOne);
            logg.info("LoginCustomer function starts here in " + LogManager.getLogger(ImpMainDriverOne.class));
            objMainConf = new MainConfiguration();
            objLoginD1 = new LoginCustomerD1(driverOne);
            TimeUnit.SECONDS.sleep(5);
            objLoginD1.btnSignInDriverOne().click();
            logg.info("SignIn Button clicks successfully");
            objLoginD1.txtEmail().click();
            logg.info("Email clicks successfully");
            objLoginD1.txtEmail().setValue(objMainConf.getCustomerEmail());
            driverOne.hideKeyboard();
            logg.info("Email entered successfully for customer user");
            objLoginD1.txtPassword().click();
            logg.info("Password clicks successfully");
            objLoginD1.txtPassword().setValue(objMainConf.getPassword());
            driverOne.hideKeyboard();
            logg.info("Password entered successfully");
            ac.tap(TapOptions.tapOptions().withElement(ElementOption.element(objLoginD1.btnSignInClick()))).release().perform();
            ac.tap(TapOptions.tapOptions().withElement(ElementOption.element(objLoginD1.btnSignInClick()))).release().perform();
            TimeUnit.SECONDS.sleep(5);
            logg.info("SignIn Button clicked successfully & navigate to homepage");
            logg.info("******** LoginCustomer test passed successfully in ImpMainDriverOne ********");
        } catch (Exception ex) {
            logg.info("There is an issue in loginCustomer function in class ImpMainDriverOne class");
            Assert.fail(ex.getMessage());
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
                objHomeCustomer.permissionMobilePopup().click();
                logg.info("Permission pop up clicks successfully");
            }
            objHomeCustomer.drpTranslateTo().click();
            logg.info("Translate Dropdown opens successfully");
            objHomeCustomer.drpSelectValueTranslateTo().click();
            logg.info("Translate dropdown value selects successfully");
            objHomeCustomer.drpNeedHelpWith().click();
            logg.info("Need help Dropdown opens successfully");
            objHomeCustomer.drpSelectValueNeedHelpWith().click();
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
                logg.info("Button continue clicks successfully");
                objHomeCustomer.permissionMobilePopup().click();
                logg.info("Permission pop up clicks successfully");
                objHomeCustomer.permissionMobilePopup().click();
                logg.info("Permission pop up clicks successfully & call connecting starts");
            }
            TimeUnit.SECONDS.sleep(10);
            logg.info("******** callAudio test passed successfully in ImpMainDriverOne ********");
        } catch (Exception ex) {
            logg.info("There is an issue in callAudio function in class ImpMainDriverOne class");
            Assert.fail(ex.getMessage());
        }
    }

    public void cancelCallByCustomer() {
        try {
            logg.info("cancel Call By Customer function starts here " + LogManager.getLogger(ImpMainDriverOne.class));
            objHomeCustomer = new HomeCustomerD1(driverOne);
            countButton = objHomeCustomer.btnCancelCall().size();
            logg.info("The total count is " + countButton);
            objHomeCustomer.btnCancelCall().get(3).click();
            logg.info("Call cancel button clicks successfully");
            TimeUnit.SECONDS.sleep(4);
            objHomeCustomer.confirmCancelCallPopup().click();
            logg.info("Call cancel yes button clicks successfully & Feedback Form Opens Successfully");
            logg.info("******** cancelCallByCustomer test passed successfully in ImpMainDriverOne ********");
            TimeUnit.SECONDS.sleep(8);
        } catch (Exception ex) {
            logg.info("There is an issue in cancelCallCustomer function in class ImpMainDriverOne class");
            Assert.fail(ex.getMessage());
        }
    }

    public void submitFeedbackByCustomer() {
        try {
            logg.info("Submit Feedback By Customer function starts here " + LogManager.getLogger(ImpMainDriverOne.class));
            objCustFeedback = new CustomerFeedbackLinguist(driverOne);
            countButton = objCustFeedback.feedbackStepForLinguist().size();
            logg.info("The total count is " + countButton);
            objCustFeedback.feedbackStepForLinguist().get(5).click();
            logg.info("Rating gives successfully by customer");
            objCustFeedback.feedbackNextBtn().click();
            logg.info("Customer moves to step2 for submit feedback");
            objCustFeedback.feedbackSubmitBtn().click();
            logg.info("Feedback form submitted successfully by customer");
            logg.info("******** submitFeedbackByCustomer test passed successfully in ImpMainDriverOne ********");
            TimeUnit.SECONDS.sleep(6);
        } catch (Exception ex) {
            logg.info("There is an issue in submitFeedbackByCustomer function in class ImpMainDriverOne class");
            Assert.fail(ex.getMessage());
        }
    }

    public void customerLogout() {
        try {
            objCustLogout = new LogoutCustomer(driverOne);
            int countsize = objCustLogout.openNavigation().size();
            logg.info("The total count is " + countsize);
            objCustLogout.openNavigation().get(0).click();
            logg.info("Left navigation click successfully");
            objCustLogout.navSettings().click();
            logg.info("Settings click successfully");
            objCustLogout.btnLogout().click();
            logg.info("Logout button click successfully");
            objCustLogout.logoutPopUp().click();
            logg.info("Yes click successfully in popup");
            TimeUnit.SECONDS.sleep(3);

        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    public void createAccount() {
        try {
            rnd = new Random();
            objRegister = new RegisterCustomer(driverOne);
            int randomNum = rnd.nextInt(9999);
            logg.info("createAccount function starts here " + LogManager.getLogger(ImpMainDriverOne.class));
            objRegister.btnGetStarted().click();
            logg.info("Register button clicks successfully");
            objRegister.txtFirstName().setValue("Faizan");
            logg.info("Name enter successfully");
            objRegister.txtEmail().setValue("A1" + randomNum + "@abc.com");
            logg.info("Email enter successfully and email is A1" + randomNum + "@abc.com");
            objRegister.txtCreatePassword().setValue("Faizan" + randomNum + "test");
            logg.info("Password enter successfully and the password is Faizan" + randomNum + "test");
            objRegister.btnCreateAccount().click();
            logg.info("Create Account button clicks successfully");
            TimeUnit.SECONDS.sleep(10);
        } catch (Exception ex) {
            ex.getMessage();
            Assert.fail();
        }
    }
}
