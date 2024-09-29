package io.zjc.app.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceConfig {
    @Bean(name = "myTestMariaDbDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.mariadb.mytest")
    public DataSource myTestMariaDbDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "mysql156O3DataPortalDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.mysql.dataportal")
    public DataSource mysql156O3DataPortalDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "multipleDataSource")
    public MultipleDataSource getMultipleDataSource(@Qualifier("myTestMariaDbDataSource") DataSource myTestMariaDbDataSource,
                                                    @Qualifier("mysql156O3DataPortalDataSource") DataSource mysql156O3DataPortalDataSource) {
        MultipleDataSource multipleDataSource = new MultipleDataSource();
        multipleDataSource.setDefaultTargetDataSource(mysql156O3DataPortalDataSource);
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DataSourceContextHolder.DATA_SOURCE_MARIADB_MYTEST, myTestMariaDbDataSource);
        targetDataSources.put(DataSourceContextHolder.DATA_SOURCE_MYSQL_DATAPORTAL_156O3, mysql156O3DataPortalDataSource);
        multipleDataSource.setTargetDataSources(targetDataSources);
        return multipleDataSource;
    }
}