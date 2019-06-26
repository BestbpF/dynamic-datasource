package com.bpf.dynamicdatasource.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface Test2Mapper {
    @Select("select * from product")
    List<Map<String, Object>> findAll();

    @Insert("insert into product(number) values(2)")
    int insert();
}
