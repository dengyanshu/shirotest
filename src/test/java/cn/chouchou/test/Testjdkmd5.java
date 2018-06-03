package cn.chouchou.test;

import java.security.MessageDigest;

import org.junit.Test;



public class Testjdkmd5 {
	
	@Test
	public  void   test1()throws Exception{
		MessageDigest md5 = MessageDigest.getInstance("md5");
		byte[] bytes=md5.digest("123456".getBytes());
		StringBuilder sb=new StringBuilder();
		for(int x=0;x<bytes.length;x++){
			String s=String.format("%02x", bytes[x]);
			sb.append(s);
		}
		System.out.println(sb.toString().toLowerCase());
	}

}
