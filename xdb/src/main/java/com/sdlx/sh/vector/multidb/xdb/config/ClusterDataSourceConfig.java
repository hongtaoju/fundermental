/*
 * module: fundermental
 * file: ClusterDataSourceConfig.java
 * date: 5/12/20 12:12 AM
 * author: VectorJu
 */

/**
 * @create 2020-05-12 00:12
 * @desc cluster datasource
 **/
package com.sdlx.sh.vector.multidb.xdb.config;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = {"com.sdlx.sh.vector.multidb.xdb.mapper.cluster"},sqlSessionTemplateRef = "clusterSqlSessionTemplate")
@EnableTransactionManagement(proxyTargetClass = true)
public class ClusterDataSourceConfig {


    /**
     * 创建数据源
     *@return DataSource
     */
    @Bean(name = "clusterDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.cluster")
    public DataSource masterDataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 创建工厂
     *@param dataSource
     *@throws Exception
     *@return SqlSessionFactory
     */
    @Bean(name = "clusterSqlSessionFactory")
    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("clusterDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/cluster/*.xml"));
        return bean.getObject();
    }

    /**
     * 创建事务
     *@param dataSource
     *@return DataSourceTransactionManager
     */
    @Bean(name = "clusterTransactionManager")
    public DataSourceTransactionManager masterDataSourceTransactionManager(@Qualifier("clusterDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * 创建模板
     *@param sqlSessionFactory
     *@return SqlSessionTemplate
     */
    @Bean(name = "clusterSqlSessionTemplate")
    public SqlSessionTemplate masterSqlSessionTemplate(@Qualifier("clusterSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}

