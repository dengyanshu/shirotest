package cn.chouchou.service;

import java.io.Serializable;

public interface IBaseService<T> {
	 public int insert(T t);
     public int deleteOne(T t);
     public int update(T t);
     public T selectOne(Serializable  id);
}
