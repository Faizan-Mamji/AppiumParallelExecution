package com.Tenpearls.JeenieImplementation;

import com.Tenpearls.DriverAppium.MainDriverCalling;
import com.Tenpearls.DriverAppium.MainConfiguration;
import com.Tenpearls.JeeniePomDriverOne.*;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ImpMainDriverOne extends MainDriverCalling {

    Boolean checkCustomerPermission, checkAuthPopup, checkAddCard, checkDiscountPakcage, checkSpecialPakcage, checkUnlimited, checkNeedHelpDrpOpen, checkAddPayment, checkScenarioDrpOpen, checkPermission, reloadCheckBusiness, checkReloadPackage, onBoardingCheck, permissionCheck, checkSignInBtn, checkAllow, checkOk;
    MainConfiguration objMainConf = new MainConfiguration();
    LoginCustomerD1 objLoginD1;
    PackagePurchaseAccountDetails objPackage;
    HomeCustomerD1 objHomeCustomer;
    CustomerFeedbackLinguist objCustFeedback;
    RegisterCustomer objRegister;
    LogoutCustomer objCustLogout;
    PromoCodes objPromo;
    Logger logg = LogManager.getLogger(ImpMainDriverOne.class);
    TouchAction ac;

    String getAccountValue, getNeedHelpValue, getSpeakValue,
            scenarioTextOne = "Global Business Meetings",
            chineseLanguage = "Chinese (Mandarin)",
            americanEngish = "English",
            accountValue = "0 mins",
            accountValueUnlimited = "Unlimited",
            codeSpecial = "special",
            codeDiscount = "discount";

    int countButton, getFirstHeight, getSecondHeight;
    Random rnd;

    public ImpMainDriverOne(IOSDriver<MobileElement> driver) {
        this.driverOne = driver;
    }

    public void loginCustomer(String userName, String password) {
        try {
            ac = new TouchAction(driverOne);
            logg.info("LoginCustomer function starts here in " + LogManager.getLogger(ImpMainDriverOne.class));
            objMainConf = new MainConfiguration();
            objLoginD1 = new LoginCustomerD1(driverOne);
            TimeUnit.SECONDS.sleep(10);
            iOSLaunchPopup();
            checkSignInBtn = objLoginD1.btnSignInDriverOne().size() > 0;
            logg.info("SignIn Button exist on Jeenie page = " + checkSignInBtn);
            if (checkSignInBtn == true) {
                objLoginD1.btnSignInDriverOne().get(0).click();
                logg.info("SignIn Button clicks successfully");
            }
            //Get Locations of elements
            int a = objLoginD1.txtEmail().getSize().height;
            int b = objLoginD1.txtPassword().getSize().height;
            objLoginD1.txtEmail().click();
            logg.info("Email clicks successfully");
            objLoginD1.txtEmail().setValue(userName);
            logg.info("Email enter successfully");
            TimeUnit.SECONDS.sleep(1);
            logg.info("Waiting");
            logg.info("Email entered successfully for linguist user");
            objLoginD1.txtPassword().click();
            logg.info("Password clicks successfully");
            objLoginD1.txtPassword().setValue(password);
            logg.info("Password enter successfully");
            TimeUnit.SECONDS.sleep(1);
            logg.info("Waiting");
            logg.info("Password entered successfully");
            ac.press(PointOption.point(a, b)).moveTo(PointOption.point(b, b + 10)).release().perform();
            TimeUnit.SECONDS.sleep(3);
            ac.tap(TapOptions.tapOptions().withElement(ElementOption.element(objLoginD1.btnSignInClick()))).release().perform();
            TimeUnit.SECONDS.sleep(5);
            logg.info("SignIn Button clicked successfully & navigate to OnBoarding/homepage screen");
            checkOnboardingScreen();
            logg.info("******* Login Customer test passed successfully in ImpMainDriverOne *******");
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
            mobilePermissions();
            packagePurchasecreditDetails();
            languageChecks();
            logg.info("******** callAudio test passed successfully in ImpMainDriverOne ********");
        } catch (Exception ex) {
            logg.info("There is an issue in callAudio function in class ImpMainDriverOne class");
            Assert.fail(ex.getMessage());
        }
    }

    public void callingPartial() {
        try {
            objHomeCustomer.btnAudioCall().click();
            logg.info("Audio Call button clicks successfully & Call starts connecting");
            checkCustomerPermission = objHomeCustomer.checkLocationPermissionRequest().size() > 0;
            logg.info("Boolean value returns of checkCustomerPermission is: " + checkCustomerPermission);

            if (checkCustomerPermission == true) {
                objHomeCustomer.btnContinue().click();
                logg.info("Button continue clicks successfully");
                objHomeCustomer.permissionMobilePopup().get(0).click();
                logg.info("Permission pop up clicks successfully");
                objHomeCustomer.permissionMobilePopup().get(0).click();
                logg.info("Permission pop up clicks successfully & call connecting starts");
            }
            TimeUnit.SECONDS.sleep(25);
        } catch (Exception ex) {
            logg.info("There is an issue in callingPartial function in class ImpMainDriverOne class");
            Assert.fail(ex.getMessage());
        }
    }

    public void cancelCallByCustomer() {
        try {
            logg.info("cancel Call By Customer function starts here " + LogManager.getLogger(ImpMainDriverOne.class));
            objHomeCustomer = new HomeCustomerD1(driverOne);
            //InternetConnectivity();
            countButton = objHomeCustomer.btnCancelCall().size();
            logg.info("The total count is " + countButton);
            objHomeCustomer.btnCancelCall().get(0).click();
            logg.info("Call cancel button clicks successfully");
            TimeUnit.SECONDS.sleep(2);
            objHomeCustomer.confirmCancelCallPopup().click();
            logg.info("Call cancel yes button clicks successfully & Feedback Form Opens Successfully");
            logg.info("******** cancelCallByCustomer test passed successfully in ImpMainDriverOne ********");
            TimeUnit.SECONDS.sleep(8);
            //EnableWifiAgain();
        } catch (Exception ex) {
            logg.info("There is an issue in cancelCallCustomer function in class ImpMainDriverOne class");
            Assert.fail(ex.getMessage());
        }
    }

    public void submitFeedbackByCustomer() {
        try {
            logg.info("Submit Feedback By Customer function starts here " + LogManager.getLogger(ImpMainDriverOne.class));
            objCustFeedback = new CustomerFeedbackLinguist(driverOne);
            objCustFeedback.selectStarFive().click();
            logg.info("Rating gives successfully by customer");
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
            objRegister.txtCreatePassword().setValue("password");
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
                objHomeCustomer.selectOnBoardingList().get(0).click();
                logg.info("Onboarding value selected successfully");
                objHomeCustomer.continueOnBoardingBtn().click();
                TimeUnit.SECONDS.sleep(7);
                logg.info("Continue button clicks successfully & navigate to home page");
            }
        } catch (Exception ex) {
            logg.info("There is an issue in checkOnboardingScreen function in class ImpMainDriverOne class");
            Assert.fail(ex.getMessage());
        }
    }


    public void mobilePermissions() {
        try {
            objHomeCustomer = new HomeCustomerD1(driverOne);
            logg.info("Receive Calling function starts here " + LogManager.getLogger(ImpMainDriverTwo.class));
            checkPermission = objHomeCustomer.checkLocationPermissionRequest().size() > 0;
            logg.info("Location Permission pop up found " + checkPermission);
            if (checkPermission == true) {
                objHomeCustomer.btnContinue().click();
                logg.info("Click continue in permission pop up where it failed sometimes");
                TimeUnit.SECONDS.sleep(10);
                checkAllow = objHomeCustomer.permissionMobilePopup().size() > 0;
                checkOk = objHomeCustomer.permssionFeaturesiOSPopup().size() > 0;
                if (checkAllow == true) {
                    objHomeCustomer.permissionMobilePopup().get(0).click();
                    TimeUnit.SECONDS.sleep(2);
                    logg.info("Permission pop up clicks successfully");

                    checkAllow = objHomeCustomer.permissionMobilePopup().size() > 0;
                    if (checkAllow == true) {
                        objHomeCustomer.permissionMobilePopup().get(0).click();
                        TimeUnit.SECONDS.sleep(2);
                        logg.info("Permission pop up clicks successfully");
                    }
                    checkAllow = objHomeCustomer.permissionMobilePopup().size() > 0;
                    if (checkAllow == true) {
                        objHomeCustomer.permissionMobilePopup().get(0).click();
                        TimeUnit.SECONDS.sleep(2);
                        logg.info("Permission pop up clicks successfully");
                    }
                }
                if (checkOk == true) {
                    objHomeCustomer.permssionFeaturesiOSPopup().get(0).click();
                    TimeUnit.SECONDS.sleep(1);
                    logg.info("Permission OK 1 clicks successfully");

                    checkOk = objHomeCustomer.permssionFeaturesiOSPopup().size() > 0;
                    if (checkOk == true) {
                        objHomeCustomer.permssionFeaturesiOSPopup().get(0).click();
                        TimeUnit.SECONDS.sleep(1);
                        logg.info("Permission OK 2 clicks successfully");
                    }
                    checkAllow = objHomeCustomer.permissionMobilePopup().size() > 0;
                    logg.info("Permission Allow after two OK popups in 3 requests " + checkAllow);
                    checkOk = objHomeCustomer.permssionFeaturesiOSPopup().size() > 0;
                    logg.info("Permission Allow after two OK popups in 3 requests " + checkOk);
                    if (checkOk == true) {
                        objHomeCustomer.permssionFeaturesiOSPopup().get(0).click();
                        TimeUnit.SECONDS.sleep(1);
                        logg.info("Permission OK 3 clicks successfully");
                    }
                    if (checkAllow == true) {
                        objHomeCustomer.permissionMobilePopup().get(0).click();
                        TimeUnit.SECONDS.sleep(2);
                        logg.info("Permission popup 1 clicks successfully");
                        TimeUnit.SECONDS.sleep(2);
                    }
                    permissionCheck = objHomeCustomer.permissionMobilePopup().size() > 0;
                    if (permissionCheck == true) {
                        objHomeCustomer.permissionMobilePopup().get(0).click();
                        logg.info("Permission popup 2 clicks successfully");
                        TimeUnit.SECONDS.sleep(2);
                    }
                    permissionCheck = objHomeCustomer.permissionMobilePopup().size() > 0;
                    if (permissionCheck == true) {
                        objHomeCustomer.permissionMobilePopup().get(0).click();
                        logg.info("Permission popup 3 clicks successfully");
                        TimeUnit.SECONDS.sleep(2);
                    }
                }
            }
        } catch (Exception ex) {
            logg.info("There is an issue in MobilePermissions function in class ImpMainDriverOne class");
            Assert.fail(ex.getMessage());
        }
    }


    //Limitation for iOS (Unable to do internet connectivity in iOS)
//    public void introPopupModal() {
//        try {
//            objHomeCustomer = new HomeCustomerD1(driverOne);
//            introPopUpCheck = objHomeCustomer.introPopupexist().size() > 0;
//            logg.info("Intro pop up found" + introPopUpCheck);
//            if (introPopUpCheck == true) {
//                objHomeCustomer.introPopupexist().get(0).click();
//                logg.info("Intro pop up clicked");
//            }
//        } catch (Exception ex) {
//            logg.info("There is an issue in IntroPopupModal function in class ImpMainDriverOne class");
//            Assert.fail(ex.getMessage());
//        }
//    }


    public void packagePurchasecreditDetails() {
        try {
            ac = new TouchAction(driverOne);
            objPackage = new PackagePurchaseAccountDetails(driverOne);
            objPackage.tapAccountBalance().click();
            logg.info("Account Balance Dropdown opens successfully");
            //Check reload package for business user
            reloadCheckBusiness = objPackage.packageReloadBusiness().size() > 0;
            logg.info("Yayy! Reload package found in slider = " + reloadCheckBusiness);
            checkReloadPackage = objPackage.checkReload().size() > 0;
            logg.info("Reload package found = " + checkReloadPackage);
            if (checkReloadPackage == true) {
                objPackage.checkReload().get(0).click();
                logg.info("Reload button clicks successfully");
                objPackage.removeReloadPackage().click();
                logg.info("Reload button clicks successfully");
                objPackage.clickViewPackages().get(0).click();
                logg.info("View Packages Screen Opens successfully");
            }
            objPackage.selectPackage().click();
            logg.info("Package clicks successfully");
            checkAddPayment = objPackage.addCard().size() > 0;
            if (checkAddPayment == true) {
                objPackage.addCard().get(0).click();
                logg.info("Add card clicks successfully & add credit card page opens");
                creditCardDetails();
            }
            TimeUnit.SECONDS.sleep(5);
            objPackage.btnPurchasePackage().click();
            logg.info("Package purchased button click successfully");
            objPackage.btnOkPaymentSuccessfull().click();
            logg.info("Payment successful Ok button click successfully");
            TimeUnit.SECONDS.sleep(5);
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

    public void creditCardDetails() {
        try {
            objPackage = new PackagePurchaseAccountDetails(driverOne);
            objPackage.accountdetailCardNumber().setValue(objMainConf.getAccountCardNumber());
            logg.info("Credit Card Number Enter successfully");
            objPackage.accountdetailExpirationDate().setValue(objMainConf.getExpirationDate());
            logg.info("Expiration Date Enter successfully");
            objPackage.accountdetailCvv().setValue(objMainConf.getCvvNumber());
            logg.info("Cvv Number Enter successfully");
            objPackage.accountdetail_SaveBtn().click();
            logg.info("Button clicks successfully & account details entered successfully");
            TimeUnit.SECONDS.sleep(8);
            checkAuthPopup = objPackage.authentication().size() > 0;
            if (checkAuthPopup == true) {
                objPackage.authentication().get(0).click();
                logg.info("Authentication popups click successfully");
            }
            TimeUnit.SECONDS.sleep(4);

        } catch (Exception ex) {
            logg.info("There is an issue in creditCardDetails function in class ImpMainDriverOne class");
            Assert.fail(ex.getMessage());
        }
    }

    public void restrictedUser() {
        try {
            objHomeCustomer = new HomeCustomerD1(driverOne);
            logg.info("Audio Calling function starts here " + LogManager.getLogger(ImpMainDriverOne.class));
            //Check Mobile Permission
            mobilePermissions();
            packagePurchasecreditDetails();
            getSpeakValue = objHomeCustomer.drpSpeak().getText();
            logg.info("The value of I speak is " + getSpeakValue);
            getNeedHelpValue = objHomeCustomer.drpNeedHelpWithText().getText();
            logg.info("The value of need help with  is " + getNeedHelpValue);

            //if both dropdowns are equal
            if ((getSpeakValue == "") && (getNeedHelpValue == "")) {
                objHomeCustomer.drpISpeak().click();
                logg.info("I speak Dropdown opens successfully");
                objHomeCustomer.drpSelectValueISpeak(americanEngish).get(0).click();
                logg.info("I speak Dropdown value selected successfully");
            } else {
                objHomeCustomer.drpNeedHelpWith().click();
                logg.info("Need help Dropdown opens successfully");
                checkNeedHelpDrpOpen = objHomeCustomer.drpSelectValueTranslateTo(chineseLanguage).size() > 0;
                objHomeCustomer.drpScenario().click();
                checkScenarioDrpOpen = objHomeCustomer.drpSelectValueTranslateTo(scenarioTextOne).size() > 0;
                logg.info("Scenario Dropdown shouldn't open");
                if ((checkNeedHelpDrpOpen == false) && (checkScenarioDrpOpen == false)) {
                    logg.info("Test Passed Successfully!");
                } else {
                    logg.info("Issue with restricted user! Please check!");
                }
            }

        } catch (Exception ex) {
            logg.info("There is an issue in restrictedUser function in class ImpMainDriverOne class");
            Assert.fail(ex.getMessage());
        }
    }

    public void languageChecks() {
        objHomeCustomer = new HomeCustomerD1(driverOne);
        getSpeakValue = objHomeCustomer.drpSpeak().getText();
        logg.info("The value of I speak is " + getSpeakValue);
        getNeedHelpValue = objHomeCustomer.drpNeedHelpWithText().getText();
        logg.info("The value of need help with  is " + getNeedHelpValue);

        //if both dropdowns are equal
        if (getSpeakValue.contains(americanEngish) && getNeedHelpValue.contains(chineseLanguage)) {
            callingPartial();
        }
        //if both dropdowns are equal
        else if (getSpeakValue.contains(chineseLanguage) && getNeedHelpValue.contains(americanEngish)) {
            callingPartial();
        }
        //if 1 dropdowns is null
        else if (getSpeakValue.contains(americanEngish) && getNeedHelpValue.contains("")) {
            objHomeCustomer.drpNeedHelpWith().click();
            logg.info("Need help Dropdown opens successfully");
            objHomeCustomer.drpSelectValueTranslateTo(chineseLanguage).get(0).click();
            callingPartial();
        }
        //if 1 dropdowns is null
        else if (getSpeakValue.contains(chineseLanguage) && getNeedHelpValue.contains("")) {
            objHomeCustomer.drpNeedHelpWith().click();
            logg.info("Need help Dropdown opens successfully");
            objHomeCustomer.drpSelectValueTranslateTo(americanEngish).get(0).click();
            callingPartial();
        } else if ((!getSpeakValue.contains(americanEngish)) && (!getNeedHelpValue.contains(chineseLanguage))) {
            objHomeCustomer.drpISpeak().click();
            logg.info("I speak Dropdown opens successfully");
            objHomeCustomer.drpSelectValueISpeak(americanEngish).get(0).click();
            logg.info("I speak Dropdown value selected successfully");
            objHomeCustomer.drpNeedHelpWith().click();
            logg.info("Need help Dropdown opens successfully");
            objHomeCustomer.drpSelectValueTranslateTo(chineseLanguage).get(0).click();
            callingPartial();
        } else if ((getSpeakValue.contains(americanEngish)) && (!getNeedHelpValue.contains(chineseLanguage))) {
            objHomeCustomer.drpNeedHelpWith().click();
            logg.info("Need help Dropdown opens successfully");
            objHomeCustomer.drpSelectValueTranslateTo(chineseLanguage).get(0).click();
            callingPartial();
        } else if ((!getSpeakValue.contains(americanEngish)) && (getNeedHelpValue.contains(chineseLanguage))) {
            objHomeCustomer.drpISpeak().click();
            logg.info("I speak Dropdown opens successfully");
            objHomeCustomer.drpSelectValueISpeak(americanEngish).get(0).click();
            logg.info("I speak Dropdown value selected successfully");
            callingPartial();
        }
    }

    public void lessRestrictedUser() {
        try {
            objHomeCustomer = new HomeCustomerD1(driverOne);
            logg.info("Audio Calling function starts here " + LogManager.getLogger(ImpMainDriverOne.class));
            //Check Mobile Permission
            mobilePermissions();
            packagePurchasecreditDetails();
            languageChecks();
        } catch (Exception ex) {
            logg.info("There is an issue in restrictedUser function in class ImpMainDriverOne class");
            Assert.fail(ex.getMessage());
        }
    }

    public void subscribedUser() {
        try {
            objHomeCustomer = new HomeCustomerD1(driverOne);
            objCustLogout = new LogoutCustomer(driverOne);
            objPackage = new PackagePurchaseAccountDetails(driverOne);
            logg.info("subscribedUser function starts here " + LogManager.getLogger(ImpMainDriverOne.class));
            //Check Mobile Permission
            mobilePermissions();
            logg.info("Android permission method passed successfully!");
            checkAddCard = objPackage.btnAddCard().size() > 0;
            logg.info("Add Card Button Found = " + checkAddCard);
            if (checkAddCard == true) {
                objPackage.btnAddCard().get(0).click();
                logg.info("Add Card Button click successfully!");
                objPackage.btnAddPayments().click();
                logg.info("Add Payment Button click successfully!");
                objPackage.addCard().get(0).click();
                creditCardDetails();
                TimeUnit.SECONDS.sleep(10);
                logg.info("Credit Card Details method passed!");
                driverOne.navigate().back();
                logg.info("Back 1 successful!");
                TimeUnit.SECONDS.sleep(2);
                driverOne.navigate().back();
                logg.info("Back 2 successful!");
                TimeUnit.SECONDS.sleep(2);
                checkAddCard = objPackage.btnAddCard().size() > 0;
                if (checkAddCard == false) {
                    logg.info("Test Passed Successfully");
                } else {
                    Assert.fail("The checkAddCard value = " + checkAddCard);
                }
            } else {
                objPackage.tapAccountBalance().click();
                logg.info("Payment Details page opens successfully!");
                objPackage.btnEditPayments().click();
                logg.info("Edit payment clicks successfully!");
                objPackage.btnRemoveCardPayment().click();
                logg.info("Remove Card clicks successfully!");
                objPackage.confirmRemoveCardPopup().click();
                logg.info("Credit card deleted successfully!");
                TimeUnit.SECONDS.sleep(10);
                driverOne.navigate().back();
                logg.info("Back 1 successful!");
                checkAddCard = objPackage.btnAddCard().size() > 0;
                logg.info("Add Card Button Found = " + checkAddCard);
                if (checkAddCard == true) {
                    Assert.assertTrue(checkAddCard);
                }
            }
        } catch (Exception ex) {
            logg.info("There is an issue in restrictedUser function in class ImpMainDriverOne class");
            Assert.fail(ex.getMessage());
        }
    }

    public void enterFreeMinutesPromoCodes() {
        try {
            objPromo = new PromoCodes(driverOne);
            objCustLogout = new LogoutCustomer(driverOne);
            logg.info("enterPromoCodes function starts here " + LogManager.getLogger(ImpMainDriverOne.class));
            mobilePermissions();
            TimeUnit.SECONDS.sleep(3);
            objCustLogout.openNavigation().click();
            TimeUnit.SECONDS.sleep(2);
            logg.info("Click Left navigation to close account slider!");
            objCustLogout.openNavigation().click();
            logg.info("Left navigation opens successfully!");
            objCustLogout.navPromoCode().click();
            logg.info("Promo Code page opens successfully!");
            objPromo.enterPromoCode().setValue(objMainConf.getFreeMinutes());
            logg.info("Text entered successfully!");
            objPromo.btnNext().click();
            logg.info("Button clicks successfully!");
            TimeUnit.SECONDS.sleep(3);
            objPromo.closeModal().click();
            logg.info("Modal closed successfully!");
            TimeUnit.SECONDS.sleep(8);
        } catch (Exception ex) {
            logg.info("There is an issue in enterPromoCodes function in class ImpMainDriverOne class");
            Assert.fail(ex.getMessage());
        }
    }

    public void freeCallPromoCodes() {
        try {
            objPromo = new PromoCodes(driverOne);
            objCustLogout = new LogoutCustomer(driverOne);
            objPackage = new PackagePurchaseAccountDetails(driverOne);
            logg.info("FreeCallPromoCodes function starts here " + LogManager.getLogger(ImpMainDriverOne.class));
            TimeUnit.SECONDS.sleep(2);
            driverOne.navigate().back();
            TimeUnit.SECONDS.sleep(2);
            objCustLogout.openNavigation().click();
            logg.info("Left navigation opens successfully!");
            objCustLogout.navPaymentDetails().click();
            logg.info("Payment Details opens successfully!");
            objPackage.btnAddPayments().click();
            logg.info("Add Payments opens successfully!");
            checkAddPayment = objPackage.addCard().size() > 0;
            if (checkAddPayment == true) {
                objPackage.addCard().get(0).click();
                logg.info("Add card clicks successfully & add credit card page opens");
                creditCardDetails();
            }
            TimeUnit.SECONDS.sleep(5);
            driverOne.navigate().back();
            TimeUnit.SECONDS.sleep(2);
            driverOne.navigate().back();
            TimeUnit.SECONDS.sleep(2);
            objCustLogout.openNavigation().click();
            logg.info("Left navigation opens successfully!");
            objCustLogout.navPromoCode().click();
            logg.info("Promo Code page opens successfully!");
            objPromo.enterPromoCode().setValue(objMainConf.getStartCall());
            logg.info("Text entered successfully!");
            objPromo.btnNext().click();
            logg.info("Button clicks successfully!");
            TimeUnit.SECONDS.sleep(15);
            objPromo.callCancel().click();
            logg.info("Cancel button click successfully!");
            TimeUnit.SECONDS.sleep(2);
            objPromo.acceptPopup().click();
            logg.info("Popup closed successfully!");
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception ex) {
            logg.info("There is an issue in freeCallPromoCodes function in class ImpMainDriverOne class");
            Assert.fail(ex.getMessage());
        }
    }

    public void purchasePackagesValidation() {
        try {
            objHomeCustomer = new HomeCustomerD1(driverOne);
            objPackage = new PackagePurchaseAccountDetails(driverOne);
            //Check reload package for business user
            reloadCheckBusiness = objHomeCustomer.packageReloadAvailable().size() > 0;
            logg.info("Reload package found on home screen = " + reloadCheckBusiness);
            getAccountValue = objHomeCustomer.accountBalance().get(0).getText();
            logg.info("Account Value = " + getAccountValue);
            //case when package is not reload & account balance is "0"
            if ((reloadCheckBusiness == false) && (!getAccountValue.equalsIgnoreCase(accountValueUnlimited))) {
                packagePurchasecreditDetails();
                getAccountValue = objHomeCustomer.accountBalance().get(0).getText();
                if (!getAccountValue.equalsIgnoreCase(accountValue)) {
                    Assert.assertTrue(true);
                    logg.info("Test Passed");
                    logg.info("Account Value = " + getAccountValue);
                } else {
                    Assert.fail("Account balance is still 0");
                    logg.info("Test Fail");
                    logg.info("Account Value = " + getAccountValue);
                }
            } else if ((reloadCheckBusiness == false) && (getAccountValue.equalsIgnoreCase(accountValueUnlimited))) {
                objPackage.tapAccountBalance().click();
                logg.info("Payment Details Page opens");
                objPackage.clickViewPackages().get(0).click();
                logg.info("Packages Page opens");
                objPackage.selectPackage().click();
                logg.info("Package clicks successfully");
                checkAddPayment = objPackage.addCard().size() > 0;
                if (checkAddPayment == true) {
                    objPackage.addCard().get(0).click();
                    logg.info("Add card clicks successfully & add credit card page opens");
                    creditCardDetails();
                }
                TimeUnit.SECONDS.sleep(5);
                objPackage.btnPurchasePackage().click();
                logg.info("Package purchased button click successfully");
                objPackage.btnOkPaymentSuccessfull().click();
                logg.info("Payment successful Ok button click successfully");
                TimeUnit.SECONDS.sleep(5);
                getAccountValue = objHomeCustomer.accountBalance().get(0).getText();
                if (getAccountValue.equalsIgnoreCase(accountValueUnlimited)) {
                    Assert.assertTrue(true);
                } else {
                    Assert.fail("Account balance is not Unlimited");
                    logg.info("Test Fail");
                    logg.info("Account Value = " + getAccountValue);
                }
            } else if ((reloadCheckBusiness == true) && (!getAccountValue.equalsIgnoreCase(accountValueUnlimited))) {
                objPackage.tapAccountBalance().click();
                logg.info("Account Balance Dropdown opens successfully");
                checkReloadPackage = objPackage.checkReload().size() > 0;
                logg.info("Reload package found = " + checkReloadPackage);
                if (checkReloadPackage == true) {
                    objPackage.checkReload().get(0).click();
                    logg.info("Reload button clicks successfully");
                    objPackage.removeReloadPackage().click();
                    logg.info("Reload button clicks successfully");
                    objPackage.clickViewPackages().get(0).click();
                    logg.info("View Packages Screen Opens successfully");
                }
                checkUnlimited = objPackage.packageUnlimitedBusiness().size() > 0;
                if (checkUnlimited == true) {
                    objPackage.packageUnlimitedBusiness().get(0).click();
                    logg.info("Package clicks successfully");
                } else {
                    objPackage.selectPackage().click();
                    logg.info("Package clicks successfully");
                }
                checkAddPayment = objPackage.addCard().size() > 0;
                if (checkAddPayment == true) {
                    objPackage.addCard().get(0).click();
                    logg.info("Add card clicks successfully & add credit card page opens");
                    creditCardDetails();
                }
                TimeUnit.SECONDS.sleep(5);
                objPackage.btnPurchasePackage().click();
                logg.info("Package purchased button click successfully");
                objPackage.btnOkPaymentSuccessfull().click();
                logg.info("Payment successful Ok button click successfully");
                TimeUnit.SECONDS.sleep(5);
                getAccountValue = objHomeCustomer.accountBalance().get(0).getText();
                if (getAccountValue.equalsIgnoreCase(accountValueUnlimited)) {
                    Assert.assertTrue(true);
                } else {
                    Assert.fail("Not able to found Account balance unlimited");
                }
            }
            TimeUnit.SECONDS.sleep(5);
        } catch (Exception ex) {
            logg.info("There is an issue in PackagecreditDetails function in class ImpMainDriverOne class");
            Assert.fail(ex.getMessage());
        }
    }

    public void packagePuchasingCaseReloadWithBalance() {
        try {
            objCustLogout = new LogoutCustomer(driverOne);
            objHomeCustomer = new HomeCustomerD1(driverOne);
            logg.info("packagePuchasingCaseReloadWithBalance function starts here " + LogManager.getLogger(ImpMainDriverOne.class));
            mobilePermissions();
            TimeUnit.SECONDS.sleep(3);
            objCustLogout.openNavigation().click();
            TimeUnit.SECONDS.sleep(2);
            logg.info("Click Left navigation to close account slider!");
            discountPromoCode();
            specialPromoCode();
            //Reload Package tested
            purchasePackagesValidation();
        } catch (Exception ex) {
            logg.info("There is an issue in packagePuchasing function in class ImpMainDriverOne class");
            Assert.fail(ex.getMessage());
        }
    }

    public void packagePuchasingCaseUnlimitedWithBalance() {
        try {
            objCustLogout = new LogoutCustomer(driverOne);
            objHomeCustomer = new HomeCustomerD1(driverOne);
            logg.info("packagePuchasingCaseUnlimitedWithBalance function starts here " + LogManager.getLogger(ImpMainDriverOne.class));
            //Unlimited package Code
            purchasePackagesValidation();
        } catch (Exception ex) {
            logg.info("There is an issue in packagePuchasing function in class ImpMainDriverOne class");
            Assert.fail(ex.getMessage());
        }
    }

    public void discountPromoCode() {
        try {
            objCustLogout = new LogoutCustomer(driverOne);
            objPackage = new PackagePurchaseAccountDetails(driverOne);
            objHomeCustomer = new HomeCustomerD1(driverOne);
            logg.info("specialPromoCode function starts here " + LogManager.getLogger(ImpMainDriverOne.class));
            objCustLogout.openNavigation().click();
            TimeUnit.SECONDS.sleep(2);
            logg.info("Navigation opens successfully!");
            objCustLogout.navPaymentDetails().click();
            logg.info("Payment details page opens successfully!");
            objPackage.clickViewPackages().get(0).click();
            logg.info("Packages page opens successfully!");
            objPackage.packageCode().setValue(codeDiscount);
            logg.info("Code enters successfully!");
            objPackage.btnApply().click();
            logg.info("Discount Code applied successfully!");
            TimeUnit.SECONDS.sleep(3);
            checkDiscountPakcage = objPackage.packageDiscount().size() > 0;
            if (checkDiscountPakcage == true) {
                Assert.assertTrue(true);
                objPackage.removePackageCode().click();
                logg.info("Package removed successfully!");
                TimeUnit.SECONDS.sleep(5);

            } else {
                Assert.fail("Discount package not found!");
            }
        } catch (
                Exception ex) {
            logg.info("There is an issue in specialPromoCode function in class ImpMainDriverOne class");
            Assert.fail(ex.getMessage());
        }
    }

    public void specialPromoCode() {
        try {
            objCustLogout = new LogoutCustomer(driverOne);
            objPackage = new PackagePurchaseAccountDetails(driverOne);
            objHomeCustomer = new HomeCustomerD1(driverOne);
            logg.info("specialPromoCode function starts here " + LogManager.getLogger(ImpMainDriverOne.class));
            TimeUnit.SECONDS.sleep(2);
            objPackage.packageCode().setValue(codeSpecial);
            logg.info("Code enters successfully!");
            objPackage.btnApply().click();
            logg.info("Special Code applied successfully!");
            TimeUnit.SECONDS.sleep(3);
            checkSpecialPakcage = objPackage.packageSpecial().size() > 0;
            if (checkSpecialPakcage == true) {
                Assert.assertTrue(true);
                logg.info("Special package Works successfully");
            } else {
                Assert.fail("Special package not found!");
            }
            driverOne.navigate().back();
            TimeUnit.SECONDS.sleep(2);
            driverOne.navigate().back();
            TimeUnit.SECONDS.sleep(2);
        } catch (
                Exception ex) {
            logg.info("There is an issue in specialPromoCode function in class ImpMainDriverOne class");
            Assert.fail(ex.getMessage());
        }
    }
}