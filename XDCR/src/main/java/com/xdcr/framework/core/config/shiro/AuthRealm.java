package com.xdcr.framework.core.config.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.xdcr.framework.core.login.dto.SysUser;
import com.xdcr.framework.core.login.service.LoginService;

/** 
 * 创建时间：2017年11月17日 上午9:42:31 
 * 项目名称：XDCR 
 * @author hm 
 * @version 1.0   
 * @since JDK 1.7
 * 文件名称：AuthRealm.java 
 * 类说明： 
 */
public class AuthRealm extends AuthorizingRealm {
	@Autowired
	private LoginService tLoginService;

	/* （非 Javadoc）
	* <p>Title: doGetAuthorizationInfo</p>
	* <p>Description: 授权</p>
	* @param arg0
	* @return
	* @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
	*/
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	
	/* （非 Javadoc）
	* <p>Title: doGetAuthenticationInfo</p>
	* <p>Description: 认证、登录</p>
	* @param arg0
	* @return
	* @throws AuthenticationException
	* @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
	*/
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken arg0) throws AuthenticationException {
		// TODO Auto-generated method stub
		UsernamePasswordToken tUsernamePasswordToken = (UsernamePasswordToken) arg0;
		String username = tUsernamePasswordToken.getUsername();
		SysUser tSysUser = tLoginService.findUserByUserName(username);
		return new SimpleAuthenticationInfo(tSysUser, tSysUser.getPwd(), this.getClass().getName());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
