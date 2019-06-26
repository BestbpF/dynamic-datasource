package com.bpf.dynamicdatasource.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        System.out.println("dynamic datasource 切换数据源" + DataSourceHolder.getDataSource());
        return DataSourceHolder.getDataSource();
    }
}
