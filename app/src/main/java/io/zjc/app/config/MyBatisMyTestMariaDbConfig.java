package io.zjc.app.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import jakarta.annotation.Resource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "io.zjc.app.mapper.mariadb.mytest",
        sqlSessionTemplateRef = "myTestMariaDbSqlSessionTemplate")
public class MyBatisMyTestMariaDbConfig {
    @Resource
    private DataSource multipleDataSource;

    @Bean(name = "myTestMariaDbSqlSessionFactory")
    @Primary
    public SqlSessionFactory myTestMariaDbSqlSessionFactory() throws Exception {
        MybatisSqlSessionFactoryBean sqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(multipleDataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapper/mariadb/mytest/*Mapper.xml"));
        sqlSessionFactoryBean.addTypeHandlers(new CustomStringTypeHandler());
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "myTestMariaDbTransactionManager")
    @Primary
    public DataSourceTransactionManager myTestMariaDbTransactionManager() {
        return new DataSourceTransactionManager(multipleDataSource);
    }

    @Bean(name = "myTestMariaDbSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate myTestMariaDbSqlSessionTemplate(
            @Qualifier("myTestMariaDbSqlSessionFactory") SqlSessionFactory myTestMariaDbSqlSessionFactory) {
        return new SqlSessionTemplate(myTestMariaDbSqlSessionFactory);
    }

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MARIADB));
        return interceptor;
    }
}
