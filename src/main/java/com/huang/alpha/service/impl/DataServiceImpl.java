package com.huang.alpha.service.impl;

import com.huang.alpha.entity.User;
import com.huang.alpha.mapper.UserMapper;
import com.huang.alpha.service.DataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DataServiceImpl implements DataService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int insertData(List<User> user) {
       int num =  userMapper.insertBatchdata(user);
        return num;
    }
}
