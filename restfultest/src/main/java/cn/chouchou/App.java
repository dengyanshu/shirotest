package cn.chouchou;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@Controller
@EnableSwagger2
public class App  extends SpringBootServletInitializer{
	@RequestMapping("/hello") 
	   public @ResponseBody String hello(){
	    	return  "hello sprngboot !";
	    }
         public static void main(String[] args) {
			SpringApplication.run(App.class, args);
		}
         
         
   @Override
    protected SpringApplicationBuilder configure(
    		SpringApplicationBuilder builder) {
    	// TODO Auto-generated method stub
    	return builder.sources(App.class);
    }
       
}
