package cn.chouchou.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;


/*
 * 这是一个全局的异常处理器
 * 传统的web.xml中配置的 错误页面  没有这种好！
 * 
 * **/

public class MVCException implements  HandlerExceptionResolver{
	

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		// TODO Auto-generated method stub
		CustomException  customException=null;
		if(ex instanceof CustomException){
			customException=new CustomException(ex.getMessage());
		}
		else{
			customException=new CustomException("未知错误");
		}
		
		ModelAndView  mv=new ModelAndView();
		mv.setViewName("error");
		mv.addObject("exceptionmsg", ex.getMessage());
		
		return mv;
	}

}
