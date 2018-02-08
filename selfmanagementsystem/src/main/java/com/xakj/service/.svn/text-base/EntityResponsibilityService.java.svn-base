package com.xakj.service;

import java.util.HashMap;

import net.sf.json.JSONObject;

/**
 * @author 施先锋 深圳消安科技有限公司 2017-2-21下午6:36:57
 */
public interface EntityResponsibilityService {
	/**
	 * 获取主体责任列表
	 */
	public JSONObject list(HashMap<String, Object> paramMap);

	/**
	 * 新增主体责任
	 */
	public JSONObject add(String buildCode, HashMap<String, Object> paramMap);	

	/**
	 * 查询主体责任代表
	 */
	public JSONObject set(String buildCode);	

	
	/**
	 * 删除主体责任
	 */
	public JSONObject del(String buildCode, String responsibilityCode);

	/**
	 * 获取主体责任
	 */
	public JSONObject findOne(String buildCode,String responsibilityCode);
	
	/**
	 * 更新主体责任
	 */
	public JSONObject edit(String buildCode, String responsibilityCode, HashMap<String, Object> paramMap);
	

}
