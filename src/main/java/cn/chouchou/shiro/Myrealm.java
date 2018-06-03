package cn.chouchou.shiro;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.hamcrest.core.IsSame;
import org.springframework.beans.factory.annotation.Autowired;

import cn.chouchou.entity.Sysuser;
import cn.chouchou.service.ISysuerService;

public class Myrealm extends  AuthorizingRealm{
    
	//注入查询service
	@Autowired
	private  ISysuerService  sysuerService;
	
	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		super.setName("myRealm");
	}
	//授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		// TODO Auto-generated method stub
		Sysuser  user=(Sysuser) principals.getPrimaryPrincipal();
		//用户去后台查询该权限
		Set<String>  permissons=new HashSet<String>();
		//permissons.add("user:add");
		
		SimpleAuthorizationInfo  authorizationInfo=new SimpleAuthorizationInfo();
		authorizationInfo.setStringPermissions(permissons);
		return authorizationInfo;
	}
   //认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken  mytoken=(UsernamePasswordToken)token;
		String username=mytoken.getUsername();
		
		//模拟从数据库后台查询出该用户的信息;装配成一个Sysuser;
		Sysuser user = sysuerService.selectOneByUsername(username);
		
		if(user==null){
			return  null;
		}
		
		AuthenticationInfo authenticationinfo=new SimpleAuthenticationInfo(
				user, 
				user.getUserPassword() ,
				ByteSource.Util.bytes(user.getSalt()), 
				this.getName());
		
		
		return authenticationinfo;
	}
	
	/*
	 * 该方法可以注入自定义realm的时候给 给realm 本身调用
	 * */
	public void clearCache(){
		super.clearCache(SecurityUtils.getSubject().getPrincipals());
	}

}
