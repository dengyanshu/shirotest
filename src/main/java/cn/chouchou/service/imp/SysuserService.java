package cn.chouchou.service.imp;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.chouchou.dao.SysuserMapper;
import cn.chouchou.entity.Sysuser;
import cn.chouchou.service.ISysuerService;


@Service
public class SysuserService extends  BaseService<Sysuser>  implements ISysuerService {
    
	@Autowired
	private  SysuserMapper  sysuserMapper;
	
	@Override
	public Sysuser selectOneByUsername(String username) {
		// TODO Auto-generated method stub
     	return	sysuserMapper.selectOneByUsername(username);
	}

	@Override
	public Set<String> selectpers() {
		// TODO Auto-generated method stub
		return sysuserMapper.selectpers();
	}

}
