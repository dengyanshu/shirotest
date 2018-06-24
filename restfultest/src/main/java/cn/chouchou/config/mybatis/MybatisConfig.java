package cn.chouchou.config.mybatis;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;


@Configuration
public class MybatisConfig {
	
	
	//mybatis  sesson  factory
	@Autowired
	private  ComboPooledDataSource  comboPooledDataSource;
	
	@Bean(name="sqlSessionFactoryBean")
	public SqlSessionFactoryBean  sqlSessionFactoryBean  ()throws Exception{
		SqlSessionFactoryBean  sessionFactory=new SqlSessionFactoryBean();
		sessionFactory.setDataSource(comboPooledDataSource);
		
		PathMatchingResourcePatternResolver  pathmatchingresourcePatterResolver=
				new PathMatchingResourcePatternResolver();
		
		sessionFactory.setMapperLocations(pathmatchingresourcePatterResolver.getResources("classpath:cn.chouchou.dao.*"));
		sessionFactory.setConfigLocation(pathmatchingresourcePatterResolver.getResource("classpath:mybatis.xml"));
		return  sessionFactory;
	}

}
