package com.bpf.dynamicdatasource.config;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface DataSource {
    DataSourceEnum value();
}
