package cn.chouchou.dao;

import java.util.Set;

import cn.chouchou.entity.Sysuser;

public interface SysuserMapper extends  BaseMapper<Sysuser>{

	Sysuser selectOneByUsername(String username);

	Set<String> selectpers();
}