package com.xakj.service;

import java.util.HashMap;

import net.sf.json.JSONObject;

/**
 * @author 施先锋 深圳消安科技有限公司 2017-2-21下午6:36:57
 */
public interface KeySiteService {

	/**
	 * 分页查询重点部位
	 */
	public JSONObject list(String buildCode,String floorCode,HashMap<String, Object> paramMap);
	
	/**
	 * 新增重点部位
	 */
	public JSONObject add(String buildCode,String floorCode,HashMap<String, Object> paramMap);
	
	/**
	 * 删除重点部位
	 */
	public JSONObject del(String buildCode,String floorCode,String keySiteCode);
	
	/**
	 * 获取重点部位
	 */
	public JSONObject findOne(String buildCode,String floorCode,String keySiteCode);
	
	/**
	 * 更新重点部位
	 */
	public JSONObject edit(String buildCode,String floorCode,String keySiteCode,HashMap<String, Object> paramMap);


}
