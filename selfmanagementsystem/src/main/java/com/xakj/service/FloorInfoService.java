package com.xakj.service;

import java.util.HashMap;

import net.sf.json.JSONObject;

/**
 * @author 施先锋 深圳消安科技有限公司 2017-2-21下午6:36:57
 */
public interface FloorInfoService {
	/**
	 * 分页查询楼层信息
	 */
	public JSONObject list(String buildCode, HashMap<String, Object> paramMap);
	
	/**
	 * 新增楼层信息
	 */
	public JSONObject add(String buildCode, HashMap<String, Object> paramMap);

	/**
	 * 删除楼层信息
	 */
	public JSONObject del(String buildCode, String floorCode);

	/**
	 * 获取楼层信息
	 */
	public JSONObject findOne(String buildCode, String floorCode);

	/**
	 * 更新楼层信息
	 */
	public JSONObject edit(String buildCode, String floorCode, HashMap<String, Object> paramMap);

}
