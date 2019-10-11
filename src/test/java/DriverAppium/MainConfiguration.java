package DriverAppium;

import java.io.FileInputStream;
import java.util.Properties;

public class MainConfiguration extends DriverAndroidOne {

    FileInputStream fs;
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

    Properties prop = new Properties();

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
}
