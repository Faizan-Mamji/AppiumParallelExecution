package com.Tenpearls.TestCases;

import com.Tenpearls.DriverAppium.MainConfiguration;
import com.Tenpearls.DriverAppium.MainDriverCalling;
import com.Tenpearls.JeenieImplementation.ImpMainDriverOne;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class JeeniePromoCodes extends MainDriverCalling {


    ImpMainDriverOne objImpD1;
    MainConfiguration objMainConf = new MainConfiguration();

    @BeforeSuite
    public void testDriver() throws MalformedURLException {
        deviceDriverOne();
    }

    @Test(priority = 1, enabled = true)
    public void CustomerLogin() {
        objImpD1 = new ImpMainDriverOne(driverOne);
        objImpD1.createAccount();
    }

    @Test(priority = 2, enabled = true)
    public void PromoCodesFreeMinutes() {
        objImpD1 = new ImpMainDriverOne(driverOne);
        objImpD1.enterFreeMinutesPromoCodes();
    }

    @Test(priority = 3, enabled = true)
    public void PromoCodesCall() {
        objImpD1 = new ImpMainDriverOne(driverOne);
        objImpD1.freeCallPromoCodes();
    }

    @AfterSuite
    public void TearDown() {
        stopDriverOne();
    }
}
