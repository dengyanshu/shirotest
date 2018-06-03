package cn.chouchou.test;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;

public class Testshiro {

	
	@Test
	public void test1(){
		
		
		Md5Hash  md5hash=new Md5Hash("1234","1526368698194",1);
		System.out.println(md5hash.toString());
		
		
	}
}
