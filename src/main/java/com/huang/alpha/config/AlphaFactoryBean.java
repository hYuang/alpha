package com.huang.alpha.config;

import com.huang.alpha.request.BaseRequest;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class AlphaFactoryBean implements FactoryBean<BaseRequest> {
    @Override
    public BaseRequest getObject() throws Exception {
        return new BaseRequest();
    }

    @Override
    public Class<?> getObjectType() {
        return BaseRequest.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
