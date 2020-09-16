package com.soft.wesker.jdbc;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {

    private static final ThreadLocal<String> dataSourceLocal = new ThreadLocal<>();

    @Override
    protected Object determineCurrentLookupKey() {
        return dataSourceLocal.get();
    }

    public void setDataSource(String dataSource){
        dataSourceLocal.set(dataSource);
    }
}
