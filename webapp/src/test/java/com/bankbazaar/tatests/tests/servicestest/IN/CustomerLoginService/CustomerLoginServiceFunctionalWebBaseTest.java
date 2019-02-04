package com.bankbazaar.tatests.tests.servicestest.IN.CustomerLoginService;

import com.bankbazaar.tatests.services.Services;
import com.bankbazaar.tatests.tests.servicestest.ServicesPipelineDataDrivenBaseTest;

/**
 * Created by sivaraj on 6/12/18.
 */
public class CustomerLoginServiceFunctionalWebBaseTest extends ServicesPipelineDataDrivenBaseTest {
    @Override
    public void beforeSuite() {

    }

    @Override
    public void beforeClass() {
        super.init(Services.CustomerLoginService());
        dataKeyName = "Data_Key";
    }

    @Override
    public void afterSuite() {

    }

    @Override
    public void afterClass() {

    }
}