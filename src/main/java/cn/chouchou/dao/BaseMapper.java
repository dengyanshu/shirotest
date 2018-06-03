package cn.chouchou.dao;

import java.io.Serializable;

public interface BaseMapper<T> {
   
	
	public  int  insert(T t);
	public  int delete(T t);
	public int deleteList(Serializable[] ids);
	public  int update(T t);
	public  T selectOne(Serializable id);
}
