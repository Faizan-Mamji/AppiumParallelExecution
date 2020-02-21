package com.Tenpearls.DriverAppium;

import java.io.FileInputStream;
import java.util.Properties;

public class MainConfiguration {

    FileInputStream fs;
    Properties prop = new Properties();
    String deviceNameFirst;
    String deviceNameSecond;
    String deviceVersionFirst;
    String deviceVersionSecond;
    String deviceIdFirst;
    String deviceIdSecond;
    String platformName;
    String customerUserEmail;
    String linguistUserEmail;
    String passwordCred;
    String appPackageName;
    String appActivityName;
    String implicWait;
    String urlD1;
    String translateTo;
    String needHelpWith;
    String drpSelectLanguage;
    String drpSelectNeedWith;
    String permissionPopUpID;
    String btnContinue;
    String mobilePermissionAlertPopUp;
    String btnTextAudio;
    String btnTextCancel;
    String signInText;
    String emailText;
    String passwordText;
    String nextbtnText;
    String callTypeText;
    String callDetailsText;
    String commentsMessageText;
    String closeEventMessageText;
    String btnGetStarted;
    String txtFirstName;
    String txtEmail;
    String txtCreatePassword;
    String btnCreateAccount;
    String navSettings;
    String textLogout;
    String btnYesLogout;
    String bundleIDiOS;
    String xcodeOrgId;
    String xcodeSigningId;
    String platformMobile;
    String accountCardNumber;
    String expirationDate;
    String cvvNumber;
    String needHelpDrp;
    String onBoarding;
    String businessEmail;
    String restrictedEmail;
    String lessRestrictedEmail;
    String subscribedEmail;
    String freeMinutes;
    String startCall;

    public MainConfiguration() {
        try {
            fs = new FileInputStream("JeenieConfiguration/MainConfig.properties");
            prop.load(fs);
        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    public String getDeviceNameOne() {
        try {
            deviceNameFirst = prop.getProperty("deviceNameOne");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return deviceNameFirst;
    }

    public String getDeviceNameTwo() {
        try {
            deviceNameSecond = prop.getProperty("deviceNameTwo");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return deviceNameSecond;
    }

    public String getDeviceVersionOne() {
        try {
            deviceVersionFirst = prop.getProperty("deviceVersionOne");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return deviceVersionFirst;
    }

    public String getDeviceVersionTwo() {
        try {
            deviceVersionSecond = prop.getProperty("deviceVersionTwo");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return deviceVersionSecond;
    }

    public String getDeviceIdOne() {
        try {
            deviceIdFirst = prop.getProperty("deviceIdOne");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return deviceIdFirst;
    }

    public String getDeviceIdTwo() {
        try {
            deviceIdSecond = prop.getProperty("deviceIdTwo");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return deviceIdSecond;
    }

    public String getDevicePlatform() {
        try {
            platformName = prop.getProperty("mobPlatformName");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return platformName;
    }

    public String getCustomerEmail() {
        try {
            customerUserEmail = prop.getProperty("customerEmail");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return customerUserEmail;
    }

    public String getLinguistEmail() {
        try {
            linguistUserEmail = prop.getProperty("linguistEmail");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return linguistUserEmail;
    }

    public String getPassword() {
        try {
            passwordCred = prop.getProperty("credPassword");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return passwordCred;
    }

    public String getPackageName() {
        try {
            appPackageName = prop.getProperty("applicationPackage");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return appPackageName;
    }

    public String getActivityName() {
        try {
            appActivityName = prop.getProperty("applicationActivity");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return appActivityName;
    }

    public String GetImplicitWait() {
        try {
            implicWait = prop.getProperty("waitImplicit");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return implicWait;
    }

    public String getLocalHostUrl() {
        try {
            urlD1 = prop.getProperty("localUrlD1");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return urlD1;
    }

    public String getLanguageTranslateTo() {
        try {
            translateTo = prop.getProperty("languageTranslateTo");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return translateTo;
    }

    public String getNeedHelp() {
        try {
            needHelpWith = prop.getProperty("needHelpWith");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return needHelpWith;
    }

    public String getSelectTranslate() {
        try {
            drpSelectLanguage = prop.getProperty("selectLanguage");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return drpSelectLanguage;
    }

    public String getSelectNeedHelp() {
        try {
            drpSelectNeedWith = prop.getProperty("selectTextNeedWith");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return drpSelectNeedWith;
    }

    public String getMobilePopupID() {
        try {
            permissionPopUpID = prop.getProperty("mobileScreenPopup");
        } catch (Exception ex) {
            ex.getMessage();
        }

        return permissionPopUpID;
    }

    public String getContinueBtn() {
        try {
            btnContinue = prop.getProperty("btnContinue");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return btnContinue;
    }

    public String getPermissionPopUpText() {
        try {
            mobilePermissionAlertPopUp = prop.getProperty("permissionPopUpText");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return mobilePermissionAlertPopUp;
    }

    public String getBtnAudioText() {
        try {
            btnTextAudio = prop.getProperty("btnAudioCall");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return btnTextAudio;
    }

    public String getBtnCancelText() {
        try {
            btnTextCancel = prop.getProperty("btnCancelText");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return btnTextCancel;
    }

    public String getSignInText() {
        try {
            signInText = prop.getProperty("btnTextSignIn");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return signInText;
    }

    public String getEmailText() {
        try {
            emailText = prop.getProperty("btnTextEmail");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return emailText;
    }

    public String getPasswordText() {
        try {
            passwordText = prop.getProperty("btnTextPassword");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return passwordText;
    }

    public String getNextbtnText() {
        try {
            nextbtnText = prop.getProperty("nextBtn");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return nextbtnText;
    }

    public String getCallTypeText() {
        try {
            callTypeText = prop.getProperty("callType");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return callTypeText;
    }

    public String getCallDetailsText() {
        try {
            callDetailsText = prop.getProperty("callDetails");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return callDetailsText;
    }

    public String getCommentsMessageText() {
        try {
            commentsMessageText = prop.getProperty("commentsMessage");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return commentsMessageText;
    }

    public String getCloseEventMessageText() {
        try {
            closeEventMessageText = prop.getProperty("closeEventMessage");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return closeEventMessageText;
    }

    public String getBtnGetStarted() {
        try {
            btnGetStarted = prop.getProperty("btnGetStarted");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return btnGetStarted;
    }

    public String getTxtFirstName() {
        try {
            txtFirstName = prop.getProperty("txtFirstName");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return txtFirstName;
    }

    public String getTxtEmail() {
        try {
            txtEmail = prop.getProperty("txtEmail");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return txtEmail;
    }

    public String getTxtCreatePassword() {
        try {
            txtCreatePassword = prop.getProperty("txtCreatePassword");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return txtCreatePassword;
    }

    public String getBtnCreateAccount() {
        try {
            btnCreateAccount = prop.getProperty("btnCreateAccount");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return btnCreateAccount;
    }

    public String getNavSettings() {
        try {
            navSettings = prop.getProperty("navSettings");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return navSettings;
    }

    public String getTextLogout() {
        try {
            textLogout = prop.getProperty("textLogout");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return textLogout;
    }

    public String getLogoutPopupID() {
        try {
            btnYesLogout = prop.getProperty("logoutPopUp");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return btnYesLogout;
    }

    public String getBundleIDiOS() {
        try {
            bundleIDiOS = prop.getProperty("iOSbundleId");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return bundleIDiOS;
    }

    public String getXcodeOrgId() {
        try {
            xcodeOrgId = prop.getProperty("xcodeOrgId");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return xcodeOrgId;
    }

    public String getXcodeSigningId() {
        try {
            xcodeSigningId = prop.getProperty("xcodeSigningId");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return xcodeSigningId;
    }

    public String getPlatformiOS() {
        try {
            platformMobile = prop.getProperty("PlatformiOS");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return platformMobile;
    }

    public String getAccountCardNumber() {
        try {
            accountCardNumber = prop.getProperty("cardNumber");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return accountCardNumber;
    }

    public String getExpirationDate() {
        try {
            expirationDate = prop.getProperty("expirationDate");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return expirationDate;
    }

    public String getCvvNumber() {
        try {
            cvvNumber = prop.getProperty("cvvNumber");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return cvvNumber;
    }

    public String getNeedHelpDrp() {
        try {
            needHelpDrp = prop.getProperty("needHelpDropdownValue");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return needHelpDrp;
    }

    public String getOnBoarding() {
        try {
            onBoarding = prop.getProperty("onBoadrdingValue");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return onBoarding;
    }

    public String getBusinessEmail() {
        try {
            businessEmail = prop.getProperty("businessEmail");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return businessEmail;
    }

    public String getRestrictedEmail() {
        try {
            restrictedEmail = prop.getProperty("restrictedEmail");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return restrictedEmail;
    }

    public String getLessRestrictedEmail() {
        try {
            lessRestrictedEmail   = prop.getProperty("lessRestrictedEmail");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return lessRestrictedEmail;
    }

    public String getSubscribedEmail() {
        try {
            subscribedEmail = prop.getProperty("subscribedEmail");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return subscribedEmail;
    }

    public String getFreeMinutes() {
        try {
            freeMinutes = prop.getProperty("freeMinutes");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return freeMinutes;
    }

    public String getStartCall() {
        try {
            startCall = prop.getProperty("startCall");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return startCall;
    }
}
