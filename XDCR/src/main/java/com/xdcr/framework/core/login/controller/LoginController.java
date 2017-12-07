package com.xdcr.framework.core.login.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xdcr.framework.core.login.service.LoginService;

/**
 * <p>
 * Title: LoginController<／p>
 * <p>
 * Description: <／p>
 * <p>
 * Company: <／p>
 * 
 * @author hm
 * @date 2017年11月16日
 */
@Controller
public class LoginController {
	
	@Resource
	private LoginService tLoginService ;

	Logger tLogger = Logger.getLogger(LoginController.class);

	/**
	 * <p>
	 * Title: root
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @return
	 */
	@RequestMapping("/")
	public String login() {
		return "login";
	}

	/**
	 * <p>
	 * Title: loginUser
	 * </p>
	 * <p>
	 * Description:登录按钮触发
	 * </p>
	 * 
	 * @return
	 */
	@RequestMapping("/login")
	public String login(HttpServletRequest request, Model model) {
		/*KaptchaNamePwdToken tKaptchaNamePwdToken = new KaptchaNamePwdToken(request.getParameter("usercode"),request.getParameter("pwd"),false,"",request.getParameter("kaptchaCode"));
		SecurityUtils.getSubject().login(tKaptchaNamePwdToken);*/
		String exceptionClassName = (String) request
				.getAttribute("shiroLoginFailure");
		if (exceptionClassName != null) {
			tLogger.info("exceptionClassName=" + exceptionClassName);
			return "login";
		}
		Session session = SecurityUtils.getSubject().getSession();
		session.getAttribute("");
		Subject subject = SecurityUtils.getSubject();
		tLogger.info("subject.getPrincipal()----" + subject.getPrincipal());
		

		return "index";
	}
	
	@RequestMapping("/index")
	public String index(HttpServletRequest request, Model model) {
		tLogger.info("index===" );
		return "";
	}
}
