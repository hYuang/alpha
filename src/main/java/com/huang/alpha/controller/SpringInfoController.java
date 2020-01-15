package com.huang.alpha.controller;

import com.alibaba.fastjson.JSON;
import com.huang.alpha.enums.Result;
import com.huang.alpha.model.Response;
import com.huang.alpha.request.BeanInfoRequest;
import com.huang.alpha.service.SpringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/spring")
public class SpringInfoController {

    @Autowired
    private SpringService springService;

    @RequestMapping("/singleton")
    @ResponseBody
    public Response getSingletonInfo(String name, Class type){

        Response response = new Response();
        try {
            Map<String,Object> dataMap = new HashMap<String,Object>();
            BeanInfoRequest beanInfoRequest = new BeanInfoRequest();
            String beanInfo = springService.getBeanByTypeOrName(beanInfoRequest);
            JSON data = JSON.parseObject(beanInfo);
            response.setData(data);
            response.setMsg(Result.SUCCESS.getValue());
            response.setMsg_code(Result.SUCCESS_CODE.getValue());
        } catch (Exception e) {
            e.printStackTrace();
            response.setData(null);
            response.setMsg(Result.FAIL.getValue());
            response.setMsg_code(Result.FAIL_CODE.getValue());
        }
        return response;
    }
}
