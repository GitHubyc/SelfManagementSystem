package com.xakj.exception;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.UnavailableSecurityManagerException;
import org.springframework.expression.spel.SpelEvaluationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
class GlobalExceptionHandler {

	public static final String DEFAULT_ERROR_VIEW = "login";
	public static final String SERVER_ERROR_VIEW = "500";

	/**
	 * 后台网关取不到数据
	 */
	@ExceptionHandler(value = UnavailableSecurityManagerException.class)
	public ModelAndView UnavailableSecurityManagerHandler(HttpServletRequest req,
			Exception e) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName(SERVER_ERROR_VIEW);
		return mav;
	}

	@ExceptionHandler(value = Exception.class)
	public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e)
			throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName(DEFAULT_ERROR_VIEW);
		return mav;
	}

}
