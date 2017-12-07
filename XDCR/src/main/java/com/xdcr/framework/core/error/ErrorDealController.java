package com.xdcr.framework.core.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorDealController  implements ErrorController{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private static final Logger logger = LoggerFactory.getLogger(ErrorDealController.class);

	/**404**/
	@RequestMapping("/error" )
	public String error (){
		return getErrorPath();
	}
	
	@Override
	public String getErrorPath() {
		logger.info("出错了。。。");
		return "error/error";
	}

}
