package cn.chouchou.config.datasource;

import java.beans.PropertyVetoException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.mchange.v2.c3p0.ComboPooledDataSource;


@Configuration
@PropertySource("classpath:jdbc.properties")
public class C3p0Config {
	
	@Value("${driverClass}")
	private  String driver;
	
	@Value("${url}")
	private  String  url; 
	
	@Value("${user}")
	private  String  user;
	
	@Value("${password}")
	private  String password;
   
	//获取一个连接池对象
	@Bean
	public  ComboPooledDataSource comboPooledDataSource(){
		ComboPooledDataSource  ds=new ComboPooledDataSource();
		try {
			ds.setDriverClass(driver);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ds.setJdbcUrl(url);
		ds.setUser(user);
		ds.setPassword(password);
		return  ds;
	}
	
}
