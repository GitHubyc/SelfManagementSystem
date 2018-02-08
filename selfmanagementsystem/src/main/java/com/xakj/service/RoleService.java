package com.xakj.service;


import java.util.HashMap;

import com.xakj.constant.Constant;
import com.xakj.util.HttpClientUtil;

import net.sf.json.JSONObject;

public interface RoleService {
	
	/**
	 * 获取角色
	 */
	public JSONObject list(HashMap<String, Object> paramMap);
	
	/**
	 * 获取所有角色
	 */
	public JSONObject all(HashMap<String, Object> paramMap);
	
	/**
	 * 新增角色
	 */
	public JSONObject add(HashMap<String, Object> paramMap);
	
	/**
	 * 删除角色
	 */
	public JSONObject del(HashMap<String, Object> paramMap);

	/**
	 * 更新角色
	 */
	public JSONObject edit(HashMap<String, Object> paramMap);
	
	/**
	 * 查看角色
	 */
	public JSONObject details(HashMap<String, Object> paramMap);

	/**
	 * 查询角色权限
	 */
	public JSONObject roleRight(HashMap<String, Object> paramMap);
	
	/**
	 * 添加角色权限
	 */
	public JSONObject addRoleRight(HashMap<String, Object> paramMap);
}