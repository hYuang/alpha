package com.huang.alpha.mapper;


import com.huang.alpha.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface UserMapper  {

    public int insertBatchdata(List<User> data);
}
