package com.Tenpearls.TestCases;

import com.Tenpearls.DriverAppium.MainDriverCalling;
import com.Tenpearls.JeenieImplementation.ImpMainDriverOne;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class JeenieTestOne extends MainDriverCalling {

    ImpMainDriverOne objImpD1;

    @BeforeSuite
    public void testDriver() throws MalformedURLException {
        deviceDriverOne();
    }

    @Test(priority = 1, enabled = true)
    public void customerLogin() {
        objImpD1 = new ImpMainDriverOne(driverOne);
        //objImpD1.loginCustomer();
        objImpD1.createAccount();
    }

    @Test(priority = 4, enabled = true)
    public void CustomerCallingLinguist() {
        objImpD1 = new ImpMainDriverOne(driverOne);
        objImpD1.callAudio();
    }

//    @Test(priority = 7, enabled = true)
//    public void FeedBackSubmitByCustomer() {
//        objImpD1 = new ImpMainDriverOne(driverOne);
//        objImpD1.submitFeedbackByCustomer();
//        System.out.println("Test priority 7 executed of Jeenie 1");
//    }

//    @Test(priority = 9, enabled = true)
//    public void CustomerLogout() {
//        objImpD1 = new ImpMainDriverOne(driverOne);
//        objImpD1.customerLogout();
//    }

    @AfterSuite
    public void TearDown() {
        System.out.println("Stop driver");
        driverOne.quit();
        System.out.println("Driver Quit Successfully");
    }
}
