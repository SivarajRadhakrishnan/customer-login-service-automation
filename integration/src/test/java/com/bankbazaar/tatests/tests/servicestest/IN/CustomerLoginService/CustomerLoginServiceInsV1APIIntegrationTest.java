package com.bankbazaar.tatests.tests.servicestest.IN.CustomerLoginService;

import com.bankbazaar.DataUtil.StringUtil;
import com.bankbazaar.loggers.LogManager;
import com.bankbazaar.model.TestInfo;
import com.bankbazaar.model.WebServiceResponse;
import com.bankbazaar.tatests.constants.services.CustomerLoginServiceConstants;
import com.bankbazaar.tatests.services.Services;
import com.bankbazaar.util.Util;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sivaraj on 17/12/18.
 */
public class CustomerLoginServiceInsV1APIIntegrationTest extends CustomerLoginServiceBaseTest {

    @Test(groups = {"Regression","GetCustomerById"},
            description = "Call getCustomerById API with customer Id of MPInsurance dummy customer")
    @TestInfo(testLinkTestCaseIds = {"NA"},
            testCaseDescription = "Call getCustomerById API with customer Id of MPInsurance dummy customer",
            useCasesDescription = "Call getCustomerById API with customer Id of MPInsurance dummy customer",
            module = "GetCustomerById",
            category = "CUSTOMERLOGINSERVICE",
            testType = "Services",
            currentStage = "InRegression",
            priority = "P1",
            createdBy = "sivaraj.radhakrishnan@bankbazaar.com",
            createdOn = "09/10/2018",
            timeToAutomateInHrs = "")
    public void IN_CustomerLoginService_Call_GetCustomerId_API_For_Insurance_V1_Customer_And_Validate_Response()
    {
        Map<String, String> values = Services.CustomerLoginService().getAllValues();
        String dataKey = values.get(CustomerLoginServiceConstants.EnvironmentName).toUpperCase() + "_Customer_1";
        Map<String, String> customerData = Services.CustomerLoginService().getInsuranceCustomerData(dataKey);
        if(!Util.isMapEmpty(customerData))
        {
            values.putAll(customerData);
            String customerId = values.get(CustomerLoginServiceConstants.CustomerId);
            WebServiceResponse response = Services.CustomerLoginService().getV1CustomerById(customerId, CustomerLoginServiceConstants.mpinsurance);
            setValidationData(values);
            Services.CustomerLoginService().validateV1Customer(response, values);
            Services.CustomerLoginService().validateV1CustomerRoles(response, getCustomerRoles(values));
        }else
        {
            LogManager.logError("Customer Data is empty for the Data Key : " + dataKey);
        }
        EndTest();
    }

    @Test(groups = {"Regression","GetCustomerByMobile"}, enabled = false,
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
    public void IN_CustomerLoginService_Call_GetCustomerByMobile_API_For_Insurance_V1_Customer_And_Validate_Response()
    {
        Map<String, String> values = Services.CustomerLoginService().getAllValues();
        String dataKey = values.get(CustomerLoginServiceConstants.EnvironmentName).toUpperCase() + "_Customer_1";
        Map<String, String> customerData = Services.CustomerLoginService().getInsuranceCustomerData(dataKey);
        if(!Util.isMapEmpty(customerData))
        {
            values.putAll(customerData);
            String mobile = customerData.get(CustomerLoginServiceConstants.MobileNumber);
            if(StringUtil.isNullOrEmpty(mobile))
            {
                WebServiceResponse response = Services.CustomerLoginService().getV1CustomerByMobileNumber(CustomerLoginServiceConstants.mpinsurance, mobile);
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

    @Test(groups = {"Regression","GetCustomerByUserName"}, enabled = false,
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
    public void IN_CustomerLoginService_Call_GetCustomerByUserName_API_For_Insurance_V1_Customer_And_Validate_Response()
    {
        Map<String, String> values = Services.CustomerLoginService().getAllValues();
        String dataKey = values.get(CustomerLoginServiceConstants.EnvironmentName).toUpperCase() + "_Customer_1";
        Map<String, String> customerData = Services.CustomerLoginService().getInsuranceCustomerData(dataKey);
        if(!Util.isMapEmpty(customerData))
        {
            values.putAll(customerData);
            String userName = values.get(CustomerLoginServiceConstants.UserName);
            String customerType = values.get(CustomerLoginServiceConstants.CustomerType);
            WebServiceResponse response = Services.CustomerLoginService().getV1CustomerByUserName(CustomerLoginServiceConstants.mpinsurance, userName, customerType);
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
    public void IN_CustomerLoginService_Call_GetAllCustomersByUserName_API_For_Insurance_V1_Customer_And_Validate_Response()
    {
        Map<String, String> values = Services.CustomerLoginService().getAllValues();

        String environment = values.get(CustomerLoginServiceConstants.EnvironmentName).toUpperCase();
        String mappingDataKey = environment + "_" + CustomerLoginServiceConstants.Customers;
        Map<String, String> customersMapping = Services.CustomerLoginService().getInsuranceCustomersMapping(mappingDataKey);
        if(!Util.isMapEmpty(customersMapping))
        {
            String userName = customersMapping.get(CustomerLoginServiceConstants.UserName);
            String customerKeySuffixes = customersMapping.get(CustomerLoginServiceConstants.CustomerKeySuffix);
            if(!StringUtil.isNullOrEmpty(customerKeySuffixes))
            {
                WebServiceResponse response = Services.CustomerLoginService().getAllV1CustomersByUserName(userName, CustomerLoginServiceConstants.mpinsurance);
                List<String> customerKeySuffixList = Util.toList(customerKeySuffixes.split(","));
                for(String customerKeySuffix: customerKeySuffixList)
                {
                    String dataKey = environment + "_" + customerKeySuffix;
                    Map<String, String> customerData = Services.CustomerLoginService().getInsuranceCustomerData(dataKey);

                    Map<String, String> validationValues = new HashMap<String, String>(values);
                    validationValues.putAll(customerData);
                    setValidationData(validationValues);
                    Services.CustomerLoginService().validateV1CustomerList(response, validationValues);
                    Services.CustomerLoginService().validateV1CustomerListRoles(validationValues.get(CustomerLoginServiceConstants.CustomerId), response, getCustomerRoles(validationValues));
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