package com.xakj.service;

import java.util.HashMap;

import net.sf.json.JSONObject;

/**
 * @author 施先锋 深圳消安科技有限公司 2017-2-21下午6:36:57
 */
public interface HouseInfoService{

	/**
	 * 获取建筑信息列表
	 */
	public JSONObject list(String buildCode,String floorCode,HashMap<String, Object> paramMap);
	
	/**
	 * 新增建筑信息
	 */
	public JSONObject add(String buildCode,String floorCode,HashMap<String, Object> paramMap);
	
	/**
	 * 删除建筑信息
	 */
	public JSONObject del(String buildCode,String floorCode,String houseCode);
	
	/**
	 * 获取建筑信息
	 */
	public JSONObject findOne(String buildCode,String floorCode,String houseCode);
	
	/**
	 * 更新建筑信息
	 */
	public JSONObject edit(String buildCode,String floorCode,String houseCode,HashMap<String, Object> paramMap);
	
	
	
	

}
