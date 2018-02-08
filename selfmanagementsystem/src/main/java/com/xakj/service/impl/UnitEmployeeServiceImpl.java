package com.xakj.service.impl;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.xakj.constant.Constant;
import com.xakj.service.UnitEmployeeService;
import com.xakj.util.HttpClientUtil;
import com.xiaoleilu.hutool.http.HttpException;
import com.xiaoleilu.hutool.http.HttpRequest;

import net.sf.json.JSONObject;

@Component
public class UnitEmployeeServiceImpl implements UnitEmployeeService {

	/**
	 * 分页获取单位员工
	 */
	@Override
	public JSONObject list(HashMap<String, Object> paramMap){
		String url = Constant.SERVERURL + "/unit/"+paramMap.get("unitCode")+"/unitEmployee";	
		paramMap.remove("departmentCode");
		return HttpClientUtil.get(url, HttpClientUtil.getToken(), paramMap);
	};
	
	/**
	 * 获取所有员工
	 */
	@Override
	public JSONObject all(HashMap<String, Object> paramMap){
		String url = Constant.SERVERURL + "/unit/allEmployee";	
		return HttpClientUtil.get(url, HttpClientUtil.getToken(), new HashMap<String, Object>());
	};
	
	/**
	 * 获取单位部门员工
	 */
	@Override
	public JSONObject department_list(HashMap<String, Object> paramMap){
		String url = Constant.SERVERURL + "/unit/"+paramMap.get("unitCode")+"/unitDepartment/"+paramMap.get("departmentCode")+"/unitEmployee";	
		return HttpClientUtil.get(url, HttpClientUtil.getToken(), paramMap);
	};
	
	/**
	 * 新增单位员工
	 */
	@Override
	public JSONObject add(HashMap<String, Object> paramMap){
		String url = Constant.SERVERURL + "/unit/"+paramMap.get("unitCode")+"/unitDepartment/"+paramMap.get("departmentCode")+"/unitEmployee";	
		return HttpClientUtil.postByBody(url, HttpClientUtil.getToken(), paramMap);
	};
	
	/**
	 * 删除单位员工
	 */
	@Override
	public JSONObject del(HashMap<String, Object> paramMap){
		String url = Constant.SERVERURL + "/unit/"+paramMap.get("unitCode")+"/unitDepartment/"+paramMap.get("departmentCode")+"/unitEmployee/"+paramMap.get("employeeCode");
		return HttpClientUtil.delete(url, HttpClientUtil.getToken(),  new HashMap<String, Object>());
	};

	/**
	 * 更新单位员工
	 */
	@Override
	public JSONObject edit(HashMap<String, Object> paramMap){
		String url = Constant.SERVERURL + "/unit/"+paramMap.get("unitCode")+"/unitDepartment/"+paramMap.get("departmentCode")+"/unitEmployee/"+paramMap.get("employeeCode");
		paramMap.remove("departmentCode");
		paramMap.remove("employeeCode");
		return HttpClientUtil.putByBody(url, HttpClientUtil.getToken(), paramMap);
	};
	
	/**
	 * 查看单位员工
	 */
	@Override
	public JSONObject details(HashMap<String, Object> paramMap){
		String url = Constant.SERVERURL + "/unit/"+paramMap.get("unitCode")+"/unitDepartment/"+paramMap.get("departmentCode")+"/unitEmployee/"+paramMap.get("employeeCode");
		return HttpClientUtil.get(url, HttpClientUtil.getToken(), new HashMap<String, Object>());
	}
}
