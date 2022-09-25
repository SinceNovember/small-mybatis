package com.simple.mybatis.datasource.pooled;

import com.simple.mybatis.datasource.unpooled.UnpooledDataSourceFactory;

import javax.sql.DataSource;

/**
 * @author SinceNovember
 * @description: 有连接池的数据源工厂
 * @date 2022/9/20
 */

public class PooledDataSourceFactory extends UnpooledDataSourceFactory {


    public PooledDataSourceFactory() {
        this.dataSource = new PooledDataSource();
    }

}
