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

    @Test(priority = 0)
    public void customerLogin() {
        objImpD1=new ImpMainDriverOne(driverOne);
        objImpD1.loginCustomer();
        System.out.println("Before Test Passed");
    }

    @AfterSuite
    public void Test2() {
        System.out.println("Stop driver");
        driverOne.quit();
        System.out.println("Test Passed");
    }
}
