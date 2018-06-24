package cn.chouchou.task;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

@Configuration
@Component
@EnableScheduling
public class Task1 {
       public Logger  logger=Logger.getLogger(Task1.class);
	
	    public void sayHello(){  
	    	logger.info("Hello world, i'm the king of the world!!!");  
	    }  
}
