package com.Tenpearls.JeenieImplementation;

import com.Tenpearls.DriverAppium.MainDriverCalling;
import com.Tenpearls.DriverAppium.MainConfiguration;
import com.Tenpearls.JeeniePomDriverOne.*;
import com.Tenpearls.JeeniePomDriverTwo.HomeLinguistD2;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.HideKeyboardStrategy;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ImpMainDriverOne extends MainDriverCalling {
    Boolean checkCustomerPermission, checkPermission, checkCancelIcon, permissionCheck, onBoardingCheck, CheckSignInBtn, IntroPopUpCheck, checkWifiEnabled, checkDataEnabled, CheckContinueBtn, CheckAllow, CheckOk;
    MainConfiguration objMainConf = new MainConfiguration();
    LoginCustomerD1 objLoginD1;
    PackagePurchaseAccountDetails objPackage;
    HomeCustomerD1 objHomeCustomer;
    CustomerFeedbackLinguist objCustFeedback;
    RegisterCustomer objRegister;
    LogoutCustomer objCustLogout;
    Logger logg = LogManager.getLogger(ImpMainDriverOne.class);
    TouchAction ac;
    String getOnBoardingValue, getScenarioId,
            scenario_TextOne = "Global Business Meetings",
            NeedHelpValue = "Chinese (Mandarin)";
    int countButton, getFirstHeight, getSecondHeight;
    Random rnd;

    public ImpMainDriverOne(IOSDriver<MobileElement> driver) {
        this.driverOne = driver;
    }

    public void loginCustomer() {
        try {
            ac = new TouchAction(driverOne);
            logg.info("LoginCustomer function starts here in " + LogManager.getLogger(ImpMainDriverOne.class));
            objMainConf = new MainConfiguration();
            objLoginD1 = new LoginCustomerD1(driverOne);
            TimeUnit.SECONDS.sleep(10);
//            permissionCheck = objLoginD1.checkLaunchPopup().size() > 0;
//            logg.info("Get value is " + permissionCheck);
//            if (permissionCheck == true) {
//                logg.info("Popup is accessible now");
//                objLoginD1.checkLaunchPopup().get(0).click();
//                logg.info("Allow Popup closed successfully");
//                TimeUnit.SECONDS.sleep(5);
//            }
            CheckSignInBtn = objLoginD1.btnSignInDriverOne().size() > 0;
            logg.info("SignIn Button exist on Jeenie page = " + CheckSignInBtn);
            if (CheckSignInBtn == true) {
                objLoginD1.btnSignInDriverOne().get(0).click();
                logg.info("SignIn Button clicks successfully");
            }
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
            logg.info("SignIn Button clicked successfully & navigate to OnBoarding/homepage Screen");
            checkOnboardingScreen();
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
            //Check Mobile Permission
            MobilePermissions();
            PackagePurchasecreditDetails();
            objHomeCustomer.drpNeedHelpWith().click();
            logg.info("Need help Dropdown opens successfully");
            objHomeCustomer.drpSelectValueTranslateTo("secondaryLang_2").click();
            logg.info("Need help Dropdown value selects successfully");
            objHomeCustomer.btnAudioCall().click();
            logg.info("Audio Call button clicks successfully & Call starts connecting");
            checkCustomerPermission = objHomeCustomer.checkLocationPermissionRequest().size() > 0;
            logg.info("Boolean value returns is: " + checkCustomerPermission);

            if (checkCustomerPermission == true) {
                objHomeCustomer.btnContinue().click();
                logg.info("Button continue clicks successfully");
                objHomeCustomer.permissionMobilePopup().get(0).click();
                logg.info("Permission pop up clicks successfully");
                objHomeCustomer.permissionMobilePopup().get(0).click();
                logg.info("Permission pop up clicks successfully & call connecting starts");
            }
            TimeUnit.SECONDS.sleep(15);
            logg.info("******** callAudio test passed successfully in ImpMainDriverOne ********");
        } catch (Exception ex) {
            logg.info("There is an issue in callAudio function in class ImpMainDriverOne class");
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
            objCustLogout.openNavigation().click();
            logg.info("Left navigation click successfully");
            objCustLogout.navSettings().click();
            logg.info("Settings click successfully");
            objCustLogout.btnLogout().click();
            logg.info("Logout button click successfully");
            objCustLogout.logoutPopUp().click();
            logg.info("Yes click successfully in popup");
            TimeUnit.SECONDS.sleep(3);

        } catch (Exception ex) {
            logg.info("There is an issue in customerLogout function in class ImpMainDriverOne class");
            Assert.fail(ex.getMessage());
        }
    }

    public void createAccount() {
        TouchAction ac = new TouchAction(driverOne);
        try {
            iOSLaunchPopup();
            rnd = new Random();
            objRegister = new RegisterCustomer(driverOne);
            int randomNum = rnd.nextInt(9999);
            logg.info("createAccount function starts here " + LogManager.getLogger(ImpMainDriverOne.class));
            objRegister.btnGetStarted().click();
            logg.info("Register button clicks successfully");
            getFirstHeight = objRegister.txtEmail().getSize().height;
            getSecondHeight = objRegister.txtCreatePassword().getSize().height;
            objRegister.txtFirstName().setValue("Faizan");
            logg.info("Name enter successfully");
            objRegister.txtEmail().setValue("A1" + randomNum + "@abc.com");
            logg.info("Email enter successfully and email is A1" + randomNum + "@abc.com");
            objRegister.txtCreatePassword().setValue("Faizan" + randomNum + "test");
            logg.info("Password enter successfully and the password is Faizan" + randomNum + "test");
            ac.press(PointOption.point(getFirstHeight, getSecondHeight)).moveTo(PointOption.point(getSecondHeight, getSecondHeight + 10)).perform().release();
            logg.info("Keyboard closed successfully");
            objRegister.btnCreateAccount().click();
            logg.info("Create Account button clicks successfully");
            TimeUnit.SECONDS.sleep(10);
            checkOnboardingScreen();
        } catch (Exception ex) {
            logg.info("There is an issue in createAccount function in class ImpMainDriverOne class");
            Assert.fail(ex.getMessage());
        }
    }

    public void checkOnboardingScreen() {
        try {
            objHomeCustomer = new HomeCustomerD1(driverOne);
            onBoardingCheck = objHomeCustomer.selectOnBoardingList().size() > 0;
            logg.info("Onboarding page found = " + onBoardingCheck);
            if (onBoardingCheck == true) {
                getOnBoardingValue = objHomeCustomer.selectListValue("scenarioItemsId1").getText();
                logg.info("Getting Onboarding list value is " + getOnBoardingValue);
                objHomeCustomer.selectListValue("scenarioItemsId1").click();
                logg.info("Onboarding value selected successfully");
                objHomeCustomer.continueOnBoardingBtn().click();
                TimeUnit.SECONDS.sleep(7);
                logg.info("Continue button clicks successfully & navigate to home page");
//                getScenarioId = objHomeCustomer.getScenerioValueHomePage().getText();
//                logg.info("Get Scenario id value from home page");
//                Assert.assertEquals(getOnBoardingValue, getScenarioId);
//                logg.info("Assertion Passed!!");
            }
        } catch (Exception ex) {
            logg.info("There is an issue in checkOnboardingScreen function in class ImpMainDriverOne class");
            Assert.fail(ex.getMessage());
        }
    }

    public void MobilePermissions() {
        try {
            objHomeCustomer = new HomeCustomerD1(driverOne);
            logg.info("Receive Calling function starts here " + LogManager.getLogger(ImpMainDriverTwo.class));
            checkPermission = objHomeCustomer.checkLocationPermissionRequest().size() > 0;
            logg.info("Location Permission pop up found " + checkPermission);
            if (checkPermission == true) {
                objHomeCustomer.btnContinue().click();
                logg.info("Click continue in permission pop up where it failed sometimes");
                TimeUnit.SECONDS.sleep(10);
                CheckAllow = objHomeCustomer.permissionMobilePopup().size() > 0;
                CheckOk = objHomeCustomer.permssionFeaturesiOSPopup().size() > 0;
                if (CheckAllow == true) {
                    objHomeCustomer.permissionMobilePopup().get(0).click();
                    TimeUnit.SECONDS.sleep(2);
                    logg.info("Permission pop up clicks successfully");

                    CheckAllow = objHomeCustomer.permissionMobilePopup().size() > 0;
                    if (CheckAllow == true) {
                        objHomeCustomer.permissionMobilePopup().get(0).click();
                        TimeUnit.SECONDS.sleep(2);
                        logg.info("Permission pop up clicks successfully");
                    }
                    CheckAllow = objHomeCustomer.permissionMobilePopup().size() > 0;
                    if (CheckAllow == true) {
                        objHomeCustomer.permissionMobilePopup().get(0).click();
                        TimeUnit.SECONDS.sleep(2);
                        logg.info("Permission pop up clicks successfully");
                    }
                }
                if (CheckOk == true) {
                    objHomeCustomer.permssionFeaturesiOSPopup().get(0).click();
                    TimeUnit.SECONDS.sleep(1);
                    logg.info("Permission OK 1 clicks successfully");

                    CheckOk = objHomeCustomer.permssionFeaturesiOSPopup().size() > 0;
                    if (CheckOk == true) {
                        objHomeCustomer.permssionFeaturesiOSPopup().get(0).click();
                        TimeUnit.SECONDS.sleep(1);
                        logg.info("Permission OK 2 clicks successfully");
                    }
                    CheckAllow = objHomeCustomer.permissionMobilePopup().size() > 0;
                    logg.info("Permission Allow after two OK popups in 3 requests " + CheckAllow);
                    CheckOk = objHomeCustomer.permssionFeaturesiOSPopup().size() > 0;
                    logg.info("Permission Allow after two OK popups in 3 requests " + CheckOk);
                    if (CheckOk == true) {
                        objHomeCustomer.permssionFeaturesiOSPopup().get(0).click();
                        TimeUnit.SECONDS.sleep(1);
                        logg.info("Permission OK 3 clicks successfully");
                    }
                    if (CheckAllow == true) {
                        objHomeCustomer.permissionMobilePopup().get(0).click();
                        TimeUnit.SECONDS.sleep(2);
                        logg.info("Permission pop up clicks successfully");
                    }
                }
            }

        } catch (Exception ex) {
            logg.info("There is an issue in AndroidPermissions function in class ImpMainDriverOne class");
            Assert.fail(ex.getMessage());
        }
    }

    //Limitation for iOS (Unable to do internet connectivity in iOS)

    public void PackagePurchasecreditDetails() {
        try {
            ac = new TouchAction(driverOne);
            objPackage = new PackagePurchaseAccountDetails(driverOne);
            objPackage.tapAccountBalance().click();
            logg.info("Account Balance Dropdown opens successfully");
            objPackage.selectPackage().click();
            logg.info("Package clicks successfully");
            objPackage.addCard().click();
            logg.info("Add card clicks successfully & add credit card page opens");
//            getFirstHeight = objPackage.accountdetail_SaveBtn().getSize().height;
//            getSecondHeight = objPackage.btn_Paypal().getSize().height;
//            logg.info("The height is " + getFirstHeight, getSecondHeight);
            objPackage.accountdetail_CardNumber().setValue(objMainConf.getAccountCardNumber());
            logg.info("Credit Card Number Enter successfully");
            objPackage.accountdetail_ExpirationDate().setValue(objMainConf.getExpirationDate());
            logg.info("Expiration Date Enter successfully");
            objPackage.accountdetail_Cvv().setValue(objMainConf.getCvvNumber());
            logg.info("Cvv Number Enter successfully");
            TimeUnit.SECONDS.sleep(3);
            //ac.tap(PointOption.point(getFirstHeight, getSecondHeight)).moveTo(PointOption.point(getFirstHeight, getSecondHeight - 30)).perform().release();
            objPackage.accountdetail_CvvIcon().click();
            TimeUnit.SECONDS.sleep(3);
            objPackage.accountdetail_SaveBtn().click();
            logg.info("Button clicks successfully & account details entered successfully");
            TimeUnit.SECONDS.sleep(10);
            objPackage.btn_PurchasePackage().click();
            logg.info("Package purchased button click successfully");
            objPackage.btnOk_PaymentSuccessfull().click();
            logg.info("Payment successful Ok button click successfully");
        } catch (Exception ex) {
            logg.info("There is an issue in PackagecreditDetails function in class ImpMainDriverOne class");
            Assert.fail(ex.getMessage());
        }
    }

    public void iOSLaunchPopup() {
        try {
            objRegister = new RegisterCustomer(driverOne);
            TimeUnit.SECONDS.sleep(10);
            permissionCheck = objRegister.checkLaunchPopup().size() > 0;
            logg.info("Get value is " + permissionCheck);
            if (permissionCheck == true) {
                logg.info("Popup is accessible now");
                objRegister.checkLaunchPopup().get(0).click();
                logg.info("Allow Popup closed successfully");
                TimeUnit.SECONDS.sleep(5);
            }
        } catch (Exception ex) {
            logg.info("There is an issue in iOSLaunchPopup function in class ImpMainDriverOne class");
            Assert.fail(ex.getMessage());
        }
    }
}
