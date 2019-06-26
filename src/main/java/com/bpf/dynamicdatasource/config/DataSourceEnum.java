package com.bpf.dynamicdatasource.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DataSourceEnum {
    DEFAULT("test1"),
    TEST1("test1"),
    TEST2("test2");
    private String name;
}
