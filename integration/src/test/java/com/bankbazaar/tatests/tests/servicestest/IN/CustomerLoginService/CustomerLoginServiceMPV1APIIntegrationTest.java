package com.bankbazaar.tatests.tests.servicestest.IN.CustomerLoginService;

import com.bankbazaar.DataUtil.StringUtil;
import com.bankbazaar.core.Validator;
import com.bankbazaar.loggers.LogManager;
import com.bankbazaar.model.Enums;
import com.bankbazaar.model.TestInfo;
import com.bankbazaar.model.WebServiceResponse;
import com.bankbazaar.tatests.constants.services.CustomerLoginServiceConstants;
import com.bankbazaar.tatests.services.Services;
import com.bankbazaar.tatests.tests.servicestest.IN.CustomerLoginService.CustomerLoginServiceBaseTest;
import com.bankbazaar.util.Util;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sivaraj on 17/12/18.
 */
public class CustomerLoginServiceMPV1APIIntegrationTest extends CustomerLoginServiceBaseTest {
    @Test(groups = {"Regression","SaveCustomer", "Staging"},
            description = "Save new V1 Customer by calling saveCustomer API and validate the saved customer")
    @TestInfo(testLinkTestCaseIds = {"NA"},
            testCaseDescription = "Save new V1 Customer by calling saveCustomer API and validate the saved customer",
            useCasesDescription = "Save new V1 Customer by calling saveCustomer API and validate the saved customer",
            module = "SaveCustomer",
            category = "CUSTOMERLOGINSERVICE",
            testType = "Services",
            currentStage = "InRegression",
            priority = "P1",
            createdBy = "sivaraj.radhakrishnan@bankbazaar.com",
            createdOn = "14/09/2018",
            timeToAutomateInHrs = "")
    public void IN_CustomerLoginService_Call_SaveCustomer_API_For_V1_Customer_And_Validate_Response()
    {
        Map<String, String> values = Services.CustomerLoginService().getAllValues();
        values.put(CustomerLoginServiceConstants.RoleIds, values.get(CustomerLoginServiceConstants.DefaultRoleIds));
        Map<String, List<Map<String, String>>> multiValueDataMap = getMultiValueData(values);
        WebServiceResponse saveV1CustomerResponse = Services.CustomerLoginService().saveV1Customer(CustomerLoginServiceConstants.mp, values, multiValueDataMap, true);
        setValidationData(values);
        Services.CustomerLoginService().validateV1SaveCustomerResponse(saveV1CustomerResponse, values);
        Services.CustomerLoginService().validateV1CustomerRoles(saveV1CustomerResponse, multiValueDataMap.get(CustomerLoginServiceConstants.CustomerRoles));

        String customerId = Services.CustomerLoginService().getValueByXpath(saveV1CustomerResponse.responseXml, CustomerLoginServiceConstants.V1_Customer_Id);
        String createdOn = Services.CustomerLoginService().getValueByXpath(saveV1CustomerResponse.responseXml, CustomerLoginServiceConstants.V1_Customer_CreatedOn);
        String customerDetailsId = Services.CustomerLoginService().getValueByXpath(saveV1CustomerResponse.responseXml, CustomerLoginServiceConstants.V1_Customer_Details_Id);

        values.put(CustomerLoginServiceConstants.CustomerId, customerId);
        values.put(CustomerLoginServiceConstants.CreatedOn, createdOn);
        values.put(CustomerLoginServiceConstants.CustomerDetailsId, customerDetailsId);
        values.put(CustomerLoginServiceConstants.UserName, values.get(CustomerLoginServiceConstants.EmailId));
        WebServiceResponse getV1CustomerByIdResponse = Services.CustomerLoginService().getV1CustomerById(customerId, CustomerLoginServiceConstants.mp);
        Services.CustomerLoginService().validateV1Customer(getV1CustomerByIdResponse, values);
        Services.CustomerLoginService().validateV1CustomerRoles(getV1CustomerByIdResponse, multiValueDataMap.get(CustomerLoginServiceConstants.CustomerRoles));
        EndTest();
    }

    @Test(groups = {"Regression","SaveCustomer"},
            description = "Save new V1 Customer by calling saveCustomer API and validate the saved customer")
    @TestInfo(testLinkTestCaseIds = {"NA"},
            testCaseDescription = "Save new V1 Customer by calling saveCustomer API and validate the saved customer",
            useCasesDescription = "Save new V1 Customer by calling saveCustomer API and validate the saved customer",
            module = "SaveCustomer",
            category = "CUSTOMERLOGINSERVICE",
            testType = "Services",
            currentStage = "InRegression",
            priority = "P1",
            createdBy = "sivaraj.radhakrishnan@bankbazaar.com",
            createdOn = "14/09/2018",
            timeToAutomateInHrs = "")
    public void IN_CustomerLoginService_Update_An_Existing_V1_Customer_By_Calling_SaveCustomer_API_And_Validate_Response()
    {
        Map<String, String> values = Services.CustomerLoginService().getAllValues();
        String dataKey = values.get(CustomerLoginServiceConstants.EnvironmentName).toUpperCase() + "_Customer_9";
        Map<String, String> customerData = Services.CustomerLoginService().getCustomerData(dataKey);
        if(!Util.isMapEmpty(customerData))
        {
            values.putAll(customerData);
            String customerId = customerData.get(CustomerLoginServiceConstants.CustomerId);
            WebServiceResponse getV1CustomerByIdResponse = Services.CustomerLoginService().getV1CustomerById(customerId, CustomerLoginServiceConstants.mp);

            Map<String, String> newValues = Services.CustomerLoginService().getAllValues();
            String updatedCustomerJson = updateCustomerJson(getV1CustomerByIdResponse.responseJson, newValues);

            WebServiceResponse saveV1CustomerResponse = Services.CustomerLoginService().saveV1Customer(CustomerLoginServiceConstants.mp, updatedCustomerJson, true);
            values.put(CustomerLoginServiceConstants.FirstName, newValues.get(CustomerLoginServiceConstants.FirstName));
            values.put(CustomerLoginServiceConstants.LastName, newValues.get(CustomerLoginServiceConstants.LastName));
            values.put(CustomerLoginServiceConstants.MobileNumber, newValues.get(CustomerLoginServiceConstants.MobileNumber));
            setValidationData(values);
            Services.CustomerLoginService().validateV1Customer(saveV1CustomerResponse, values);
            Services.CustomerLoginService().validateV1CustomerRoles(saveV1CustomerResponse, getCustomerRoles(values));
        }else
        {
            LogManager.logError("Customer Data is empty for the Data Key : " + dataKey);
        }
        EndTest();
    }

    @Test(groups = {"Regression","SaveCustomer"},
            description = "Save new V1 Customer with existing UserName by calling saveCustomer API and validate the saved customer")
    @TestInfo(testLinkTestCaseIds = {"NA"},
            testCaseDescription = "Save new V1 Customer with existing UserName by calling saveCustomer API and validate the saved customer",
            useCasesDescription = "Save new V1 Customer with existing UserName by calling saveCustomer API and validate the saved customer",
            module = "SaveCustomer",
            category = "CUSTOMERLOGINSERVICE",
            testType = "Services",
            currentStage = "InRegression",
            priority = "P1",
            createdBy = "sivaraj.radhakrishnan@bankbazaar.com",
            createdOn = "14/09/2018",
            timeToAutomateInHrs = "")
    public void IN_CustomerLoginService_Call_SaveCustomer_API_To_Save_New_V1_Customer_With_Existing_UserName_And_Validate_Response()
    {
        Map<String, String> values = Services.CustomerLoginService().getAllValues();
        values.put(CustomerLoginServiceConstants.RoleIds, values.get(CustomerLoginServiceConstants.DefaultRoleIds));
        Map<String, List<Map<String, String>>> multiValueDataMap = getMultiValueData(values);

        String dataKey = values.get(CustomerLoginServiceConstants.EnvironmentName).toUpperCase() + "_Customer_9";
        Map<String, String> customerData = Services.CustomerLoginService().getCustomerData(dataKey);
        if(!Util.isMapEmpty(customerData))
        {
            values.put(CustomerLoginServiceConstants.EmailId, customerData.get(CustomerLoginServiceConstants.EmailId));
            WebServiceResponse saveV1CustomerResponse = Services.CustomerLoginService().saveV1Customer(CustomerLoginServiceConstants.mp, values, multiValueDataMap, false);
            Validator.validate("Http Status", saveV1CustomerResponse.status, 500, Enums.ValidationType.EQUALS, true);
        }else
        {
            LogManager.logError("Customer Data is empty for the Data Key : " + dataKey);
        }
        EndTest();
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
    public void IN_CustomerLoginService_Call_GetCustomerId_API_For_V1_Customer_And_Validate_Response()
    {
        Map<String, String> values = Services.CustomerLoginService().getAllValues();
        String dataKey = values.get(CustomerLoginServiceConstants.EnvironmentName).toUpperCase() + "_Customer_1";
        Map<String, String> customerData = Services.CustomerLoginService().getCustomerData(dataKey);
        if(!Util.isMapEmpty(customerData))
        {
            values.putAll(customerData);
            String customerId = values.get(CustomerLoginServiceConstants.CustomerId);
            WebServiceResponse response = Services.CustomerLoginService().getV1CustomerById(customerId, CustomerLoginServiceConstants.mp);
            setValidationData(values);
            Services.CustomerLoginService().validateV1Customer(response, values);
            Services.CustomerLoginService().validateV1CustomerRoles(response, getCustomerRoles(values));
        }else
        {
            LogManager.logError("Customer Data is empty for the Data Key : " + dataKey);
        }
        EndTest();
    }

    @Test(groups = {"Regression","GetCustomerByMobile"},
            description = "Call getCustomerByMobile API with existing customer mobile number")
    @TestInfo(testLinkTestCaseIds = {"NA"},
            testCaseDescription = "Call getCustomerByMobile API with existing customer mobile number",
            useCasesDescription = "Call getCustomerByMobile API with existing customer mobile number",
            module = "GetCustomerByMobile",
            category = "CUSTOMERLOGINSERVICE",
            testType = "Services",
            currentStage = "InRegression",
            priority = "P1",
            createdBy = "sivaraj.radhakrishnan@bankbazaar.com",
            createdOn = "12/09/2018",
            timeToAutomateInHrs = "")
    public void IN_CustomerLoginService_Call_GetCustomerByMobile_API_For_V1_Customer_And_Validate_Response()
    {
        Map<String, String> values = Services.CustomerLoginService().getAllValues();
        String dataKey = values.get(CustomerLoginServiceConstants.EnvironmentName).toUpperCase() + "_Customer_2";
        Map<String, String> customerData = Services.CustomerLoginService().getCustomerData(dataKey);
        if(!Util.isMapEmpty(customerData))
        {
            values.putAll(customerData);
            String mobile = customerData.get(CustomerLoginServiceConstants.MobileNumber);
            if(StringUtil.isNullOrEmpty(mobile))
            {
                WebServiceResponse response = Services.CustomerLoginService().getV1CustomerByMobileNumber(CustomerLoginServiceConstants.mp, mobile);
                setValidationData(values);
                Services.CustomerLoginService().validateV1Customer(response, values);
                Services.CustomerLoginService().validateV1CustomerRoles(response, getCustomerRoles(values));
            }else {
                LogManager.logInfo("Mobile number is empty");
            }
        }else
        {
            LogManager.logError("Customer Data is empty for the Data Key : " + dataKey);
        }
        EndTest();
    }

    @Test(groups = {"Regression","GetCustomerByUserName"},
            description = "Call getCustomerUserName API with existing username of BBMOBILE customer")
    @TestInfo(testLinkTestCaseIds = {"NA"},
            testCaseDescription = "Call getCustomerUserName API with existing username of BBMOBILE customer",
            useCasesDescription = "Call getCustomerUserName API with existing username of BBMOBILE customer",
            module = "GetCustomerByUserName",
            category = "CUSTOMERLOGINSERVICE",
            testType = "Services",
            currentStage = "InRegression",
            priority = "P1",
            createdBy = "sivaraj.radhakrishnan@bankbazaar.com",
            createdOn = "12/09/2018",
            timeToAutomateInHrs = "")
    public void IN_CustomerLoginService_Call_GetCustomerByUserName_API_For_V1_Customer_And_Validate_Response()
    {
        Map<String, String> values = Services.CustomerLoginService().getAllValues();
        String dataKey = values.get(CustomerLoginServiceConstants.EnvironmentName).toUpperCase() + "_Customer_3";
        Map<String, String> customerData = Services.CustomerLoginService().getCustomerData(dataKey);
        if(!Util.isMapEmpty(customerData))
        {
            values.putAll(customerData);
            String mobile = values.get(CustomerLoginServiceConstants.UserName);
            WebServiceResponse response = Services.CustomerLoginService().getV1CustomerByUserName(CustomerLoginServiceConstants.mp, mobile, CustomerLoginServiceConstants.BBMOBILE);
            setValidationData(values);
            Services.CustomerLoginService().validateV1Customer(response, values);
            Services.CustomerLoginService().validateV1CustomerRoles(response, getCustomerRoles(values));
        }else
        {
            LogManager.logError("Customer Data is empty for the Data Key : " + dataKey);
        }
        EndTest();
    }

    @Test(groups = {"Regression","GetCustomerBySocialProfileId"},
            description = "Call getCustomerBySocialProfileId API with existing social profile id of FACEBOOK customer")
    @TestInfo(testLinkTestCaseIds = {"NA"},
            testCaseDescription = "Call getCustomerBySocialProfileId API with existing social profile id of FACEBOOK customer",
            useCasesDescription = "Call getCustomerBySocialProfileId API with existing social profile id of FACEBOOK customer",
            module = "GetCustomerBySocialProfileId",
            category = "CUSTOMERLOGINSERVICE",
            testType = "Services",
            currentStage = "InRegression",
            priority = "P1",
            createdBy = "sivaraj.radhakrishnan@bankbazaar.com",
            createdOn = "12/09/2018",
            timeToAutomateInHrs = "")
    public void IN_CustomerLoginService_Call_GetCustomerBySocialProfileId_API_For_V1_Customer_And_Validate_Response()
    {
        Map<String, String> values = Services.CustomerLoginService().getAllValues();
        String dataKey = values.get(CustomerLoginServiceConstants.EnvironmentName).toUpperCase() + "_Customer_4";
        Map<String, String> customerData = Services.CustomerLoginService().getCustomerData(dataKey);
        if(!Util.isMapEmpty(customerData))
        {
            values.putAll(customerData);
            String socialProfileId = values.get(CustomerLoginServiceConstants.ThirdPartyCustomerId);
            WebServiceResponse response = Services.CustomerLoginService().getV1CustomerBySocialProfileId(CustomerLoginServiceConstants.mp, socialProfileId, CustomerLoginServiceConstants.FACEBOOK);
            setValidationData(values);
            Services.CustomerLoginService().validateV1Customer(response, values);
            Services.CustomerLoginService().validateV1CustomerRoles(response, getCustomerRoles(values));
        }else
        {
            LogManager.logError("Customer Data is empty for the Data Key : " + dataKey);
        }
        EndTest();
    }

    @Test(groups = {"Regression","GetAllCustomersByUserName"},
            description = "Call getAllCustomers API with existing customer username")
    @TestInfo(testLinkTestCaseIds = {"NA"},
            testCaseDescription = "Call getAllCustomers API with existing customer username",
            useCasesDescription = "Call getAllCustomers API with existing customer username",
            module = "GetAllCustomersByUserName",
            category = "CUSTOMERLOGINSERVICE",
            testType = "Services",
            currentStage = "InRegression",
            priority = "P1",
            createdBy = "sivaraj.radhakrishnan@bankbazaar.com",
            createdOn = "12/09/2018",
            timeToAutomateInHrs = "")
    public void IN_CustomerLoginService_Call_GetAllCustomersByUserName_API_For_V1_Customer_And_Validate_Response()
    {
        Map<String, String> values = Services.CustomerLoginService().getAllValues();

        String mappingDataKey = values.get(CustomerLoginServiceConstants.EnvironmentName).toUpperCase() + "_" + CustomerLoginServiceConstants.Customers;
        Map<String, String> customersMapping = Services.CustomerLoginService().getCustomersMapping(mappingDataKey);
        if(!Util.isMapEmpty(customersMapping))
        {
            String userName = customersMapping.get(CustomerLoginServiceConstants.UserName);
            String customerKeySuffixes = customersMapping.get(CustomerLoginServiceConstants.CustomerKeySuffix);
            if(!StringUtil.isNullOrEmpty(customerKeySuffixes))
            {
                WebServiceResponse response = Services.CustomerLoginService().getAllV1CustomersByUserName(userName, CustomerLoginServiceConstants.mp);
                List<String> customerKeySuffixList = Util.toList(customerKeySuffixes.split(","));
                for(String customerKeySuffix: customerKeySuffixList)
                {
                    String dataKey = values.get(CustomerLoginServiceConstants.EnvironmentName).toUpperCase() + "_" + customerKeySuffix;
                    Map<String, String> customerData = Services.CustomerLoginService().getCustomerData(dataKey);

                    Map<String, String> validationValues = new HashMap<String, String>(values);
                    validationValues.putAll(customerData);
                    setValidationData(validationValues);
                    Services.CustomerLoginService().validateV1CustomerList(response, validationValues);
                    List<Map<String, String>> customerRoles = getCustomerRoles(validationValues);
                    String customerId = validationValues.get(CustomerLoginServiceConstants.CustomerId);
                    Services.CustomerLoginService().validateV1CustomerListRoles(customerId, response, customerRoles);
                }
            }else
            {
                LogManager.logError("Customers Mapping data is empty for the Mapping Key : " + mappingDataKey);
            }
        }else
        {
            LogManager.logError("Customers Mapping data is empty for the Mapping Key : " + mappingDataKey);
        }
        EndTest();
    }
}