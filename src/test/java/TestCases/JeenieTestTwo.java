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
        objImpD2 = new ImpMainDriverTwo(driverTwo);
        objImpD2.loginLinguist();
        System.out.println("Test 2 executed of Jeenie 2");
    }

    @Test(priority = 3)
    public void LinguistPermission() {
        objImpD2 = new ImpMainDriverTwo(driverTwo);
        objImpD2.lingustPermissionCheck();
        System.out.println("Test 3 executed of Jeenie 2");
    }

    @Test(priority = 5)
    public void AcceptCustomerCalling() {
        objImpD2 = new ImpMainDriverTwo(driverTwo);
        objImpD2.acceptCustomerCall();
        System.out.println("Call received by linguist successfully!!");
    }


    @Test(priority = 8)
    public void FeedBackSubmitByLinguist() {
        objImpD2=new ImpMainDriverTwo(driverTwo);
        objImpD2.submitFeedbackByLinguist();
        System.out.println("Feedback submitted successfully by linguist");
    }

    @AfterSuite
    public void TearDown() {
        System.out.println("Stop driver");
        driverTwo.closeApp();
        System.out.println("App Close Successfully");
        driverTwo.quit();
        System.out.println("Driver Quit Successfully");
        quitAppiumService();
        System.out.println("Service Stopped Successfully");
    }
}
