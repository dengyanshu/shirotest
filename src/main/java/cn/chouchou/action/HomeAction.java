package cn.chouchou.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.chouchou.entity.Sysuser;


@Controller
public class HomeAction {
	
	@RequestMapping("/home")
	public  String  gohome(HttpServletRequest request){
		Sysuser  user=(Sysuser) SecurityUtils.getSubject().getPrincipal();
		request.setAttribute("userinfo", user);
		return "forward:/WEB-INF/jsp/home.jsp";
	}

}
