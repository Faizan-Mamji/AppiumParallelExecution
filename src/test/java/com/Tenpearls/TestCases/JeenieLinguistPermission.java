package com.Tenpearls.TestCases;

import com.Tenpearls.DriverAppium.MainDriverCalling;
import com.Tenpearls.JeenieImplementation.ImpMainDriverTwo;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.annotations.*;

public class JeenieLinguistPermission extends MainDriverCalling {

    AppiumDriverLocalService appiumService;
    ImpMainDriverTwo objImpD2;
    MainDriverCalling objD;

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
        objImpD2.lingustPermissionCheckDeny();
        System.out.println("Test 3 executed of Jeenie 2");
    }


//    @AfterSuite
//    public void TearDown() {
//        stopDriverTwo();
//
//    }
}
