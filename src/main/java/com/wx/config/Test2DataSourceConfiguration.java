package com.wx.config;

import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@MapperScan(basePackages = {"com.wx.test2"}, sqlSessionFactoryRef = "testSqlSessionFactory")
public class Test2DataSourceConfiguration {
  /**
   * The constant MAPPER_XML_LOCATION.
   */
  public static final String MAPPER_XML_LOCATION = "classpath:com/wx/test2/impl/*.xml";

  /**
   * The Open plat form data source.
   */
  @Autowired
  @Qualifier("TestDataSource")
  DataSource springDataSource;

  /**
   * 配置Sql Session模板
   *
   * @return the sql session template
   * @throws Exception the exception
   */
  @Bean
  public SqlSessionTemplate testSqlSessionTemplate() throws Exception {
    return new SqlSessionTemplate(testSqlSessionFactory());
  }

  /**
   * 配置SQL Session工厂
   *
   * @return the sql session factory
   * @throws Exception the exception
   */
  @Bean
  public SqlSessionFactory testSqlSessionFactory() throws Exception {
    SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
    factoryBean.setDataSource(springDataSource);
    //指定XML文件路径
    factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_XML_LOCATION));
    return factoryBean.getObject();
  }
}