package com.huang.demo;

import com.huang.demo.service.DemoService;
import com.huang.demo.service.impl.DemoServiceImpl;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;
import org.apache.dubbo.container.Container;

public class EchoContainer  implements Container {

    @Override
    public void start() {
        ServiceConfig<DemoService>  serviceConfig = new ServiceConfig<>();
        serviceConfig.setApplication(new ApplicationConfig("demo-echo-provider"));
        serviceConfig.setRegistry(new RegistryConfig("zookeeper://127.0.0.1:2181"));
        serviceConfig.setInterface(DemoService.class);
        serviceConfig.setRef(new DemoServiceImpl());
        serviceConfig.setExport(true);
        serviceConfig.export();
    }

    @Override
    public void stop() {

    }
}
