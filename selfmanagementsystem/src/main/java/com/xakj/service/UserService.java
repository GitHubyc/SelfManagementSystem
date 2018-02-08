package com.xakj.service;


import java.util.HashMap;

import net.sf.json.JSONObject;


public interface UserService {

	/**
	 * 获取用户
	 */
	public JSONObject list(HashMap<String, Object> paramMap);
	
	/**
	 * 根据用户名/id获取用户
	 */
	public JSONObject selByNameOrId(HashMap<String, Object> paramMap);
	
	/**
	 * 新增用户
	 */
	public JSONObject add(HashMap<String, Object> paramMap);
	
	/**
	 * 删除用户
	 */
	public JSONObject del(String userId);

	/**
	 * 更新用户
	 */
	public JSONObject edit(HashMap<String, Object> paramMap);
	
	/**
	 * 查看用户
	 */
	public JSONObject details(HashMap<String, Object> paramMap);
	
	/**
	 * 查询用户权限
	 */
	public JSONObject userRight(String userId, String applyId);
	
	/**
	 * 添加用户权限
	 */
	public JSONObject addUserRight(HashMap<String, Object> paramMap);
	
	/**
	 * 查询用户组
	 */
	public JSONObject userGroup(HashMap<String, Object> paramMap);
	
	/**
	 * 添加用户组
	 */
	public JSONObject addUserGroup(HashMap<String, Object> paramMap);
	
	/**
	 * 查询用户角色
	 */
	public JSONObject userRole(HashMap<String, Object> paramMap);
	
	/**
	 * 添加用户角色
	 */
	public JSONObject addUserRole(HashMap<String, Object> paramMap);

}