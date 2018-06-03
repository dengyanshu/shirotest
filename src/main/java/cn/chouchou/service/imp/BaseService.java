package cn.chouchou.service.imp;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import cn.chouchou.dao.BaseMapper;
import cn.chouchou.dao.SupplierMapper;
import cn.chouchou.dao.SysuserMapper;
import cn.chouchou.service.IBaseService;

public class BaseService<T>  implements  IBaseService<T> {
	
	
	private  BaseMapper<T>  baseMapper;
	
	@Autowired
	private  SupplierMapper  supplierMapper;
    
	@Autowired
	private  SysuserMapper sysuserMapper;
	
	@PostConstruct
	public void init()throws Exception{
		ParameterizedType  pt= (ParameterizedType) this.getClass().getGenericSuperclass();
		Class clazz=(Class) pt.getActualTypeArguments()[0];
		String name=clazz.getSimpleName();
		String  localMappper=name.substring(0, 1).toLowerCase()+name.substring(1)+"Mapper";
		
		Field baseField=this.getClass().getSuperclass().getDeclaredField("baseMapper");
		Field localField=this.getClass().getSuperclass().getDeclaredField(localMappper);
		baseField.set(this, localField.get(this));
		
		
	}
	
	@Override
	public int insert(T t) {
		// TODO Auto-generated method stub
		return baseMapper.insert(t);
	}

	@Override
	public int delete(T t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteList(Serializable[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(T t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public T selectOne(Serializable id) {
		// TODO Auto-generated method stub
		return baseMapper.selectOne(id);
	}



}
