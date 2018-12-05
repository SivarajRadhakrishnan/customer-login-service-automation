package com.bankbazaar.tatests.tests.servicestest.IN.CustomerLoginService;

import com.bankbazaar.loggers.LogManager;
import com.bankbazaar.model.TestInfo;
import com.bankbazaar.model.WebServiceResponse;
import com.bankbazaar.tatests.constants.CustomerLoginServiceConstants;
import com.bankbazaar.tatests.services.Services;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * Created by sivaraj on 17/12/18.
 */
public class CustomerLoginServiceV2SignupAPIIntegrationTest extends CustomerLoginServiceBaseTest{

    @Test(groups = {"Regression","SignUp"},
            description = "Call SignUp API to save BB_NATIVE_EMAIL customer and validate response")
    @TestInfo(testLinkTestCaseIds = {"NA"},
            testCaseDescription = "Call SignUp API to save BB_NATIVE_EMAIL customer and validate response",
            useCasesDescription = "Call SignUp API to save BB_NATIVE_EMAIL customer and validate response",
            module = "SignIn",
            category = "CUSTOMERLOGINSERVICE",
            testType = "Services",
            currentStage = "InRegression",
            priority = "P1",
            createdBy = "sivaraj.radhakrishnan@bankbazaar.com",
            createdOn = "03/12/2018",
            timeToAutomateInHrs = "")
    public void IN_CustomerLoginService_Call_SignUP_API_And_Save_BB_NATIVE_EMAIL_Customer_For_Website_Login_And_Validate_Response()
    {
        Map<String, String> values = Services.CustomerLoginService().getAllValues();
        values.put(CustomerLoginServiceConstants.UserName, values.get(CustomerLoginServiceConstants.EmailId));
        values.put(CustomerLoginServiceConstants.LoginType, CustomerLoginServiceConstants.BB_NATIVE_EMAIL);
        WebServiceResponse response = Services.CustomerLoginService().signUp(CustomerLoginServiceConstants.mp, values, true);
        if(response.status == 200)
        {
            Services.CustomerLoginService().validateSignUpResponse(response, values);
            Services.CustomerLoginService().populateSignUpResponse(response, values);
            WebServiceResponse response2 = Services.CustomerLoginService().getV2CustomerById(values.get(CustomerLoginServiceConstants.CustomerId), CustomerLoginServiceConstants.mp);
            Services.CustomerLoginService().validateV2Customer(response2, values);
        }else
        {
            LogManager.logError("Http Status : " + response.status);
        }
    }

    @Test(groups = {"Regression","SignUp"},
            description = "Call SignUp API to save BB_NATIVE_EMAIL customer and validate response")
    @TestInfo(testLinkTestCaseIds = {"NA"},
            testCaseDescription = "Call SignUp API to save BB_NATIVE_EMAIL customer and validate response",
            useCasesDescription = "Call SignUp API to save BB_NATIVE_EMAIL customer and validate response",
            module = "SignIn",
            category = "CUSTOMERLOGINSERVICE",
            testType = "Services",
            currentStage = "InRegression",
            priority = "P1",
            createdBy = "sivaraj.radhakrishnan@bankbazaar.com",
            createdOn = "03/12/2018",
            timeToAutomateInHrs = "")
    public void IN_CustomerLoginService_Call_SignUP_API_And_Save_BB_NATIVE_EMAIL_Customer_For_MobileApp_Login_And_Validate_Response()
    {
        Map<String, String> values = Services.CustomerLoginService().getAllValues();
        values.put(CustomerLoginServiceConstants.UserName, values.get(CustomerLoginServiceConstants.EmailId));
        values.put(CustomerLoginServiceConstants.LoginType, CustomerLoginServiceConstants.BB_NATIVE_EMAIL);
        values.put(CustomerLoginServiceConstants.Platform, CustomerLoginServiceConstants.ANDROID);
        values.put(CustomerLoginServiceConstants.AppVersion, values.get(CustomerLoginServiceConstants.AndroidAppVersionOld));
        WebServiceResponse response = Services.CustomerLoginService().signUp(CustomerLoginServiceConstants.mp, values, true);
        if(response.status == 200)
        {
            Services.CustomerLoginService().validateSignUpResponse(response, values);
            Services.CustomerLoginService().populateSignUpResponse(response, values);
            WebServiceResponse response2 = Services.CustomerLoginService().getV2CustomerById(values.get(CustomerLoginServiceConstants.CustomerId), CustomerLoginServiceConstants.mp);
            Services.CustomerLoginService().validateV2Customer(response2, values);
        }else
        {
            LogManager.logError("Http Status : " + response.status);
        }
    }

    @Test(groups = {"Regression","SignUp"},
            description = "Call SignUp API to save BB_NATIVE_MOBILE customer for website login and validate response")
    @TestInfo(testLinkTestCaseIds = {"NA"},
            testCaseDescription = "Call SignUp API to save BB_NATIVE_MOBILE customer for website login and validate response",
            useCasesDescription = "Call SignUp API to save BB_NATIVE_MOBILE customer for website login and validate response",
            module = "SignIn",
            category = "CUSTOMERLOGINSERVICE",
            testType = "Services",
            currentStage = "InRegression",
            priority = "P1",
            createdBy = "sivaraj.radhakrishnan@bankbazaar.com",
            createdOn = "03/12/2018",
            timeToAutomateInHrs = "")
    public void IN_CustomerLoginService_Call_SignUP_API_And_Save_BB_NATIVE_MOBILE_Customer_For_Website_Login_And_Validate_Response()
    {
        Map<String, String> values = Services.CustomerLoginService().getAllValues();
        values.put(CustomerLoginServiceConstants.UserName, "7999999999");
        values.put(CustomerLoginServiceConstants.Password, "test123!");
        values.put(CustomerLoginServiceConstants.FirstName, "FXOCCRPFKEYSPEW");
        values.put(CustomerLoginServiceConstants.LastName, "FWOCDGZRIOHSITB");
        values.put(CustomerLoginServiceConstants.LoginType, CustomerLoginServiceConstants.BB_NATIVE_MOBILE);
        values.put(CustomerLoginServiceConstants.OTPVerified, "true");
        WebServiceResponse response = Services.CustomerLoginService().signUp(CustomerLoginServiceConstants.mp, values, true);
        if(response.status == 200)
        {
            Services.CustomerLoginService().validateSignUpResponse(response, values);
            Services.CustomerLoginService().populateSignUpResponse(response, values);
            WebServiceResponse response2 = Services.CustomerLoginService().getV2CustomerById(values.get(CustomerLoginServiceConstants.CustomerId), CustomerLoginServiceConstants.mp);
            Services.CustomerLoginService().validateV2Customer(response2, values);
        }else
        {
            LogManager.logError("Http Status : " + response.status);
        }
    }

    @Test(groups = {"Regression","SignUp"},
            description = "Call SignUp API to save BB_NATIVE_MOBILE customer for website login and validate response")
    @TestInfo(testLinkTestCaseIds = {"NA"},
            testCaseDescription = "Call SignUp API to save BB_NATIVE_MOBILE customer for website login and validate response",
            useCasesDescription = "Call SignUp API to save BB_NATIVE_MOBILE customer for website login and validate response",
            module = "SignIn",
            category = "CUSTOMERLOGINSERVICE",
            testType = "Services",
            currentStage = "InRegression",
            priority = "P1",
            createdBy = "sivaraj.radhakrishnan@bankbazaar.com",
            createdOn = "03/12/2018",
            timeToAutomateInHrs = "")
    public void IN_CustomerLoginService_Call_SignUP_API_And_Save_BB_NATIVE_MOBILE_Customer_For_Website_AutoSignUp_Login_And_Validate_Response()
    {
        Map<String, String> values = Services.CustomerLoginService().getAllValues();
        values.put(CustomerLoginServiceConstants.UserName, "7999999999");
        values.put(CustomerLoginServiceConstants.Password, "test123!");
        values.put(CustomerLoginServiceConstants.FirstName, "FXOCCRPFKEYSPEW");
        values.put(CustomerLoginServiceConstants.LastName, "FWOCDGZRIOHSITB");
        values.put(CustomerLoginServiceConstants.LoginType, CustomerLoginServiceConstants.BB_NATIVE_MOBILE);
        values.put(CustomerLoginServiceConstants.OTPVerified, "true");
        values.put(CustomerLoginServiceConstants.AutoSignup, "true");
        values.put(CustomerLoginServiceConstants.CustomerContactDetailSource, values.get(CustomerLoginServiceConstants.CustomerContactDetailSource_Random));
        WebServiceResponse response = Services.CustomerLoginService().signUp(CustomerLoginServiceConstants.mp, values, true);
        if(response.status == 200)
        {
            Services.CustomerLoginService().validateSignUpResponse(response, values);
            Services.CustomerLoginService().populateSignUpResponse(response, values);
            WebServiceResponse response2 = Services.CustomerLoginService().getV2CustomerById(values.get(CustomerLoginServiceConstants.CustomerId), CustomerLoginServiceConstants.mp);
            Services.CustomerLoginService().validateV2Customer(response2, values);
        }else
        {
            LogManager.logError("Http Status : " + response.status);
        }
    }

    @Test(groups = {"Regression","SignUp"},
            description = "Call SignUp API to save BB_NATIVE_MOBILE customer for Mobile app login with lastest app version and validate response")
    @TestInfo(testLinkTestCaseIds = {"NA"},
            testCaseDescription = "Call SignUp API to save BB_NATIVE_MOBILE customer for Mobile app login with lastest app version and validate response",
            useCasesDescription = "Call SignUp API to save BB_NATIVE_MOBILE customer for Mobile app login with lastest app version and validate response",
            module = "SignIn",
            category = "CUSTOMERLOGINSERVICE",
            testType = "Services",
            currentStage = "InRegression",
            priority = "P1",
            createdBy = "sivaraj.radhakrishnan@bankbazaar.com",
            createdOn = "03/12/2018",
            timeToAutomateInHrs = "")
    public void IN_CustomerLoginService_Call_SignUP_API_And_Save_BB_NATIVE_MOBILE_Customer_For_MobileApp_Login_LatestAppVersion_And_Validate_Response()
    {
        Map<String, String> values = Services.CustomerLoginService().getAllValues();
        values.put(CustomerLoginServiceConstants.UserName, "7999999999");
        values.put(CustomerLoginServiceConstants.Password, "test123!");
        values.put(CustomerLoginServiceConstants.FirstName, "FXOCCRPFKEYSPEW");
        values.put(CustomerLoginServiceConstants.LastName, "FWOCDGZRIOHSITB");
        values.put(CustomerLoginServiceConstants.LoginType, CustomerLoginServiceConstants.BB_NATIVE_MOBILE);
        values.put(CustomerLoginServiceConstants.Platform, CustomerLoginServiceConstants.ANDROID);
        values.put(CustomerLoginServiceConstants.AppVersion, values.get(CustomerLoginServiceConstants.AndroidAppVersionNew));
        values.put(CustomerLoginServiceConstants.DeviceId, "44b0dc51-c9c8-4b38-9609-6b4676332a30");
        values.put(CustomerLoginServiceConstants.OTPVerified, "true");
        WebServiceResponse response = Services.CustomerLoginService().signUp(CustomerLoginServiceConstants.mp, values, true);
        if(response.status == 200)
        {
            Services.CustomerLoginService().validateSignUpResponse(response, values);
            Services.CustomerLoginService().populateSignUpResponse(response, values);
            WebServiceResponse response2 = Services.CustomerLoginService().getV2CustomerById(values.get(CustomerLoginServiceConstants.CustomerId), CustomerLoginServiceConstants.mp);
            Services.CustomerLoginService().validateV2Customer(response2, values);
        }else
        {
            LogManager.logError("Http Status : " + response.status);
        }
    }

    @Test(groups = {"Regression","SignUp"},
            description = "Call SignUp API to save BB_NATIVE_MOBILE customer for Mobile app login with lastest app version and validate response")
    @TestInfo(testLinkTestCaseIds = {"NA"},
            testCaseDescription = "Call SignUp API to save BB_NATIVE_MOBILE customer for Mobile app login with lastest app version and validate response",
            useCasesDescription = "Call SignUp API to save BB_NATIVE_MOBILE customer for Mobile app login with lastest app version and validate response",
            module = "SignIn",
            category = "CUSTOMERLOGINSERVICE",
            testType = "Services",
            currentStage = "InRegression",
            priority = "P1",
            createdBy = "sivaraj.radhakrishnan@bankbazaar.com",
            createdOn = "03/12/2018",
            timeToAutomateInHrs = "")
    public void IN_CustomerLoginService_Call_SignUP_API_And_Save_BB_NATIVE_MOBILE_Customer_For_MobileApp_Login_OldAppVersion_And_Validate_Response()
    {
        Map<String, String> values = Services.CustomerLoginService().getAllValues();
        values.put(CustomerLoginServiceConstants.UserName, "7999999999");
        values.put(CustomerLoginServiceConstants.Password, "test123!");
        values.put(CustomerLoginServiceConstants.FirstName, "FXOCCRPFKEYSPEW");
        values.put(CustomerLoginServiceConstants.LastName, "FWOCDGZRIOHSITB");
        values.put(CustomerLoginServiceConstants.LoginType, CustomerLoginServiceConstants.BB_NATIVE_MOBILE);
        values.put(CustomerLoginServiceConstants.Platform, CustomerLoginServiceConstants.IOS);
        values.put(CustomerLoginServiceConstants.AppVersion, values.get(CustomerLoginServiceConstants.AndroidAppVersionOld));
        values.put(CustomerLoginServiceConstants.DeviceId, "d8a2a508-d1ca-4e28-8385-54543a0f8b43");
        values.put(CustomerLoginServiceConstants.OTPVerified, "true");
        WebServiceResponse response = Services.CustomerLoginService().signUp(CustomerLoginServiceConstants.mp, values, true);
        if(response.status == 200)
        {
            Services.CustomerLoginService().validateSignUpResponse(response, values);
            Services.CustomerLoginService().populateSignUpResponse(response, values);
            WebServiceResponse response2 = Services.CustomerLoginService().getV2CustomerById(values.get(CustomerLoginServiceConstants.CustomerId), CustomerLoginServiceConstants.mp);
            Services.CustomerLoginService().validateV2Customer(response2, values);
        }else
        {
            LogManager.logError("Http Status : " + response.status);
        }
    }

    @Test(groups = {"Regression","SignUp"},
            description = "Call SignUp API to save BB_NATIVE_MOBILE customer for Mobile app login with lastest app version and validate response")
    @TestInfo(testLinkTestCaseIds = {"NA"},
            testCaseDescription = "Call SignUp API to save BB_NATIVE_MOBILE customer for Mobile app login with lastest app version and validate response",
            useCasesDescription = "Call SignUp API to save BB_NATIVE_MOBILE customer for Mobile app login with lastest app version and validate response",
            module = "SignIn",
            category = "CUSTOMERLOGINSERVICE",
            testType = "Services",
            currentStage = "InRegression",
            priority = "P1",
            createdBy = "sivaraj.radhakrishnan@bankbazaar.com",
            createdOn = "03/12/2018",
            timeToAutomateInHrs = "")
    public void IN_CustomerLoginService_Call_SignUP_API_And_Save_DEVICE_Customer_For_MobileApp_Login_And_Validate_Response()
    {
        Map<String, String> values = Services.CustomerLoginService().getAllValues();
        values.put(CustomerLoginServiceConstants.UserName, values.get(CustomerLoginServiceConstants.DeviceId) + "#" + values.get(CustomerLoginServiceConstants.DeviceUserName_Suffix));
        values.put(CustomerLoginServiceConstants.Password, "test123!");
        values.put(CustomerLoginServiceConstants.LoginType, CustomerLoginServiceConstants.MOBILE_APP);
        values.put(CustomerLoginServiceConstants.Platform, CustomerLoginServiceConstants.ANDROID);
        values.put(CustomerLoginServiceConstants.AppVersion, values.get(CustomerLoginServiceConstants.AndroidAppVersionNew));
        values.put(CustomerLoginServiceConstants.OTPVerified, "true");
        WebServiceResponse response = Services.CustomerLoginService().signUp(CustomerLoginServiceConstants.mp, values, true);
        if(response.status == 200)
        {
            Services.CustomerLoginService().validateSignUpResponse(response, values);
            Services.CustomerLoginService().populateSignUpResponse(response, values);
            WebServiceResponse response2 = Services.CustomerLoginService().getV2CustomerById(values.get(CustomerLoginServiceConstants.CustomerId), CustomerLoginServiceConstants.mp);
            Services.CustomerLoginService().validateV2Customer(response2, values);
        }else
        {
            LogManager.logError("Http Status : " + response.status);
        }
    }
}