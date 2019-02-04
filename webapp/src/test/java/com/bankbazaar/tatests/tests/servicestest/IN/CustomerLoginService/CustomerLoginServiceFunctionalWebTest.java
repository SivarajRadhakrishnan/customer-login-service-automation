package com.bankbazaar.tatests.tests.servicestest.IN.CustomerLoginService;

import com.bankbazaar.core.BaseContext;
import com.bankbazaar.model.TestInfo;
import com.bankbazaar.tatests.constants.web.MPConstants;
import com.bankbazaar.tatests.pages.Pages;
import com.bankbazaar.tatests.services.Services;
import com.bankbazaar.tatests.workflows.WorkFlows;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * Created by sivaraj on 6/12/18.
 */
public class CustomerLoginServiceFunctionalWebTest extends CustomerLoginServiceFunctionalWebBaseTest {
    @Test(groups = {"Regression","SignIn"},
            description = "Login into MP using facebook user credentials and verify login is success")
    @TestInfo(testLinkTestCaseIds = {"NA"},
            testCaseDescription = "Login into MP using facebook user credentials and verify login is success",
            useCasesDescription = "Login into MP using facebook user credentials and verify login is success",
            module = "SignIn",
            category = "CUSTOMERLOGINSERVICE",
            testType = "Services",
            currentStage = "InRegression",
            priority = "P1",
            createdBy = "sivaraj.radhakrishnan@bankbazaar.com",
            createdOn = "03/01/2019",
            timeToAutomateInHrs = "")
    public void IN_CustomerLoginService_Validate_FB_Login()
    {
        Map<String, String> values = Services.CustomerLoginService().getAllWebValues();
        BaseContext.testContext.get().partnerBankName = values.get(MPConstants.nonPartner);
        Pages.HomePage().loadHomePage(values);
        Pages.Dashboard().click_loginButton();
        Pages.LoginPage().validate_isDisplayedloginToBankbazaar(values);
        Pages.LoginPage().validate_isDisplayedSignInWithFacebook(values.get(MPConstants.signInWithFacebook));
        Pages.LoginPage().validate_isSelectedExistingUser();
        Pages.LoginPage().click_fbLoginButton();
        Pages.LoginPage().validate_isDisplayedFbRedirectionText(values.get(MPConstants.fbRedirection));
        Pages.FbLogin().login_facebook(values.get(MPConstants.fbLoginUserName), values.get(MPConstants.fbLoginPassword), false);
        Pages.Dashboard().validate_isDisplayedSuccessLogin();
        WorkFlows.DashBoardWF().validate_SuccessLogin();
        EndTest();
    }
}