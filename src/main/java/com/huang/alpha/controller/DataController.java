package com.huang.alpha.controller;

import com.huang.alpha.entity.User;
import com.huang.alpha.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/data")
public class DataController {


    @Autowired
    private DataService dataService;


    @RequestMapping(value = "/initdata/{total}", method = RequestMethod.GET)
    @ResponseBody
    public int initUserData(@PathVariable("total") int total){

        List<User> userList = new ArrayList<User>();
        for (int i = 0; i < total; i++) {
            User user = new User();
            user.setAge(new Random().nextInt(100));
            user.setName("test" + String.valueOf(i%10));
            int userAge = user.getAge();
            if(userAge % 2 == 0 ){
                user.setSex("male");
            }else{
                user.setSex("female");
            }

            userList.add(user);
        }

        int num = dataService.insertData(userList);
        return num;
    }


}
