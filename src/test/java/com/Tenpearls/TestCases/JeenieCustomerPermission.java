package com.Tenpearls.TestCases;

import com.Tenpearls.DriverAppium.MainConfiguration;
import com.Tenpearls.DriverAppium.MainDriverCalling;
import com.Tenpearls.JeenieImplementation.ImpMainDriverOne;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class JeenieCustomerPermission extends MainDriverCalling {
    MainConfiguration objMainConf = new MainConfiguration();
    ImpMainDriverOne objImpD1;

    @BeforeSuite
    public void testDriver() throws MalformedURLException {
        deviceDriverOne();
    }

    @Test(priority = 1, enabled = true)
    public void CustomerLogin() {
        objImpD1  = new ImpMainDriverOne(driverOne);
        objImpD1.loginCustomer(objMainConf.getResponse("customerEmail"), objMainConf.getResponse("credPassword"));
    }

    @Test(priority = 2, enabled = true)
    public void CustomerCallingLinguist() {
        objImpD1 = new ImpMainDriverOne(driverOne);
        objImpD1.callAudio2();
    }

    @AfterSuite
    public void TearDown() {
        stopDriverOne();
    }
}
