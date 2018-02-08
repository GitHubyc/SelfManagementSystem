package com.xakj.service;

import java.util.HashMap;

import net.sf.json.JSONObject;

/**
 * @author 施先锋 深圳消安科技有限公司 2017-2-21下午6:36:57
 */
public interface UnitDepartmentService {
	/**
	 * 获取单位部门
	 */
	public JSONObject list(String unitCode, HashMap<String, Object> paramMap);

	/**
	 * 新增单位部门
	 */
	public JSONObject add(String unitCode, HashMap<String, Object> paramMap);

	/**
	 * 删除单位部门
	 */
	public JSONObject del(String unitCode, String departmentCode);

	/**
	 * 获取查单位部门
	 */
	public JSONObject findOne(String unitCode, String departmentCode);

	/**
	 * 更新查单位部门
	 */
	public JSONObject edit(String unitCode, String departmentCode,HashMap<String, Object> paramMap);

}
