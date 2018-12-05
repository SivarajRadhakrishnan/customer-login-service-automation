package com.bankbazaar.tatests.tests.servicestest.IN.CustomerLoginService;

import com.bankbazaar.model.TestInfo;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by sivaraj on 6/12/18.
 */
public class CustomerLoginServiceFunctionalWebTest extends CustomerLoginServiceFunctionalWebBaseTest {
    @Test(groups = {"Regression","GetCustomerById"},
            description = "Call getCustomerById API with existing cusomer Id of BANKBAZAAR customer")
    @TestInfo(testLinkTestCaseIds = {"NA"},
            testCaseDescription = "Call getCustomerById API with existing cusomer Id of BANKBAZAAR customer",
            useCasesDescription = "Call getCustomerById API with existing cusomer Id of BANKBAZAAR customer",
            module = "GetCustomerById",
            category = "CUSTOMERLOGINSERVICE",
            testType = "Services",
            currentStage = "InRegression",
            priority = "P1",
            createdBy = "sivaraj.radhakrishnan@bankbazaar.com",
            createdOn = "10/09/2018",
            timeToAutomateInHrs = "")
    public void IN_CustomerLoginService_FunctionalWeb_TestCase1()
    {
        Assert.assertEquals(true, true);
    }
    @Test(groups = {"Regression","GetCustomerById"},
            description = "Call getCustomerById API with existing cusomer Id of BANKBAZAAR customer")
    @TestInfo(testLinkTestCaseIds = {"NA"},
            testCaseDescription = "Call getCustomerById API with existing cusomer Id of BANKBAZAAR customer",
            useCasesDescription = "Call getCustomerById API with existing cusomer Id of BANKBAZAAR customer",
            module = "GetCustomerById",
            category = "CUSTOMERLOGINSERVICE",
            testType = "Services",
            currentStage = "InRegression",
            priority = "P1",
            createdBy = "sivaraj.radhakrishnan@bankbazaar.com",
            createdOn = "10/09/2018",
            timeToAutomateInHrs = "")
    public void IN_CustomerLoginService_FunctionalWeb_TestCase2()
    {
        Assert.assertEquals(true, false);
    }
}