package com.Tenpearls.TestCases;

import com.Tenpearls.DriverAppium.MainConfiguration;
import com.Tenpearls.DriverAppium.MainDriverCalling;
import com.Tenpearls.JeenieImplementation.ImpMainDriverOne;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class JeenieTestSubscribedE2E extends MainDriverCalling {
    MainConfiguration objMainConf = new MainConfiguration();
    ImpMainDriverOne objImpD1;

    @BeforeSuite
    public void testDriver() throws MalformedURLException {
        deviceDriverOne();
    }

    @Test(priority = 1, enabled = true)
    public void CustomerLogin() {
        objImpD1 = new ImpMainDriverOne(driverOne);
        objImpD1.loginCustomer(objMainConf.getSubscribedEmail(), objMainConf.getPassword());
    }

    @Test(priority = 2, enabled = true)
    public void CustomerCallingLinguist() {
        objImpD1 = new ImpMainDriverOne(driverOne);
        objImpD1.subscribedUser();
    }

    @Test(priority = 3, enabled = true)
    public void CustomerLogout() {
        objImpD1 = new ImpMainDriverOne(driverOne);
        objImpD1.customerLogout();
    }

    @AfterSuite
    public void TearDown() {
        stopDriverOne();

    }

}
