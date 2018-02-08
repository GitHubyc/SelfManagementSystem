package com.xakj.service;

import java.util.HashMap;

import net.sf.json.JSONObject;

/**
 * @author 施先锋 深圳消安科技有限公司 2017-2-21下午6:36:57
 */
public interface FireFacilitieService{

	/**
	 * 获取消防设施列表
	 */
	public JSONObject list(HashMap<String, Object> paramMap);
	
	/**
	 * 查询某类消防设施系统列表
	 */
	public JSONObject listType(String facilitieCode,HashMap<String, Object> paramMap);
	

	/**
	 * 设置消防设施表
	 */
	public JSONObject setFire(String jsonString);
	
	
	/**
	 * 添加某类消防设施系统
	 */
	public JSONObject add(String facilitieCode,HashMap<String, Object> paramMap);
	
	/**
	 * 删除某类消防设施系统
	 */
	public JSONObject del(String facilitieCode,String facilitieSystemCode);
	
	/**
	 * 查询某类消防设施系统详细
	 */
	public JSONObject findOne(String facilitieCode,String facilitieSystemCode);
	
	/**
	 * 更新某类消防设施系统
	 */
	public JSONObject edit(String facilitieCode,String facilitieSystemCode,HashMap<String, Object> paramMap);
	
	
	
	

}
