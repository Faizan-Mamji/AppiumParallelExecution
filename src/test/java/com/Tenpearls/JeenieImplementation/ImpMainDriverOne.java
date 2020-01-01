package com.Tenpearls.JeenieImplementation;

import com.Tenpearls.DriverAppium.MainDriverCalling;
import com.Tenpearls.DriverAppium.MainConfiguration;
import com.Tenpearls.JeeniePomDriverOne.*;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ImpMainDriverOne extends MainDriverCalling {
    Boolean checkCustomerPermission, checkPermission, balanceAlert, onBoardingCheck, permissionCheck, CheckSignInBtn, IntroPopUpCheck, checkWifiEnabled, checkDataEnabled;
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
    ;
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
            AndroidPermissions();
            PackagePurchasecreditDetails();
            objHomeCustomer.drpNeedHelpWith().click();
            logg.info("Need help Dropdown opens successfully");
            objHomeCustomer.drpSelectValueTranslateTo(NeedHelpValue).click();
            logg.info("Need help Dropdown value selects successfully");
            objHomeCustomer.btnAudioCall().click();
            logg.info("Audio Call button clicks successfully & Call starts connecting");
            checkCustomerPermission = objHomeCustomer.checkLocationPermissionRequest().size() > 0;
            logg.info("Boolean value returns is: " + checkCustomerPermission);
//            balanceAlert = objHomeCustomer.checkAccountMinutes().size() > 0;
//            logg.info("Boolean value returns is: " + balanceAlert);
//            if (balanceAlert == true) {
//                objHomeCustomer.btnContinuePopupBalance().click();
//                logg.info("Button continue clicks successfully");
//            }
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

    public void cancelCallByCustomer() {
        try {
            logg.info("cancel Call By Customer function starts here " + LogManager.getLogger(ImpMainDriverOne.class));
            objHomeCustomer = new HomeCustomerD1(driverOne);
            InternetConnectivity();
            countButton = objHomeCustomer.btnCancelCall().size();
            logg.info("The total count is " + countButton);
            objHomeCustomer.btnCancelCall().get(3).click();
            logg.info("Call cancel button clicks successfully");
            TimeUnit.SECONDS.sleep(2);
            objHomeCustomer.confirmCancelCallPopup().click();
            logg.info("Call cancel yes button clicks successfully & Feedback Form Opens Successfully");
            logg.info("******** cancelCallByCustomer test passed successfully in ImpMainDriverOne ********");
            TimeUnit.SECONDS.sleep(8);
            EnableWifiAgain();
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
            logg.info("There is an issue in customerLogout function in class ImpMainDriverOne class");
            Assert.fail(ex.getMessage());
        }
    }

    public void createAccount() {
        try {
            rnd = new Random();
            objRegister = new RegisterCustomer(driverOne);
            int randomNum = rnd.nextInt(9999);
            logg.info("createAccount function starts here " + LogManager.getLogger(ImpMainDriverOne.class));
            TimeUnit.SECONDS.sleep(10);
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
                getOnBoardingValue = objHomeCustomer.selectListValue(scenario_TextOne).getText();
                logg.info("Getting Onboarding list value is " + getOnBoardingValue);
                objHomeCustomer.selectListValue(scenario_TextOne).click();
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

    public void AndroidPermissions() {
        try {
            objHomeCustomer = new HomeCustomerD1(driverOne);
            logg.info("AndroidPermissions function starts here " + LogManager.getLogger(ImpMainDriverOne.class));
            checkPermission = objHomeCustomer.checkLocationPermissionRequest().size() > 0;
            logg.info("Location Permission pop up found" + checkPermission);
            if (checkPermission == true) {
                objHomeCustomer.btnContinue().click();
                logg.info("Click continue in permission pop up");
                permissionCheck = objHomeCustomer.permissionMobilePopup().size() > 0;
                if (permissionCheck == true) {
                    objHomeCustomer.permissionMobilePopup().get(0).click();
                    logg.info("Permission popup 1 clicks successfully");
                }
                permissionCheck = objHomeCustomer.permissionMobilePopup().size() > 0;
                if (permissionCheck == true) {
                    objHomeCustomer.permissionMobilePopup().get(0).click();
                    logg.info("Permission popup 2 clicks successfully");
                }
                permissionCheck = objHomeCustomer.permissionMobilePopup().size() > 0;
                if (permissionCheck == true) {
                    objHomeCustomer.permissionMobilePopup().get(0).click();
                    logg.info("Permission popup 3 clicks successfully");
                }
            }
        } catch (Exception ex) {
            logg.info("There is an issue in AndroidPermissions function in class ImpMainDriverOne class");
            Assert.fail(ex.getMessage());
        }
    }

    public void IntroPopupModal() {
        try {
            objHomeCustomer = new HomeCustomerD1(driverOne);
            IntroPopUpCheck = objHomeCustomer.introPopupexist().size() > 0;
            logg.info("Intro pop up found" + IntroPopUpCheck);
            if (IntroPopUpCheck == true) {
                objHomeCustomer.introPopupexist().get(0).click();
                logg.info("Intro pop up clicked");
            }
        } catch (Exception ex) {
            logg.info("There is an issue in IntroPopupModal function in class ImpMainDriverOne class");
            Assert.fail(ex.getMessage());
        }
    }

    public void InternetConnectivity() {
        //Case handle = Wifi Off - Data On
        try {
            driverOne.setConnection(new ConnectionStateBuilder().withWiFiDisabled().build());
            TimeUnit.SECONDS.sleep(8);
            checkWifiEnabled = driverOne.getConnection().isWiFiEnabled();
            logg.info("The value of wifi we get is " + checkWifiEnabled);
            TimeUnit.SECONDS.sleep(2);
            if (checkWifiEnabled == false) {
                checkDataEnabled = driverOne.getConnection().isDataEnabled();
                logg.info("The value of data we get is " + checkDataEnabled);
                if (checkDataEnabled == false) {
                    driverOne.setConnection(new ConnectionStateBuilder().withDataEnabled().build());
                    logg.info("Data is enabled successfully");
                    checkDataEnabled = driverOne.getConnection().isDataEnabled();
                    logg.info("The value of data we get is " + checkDataEnabled);
                    TimeUnit.SECONDS.sleep(4);
                    logg.info("InternetConnectivity method Passed");
                }
            }
        } catch (Exception ex) {
            logg.info("There is an issue in InternetConnectivity function in class ImpMainDriverOne class");
            Assert.fail(ex.getMessage());
        }
    }

    public void PackagePurchasecreditDetails() {
        try {
            objPackage = new PackagePurchaseAccountDetails(driverOne);
            objPackage.tapAccountBalance().click();
            logg.info("Account Balance Dropdown opens successfully");
            objPackage.selectPackage().click();
            logg.info("Package clicks successfully");
            objPackage.addCard().click();
            logg.info("Add card clicks successfully & add credit card page opens");
            objPackage.accountdetail_CardNumber().setValue(objMainConf.getAccountCardNumber());
            logg.info("Credit Card Number Enter successfully");
            objPackage.accountdetail_ExpirationDate().setValue(objMainConf.getExpirationDate());
            logg.info("Expiration Date Enter successfully");
            objPackage.accountdetail_Cvv().setValue(objMainConf.getCvvNumber());
            logg.info("Cvv Number Enter successfully");
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

    public void EnableWifiAgain() {
        try {
            checkWifiEnabled = driverOne.getConnection().isWiFiEnabled();
            if (checkWifiEnabled == false) {
                driverOne.setConnection(new ConnectionStateBuilder().withWiFiEnabled().build());
                logg.info("Now wifi is enable after call cancelled " + checkWifiEnabled);
                TimeUnit.SECONDS.sleep(8);
            }
            checkWifiEnabled = driverOne.getConnection().isWiFiEnabled();
            logg.info("The value of wifi After feeback submission we get is " + checkWifiEnabled);
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception ex) {
            logg.info("There is an issue in EnableWifiAgain function in class ImpMainDriverOne class");
            Assert.fail(ex.getMessage());
        }
    }
}
