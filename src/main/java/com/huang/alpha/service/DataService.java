package com.huang.alpha.service;

import com.huang.alpha.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DataService {


    public int  insertData(List<User> user);
}
