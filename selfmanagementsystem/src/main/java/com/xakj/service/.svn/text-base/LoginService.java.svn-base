package com.xakj.service;


import com.xakj.model.dto.User;

import net.sf.json.JSONObject;


public interface LoginService {
	/**
	 * 用户登录
	 */
	public User Login(String username,String password);
	
	/**
	 * 查用户信息
	 */
	public User LoginInfo(String token);

	/**
	 * 校验令牌
	 */
	JSONObject checkToken(String authorization);
}