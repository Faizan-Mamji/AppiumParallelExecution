package TestCases;

import DriverAppium.MainDriverCalling;
import JeenieImplementation.ImpMainDriverTwo;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.annotations.*;

public class JeenieTestTwo extends MainDriverCalling {

    AppiumDriverLocalService appiumService;
    ImpMainDriverTwo objImpD2;

    @BeforeSuite
    public void testDriver() {
        deviceDriverTwo();
    }

    @Test(priority = 2)
    public void LinguistLogin() {
        objImpD2=new ImpMainDriverTwo(driverTwo);
        objImpD2.loginLinguist();
        System.out.println("Test 2 executed of Jeenie 2");
    }

    @Test(priority = 3)
    public void LinguistPermission() {
        objImpD2=new ImpMainDriverTwo(driverTwo);
        objImpD2.lingustPermissionCheck();
        System.out.println("Test 3 executed of Jeenie 2");
    }

    @Test(priority = 5)
    public void CancelLinguistNotification() {
        objImpD2=new ImpMainDriverTwo(driverTwo);
        objImpD2.lingustCallCancelNotification();
        System.out.println("Test 5 executed of Jeenie 2");
    }

    @AfterSuite
    public void Test2() {
        System.out.println("Stop driver");
        driverTwo.quit();
        quitAppiumService();
        System.out.println("Test Passed driver2");
    }
}
