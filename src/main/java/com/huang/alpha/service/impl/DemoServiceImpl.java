package com.huang.demo.service.impl;

import com.huang.demo.service.DemoService;

public class DemoServiceImpl implements DemoService {
    @Override
    public String echoMessage(String message) {
        return String.join("provider echo " , message);
    }
}
