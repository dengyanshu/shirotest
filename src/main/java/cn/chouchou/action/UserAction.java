package cn.chouchou.action;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.aspectj.weaver.reflect.InternalUseOnlyPointcutParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.chouchou.entity.Sysuser;
import cn.chouchou.service.ISysuerService;


@Controller
@RequestMapping("/user")
public class UserAction {
	
	@Autowired
	private ISysuerService  sysuerService;
  
	@RequestMapping("/login")
	public String login(HttpServletRequest  request){
		/*
		 * 自己进行校验 不使用shiro 自带的表单验证
		 *  
		 * String session_code=(String)session.getAttribute("sRand");
		if(code==null||"".equals(code)){
			System.out.println("code kong....");
			session.setAttribute("errorinfo", "验证码失败...");
			return "redirect:/login.jsp";
		}
		if(!code.equals(session_code)){
			System.out.println("code wrong!...");
			session.setAttribute("errorinfo", "验证码失败...");
			return "redirect:/login.jsp";
		}
		Subject  subject= SecurityUtils.getSubject();
		try{
			subject.login(new UsernamePasswordToken(username, password));
		}
		catch (UnknownAccountException e) {
			System.out.println("未知账号异常....");
			session.setAttribute("errorinfo", "未知账号异常...");
			return "redirect:/login.jsp";
		}
		catch (org.apache.shiro.authc.IncorrectCredentialsException e) {
			System.out.println("凭证异常....");
			session.setAttribute("errorinfo", "凭证异常...");
			return "redirect:/login.jsp";
		}
		catch(Exception  e){
			System.out.println("其他异常....");
			session.setAttribute("errorinfo", "账号校验异常...");
			return "redirect:/login.jsp";
		}
		Sysuser  user=(Sysuser) subject.getPrincipal();
		session.setAttribute("userinfo", user);
		return "redirect:/home.jsp";
		*/
		String shirologin_attr=(String) request.getAttribute("shiroLoginFailure");
		if(shirologin_attr!=null){
			//有进行验证
			request.getSession().setAttribute("errorinfo", shirologin_attr);
			if(shirologin_attr.equalsIgnoreCase("")){
				//此处可以进行异常的跳转什么的
			}
		}
		System.out.println("shirologin_attr="+shirologin_attr);
		return "redirect:/login.jsp";
	}
	
	/**
	 * 模拟表单添加用户 写入数据库 注意密码的散列加密 
	 * 
	 * */
	
	@RequestMapping("/add")
	@RequiresPermissions({"user:add"})
	public @ResponseBody int  insertUser(Sysuser  user
		){
		
		
		user.setUserId(UUID.randomUUID().toString());
		user.setCreateDate(Calendar.getInstance().getTime());
		String salt=System.currentTimeMillis()+"";
		//调用shiro工具类算下散列后的密码
		Md5Hash  md5hash=new Md5Hash(user.getUserPassword(), salt, 1);
		user.setUserPassword(md5hash.toString());
		user.setSalt(salt);
		int  res=sysuerService.insert(user);
		return  res;
	}
}
