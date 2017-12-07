package com.xdcr.framework.core.config.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

/** 
 * 创建时间：2017年11月20日 下午2:24:03 
 * 项目名称：XDCR 
 * @author hm 
 * @version 1.0   
 * @since JDK 1.7
 * 文件名称：KaptchaNamePwdToken.java  新增验证码属性
 * 类说明： 
 */
public class KaptchaNamePwdToken extends UsernamePasswordToken {
	
	private static final long serialVersionUID = -3806948842869703677L;
	private String kaptcha;
	
	public KaptchaNamePwdToken(String username, String password,
            boolean rememberMe, String host, String kaptcha) {
		
		super(username, password, rememberMe, host);
		
		this.kaptcha = kaptcha;
	}
	

	public String getKaptcha() {
		return kaptcha;
	}


	public void setKaptcha(String kaptcha) {
		this.kaptcha = kaptcha;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
