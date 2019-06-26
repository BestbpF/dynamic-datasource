package com.bpf.dynamicdatasource.config;

public class DataSourceHolder {

    private static final ThreadLocal<String> DS_HOLDER = new ThreadLocal<>();

    public static void setDataSource(DataSourceEnum dataSource) {
        DS_HOLDER.set(dataSource.getName());
    }

    public static String getDataSource() {
        return DS_HOLDER.get();
    }

    public static void clearDataSource() {
        DS_HOLDER.remove();
    }
}
