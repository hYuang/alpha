package com.huang.service.impl;

import com.huang.service.DemoService;

public class DemoServiceImpl implements DemoService {
    @Override
    public String echo(String message) {
        return String.join("Server  reponse ", message);
    }
}
