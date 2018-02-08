package com.xakj.service;

import java.util.HashMap;

import net.sf.json.JSONObject;

/**
 * 消防物联模块
 */
public interface FireControlInstrumentationService {

	/**
	 * 获取传感器类型
	 */
	public JSONObject sensorTypeList(HashMap<String, Object> paramMap);

	/**
	 * 根据建筑ID获取传感器列表
	 */
	public JSONObject sensorInfoList(HashMap<String, Object> paramMap);

	/**
	 * 根据单位ID获取传感器列表
	 */
	public JSONObject sensorInfoListByUnitCode(HashMap<String, Object> paramMap);
	
	/**
	 * 根据单位ID获取前置机列表
	 */
	public JSONObject getFrontEndComputerByUnitId(
			HashMap<String, Object> paramMap);

	/**
	 * 新增前置机
	 */
	public JSONObject saveFrontEndComputer(HashMap<String, Object> paramMap);

	/**
	 * 删除前置机
	 */
	public JSONObject deleteFrontEndComputer(HashMap<String, Object> paramMap);

	/**
	 * 更新前置机
	 */
	public JSONObject updateFrontEndComputer(HashMap<String, Object> paramMap);

	/**
	 * 查看前置机
	 */
	public JSONObject getFrontEndComputer(HashMap<String, Object> paramMap);

	/**
	 * 新增传感器
	 */
	public JSONObject saveSensor(HashMap<String, Object> paramMap);

	/**
	 * 删除传感器
	 */
	public JSONObject deleteSensor(HashMap<String, Object> paramMap);

	/**
	 * 更新传感器
	 */
	public JSONObject updateSensor(HashMap<String, Object> paramMap);

	/**
	 * 查看传感器
	 */
	public JSONObject getSensor(HashMap<String, Object> paramMap);

	/**
	 * 新增消防主机
	 */
	public JSONObject saveFireengine(HashMap<String, Object> paramMap);

	/**
	 * 删除消防主机
	 */
	public JSONObject deleteFireengine(HashMap<String, Object> paramMap);

	/**
	 * 更新消防主机
	 */
	public JSONObject updateFireengine(HashMap<String, Object> paramMap);

	/**
	 * 查看消防主机
	 */
	public JSONObject getFireengine(HashMap<String, Object> paramMap);

	/**
	 * 查看消防主机列表
	 */
	public JSONObject listFireengine(HashMap<String, Object> paramMap);

	/**
	 * 新增消防主机
	 */
	public JSONObject saveSpotpoint(HashMap<String, Object> paramMap);

	/**
	 * 删除消防主机
	 */
	public JSONObject deleteSpotpoint(HashMap<String, Object> paramMap);

	/**
	 * 更新消防主机
	 */
	public JSONObject updateSpotpoint(HashMap<String, Object> paramMap);

	/**
	 * 查看消防主机
	 */
	public JSONObject getSpotpoint(HashMap<String, Object> paramMap);

	/**
	 * 查看消防主机列表
	 */
	public JSONObject listSpotpoint(HashMap<String, Object> paramMap);

	/**
	 * 所有探点类型
	 */
	JSONObject spotTypeList(HashMap<String, Object> paramMap);
	
	/**
	 * 根据单位ID获取探点列表
	 */
	public JSONObject spotpointListByUnitCode(HashMap<String, Object> paramMap);

}
