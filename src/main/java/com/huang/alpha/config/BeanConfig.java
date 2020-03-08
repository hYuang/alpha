package com.huang.alpha.config;

import com.huang.alpha.constants.Constants;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;

@Configuration
@PropertySource(value = {"classpath:/mybatis.properties"})
public class BeanConfig {

	@Autowired
	private Environment env;
	
	@Bean
	public DataSource getDataSource() {
		UnpooledDataSource unpooledDataSource = new UnpooledDataSource();
		unpooledDataSource.setDriver(env.getProperty(Constants.MYSQL_DRIVER));
		unpooledDataSource.setUrl(env.getProperty(Constants.MYSQL_URL));
		unpooledDataSource.setPassword(env.getProperty(Constants.MYSQL_PASSWORD));
		unpooledDataSource.setUsername(env.getProperty(Constants.MYSQL_USER));
		PooledDataSource pooledDataSource = new PooledDataSource(unpooledDataSource);
		return pooledDataSource;
	}
	
	@Bean
	public SqlSessionFactory getSqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(getDataSource());
		Resource[] mapperLocation = {new ClassPathResource("mapper/UserMapper.xml")};
		sqlSessionFactoryBean.setMapperLocations(mapperLocation);
		return sqlSessionFactoryBean.getObject();
	}
	
}
