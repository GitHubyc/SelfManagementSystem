package com.xakj.service.impl;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.xakj.constant.Constant;
import com.xakj.service.UnitDepartmentService;
import com.xakj.util.HttpClientUtil;

import net.sf.json.JSONObject;

@Component
public class UnitDepartmentServiceImpl implements UnitDepartmentService {

	@Override
	public JSONObject list(String unitCode, HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/unit/"+unitCode+"/unitDepartall";	
		return HttpClientUtil.get(url, HttpClientUtil.getToken(), new HashMap<String, Object>());
	}

	@Override
	public JSONObject add(String unitCode, HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/unit/"+unitCode+"/unitDepartment";	
		return HttpClientUtil.postByBody(url, HttpClientUtil.getToken(), paramMap);
	}

	@Override
	public JSONObject del(String unitCode, String departmentCode) {
		String url = Constant.SERVERURL + "/unit/"+unitCode+"/unitDepartment/"+departmentCode;	
		return HttpClientUtil.delete(url, HttpClientUtil.getToken(), new HashMap<String, Object>());
	}

	@Override
	public JSONObject findOne(String unitCode, String departmentCode) {
		String url = Constant.SERVERURL + "/unit/"+unitCode+"/unitDepartment/"+departmentCode;	
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		return HttpClientUtil.get(url, HttpClientUtil.getToken(), paramMap);
	}

	@Override
	public JSONObject edit(String unitCode, String departmentCode,HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/unit/"+unitCode+"/unitDepartment/"+departmentCode;	
		return HttpClientUtil.putByBody(url, HttpClientUtil.getToken(), paramMap);
	}
	
	

}
