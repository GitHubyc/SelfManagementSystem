package com.xakj.service;

import java.util.HashMap;

import net.sf.json.JSONObject;

/**
 * @author 施先锋 深圳消安科技有限公司 2017-2-21下午6:36:57
 */
public interface WorkService {

	/**
	 * 获取人员工作列表
	 */
	public JSONObject list(HashMap<String, Object> paramMap);

	/**
	 * 新增人员工作
	 */
	public JSONObject add(HashMap<String, Object> paramMap);

	/**
	 * 删除人员工作
	 */
	public JSONObject del(String buildCode);

	/**
	 * 更新人员工作
	 */
	public JSONObject edit(String buildCode, HashMap<String, Object> paramMap);

}
