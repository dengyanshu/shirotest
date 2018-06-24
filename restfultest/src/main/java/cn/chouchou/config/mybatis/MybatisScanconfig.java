package cn.chouchou.config.mybatis;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@AutoConfigureAfter(MybatisConfig.class)
public class MybatisScanconfig {
   
	@Bean(name="chouchouMapperScanner")
	public MapperScannerConfigurer   chouchouMapperScanner(){
	     MapperScannerConfigurer mapperScanner=new MapperScannerConfigurer();
	     mapperScanner.setBasePackage("cn.chouchou.dao");
	     mapperScanner.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
	     return  mapperScanner;
	}
}
