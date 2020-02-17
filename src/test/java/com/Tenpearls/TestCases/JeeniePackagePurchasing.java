package com.Tenpearls.TestCases;

import com.Tenpearls.DriverAppium.MainConfiguration;
import com.Tenpearls.DriverAppium.MainDriverCalling;
import com.Tenpearls.JeenieImplementation.ImpMainDriverOne;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;

import java.net.MalformedURLException;

public class JeeniePackagePurchasing extends MainDriverCalling {
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
    public void PurchasePackageWithBalanceCase() {
        objImpD1 = new ImpMainDriverOne(driverOne);
        objImpD1.packagePuchasingCaseReloadWithBalance();
    }

    @Test(priority = 3, enabled = true)
    public void PurchasePackageWithUnlimitedCase() {
        objImpD1 = new ImpMainDriverOne(driverOne);
        objImpD1.packagePuchasingCaseUnlimitedWithBalance();
    }

    @AfterSuite
    public void TearDown() {
        stopDriverOne();
    }
}

