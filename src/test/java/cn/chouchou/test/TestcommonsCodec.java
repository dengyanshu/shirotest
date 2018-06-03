package cn.chouchou.test;

import java.security.MessageDigest;

import net.sf.json.JSONObject;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.HmacUtils;
import org.apache.commons.codec.digest.Md5Crypt;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

public class TestcommonsCodec {
	
	@Test
	public  void test1()throws Exception{
		
		//1、base64解码
		byte[] bytes=Base64.decodeBase64("eyJjb2RlIjoxMDA4NiwibWVzc2FnZSI6Iui/lOWbnuaIkOWKn++8gSJ9");
	    System.out.println(new String(bytes,"utf-8"));
	    
	    //2、base64编码
	     
	    JSONObject  object=new JSONObject();
	    object.put("code", 10086);
	    object.put("message", "返回成功！");
	    System.out.println("json string="+object.toString());
	    
	    System.out.println(new String(Base64.encodeBase64String(object.toString().getBytes("utf-8"))));
	    
	   
	}
	
	@Test
	public  void  test2(){
		System.out.println(DigestUtils.md5Hex("12345"));
		System.out.println(DigestUtils.sha1Hex("12345"));
		
		
	}

}
