package com.simple.mybatis.datasource.pooled;

import com.simple.mybatis.datasource.unpooled.UnpooledDataSourceFactory;

import javax.sql.DataSource;

/**
 * @author SinceNovember
 * @description: 有连接池的数据源工厂
 * @date 2022/9/20
 */

public class PooledDataSourceFactory extends UnpooledDataSourceFactory {

    @Override
    public DataSource getDataSource() {
        PooledDataSource pooledDataSource = new PooledDataSource();
        pooledDataSource.setDriver(props.getProperty("driver"));
        pooledDataSource.setUrl(props.getProperty("url"));
        pooledDataSource.setUsername(props.getProperty("username"));
        pooledDataSource.setPassword(props.getProperty("password"));
        return pooledDataSource;
    }


}
