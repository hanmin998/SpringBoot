package com.xdcr.framework.core.common;

import java.util.UUID;

public class UUIDUtils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(getUUID32());
	}
	
	/**
	 * 生成32位的uuid
	 * @return
	 */
	public static String getUUID32() { 
		    /*UUID uuid = UUID.randomUUID(); 
		    String str = uuid.toString(); 
		    // 去掉"-"符号 
		    String temp = str.substring(0, 8) + str.substring(9, 13) 
		        + str.substring(14, 18) + str.substring(19, 23) 
		        + str.substring(24); 
		    return temp;*/ 
		     
		    return UUID.randomUUID().toString().replace("-", ""); 
		  } 

}
