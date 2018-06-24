package cn.chouchou.dao;

import java.util.List;

import cn.chouchou.entity.Supplier;


public interface SupplierMapper extends  BaseMapper<Supplier>{

	List<Supplier> selectAll();

	int deleteOneByid(int id);
   
}