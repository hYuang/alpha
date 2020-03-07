package com.huang.alpha.service.impl;

import com.huang.alpha.mapper.ThreadsMapper;
import com.huang.alpha.request.BeanInfoRequest;
import com.huang.alpha.service.SpringService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SpringServiceImpl implements SpringService {

    @Autowired
    private ThreadsMapper threadsMapper;

    @Autowired
    private Environment env;

    @Override
    public String getBeanByTypeOrName(BeanInfoRequest beanInfoRequest) {
        log.info("Mapper class type " + threadsMapper.getClass());
        return null;
    }
}
