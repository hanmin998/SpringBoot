package com.xdcr.framework.core.config.shiro;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import com.xdcr.framework.core.common.SpringUtil;

/** 
 * 创建时间：2017年11月20日 下午4:04:36 
 * 项目名称：XDCR 
 * @author hm 
 * @version 1.0   
 * @since JDK 1.7
 * 文件名称：BasicFormAuthenticationFilter.java 
 * 类说明： 
 */

public class BasicFormAuthenticationFilter extends FormAuthenticationFilter {

	
	/*@Resource
	StringRedisTemplate tRedisTemplate;*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	Logger logger = Logger.getLogger(BasicFormAuthenticationFilter.class);
	private String kaptchaParam = "kaptchaCode";
	public String getKaptchaParam() {
		return kaptchaParam;
	}
	public void setKaptchaParam(String kaptchaParam) {
		this.kaptchaParam = kaptchaParam;
	}
	protected String getKaptchaParam(ServletRequest request) {
        return WebUtils.getCleanParam(request, getKaptchaParam());
    }
	@Override
	protected AuthenticationToken createToken(ServletRequest request,
			ServletResponse response) {
		// TODO Auto-generated method stub
		String username = getUsername(request);
        
        String password = getPassword(request);
        
        String kaptchaCode = getKaptchaParam(request);
        
        boolean rememberMe = isRememberMe(request);
        
        String host = getHost(request);
        
        return new KaptchaNamePwdToken(username, password, rememberMe,host, kaptchaCode);
	}
    // 验证码校验
   protected void doCaptchaValidate(HttpServletRequest request, KaptchaNamePwdToken token) {
    	String kaptchaKey = "";
    	String kapchaVal = "";
    	Cookie[] cookies = request.getCookies();
    	for(Cookie cookie : cookies){
    		if(cookie.getName().equalsIgnoreCase("kaptchaCode")){
    			kaptchaKey = cookie.getValue();
    		}
    	}
    	StringRedisTemplate tRedisTemplate = (StringRedisTemplate) SpringUtil.getBean("redisTemplate");
    	kapchaVal = tRedisTemplate.opsForValue().get(kaptchaKey);
        
        logger.info("kaptcha="+kapchaVal);

        if ((StringUtils.isEmpty(token.getKaptcha())) || !token.getKaptcha().equalsIgnoreCase(kapchaVal)) {
        	throw new AuthenticationException("验证码错误！"); 
        }
    }
	@Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
		logger.info("executeLogin=====");
		AuthenticationToken token = this.createToken(request, response);
		try {
	        	
	           doCaptchaValidate((HttpServletRequest) request, (KaptchaNamePwdToken) token);

	           Subject subject = getSubject(request, response);
	            
	           subject.login(token);

	           return onLoginSuccess(token, subject, request, response);
	            
	       } catch (AuthenticationException e) {
	        	
	           return onLoginFailure(token, e, request, response);
	       }
	}
	/**
     * 重写默认登录成功后的跳转
     * 默认：登录成功后的跳转页面为上次访问的页面，如果没有则跳转配置的SuccessUrl，这种跳转在前台页面为frame结构中不适用
     * 更改，跳转成功后，统一转到首页
     */
	/*@Override
	protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
			ServletResponse response) throws Exception {

		WebUtils.getAndClearSavedRequest(request) ; //清理原来地址
		
		return super.onLoginSuccess(token, subject, request, response);
		
	}*/
	

	/**
	 * 重写接口 AccessControlFilter.onAccessDenied ，增加踢人功能，后登录帐号会将系统内已经存在的相同帐号踢出登录，并给出提示
	 * 
	 */
	/*@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {

		Subject subject = getSubject(request, response);
		
        if(!subject.isAuthenticated() && !subject.isRemembered()) {
        	
        	AuthenticationToken token = this.createToken(request, response);
    	    boolean result = doCaptchaValidate((HttpServletRequest) request, (KaptchaNamePwdToken) token);
    	    if(!result){
    	    	return true;
    	    }
        }
        logger.info("super.onAccessDenied====");
		return super.onAccessDenied(request, response, mappedValue);
	}*/
}
