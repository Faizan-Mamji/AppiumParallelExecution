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
        objImpD1=new ImpMainDriverOne(driverOne);
        objImpD1.loginCustomer();
        System.out.println("Test 1 executed of Jeenie 1");
    }

    @Test(priority = 4)
    public void CustomerCallingLinguist() {
        objImpD1=new ImpMainDriverOne(driverOne);
        objImpD1.callAudio();
        System.out.println("Test 4 executed of Jeenie 1");
    }

    @AfterSuite
    public void Test2() {
        System.out.println("Stop driver");
        driverOne.quit();
        quitAppiumService();
        System.out.println("Test Passed for driver1");
    }
}
