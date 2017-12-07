package com.xdcr.framework.core.common;

import java.awt.image.BufferedImage;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.code.kaptcha.impl.DefaultKaptcha;
@Controller
public class KaptchaController {

	@Autowired
	DefaultKaptcha tDefaultKaptcha;
	@Autowired
	StringRedisTemplate tRedisTemplate;
	
	@RequestMapping(value = "/common/captcha-image")
	public ModelAndView getKaptchaImage(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		Logger logger = Logger.getLogger(KaptchaController.class);
		
		response.setDateHeader("Expires", 0);
		response.setHeader("Cache-Control",
				"no-store, no-cache, must-revalidate");
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");
		response.setHeader("Pragma", "no-cache");
		response.setContentType("image/jpeg");

		String capText = tDefaultKaptcha.createText();
		logger.info("capText: " + capText);

		try {
			String uuid = UUIDUtils.getUUID32().trim().toString();
			tRedisTemplate.opsForValue().set(uuid, capText, 60 * 5,
					TimeUnit.SECONDS);
			
			
			System.out.println("tRedisTemplate.opsForValue().get(uuid)==========="+tRedisTemplate.opsForValue().get(uuid));
			
			Cookie cookie = new Cookie("kaptchaCode", uuid);
			cookie.setPath("/");
			response.addCookie(cookie);
		} catch (Exception e) {
			e.printStackTrace();
		}

		BufferedImage bi = tDefaultKaptcha.createImage(capText);
		ServletOutputStream out = response.getOutputStream();
		ImageIO.write(bi, "jpg", out);
		try {
			out.flush();
		} finally {
			out.close();
		}
		return null;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
