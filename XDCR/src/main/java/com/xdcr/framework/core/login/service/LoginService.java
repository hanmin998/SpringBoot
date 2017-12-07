package com.xdcr.framework.core.login.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.xdcr.framework.core.login.dao.ISysUser;
import com.xdcr.framework.core.login.dto.SysUser;

/** 
 * 创建时间：2017年11月17日 上午10:15:40 
 * 项目名称：XDCR 
 * @author hm 
 * @version 1.0   
 * @since JDK 1.7
 * 文件名称：LoginService.java 
 * 类说明： 
 */
@Service
public class LoginService {
	
	@Autowired 
	private ISysUser tISysUser;
	
	public SysUser findUserByUserName (String userName) {
	    	
		return tISysUser.findUserByUserName(userName) ;
	    	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
