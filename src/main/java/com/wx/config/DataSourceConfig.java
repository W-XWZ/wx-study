package com.wx.config;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableConfigurationProperties
@EnableTransactionManagement(proxyTargetClass = true)
public class DataSourceConfig {
  /**
   * spring数据库配置前缀.
   */
  final static String SPRING_PREFIX = "spring.jta.atomikos.datasource.spring";
  /**
   * test数据库配置前缀.
   */
  final static String TEST_PREFIX = "spring.jta.atomikos.datasource.test";

  /**
   * The constant logger.
   */
  final static Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);


  /**
   * 配置Spring数据库的数据源
   *
   * @return the data source
   */
  @Bean(name = "SpringDataSource")
  @ConfigurationProperties(prefix = SPRING_PREFIX)  // application.properties中对应属性的前缀
  public DataSource springDataSource() {
    return new AtomikosDataSourceBean();
  }


  /**
   * 配置Test数据库的数据源
   *
   * @return the data source
   */
  @Bean(name = "TestDataSource")
  @ConfigurationProperties(prefix = TEST_PREFIX)  // application.properties中对应属性的前缀
  public DataSource testDataSource() {
    return new AtomikosDataSourceBean();
  }
}