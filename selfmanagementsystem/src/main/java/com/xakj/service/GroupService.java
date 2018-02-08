package com.xakj.service;


import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xakj.constant.Constant;
import com.xakj.util.HttpClientUtil;

import net.sf.json.JSONObject;

public interface GroupService {
	
	/**
	 * 获取组
	 */
	public JSONObject list(HashMap<String, Object> paramMap);
	
	/**
	 * 获取所有组
	 */
	public JSONObject all(HashMap<String, Object> paramMap);
	
	/**
	 * 新增组
	 */
	public JSONObject add(HashMap<String, Object> paramMap);
	
	/**
	 * 删除组
	 */
	public JSONObject del(HashMap<String, Object> paramMap);

	/**
	 * 更新组
	 */
	public JSONObject edit(HashMap<String, Object> paramMap);
	
	/**
	 * 查看组
	 */
	public JSONObject details(HashMap<String, Object> paramMap);
	
	/**
	 * 查询组用户
	 */
	public JSONObject group_user(HashMap<String, Object> paramMap);

	/**
	 * 查询组角色
	 */
	public JSONObject group_role(HashMap<String, Object> paramMap);
	
	/**
	 * 添加组角色
	 */
	public JSONObject add_group_role(HashMap<String, Object> paramMap);

	/**
	 * 查询组权限
	 */
	public JSONObject group_right(HashMap<String, Object> paramMap);
	
	/**
	 * 添加组权限
	 */
	public JSONObject add_group_right(HashMap<String, Object> paramMap);

}