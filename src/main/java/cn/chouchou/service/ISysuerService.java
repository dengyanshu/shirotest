package cn.chouchou.service;

import java.util.Set;

import cn.chouchou.entity.Sysuser;

public interface ISysuerService  extends IBaseService<Sysuser> {
     
	
	
	Sysuser selectOneByUsername(String username);
	
	
	//模拟通过用户获取permission
	Set<String>  selectpers();
}
