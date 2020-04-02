package com.huang.demo;

import com.huang.demo.service.DemoService;
import com.huang.demo.service.impl.DemoServiceImpl;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;

import java.io.IOException;

public class Demo {

    public static void main(String[] args) throws IOException {
        ServiceConfig<DemoService> service = new ServiceConfig<>();
        service.setRegistry(new RegistryConfig(("zookeeper://127.0.0.1:2181")));
        service.setApplication(new ApplicationConfig("java-demo-provider"));
        service.setInterface(DemoService.class);
        service.setRef(new DemoServiceImpl());
        service.setExport(true);
        service.export();
        System.out.println("service provider start ");
        System.in.read();
    }
}
