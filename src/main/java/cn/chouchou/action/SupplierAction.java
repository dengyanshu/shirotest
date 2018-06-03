package cn.chouchou.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.chouchou.entity.Supplier;
import cn.chouchou.exception.CustomException;
import cn.chouchou.service.ISupplierService;


@Controller
@RequestMapping("/supplier")
public class SupplierAction {
    
	@Autowired
    private  ISupplierService  supplierService;
	
	@RequestMapping("/id")
	public  @ResponseBody Supplier  getDomainbyid(int id) throws CustomException{
		Supplier  supp=supplierService.selectOne(id);
		if(supp==null)
			throw  new CustomException("供应商不存在");
		return supp;
	}
}
