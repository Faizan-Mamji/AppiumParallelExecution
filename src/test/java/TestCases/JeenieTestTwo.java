package TestCases;

import DriverAppium.DriverAndroidOne;
import DriverAppium.DriverAndroidTwo;
import JeenieImplementation.ImpDriverTwo;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.annotations.*;

public class JeenieTestTwo extends DriverAndroidTwo {

    AppiumDriverLocalService appiumService;
    ImpDriverTwo objImpD2;


    @BeforeSuite
    public void testDriver() {

        //appiumService = AppiumDriverLocalService.buildDefaultService();
       //appiumService.start();
        deviceDriverTwo();

    }

    @Test(priority = 0)
    public void LinguistLogin() {
        objImpD2=new ImpDriverTwo(driverTwo);
        objImpD2.loginLinguist();
        System.out.println("Before Test Passed");
    }

    @AfterSuite
    public void Test2() {
        System.out.println("Stop driver");
        driverTwo.quit();
//        System.out.println("Stop appium service");
//        appiumService.stop();
        System.out.println("Test Passed");
    }
}
