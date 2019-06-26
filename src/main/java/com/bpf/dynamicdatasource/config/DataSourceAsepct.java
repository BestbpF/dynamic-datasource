package com.bpf.dynamicdatasource.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
@Order(1)
public class DataSourceAsepct {

    @Pointcut("@annotation(com.bpf.dynamicdatasource.config.DataSource)")
    public void pointCut(){}

    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
        Object target = joinPoint.getTarget();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        DataSourceEnum dataSource = DataSourceEnum.DEFAULT;
        try {
            Method method = target.getClass().getMethod(signature.getName(), signature.getParameterTypes());
            if (method.isAnnotationPresent(DataSource.class)) {
                DataSource annotation = method.getAnnotation(DataSource.class);
                dataSource = annotation.value();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        System.out.println("aop切换数据源：" + dataSource.getName());
        DataSourceHolder.setDataSource(dataSource);
    }

    @After("pointCut()")
    public void after() {
        DataSourceHolder.clearDataSource();
    }
}
