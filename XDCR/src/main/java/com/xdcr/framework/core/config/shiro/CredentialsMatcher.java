package com.xdcr.framework.core.config.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

/** 
 * 创建时间：2017年11月17日 上午11:01:17 
 * 项目名称：XDCR 
 * @author hm 
 * @version 1.0   
 * @since JDK 1.7
 * 文件名称：CredentialsMatcher.java 
 * 类说明： 
 */
public class CredentialsMatcher extends SimpleCredentialsMatcher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean doCredentialsMatch(AuthenticationToken token,
			AuthenticationInfo info) throws AuthenticationException{
		// TODO Auto-generated method stub
		UsernamePasswordToken tUsernamePasswordToken = (UsernamePasswordToken) token;
		//获得用户输入的密码:(可以采用加盐(salt)的方式去检验)
		String inPwd = new String(tUsernamePasswordToken.getPassword()); //密码可采用加密技术
		String dbPwd = (String) info.getCredentials();
		return this.equals(inPwd, dbPwd);
	}
	

}
