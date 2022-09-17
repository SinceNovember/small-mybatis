package com.simple.mybatis.datasource;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author SinceNovember
 * @description: 数据源工厂
 * @date 2022/9/17
 */

public interface DataSourceFactory {

    void setProperties(Properties props);

    DataSource getDataSource();

}
