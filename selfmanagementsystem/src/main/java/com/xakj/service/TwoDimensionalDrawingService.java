package com.xakj.service;

import java.util.HashMap;

import net.sf.json.JSONObject;

/**
 * @author 施先锋 深圳消安科技有限公司 2017-2-21下午6:36:57
 */
public interface TwoDimensionalDrawingService{

	/**
	 * 分页查询二维图纸
	 */
	public JSONObject list(String buildCode,String floorCode,HashMap<String, Object> paramMap);
	
	/**
	 * 新增二维图纸
	 */
	public JSONObject add(String buildCode,String floorCode,HashMap<String, Object> paramMap);
	
	/**
	 * 删除二维图纸
	 */
	public JSONObject del(String buildCode,String floorCode,String drawingCode);
	
	/**
	 * 获取二维图纸
	 */
	public JSONObject findOne(String buildCode,String floorCode,String drawingCode);
	
	/**
	 * 更新二维图纸
	 */
	public JSONObject edit(String buildCode,String floorCode,String drawingCode,HashMap<String, Object> paramMap);
	
	/**
	 * 新增加更新二维图纸
	 */
	public JSONObject save(String buildCode,String floorCode,HashMap<String, Object> paramMap);
	

}
