package com.bankbazaar.tatests.tests.servicestest.IN.CustomerLoginService;

import com.bankbazaar.DataUtil.StringUtil;
import com.bankbazaar.loggers.LogManager;
import com.bankbazaar.model.Enums;
import com.bankbazaar.model.TestInfo;
import com.bankbazaar.model.WebServiceResponse;
import com.bankbazaar.tatests.constants.services.CustomerLoginServiceConstants;
import com.bankbazaar.tatests.services.Services;
import com.bankbazaar.tatests.tests.servicestest.IN.CustomerLoginService.CustomerLoginServiceBaseTest;
import com.bankbazaar.util.Util;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * Created by sivaraj on 17/12/18.
 */
public class CustomerLoginServiceV2SigninAPIIntegrationTest extends CustomerLoginServiceBaseTest{

    @Test(groups = {"Regression","SignIn"},
            description = "Call SignIn API with BB_NATIVE_EMAIL customer credentials for website login and validate response")
    @TestInfo(testLinkTestCaseIds = {"NA"},
            testCaseDescription = "Call SignIn API with BB_NATIVE_EMAIL customer credentials for website login and validate response",
            useCasesDescription = "Call SignIn API with BB_NATIVE_EMAIL customer credentials for website login and validate response",
            module = "SignIn",
            category = "CUSTOMERLOGINSERVICE",
            testType = "Services",
            currentStage = "InRegression",
            priority = "P1",
            createdBy = "sivaraj.radhakrishnan@bankbazaar.com",
            createdOn = "03/12/2018",
            timeToAutomateInHrs = "")
    public void IN_CustomerLoginService_Call_SignIn_API_With_BB_NATIVE_EMAIL_Customer_For_WebsiteLogin_And_Validate_Response()
    {
        Map<String, String> values = Services.CustomerLoginService().getAllValues();
        Map<String, String> customerData = getV2CustomerData("Cust_1", values.get(CustomerLoginServiceConstants.LoginType));

        if(!Util.isMapEmpty(customerData))
        {
            values.putAll(customerData);
            values.put(CustomerLoginServiceConstants.LoginType, CustomerLoginServiceConstants.BB_NATIVE_EMAIL);
            WebServiceResponse response = Services.CustomerLoginService().signIn(CustomerLoginServiceConstants.mp, values, true);
            Services.CustomerLoginService().validateSignInResponse(response, values);
        }
        EndTest();
    }

    @Test(groups = {"Regression","SignIn"},
            description = "Call SignIn API with BB_NATIVE_MOBILE customer credentials for website login and validate response")
    @TestInfo(testLinkTestCaseIds = {"NA"},
            testCaseDescription = "Call SignIn API with BB_NATIVE_MOBILE customer credentials for website login and validate response",
            useCasesDescription = "Call SignIn API with BB_NATIVE_MOBILE customer credentials for website login and validate response",
            module = "SignIn",
            category = "CUSTOMERLOGINSERVICE",
            testType = "Services",
            currentStage = "InRegression",
            priority = "P1",
            createdBy = "sivaraj.radhakrishnan@bankbazaar.com",
            createdOn = "03/12/2018",
            timeToAutomateInHrs = "")
    public void IN_CustomerLoginService_Call_SignIn_API_With_BB_NATIVE_MOBILE_Customer_For_WebsiteLogin_And_Validate_Response()
    {
        Map<String, String> values = Services.CustomerLoginService().getAllValues();
        Map<String, String> customerData = getV2CustomerData("Cust_2", values.get(CustomerLoginServiceConstants.LoginType));

        if(!Util.isMapEmpty(customerData))
        {
            values.putAll(customerData);
            values.put(CustomerLoginServiceConstants.UserName, "9095390984");
            values.put(CustomerLoginServiceConstants.LoginType, CustomerLoginServiceConstants.BB_NATIVE_MOBILE);
            values.put(CustomerLoginServiceConstants.OTPVerified, "true");
            values.put(CustomerLoginServiceConstants.AutoLogin, "true");
            WebServiceResponse response = Services.CustomerLoginService().signIn(CustomerLoginServiceConstants.mp, values, true);

            Services.CustomerLoginService().validateSignInResponse(response, values);
        }
        EndTest();
    }

    @Test(groups = {"Regression","SignIn"},
            description = "Call SignIn API with BB_NATIVE_EMAIL customer credentials for mobile-app login and validate response")
    @TestInfo(testLinkTestCaseIds = {"NA"},
            testCaseDescription = "Call SignIn API with BB_NATIVE_EMAIL customer credentials for mobile-app login and validate response",
            useCasesDescription = "Call SignIn API with BB_NATIVE_EMAIL customer credentials for mobile-app login and validate response",
            module = "SignIn",
            category = "CUSTOMERLOGINSERVICE",
            testType = "Services",
            currentStage = "InRegression",
            priority = "P1",
            createdBy = "sivaraj.radhakrishnan@bankbazaar.com",
            createdOn = "03/12/2018",
            timeToAutomateInHrs = "")
    public void IN_CustomerLoginService_Call_SignIn_API_With_BB_NATIVE_EMAIL_Customer_With_MobileAppLogin_And_Validate_Response()
    {
        Map<String, String> values = Services.CustomerLoginService().getAllValues();
        Map<String, String> customerData = getV2CustomerData("Cust_1", values.get(CustomerLoginServiceConstants.LoginType));

        if(!Util.isMapEmpty(customerData))
        {
            values.putAll(customerData);
            values.put(CustomerLoginServiceConstants.LoginType, CustomerLoginServiceConstants.BB_NATIVE_EMAIL);
            values.put(CustomerLoginServiceConstants.Platform, CustomerLoginServiceConstants.ANDROID);
            values.put(CustomerLoginServiceConstants.DeviceId, "5662dadb-6020-4f0c-8228-4bfebf7962d5_1543413968");
            values.put(CustomerLoginServiceConstants.AppVersion, values.get(CustomerLoginServiceConstants.AndroidAppVersionNew));

            WebServiceResponse response = Services.CustomerLoginService().signIn(CustomerLoginServiceConstants.mp, values, true);
            Services.CustomerLoginService().validateSignInResponse(response, values);
        }
        EndTest();
    }

    @Test(groups = {"Regression","SignIn"},
            description = "Call SignIn API with BB_NATIVE_MOBILE customer credentials for mobile-app login with latest app-version and validate response")
    @TestInfo(testLinkTestCaseIds = {"NA"},
            testCaseDescription = "Call SignIn API with BB_NATIVE_MOBILE customer credentials for mobile-app login with latest app-version and validate response",
            useCasesDescription = "Call SignIn API with BB_NATIVE_MOBILE customer credentials for mobile-app login with latest app-version and validate response",
            module = "SignIn",
            category = "CUSTOMERLOGINSERVICE",
            testType = "Services",
            currentStage = "InRegression",
            priority = "P1",
            createdBy = "sivaraj.radhakrishnan@bankbazaar.com",
            createdOn = "03/12/2018",
            timeToAutomateInHrs = "")
    public void IN_CustomerLoginService_Call_SignIn_API_With_BB_NATIVE_MOBILE_Customer_For_MobileAppLogin_With_Latest_AppVersion_And_Validate_Response()
    {
        Map<String, String> values = Services.CustomerLoginService().getAllValues();
        Map<String, String> customerData = getV2CustomerData("Cust_3", values.get(CustomerLoginServiceConstants.LoginType));

        if(!Util.isMapEmpty(customerData))
        {
            values.putAll(customerData);
            values.put(CustomerLoginServiceConstants.LoginType, CustomerLoginServiceConstants.BB_NATIVE_MOBILE);
            values.put(CustomerLoginServiceConstants.Platform, CustomerLoginServiceConstants.IOS);
            values.put(CustomerLoginServiceConstants.DeviceId, "23D82CA3-0E5C-4C72-A198-CB66F0455036_1542867719");
            values.put(CustomerLoginServiceConstants.AppVersion, values.get(CustomerLoginServiceConstants.IOSAppVersionNew));
            values.put(CustomerLoginServiceConstants.OTPVerified, "true");

            WebServiceResponse response = Services.CustomerLoginService().signIn(CustomerLoginServiceConstants.mp, values, true);
            Services.CustomerLoginService().validateSignInResponse(response, values);
        }
        EndTest();
    }

    @Test(groups = {"Regression","SignIn"},
            description = "Call SignIn API with BB_NATIVE_EMAIL customer for mobile-app login with old app-version and validate response")
    @TestInfo(testLinkTestCaseIds = {"NA"},
            testCaseDescription = "Call SignIn API with BB_NATIVE_EMAIL customer for mobile-app login with old app-version and validate response",
            useCasesDescription = "Call SignIn API with BB_NATIVE_EMAIL customer for mobile-app login with old app-version and validate response",
            module = "SignIn",
            category = "CUSTOMERLOGINSERVICE",
            testType = "Services",
            currentStage = "InRegression",
            priority = "P1",
            createdBy = "sivaraj.radhakrishnan@bankbazaar.com",
            createdOn = "03/12/2018",
            timeToAutomateInHrs = "")
    public void IN_CustomerLoginService_Call_SignIn_API_With_BB_NATIVE_MOBILE_Customer_For_MobileAppLogin_With_Old_AppVersion_And_Validate_Response()
    {
        Map<String, String> values = Services.CustomerLoginService().getAllValues();
        Map<String, String> customerData = getV2CustomerData("Cust_3", values.get(CustomerLoginServiceConstants.LoginType));

        if(!Util.isMapEmpty(customerData))
        {
            values.putAll(customerData);
            values.put(CustomerLoginServiceConstants.LoginType, CustomerLoginServiceConstants.BB_NATIVE_MOBILE);
            values.put(CustomerLoginServiceConstants.Platform, CustomerLoginServiceConstants.ANDROID);
            values.put(CustomerLoginServiceConstants.DeviceId, "23D82CA3-0E5C-4C72-A198-CB66F0455036_1542867719");
            values.put(CustomerLoginServiceConstants.AppVersion, values.get(CustomerLoginServiceConstants.AndroidAppVersionOld));
            values.put(CustomerLoginServiceConstants.OTPVerified, "true");

            WebServiceResponse response = Services.CustomerLoginService().signIn(CustomerLoginServiceConstants.mp, values, true);
            Services.CustomerLoginService().validateSignInResponse(response, values);
        }
        EndTest();
    }

    @Test(groups = {"Regression","SignIn"},
            description = "Call SignIn API with GOOGLE customer credentials for website login and validate response")
    @TestInfo(testLinkTestCaseIds = {"NA"},
            testCaseDescription = "Call SignIn API with GOOGLE customer credentials for website login and validate response",
            useCasesDescription = "Call SignIn API with GOOGLE customer credentials for website login and validate response",
            module = "SignIn",
            category = "CUSTOMERLOGINSERVICE",
            testType = "Services",
            currentStage = "InRegression",
            priority = "P1",
            createdBy = "sivaraj.radhakrishnan@bankbazaar.com",
            createdOn = "03/12/2018",
            timeToAutomateInHrs = "")
    public void IN_CustomerLoginService_Call_SignIn_API_With_GPlus_Customer_For_WebsiteLogin_And_Validate_Response()
    {
        Map<String, String> values = Services.CustomerLoginService().getAllValues();
        Map<String, String> customerData = getV2CustomerData("Cust_4", values.get(CustomerLoginServiceConstants.LoginType));

        if(!Util.isMapEmpty(customerData))
        {
            values.putAll(customerData);
            values.put(CustomerLoginServiceConstants.LoginType, CustomerLoginServiceConstants.GOOGLE);

            String authCode = getOAuthCode(Enums.SocialLoginType.GOOGLE, values);
            values.put(CustomerLoginServiceConstants.OAuthCode, authCode);
            WebServiceResponse response = Services.CustomerLoginService().signIn(CustomerLoginServiceConstants.mp, values, true);
            Services.CustomerLoginService().validateSignInResponse(response, values);
        }
        EndTest();
    }

    @Test(groups = {"Regression","SignIn"},
            description = "Call SignIn API with FACEBOOK customer credentials for Android App login and validate response")
    @TestInfo(testLinkTestCaseIds = {"NA"},
            testCaseDescription = "Call SignIn API with FACEBOOK customer credentials for Android App login and validate response",
            useCasesDescription = "Call SignIn API with FACEBOOK customer credentials for Android App login and validate response",
            module = "SignIn",
            category = "CUSTOMERLOGINSERVICE",
            testType = "Services",
            currentStage = "InRegression",
            priority = "P1",
            createdBy = "sivaraj.radhakrishnan@bankbazaar.com",
            createdOn = "03/12/2018",
            timeToAutomateInHrs = "")
    public void IN_CustomerLoginService_Call_SignIn_API_With_Facebook_Customer_For_AndroidApp_Login_And_Validate_Response()
    {
        if(Services.OAuthService().isServiceDown())
        {
            LogManager.logError("OAuth Service is down");
            return;
        }
        Map<String, String> values = Services.CustomerLoginService().getAllValues();
        Map<String, String> customerData = getV2CustomerData("Cust_5", values.get(CustomerLoginServiceConstants.LoginType));

        if(!Util.isMapEmpty(customerData))
        {
            values.putAll(customerData);
            values.put(CustomerLoginServiceConstants.LoginType, CustomerLoginServiceConstants.FACEBOOK);
            values.put(CustomerLoginServiceConstants.Platform, CustomerLoginServiceConstants.ANDROID);
            values.put(CustomerLoginServiceConstants.DeviceId, "39206d83-4ebf-4bd3-8e8f-a9e61d53779c");
            values.put(CustomerLoginServiceConstants.AppVersion, values.get(CustomerLoginServiceConstants.AndroidAppVersionNew));
            values.put(CustomerLoginServiceConstants.OTPVerified, "true");

            String accessToken = getAccessToken(Enums.SocialLoginType.FACEBOOK, values);
            if(!StringUtil.isNullOrEmpty(accessToken))
            {
                values.put(CustomerLoginServiceConstants.AccessToken, accessToken);
                WebServiceResponse response = Services.CustomerLoginService().signIn(CustomerLoginServiceConstants.mp, values, true);
                Services.CustomerLoginService().validateSignInResponse(response, values);
            }else
            {
                LogManager.logError("AccessToken is Empty");
            }
        }
        EndTest();
    }

    @Test(groups = {"Regression","SignIn"},
            description = "Call SignIn API with FACEBOOK customer credentials for IOS App login and validate response")
    @TestInfo(testLinkTestCaseIds = {"NA"},
            testCaseDescription = "Call SignIn API with FACEBOOK customer credentials for IOS App login and validate response",
            useCasesDescription = "Call SignIn API with FACEBOOK customer credentials for IOS App login and validate response",
            module = "SignIn",
            category = "CUSTOMERLOGINSERVICE",
            testType = "Services",
            currentStage = "InRegression",
            priority = "P1",
            createdBy = "sivaraj.radhakrishnan@bankbazaar.com",
            createdOn = "03/12/2018",
            timeToAutomateInHrs = "")
    public void IN_CustomerLoginService_Call_SignIn_API_With_Facebook_Customer_For_IOSApp_Login_And_Validate_Response()
    {
        if(Services.OAuthService().isServiceDown())
        {
            LogManager.logError("OAuth Service is down");
            return;
        }
        Map<String, String> values = Services.CustomerLoginService().getAllValues();
        Map<String, String> customerData = getV2CustomerData("Cust_5", values.get(CustomerLoginServiceConstants.LoginType));

        if(!Util.isMapEmpty(customerData))
        {
            values.putAll(customerData);
            values.put(CustomerLoginServiceConstants.LoginType, CustomerLoginServiceConstants.FACEBOOK);
            values.put(CustomerLoginServiceConstants.Platform, CustomerLoginServiceConstants.IOS);
            values.put(CustomerLoginServiceConstants.DeviceId, "03c0741a-fd17-4114-8171-65ed7e5e58a4");
            values.put(CustomerLoginServiceConstants.AppVersion, values.get(CustomerLoginServiceConstants.IOSAppVersionOld));
            values.put(CustomerLoginServiceConstants.OTPVerified, "true");

            String accessToken = getAccessToken(Enums.SocialLoginType.FACEBOOK, values);
            if(!StringUtil.isNullOrEmpty(accessToken))
            {
                values.put(CustomerLoginServiceConstants.AccessToken, accessToken);
                WebServiceResponse response = Services.CustomerLoginService().signIn(CustomerLoginServiceConstants.mp, values, true);
                Services.CustomerLoginService().validateSignInResponse(response, values);
            }else
            {
                LogManager.logError("AccessToken is Empty");
            }
        }
        EndTest();
    }
}