package com.xakj.service;

import java.util.HashMap;

import net.sf.json.JSONObject;

/**
 * @author 施先锋 深圳消安科技有限公司 2017-2-21下午6:36:57
 */
public interface EducationService {

	/**
	 * 获取人员教育列表
	 */
	public JSONObject list(HashMap<String, Object> paramMap);
	
	/**
	 * 新增人员教育
	 */
	public JSONObject add(HashMap<String, Object> paramMap);
	
	/**
	 * 删除人员教育
	 */
	public JSONObject del(String educationCode);
	
	/**
	 * 更新人员教育
	 */
	public JSONObject edit(HashMap<String, Object> paramMap);
	
	


}
