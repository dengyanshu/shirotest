package cn.chouchou.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

/**
 * 
 * */
public class MyFormau extends  FormAuthenticationFilter{
     @Override
	protected boolean onAccessDenied(ServletRequest request,
			ServletResponse response, Object mappedValue) throws Exception {
		// TODO Auto-generated method stub
	   HttpSession  session= ((HttpServletRequest)request).getSession();
	    String session_code=(String) session.getAttribute("sRand");
	    String code= request.getParameter("code");
		if (session_code!=null && code!=null) {
			if (!code.equals(session_code)) {
				// randomCodeError表示验证码错误 
				request.setAttribute("shiroLoginFailure", "randomCodeError");
				//拒绝访问，不再校验账号和密码 
				return true; 
			}
		}
		return super.onAccessDenied(request, response, mappedValue);
	}
}
