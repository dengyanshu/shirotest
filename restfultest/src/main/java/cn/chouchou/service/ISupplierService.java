package cn.chouchou.service;

import java.util.List;

import cn.chouchou.entity.Supplier;

public interface ISupplierService extends  IBaseService<Supplier>{

	
	
	public List<Supplier>  selectAll();
	
	
	public int deleteOneByid(int id);
}
