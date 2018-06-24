package cn.chouchou.action;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import springfox.documentation.annotations.ApiIgnore;
import cn.chouchou.entity.Supplier;
import cn.chouchou.service.ISupplierService;


@Controller
@RequestMapping("/supplier")
public class SupplierAction {
    
	
	@Autowired
	private  ISupplierService  supplierService;
	
	
	@ApiIgnore
	@RequestMapping("/get")
    public @ResponseBody Supplier  getOneByid(int id){
		return  supplierService.selectOne(id);
    }
	
	//通过id获取指定supplier
	
	/**
	 * 路径参数描述
	 * 
	 * */
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	@ApiOperation(value="获取供应商信息",notes="根据id获取供应商")
	@ApiImplicitParam(paramType="path",example="id=2",dataType="int",name="id",value="供应商id",required=true)
	public @ResponseBody Supplier  getOne(@PathVariable("id") int id){
		
		return  supplierService.selectOne(id);
	}
	
	
	@ApiOperation(value="获取所有",notes="获取所有供应商")
	@RequestMapping(value="/",method=RequestMethod.GET)
	public @ResponseBody  List<Supplier>  getAll(){
		
		return  supplierService.selectAll();
	}
	
	/**
	 * swagger very smart  
	 * auto creat parameter introduce
	 * */
	@ApiOperation(value="增加一个",notes="增加一个供应商post")
	//@ApiImplicitParam(value="供应商",dataType="Supplier")
	@RequestMapping(value="/",method=RequestMethod.POST)
	public @ResponseBody int  postOne(@RequestBody  Supplier  supplier){
		
		return  supplierService.insert(supplier);
	}
	
	@ApiOperation(value="删除一个",notes="根据id删除当前供应商")
	@ApiImplicitParam(paramType="path",required=true,name="id",value="供应商id",dataType="int")
	@RequestMapping(value="/{id}" ,method=RequestMethod.DELETE)
	public  @ResponseBody int  deleteOne(@PathVariable("id") int id){
		
		return  supplierService.deleteOneByid(id);
		
	}
	@ApiOperation(value="更新",notes="更新一个供应商根据提交的")
	@RequestMapping(value="/",method=RequestMethod.PUT)
	public @ResponseBody  int  updateOne(@RequestBody Supplier  supplier){
		
		return   supplierService.update(supplier);
	}
}
