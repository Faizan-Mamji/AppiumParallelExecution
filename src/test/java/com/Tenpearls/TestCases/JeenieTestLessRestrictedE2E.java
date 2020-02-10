package com.Tenpearls.TestCases;

import com.Tenpearls.DriverAppium.MainConfiguration;
import com.Tenpearls.DriverAppium.MainDriverCalling;
import com.Tenpearls.JeenieImplementation.ImpMainDriverOne;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.net.MalformedURLException;

public class JeenieTestLessRestrictedE2E extends MainDriverCalling {
    MainConfiguration objMainConf = new MainConfiguration();
    ImpMainDriverOne objImpD1;

    @BeforeSuite
    public void testDriver() throws MalformedURLException {
        deviceDriverOne();
    }

    @Test(priority = 1, enabled = true)
    public void CustomerLogin() {
        objImpD1 = new ImpMainDriverOne(driverOne);
        objImpD1.loginCustomer(objMainConf.getLessRestrictedEmail(), objMainConf.getPassword());
    }

    @Test(priority = 4, enabled = true)
    public void CustomerCallingLinguist() {
        objImpD1 = new ImpMainDriverOne(driverOne);
        objImpD1.lessRestrictedUser();
    }

    @Test(priority = 6, enabled = true)
    public void CancelCallCustomer() {
        objImpD1 = new ImpMainDriverOne(driverOne);
        objImpD1.cancelCallByCustomer();
        System.out.println("Test priority 6 executed of Jeenie 1");
    }

    @Test(priority = 7, enabled = true)
    public void FeedBackSubmitByCustomer() {
        objImpD1 = new ImpMainDriverOne(driverOne);
        objImpD1.submitFeedbackByCustomer();
        System.out.println("Test priority 7 executed of Jeenie 1");
    }

    @Test(priority = 9, enabled = true)
    public void CustomerLogout() {
        objImpD1 = new ImpMainDriverOne(driverOne);
        objImpD1.customerLogout();
    }

    @AfterSuite
    public void TearDown() {
        stopDriverOne();

    }
}
