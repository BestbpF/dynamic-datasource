package com.bpf.dynamicdatasource.service;

import com.bpf.dynamicdatasource.config.DataSource;
import com.bpf.dynamicdatasource.config.DataSourceEnum;
import com.bpf.dynamicdatasource.dao.Test1Mapper;
import com.bpf.dynamicdatasource.dao.Test2Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class TestService {

    @Autowired
    private Test1Mapper test1Mapper;
    @Autowired
    private Test2Mapper test2Mapper;


    public List<Map<String, Object>> findTest1() {
        return test1Mapper.findAll();
    }

    @DataSource(DataSourceEnum.TEST2)
    public List<Map<String, Object>> findTest2() {
        return test2Mapper.findAll();
    }

    /**
     * 如果切面不加@Order，添加Transactional注解会导致切换数据源失效
     */
    @Transactional(propagation = Propagation.NEVER)
    @DataSource(DataSourceEnum.TEST2)
    public void insert() {
        test2Mapper.insert();
        int i = 1 / 0;
    }
}
