package com.Tenpearls.JeenieImplementation;

import com.Tenpearls.DriverAppium.MainConfiguration;
import com.Tenpearls.DriverAppium.MainDriverCalling;
import com.Tenpearls.JeeniePomDriverTwo.HomeLinguistD2;
import com.Tenpearls.JeeniePomDriverTwo.LinguistCallPick;
import com.Tenpearls.JeeniePomDriverTwo.LinguistFeedbackCustomer;
import com.Tenpearls.JeeniePomDriverTwo.LoginLinguistD2;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class ImpMainDriverTwo extends MainDriverCalling {
    LoginLinguistD2 objLoginD2;
    HomeLinguistD2 objLinguist;
    LinguistCallPick objCallPick;
    MainConfiguration objMainConf;
    LinguistFeedbackCustomer objLinguistFeedback;
    Boolean checkPermission, checkContinueBtn, checkAllow,
            checkBtn, checkStars, checkThumbs,checkCancelIcon, checkCallAccept, checkMenuIcon;
    Logger logg = LogManager.getLogger(ImpMainDriverTwo.class);
    String LinguistStatus;
    int SizeCount;
    TouchAction ac;
    TouchActions acc;
    String StatusText = "Offline", linguistActiveText;

    public ImpMainDriverTwo(AndroidDriver<MobileElement> driver) {
        this.driverTwo = driver;
    }

    public void loginLinguist() {
        try {
            ac = new TouchAction(driverTwo);
            logg.info("LoginLinguist function starts here in " + LogManager.getLogger(ImpMainDriverTwo.class));
            objMainConf = new MainConfiguration();
            objLoginD2 = new LoginLinguistD2(driverTwo);
            TimeUnit.SECONDS.sleep(15);
            checkBtn = objLoginD2.btnSignInExist().size() > 0;
            if (checkBtn == true) {
                objLoginD2.btnSignInExist().get(0).click();
                logg.info("SignIn Button clicks successfully");
            }
            objLoginD2.txtEmail().click();
            logg.info("Email clicks successfully");
            objLoginD2.txtEmail().setValue(objMainConf.getLinguistEmail());
            logg.info("Email enter successfully");
            TimeUnit.SECONDS.sleep(1);
            logg.info("Email entered successfully for linguist user");
            driverTwo.hideKeyboard();
            objLoginD2.txtPassword().click();
            logg.info("Password clicks successfully");
            objLoginD2.txtPassword().setValue(objMainConf.getPassword());
            logg.info("Password enter successfully");
            TimeUnit.SECONDS.sleep(1);
            logg.info("Password entered successfully");
            driverTwo.hideKeyboard();
            ac.tap(TapOptions.tapOptions().withElement(ElementOption.element(objLoginD2.btnSignInClick()))).release().perform();
            ac.tap(TapOptions.tapOptions().withElement(ElementOption.element(objLoginD2.btnSignInClick()))).release().perform();
            TimeUnit.SECONDS.sleep(5);
            logg.info("SignIn Button clicked successfully & navigate to linguist homepage");
            logg.info("******** LoginLinguist test passed successfully in ImpMainDriverTwo ********");
        } catch (Exception ex) {
            logg.info(ex.getMessage() + " There is an issue in loginLinguist function in class ImpMainDriverTwo class");
            Assert.fail();
        }
    }

    public void lingustPermissionCheck() {
        try {
            objLinguist = new HomeLinguistD2(driverTwo);
            logg.info("Receive Calling function starts here " + LogManager.getLogger(ImpMainDriverTwo.class));
            checkPermission = objLinguist.checkLocationPermissionRequest().size() > 0;
            logg.info("Location Permission pop up found " + checkPermission);
            if (checkPermission == true) {
                checkContinueBtn = objLinguist.btnContinueCheck().size() > 0;
                logg.info("Get boolean value Continue btn " + checkContinueBtn);
                TimeUnit.SECONDS.sleep(5);
                if (checkContinueBtn == true) {
                    objLinguist.btnContinueCheck().get(0).click();
                    logg.info("Click continue in permission pop up where it failed sometimes");
                    TimeUnit.SECONDS.sleep(10);
                    checkAllow = objLinguist.permissionMobilePopup().size() > 0;
                    if (checkAllow == true) {
                        objLinguist.permissionMobilePopup().get(0).click();
                        TimeUnit.SECONDS.sleep(2);
                        logg.info("Permission pop up 1 clicks successfully");

                        checkAllow = objLinguist.permissionMobilePopup().size() > 0;
                        if (checkAllow == true) {
                            objLinguist.permissionMobilePopup().get(0).click();
                            TimeUnit.SECONDS.sleep(2);
                            logg.info("Permission pop up 2 clicks successfully");
                        }
                        checkAllow = objLinguist.permissionMobilePopup().size() > 0;
                        if (checkAllow == true) {
                            objLinguist.permissionMobilePopup().get(0).click();
                            TimeUnit.SECONDS.sleep(2);
                            logg.info("Permission pop up 3 clicks successfully");
                        }
                    }
                }
            }
            TimeUnit.SECONDS.sleep(3);
            linguistActiveText = objLinguist.checkLinguistText().getText();
            System.out.println(linguistActiveText + " " + StatusText);
            if (linguistActiveText.equals(StatusText)) {
                objLinguist.changeToOnline().click();
                logg.info("Linguist status Changed to Online");
                TimeUnit.SECONDS.sleep(3);
            }
            checkContinueBtn = objLinguist.btnContinueCheck().size() > 0;
            if (checkContinueBtn == true) {
                objLinguist.btnContinueCheck().get(0).click();
                logg.info("Button continue clicks successfully");
                checkAllow = objLinguist.permissionMobilePopup().size() > 0;
                logg.info("Trying to click on allow button.");
                if (checkAllow == true) {
                    logg.info("Get Value is " + checkAllow);
                    objLinguist.permissionMobilePopup().get(0).click();
                    logg.info("Permission 1 pop up clicks successfully");
                    TimeUnit.SECONDS.sleep(1);
                }
                checkAllow = objLinguist.permissionMobilePopup().size() > 0;
                logg.info("Trying to click on allow button.");
                if (checkAllow == true) {
                    logg.info("Inside of Permission check is " + checkAllow);
                    objLinguist.permissionMobilePopup().get(0).click();
                    logg.info("Permission 2 pop up clicks successfully");
                    TimeUnit.SECONDS.sleep(1);
                }
                checkAllow = objLinguist.permissionMobilePopup().size() > 0;
                logg.info("Trying to click on allow button.");
                if (checkAllow == true) {
                    logg.info("Inside of Permission check is " + checkAllow);
                    objLinguist.permissionMobilePopup().get(0).click();
                    logg.info("Permission 3 pop up clicks successfully");
                    TimeUnit.SECONDS.sleep(1);
                }
            }
            TimeUnit.SECONDS.sleep(1);
            linguistActiveText = objLinguist.checkLinguistText().getText();
            if (linguistActiveText.equals(StatusText)) {
                objLinguist.changeToOnline().click();
                logg.info("Linguist status Changed to Online");
                TimeUnit.SECONDS.sleep(3);
            }
            logg.info("******** lingustPermissionCheck test passed successfully in ImpMainDriverTwo ********");
        } catch (Exception ex) {
            logg.info(ex.getMessage() + " - There is an issue in lingustPermissionCheck function in class ImpMainDriverTwo class");
            Assert.fail(ex.getMessage());
        }
    }

    public void acceptCustomerCall() {
        try {
            objCallPick = new LinguistCallPick(driverTwo);
            checkCallAccept = objCallPick.callPickingLinguist().size() > 0;
            logg.info("The boolean value of checkCallAccept is " + checkCallAccept);
            if (checkCallAccept == true) {
                objCallPick.callPickingLinguist().get(0).click();
                TimeUnit.SECONDS.sleep(10);
            } else {
                checkMenuIcon = objCallPick.menuNavigation().size() > 0;
                logg.info("The boolean value of menu we get is " + checkMenuIcon);
                if (checkMenuIcon == true) {
                    objCallPick.menuNavigation().get(0).click();
                    logg.info("Navigation menu clicks successfully");
                    TimeUnit.SECONDS.sleep(1);
                    objCallPick.clickHistory().click();
                    logg.info("History Page Opens successfully");
                    TimeUnit.SECONDS.sleep(1);
                    objCallPick.clickCrossIcon().click();
                    TimeUnit.SECONDS.sleep(1);
                    checkCallAccept = objCallPick.callPickingLinguist().size() > 0;
                    logg.info("The boolean value of checkCallAccept is " + checkCallAccept);
                    if (checkCallAccept == true) {
                        objCallPick.callPickingLinguist().get(0).click();
                        TimeUnit.SECONDS.sleep(15);
                    }
                }
            }
        } catch (Exception ex) {
            logg.info("There is an issue in accpetCustomerCall function in class ImpMainDriverTwo");
            Assert.fail(ex.getMessage());
        }
    }

    public void cancelCallByLinguist() {
        try {
            logg.info("cancel Call By Customer function starts here " + LogManager.getLogger(ImpMainDriverOne.class));
            objLinguist = new HomeLinguistD2(driverTwo);
            TimeUnit.SECONDS.sleep(6);
            checkCancelIcon = objLinguist.btnCancelCall().size() > 0;
            logg.info("The boolean value is " + checkCancelIcon);
            objLinguist.btnCancelCall().get(0).click();
            logg.info("Call cancel button clicks successfully");
            TimeUnit.SECONDS.sleep(2);
            objLinguist.confirmCancelCallPopup().click();
            logg.info("Call cancel yes button clicks successfully & Feedback Form Opens Successfully");
            logg.info("******** cancelCallByCustomer test passed successfully in ImpMainDriverOne ********");
            TimeUnit.SECONDS.sleep(4);
        } catch (Exception ex) {
            logg.info("There is an issue in cancelCallCustomer function in class ImpMainDriverOne class");
            Assert.fail(ex.getMessage());
        }
    }

    public void submitFeedbackByLinguist() {
        try {
            logg.info("Submit Feedback By Linguist function starts here " + LogManager.getLogger(ImpMainDriverTwo.class));
            objLinguistFeedback = new LinguistFeedbackCustomer(driverTwo);
            checkStars = objLinguistFeedback.feedbackStep1ForCustomer().size() > 0;
            if (checkStars == true) {
                objLinguistFeedback.feedbackStep1ForCustomer().get(0).click();
                logg.info("Rating gives successfully by Linguist");
            }
            checkThumbs = objLinguistFeedback.feedbackThumbsSign().size() > 0;
            if (checkThumbs == true) {
                objLinguistFeedback.feedbackThumbsSign().get(0).click();
                logg.info("Issue Resolved Rating gives successfully by Linguist");
            }
            objLinguistFeedback.feedbackNextBtn().click();
            logg.info("Linguist moves to step2 for submit feedback");
            objLinguistFeedback.feedbackStep2SelectTypeOfCall().click();
            logg.info("Type Of Call option selected by linguist");
            objLinguistFeedback.clickCallDetailsSection().click();
            logg.info("Scroll to call details section & click");
            objLinguistFeedback.clickCallDetailsSection().sendKeys("Testing by Mamji");
            logg.info("Call Details Enter successfully");
            //driverTwo.hideKeyboard();
            objLinguistFeedback.feedbackStep2SelectTypeOfCall().click();
            logg.info("Viewgroups close successfully!!");
            objLinguistFeedback.feedbackNextBtn().click();
            logg.info("Linguist moves to step3 for submit feedback");
            objLinguistFeedback.feedbackSubmitBtn().click();
            logg.info("Feedback form submitted successfully by Linguist");
            logg.info("******** submitFeedbackByLinguist test passed successfully in ImpMainDriverTwo ********");
            TimeUnit.SECONDS.sleep(6);
        } catch (Exception ex) {
            logg.info("There is an issue in submitFeedbackByLinguist function in class ImpMainDriverTwo class");
            Assert.fail(ex.getMessage());
        }
    }
}
