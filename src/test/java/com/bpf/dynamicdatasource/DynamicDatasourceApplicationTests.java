package com.bpf.dynamicdatasource;

import com.bpf.dynamicdatasource.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DynamicDatasourceApplicationTests {

    @Autowired
    private TestService testService;

    @Test
    public void test() {
        testService.insert();
    }

}
