package com.bankbazaar.tatests.tests.servicestest.IN.CustomerLoginService;

import com.bankbazaar.DataUtil.StringUtil;
import com.bankbazaar.FileUtil.FileManager;
import com.bankbazaar.core.BaseContext;
import com.bankbazaar.core.XMLProcessor;
import com.bankbazaar.loggers.LogManager;
import com.bankbazaar.model.Enums.ExecutionLocale;
import com.bankbazaar.model.Enums.SocialLoginType;
import com.bankbazaar.model.WebServiceResponse;
import com.bankbazaar.tatests.constants.CustomerLoginServiceConstants;
import com.bankbazaar.tatests.services.Services;
import com.bankbazaar.tatests.tests.servicestest.ServicesDataDrivenBaseTest;
import com.bankbazaar.tatests.tests.servicestest.ServicesPipelineBaseTest;
import com.bankbazaar.tatests.tests.servicestest.ServicesPipelineDataDrivenBaseTest;
import com.bankbazaar.tatests.workflows.WorkFlows;
import com.bankbazaar.util.EnvironmentUtil;
import com.bankbazaar.util.Util;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sivaraj on 10/9/18.
 */
public class CustomerLoginServiceBaseTest extends ServicesPipelineDataDrivenBaseTest {

    @Override
    public void beforeSuite() {
        super.init(Services.CustomerLoginService());
        dataKeyName = "Data_Key";
    }

    @Override
    public void beforeClass() {

    }

    @Override
    public void afterSuite() {

    }

    @Override
    public void afterClass() {

    }

    protected void setValidationData(Map<String, String> values)
    {
        String roleIds = values.get(CustomerLoginServiceConstants.RoleIds);
        values.put(CustomerLoginServiceConstants.Roles, "0");
        if(!StringUtil.isNullOrEmpty(roleIds))
        {
            List<String> roleIdList = Util.toList(roleIds.split(","));
            values.put(CustomerLoginServiceConstants.Roles, StringUtil.convertIntegerToString(roleIdList.size()));
        }
    }

    protected List<Map<String, String>> getCustomerRoles(Map<String, String> values)
    {
        List<Map<String, String>> customerRoles = new ArrayList<Map<String, String>>();
        String roleIds = values.get(CustomerLoginServiceConstants.RoleIds);
        if(!StringUtil.isNullOrEmpty(roleIds))
        {
            List<String> roleIdList = Util.toList(roleIds.split(","));
            for(String roleId: roleIdList)
            {
                Map<String, String> roleData = new HashMap<String, String>();
                roleData.put(CustomerLoginServiceConstants.RoleDataKey, CustomerLoginServiceConstants.RoleId);
                roleData.put(CustomerLoginServiceConstants.RoleId, roleId);
                roleData.put(CustomerLoginServiceConstants.CustomerId, values.get(CustomerLoginServiceConstants.CustomerId));
                fillStaticDataIntoValues(roleData, CustomerLoginServiceConstants.RoleDataKey, CustomerLoginServiceConstants.RoleId);
                customerRoles.add(roleData);
            }
        }
        return customerRoles;
    }

    protected Map<String, List<Map<String, String>>> getMultiValueData(Map<String, String> values)
    {
        Map<String, List<Map<String, String>>> multiValueDataMap = new HashMap<String, List<Map<String, String>>>();
        multiValueDataMap.put(CustomerLoginServiceConstants.CustomerRoles, getCustomerRoles(values));
        return multiValueDataMap;
    }

    protected String updateCustomerJson(String json, Map<String, String> values)
    {
        String updatedJson = json;
        try {
            JSONObject jsonObject = new JSONObject(json);
            jsonObject.put("firstName", values.get(CustomerLoginServiceConstants.FirstName));
            jsonObject.put("lastName", values.get(CustomerLoginServiceConstants.LastName));
            jsonObject.put("mobile", values.get(CustomerLoginServiceConstants.MobileNumber));
            updatedJson = jsonObject.toString();
        }catch (Exception e)
        {
            LogManager.logError("Error in updating customer json : ", e);
        }
        return updatedJson;
    }

    protected String getOAuthCode(SocialLoginType socialLoginType, Map<String, String> values)
    {
        String oauthCode = null;
        String userName = values.get(CustomerLoginServiceConstants.UserName);
        String password = values.get(CustomerLoginServiceConstants.Password);
        String redirectUri = values.get(CustomerLoginServiceConstants.RedirectURI);
        String clientId = values.get(CustomerLoginServiceConstants.ClientId);
        if(socialLoginType == SocialLoginType.FACEBOOK)
        {
            oauthCode = WorkFlows.LoginWF().getOAuthCode(SocialLoginType.FACEBOOK, userName, password, redirectUri, clientId);
        }else if(socialLoginType == SocialLoginType.GOOGLE)
        {
            oauthCode = WorkFlows.LoginWF().getOAuthCode(SocialLoginType.GOOGLE, userName, password, redirectUri, clientId);
        }
        return oauthCode;
    }

    protected String getAccessToken(SocialLoginType socialLoginType, Map<String, String> values)
    {
        String accessToken = null;
        if(socialLoginType != null)
        {
            String oauthCode = getOAuthCode(socialLoginType, values);
            WebServiceResponse response = Services.OAuthService().getProfile(socialLoginType.name(), oauthCode, values.get(CustomerLoginServiceConstants.RedirectURL));
            String xpath = Services.CustomerLoginService().getXpath(CustomerLoginServiceConstants.FB_OAuth_AccessToken);
            accessToken = XMLProcessor.getValueByXpath(response.responseXml, xpath);
        }
        return accessToken;
    }

    protected Map<String, String> getV2CustomerData(String customerKey, String loginType)
    {
        String custDataKey = Services.CustomerLoginService().getExecEnv().name + "_" + customerKey;
        Map<String, String> validationData = Services.CustomerLoginService().getV2CustomerData(custDataKey);

        if(!Util.isMapEmpty(validationData))
            validationData.put(CustomerLoginServiceConstants.LoginType, loginType);
        else
            LogManager.logError("Input Data not found for the customer : " + custDataKey);
        return validationData;
    }
}