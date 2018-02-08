package com.xakj.service;

import java.util.HashMap;

import net.sf.json.JSONObject;

public interface UnitInfoService {

	/**
	 * 获取单位列表
	 */
	public JSONObject list(HashMap<String, Object> paramMap);
	
	/**
	 * 获取所有单位
	 */
	public JSONObject all(HashMap<String, Object> paramMap);

	/**
	 * 获取行政单位
	 */
	public JSONObject findadmin(HashMap<String, Object> paramMap);

	/**
	 * 获取事业单位
	 */
	public JSONObject findcause(HashMap<String, Object> paramMap);

	/**
	 * 获取企业单位
	 */
	public JSONObject findenter(HashMap<String, Object> paramMap);

	/**
	 * 获取企业单位
	 */
	public JSONObject findproperty(HashMap<String, Object> paramMap);

	/**
	 * 删除行政单位
	 */
	public JSONObject deladmin(HashMap<String, Object> paramMap);

	/**
	 * 删除事业单位
	 */
	public JSONObject delCause(HashMap<String, Object> paramMap);

	/**
	 * 删除企业单位
	 */
	public JSONObject delEnter(HashMap<String, Object> paramMap);

	/**
	 * 删除物业管理处
	 */
	public JSONObject delProperty(HashMap<String, Object> paramMap);

	/**
	 * 新增行政单位
	 */
	public JSONObject addadmin(HashMap<String, Object> paramMap);

	/**
	 * 新增事业单位
	 */
	public JSONObject addCause(String json);

	/**
	 * 新增企业单位
	 */
	public JSONObject addEnter(HashMap<String, Object> paramMap);

	/**
	 * 新增物业管理处
	 */
	public JSONObject addProperty(HashMap<String, Object> paramMap);

	/**
	 * 更新行政单位
	 */
	public JSONObject updateadmin(HashMap<String, Object> paramMap);

	/**
	 * 更新事业单位
	 */
	public JSONObject updateCause(HashMap<String, Object> paramMap);

	/**
	 * 更新企业单位
	 */
	public JSONObject updateEnter(HashMap<String, Object> paramMap);

	/**
	 * 更新物业管理处
	 */
	public JSONObject updateProperty(HashMap<String, Object> paramMap);
	
	/**
	 * 查询物业管理处信息(给民警角色使用)
	 */
	public JSONObject getInfo(HashMap<String, Object> paramMap);
}
