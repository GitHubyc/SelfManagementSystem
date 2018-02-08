package com.xakj.intercepor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.xakj.constant.Constant;
import com.xakj.model.dto.User;
import com.xakj.service.RightService;
import com.xakj.service.UserService;
/**
 * 拦截器类
 * @author 袁文彪
 * 
 * 消防
 */
public class Intercept implements HandlerInterceptor {
	
	/**
	 * 请求前拦截，当前用户权限包含当前请求则通过返回true，否则跳转到403页面返回false
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		User user = (User) SecurityUtils.getSubject().getSession().getAttribute(Constant.USER);
		if(user.getRight().contains(request.getServletPath())){
			return true;
		}else{
			request.getRequestDispatcher("/403").forward(request, response);
			return false;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}


}
