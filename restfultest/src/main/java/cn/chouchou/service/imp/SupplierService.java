package cn.chouchou.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.chouchou.dao.SupplierMapper;
import cn.chouchou.entity.Supplier;
import cn.chouchou.service.ISupplierService;

@Service
public class SupplierService extends BaseService<Supplier>  implements ISupplierService{
    
	@Autowired
	private   SupplierMapper  supplierMapper;
	
	@Override
	public List<Supplier> selectAll() {
		// TODO Auto-generated method stub
		return supplierMapper.selectAll();
	}

	@Override
	public int deleteOneByid(int id) {
		// TODO Auto-generated method stub
		return supplierMapper.deleteOneByid(id);
	}

}
