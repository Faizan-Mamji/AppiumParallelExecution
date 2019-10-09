package TestCases;

import DriverAppium.DriverAndroidOne;
import JeenieImplementation.ImpDriverOne;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.annotations.*;

public class JeenieTestOne extends DriverAndroidOne {

    AppiumDriverLocalService appiumService;
    ImpDriverOne objImpD1;


    @BeforeSuite
    public void testDriver() {
        //appiumService = AppiumDriverLocalService.buildDefaultService();
        //appiumService.start();
        deviceDriverOne();

    }

    @Test(priority = 0)
    public void customerLogin() {
        objImpD1=new ImpDriverOne(driverOne);
        objImpD1.loginCustomer();
        System.out.println("Before Test Passed");
    }

    @AfterSuite
    public void Test2() {
        System.out.println("Stop driver");
        driverOne.quit();
//        System.out.println("Stop appium service");
//        appiumService.stop();
        System.out.println("Test Passed");
    }
}
