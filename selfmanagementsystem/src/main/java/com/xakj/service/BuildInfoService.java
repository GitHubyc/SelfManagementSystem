package com.xakj.service;

import java.util.HashMap;

import net.sf.json.JSONObject;

/**
 * @author 施先锋 深圳消安科技有限公司 2017-2-21下午6:36:57
 */
public interface BuildInfoService {

	/**
	 * 获取建筑信息列表
	 */
	public JSONObject list(HashMap<String, Object> paramMap);
	
	/**
	 * 新增建筑信息
	 */
	public JSONObject add(HashMap<String, Object> paramMap);
	
	/**
	 * 删除建筑信息
	 */
	public JSONObject del(String buildCode);
	
	/**
	 * 获取建筑信息
	 */
	public JSONObject findOne(String buildCode);
	
	/**
	 * 更新建筑信息
	 */
	public JSONObject edit(String buildCode,HashMap<String, Object> paramMap);
	
	
	/**
	 * 根据规土委编号或者建筑名称或建筑地址模糊查询建筑信息
	 */
	public JSONObject getBuildname(HashMap<String, Object> paramMap);
	
	/**
	 *  根据单位id和建筑信息查询建筑
	 */
	public JSONObject unitAndBuildList(HashMap<String, Object> paramMap);
	
	/**
	 * 设置建筑编号
	 */
	public JSONObject set(String buildCode,String plcBuildCode);
	

}
