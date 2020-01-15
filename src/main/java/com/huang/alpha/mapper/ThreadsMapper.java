package com.huang.alpha.mapper;

import com.huang.alpha.entity.Threads;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ThreadsMapper {

    public List<Threads> queryThread(Map<String,Object> params);
}
