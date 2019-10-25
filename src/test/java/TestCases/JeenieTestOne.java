package TestCases;

import DriverAppium.MainDriverCalling;
import JeenieImplementation.ImpMainDriverOne;
import org.testng.annotations.*;

public class JeenieTestOne extends MainDriverCalling {

    ImpMainDriverOne objImpD1;

    @BeforeSuite
    public void testDriver() {
        deviceDriverOne();
    }

    @Test(priority = 1)
    public void customerLogin() {
        objImpD1 = new ImpMainDriverOne(driverOne);
        objImpD1.loginCustomer();
    }

    @Test(priority = 4)
    public void CustomerCallingLinguist() {
        objImpD1 = new ImpMainDriverOne(driverOne);
        objImpD1.callAudio();
    }

    @Test(priority = 6)
    public void CancelCallCustomer() {
        objImpD1 = new ImpMainDriverOne(driverOne);
        objImpD1.cancelCallByCustomer();
        System.out.println("Test priority 6 executed of Jeenie 1");
    }

    @Test(priority = 7)
    public void FeedBackSubmitByCustomer() {
        objImpD1 = new ImpMainDriverOne(driverOne);
        objImpD1.submitFeedbackByCustomer();
        System.out.println("Test priority 7 executed of Jeenie 1");
    }

    @AfterSuite
    public void TearDown() {
        System.out.println("Stop driver");
        driverOne.closeApp();
        System.out.println("App Close Successfully");
        driverOne.quit();
        System.out.println("Driver Quit Successfully");
        quitAppiumService();
        System.out.println("Service Stopped Successfully");
    }
}
