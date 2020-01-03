package com.Tenpearls.DriverAppium;

import java.io.FileInputStream;
import java.util.Properties;
public class MainConfiguration {

    FileInputStream fs;
    Properties prop = new Properties();
    String DeviceNameFirst;
    String DeviceNameSecond;
    String DeviceVersionFirst;
    String DeviceVersionSecond;
    String DeviceIdFirst;
    String DeviceIdSecond;
    String PlatformName;
    String CustomerUserEmail;
    String LinguistUserEmail;
    String PasswordCred;
    String AppPackageName;
    String AppActivityName;
    String ImplicWait;
    String urlD1;
    String urlD2;
    String TranslateTo;
    String NeedHelpWith;
    String DrpSelectLanguage;
    String DrpSelectNeedWith;
    String PermissionPopUpID;
    String btnContinue;
    String MobilePermissionAlertPopUp;
    String btnTextAudio;
    String btnTextCancel;
    String SignInText;
    String EmailText;
    String PasswordText;
    String NextbtnText;
    String CallTypeText;
    String CallDetailsText;
    String CommentsMessageText;
    String CloseEventMessageText;
    String BtnGetStarted;
    String TxtFirstName;
    String TxtEmail;
    String TxtCreatePassword;
    String BtnCreateAccount;
    String NavSettings;
    String TextLogout;
    String BtnYesLogout;
    String BundleIDiOS;
    String XcodeOrgId;
    String XcodeSigningId;
    String PlatformMobile;
    String AccountCardNumber;
    String ExpirationDate;
    String CvvNumber;
    String NeedHelpDrp;
    String onBoarding;



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
            DeviceNameFirst = prop.getProperty("DeviceNameOne");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return DeviceNameFirst;
    }

    public String getDeviceNameTwo() {
        try {
            DeviceNameSecond = prop.getProperty("DeviceNameTwo");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return DeviceNameSecond;
    }

    public String getDeviceVersionOne() {
        try {
            DeviceVersionFirst = prop.getProperty("DeviceVersionOne");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return DeviceVersionFirst;
    }

    public String getDeviceVersionTwo() {
        try {
            DeviceVersionSecond = prop.getProperty("DeviceVersionTwo");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return DeviceVersionSecond;
    }

    public String getDeviceIdOne() {
        try {
            DeviceIdFirst = prop.getProperty("DeviceIdOne");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return DeviceIdFirst;
    }

    public String getDeviceIdTwo() {
        try {
            DeviceIdSecond = prop.getProperty("DeviceIdTwo");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return DeviceIdSecond;
    }

    public String getDevicePlatform() {
        try {
            PlatformName = prop.getProperty("MobPlatformName");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return PlatformName;
    }

    public String getCustomerEmail() {
        try {
            CustomerUserEmail = prop.getProperty("CustomerEmail");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return CustomerUserEmail;
    }

    public String getLinguistEmail() {
        try {
            LinguistUserEmail = prop.getProperty("LinguistEmail");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return LinguistUserEmail;
    }

    public String getPassword() {
        try {
            PasswordCred = prop.getProperty("CredPassword");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return PasswordCred;
    }

    public String getPackageName() {
        try {
            AppPackageName = prop.getProperty("ApplicationPackage");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return AppPackageName;
    }

    public String getActivityName() {
        try {
            AppActivityName = prop.getProperty("ApplicationActivity");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return AppActivityName;
    }

    public String GetImplicitWait() {
        try {
            ImplicWait = prop.getProperty("WaitImplicit");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return ImplicWait;
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
            TranslateTo = prop.getProperty("languageTranslateTo");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return TranslateTo;
    }

    public String getNeedHelp() {
        try {
            NeedHelpWith = prop.getProperty("needHelpWith");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return NeedHelpWith;
    }

    public String getSelectTranslate() {
        try {
            DrpSelectLanguage = prop.getProperty("selectLanguage");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return DrpSelectLanguage;
    }

    public String getSelectNeedHelp() {
        try {
            DrpSelectNeedWith = prop.getProperty("selectTextNeedWith");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return DrpSelectNeedWith;
    }

    public String getMobilePopupID() {
        try {
            PermissionPopUpID = prop.getProperty("mobileScreenPopup");
        } catch (Exception ex) {
            ex.getMessage();
        }

        return PermissionPopUpID;
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
            MobilePermissionAlertPopUp = prop.getProperty("permissionPopUpText");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return MobilePermissionAlertPopUp;
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
            SignInText = prop.getProperty("btnTextSignIn");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return SignInText;
    }

    public String getEmailText() {
        try {
            EmailText = prop.getProperty("btnTextEmail");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return EmailText;
    }

    public String getPasswordText() {
        try {
            PasswordText = prop.getProperty("btnTextPassword");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return PasswordText;
    }

    public String getNextbtnText() {
        try {
            NextbtnText = prop.getProperty("nextBtn");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return NextbtnText;
    }

    public String getCallTypeText() {
        try {
            CallTypeText = prop.getProperty("callType");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return CallTypeText;
    }

    public String getCallDetailsText() {
        try {
            CallDetailsText = prop.getProperty("callDetails");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return CallDetailsText;
    }

    public String getCommentsMessageText() {
        try {
            CommentsMessageText = prop.getProperty("commentsMessage");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return CommentsMessageText;
    }

    public String getCloseEventMessageText() {
        try {
            CloseEventMessageText = prop.getProperty("closeEventMessage");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return CloseEventMessageText;
    }

    public String getBtnGetStarted() {
        try {
            BtnGetStarted = prop.getProperty("btnGetStarted");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return BtnGetStarted;
    }

    public String getTxtFirstName() {
        try {
            TxtFirstName = prop.getProperty("txtFirstName");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return TxtFirstName;
    }

    public String getTxtEmail() {
        try {
            TxtEmail = prop.getProperty("txtEmail");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return TxtEmail;
    }

    public String getTxtCreatePassword() {
        try {
            TxtCreatePassword = prop.getProperty("txtCreatePassword");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return TxtCreatePassword;
    }

    public String getBtnCreateAccount() {
        try {
            BtnCreateAccount = prop.getProperty("btnCreateAccount");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return BtnCreateAccount;
    }

    public String getNavSettings() {
        try {
            NavSettings = prop.getProperty("navSettings");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return NavSettings;
    }

    public String getTextLogout() {
        try {
            TextLogout = prop.getProperty("textLogout");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return TextLogout;
    }

    public String getLogoutPopupID() {
        try {
            BtnYesLogout = prop.getProperty("logoutPopUp");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return BtnYesLogout;
    }

    public String getBundleIDiOS() {
        try {
            BundleIDiOS= prop.getProperty("iOSbundleId");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return BundleIDiOS;
    }

    public String getXcodeOrgId() {
        try {
            XcodeOrgId= prop.getProperty("xcodeOrgId");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return XcodeOrgId;
    }

    public String getXcodeSigningId() {
        try {
            XcodeSigningId= prop.getProperty("xcodeSigningId");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return XcodeSigningId;
    }

    public String getPlatformiOS() {
        try {
            PlatformMobile= prop.getProperty("PlatformiOS");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return PlatformMobile;
    }

    public String getAccountCardNumber() {
        try {
            AccountCardNumber= prop.getProperty("cardNumber");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return AccountCardNumber;
    }

    public String getExpirationDate() {
        try {
            ExpirationDate= prop.getProperty("expirationDate");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return ExpirationDate;
    }

    public String getCvvNumber() {
        try {
            CvvNumber= prop.getProperty("cvvNumber");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return CvvNumber;
    }

    public String getNeedHelpDrp() {
        try {
            NeedHelpDrp= prop.getProperty("needHelpDropdownValue");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return NeedHelpDrp;
    }

    public String getOnBoarding() {
        try {
            onBoarding= prop.getProperty("onBoadrdingValue");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return onBoarding;
    }





}
