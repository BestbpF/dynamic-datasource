package com.bpf.dynamicdatasource.dao;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface Test1Mapper {

    @Select("select * from user")
    List<Map<String, Object>> findAll();
}
