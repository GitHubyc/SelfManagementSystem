package com.xakj.service.impl;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.xakj.constant.Constant;
import com.xakj.service.UnitInfoService;
import com.xakj.util.HttpClientUtil;

import net.sf.json.JSONObject;

@Component
public class UnitInfoServiceImpl implements UnitInfoService {

	/**
	 * 获取单位列表
	 */
	@Override
	public JSONObject list(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/unit";
		return HttpClientUtil.get(url, HttpClientUtil.getToken(), paramMap);
	}

	/**
	 * 获取所有单位
	 */
	@Override
	public JSONObject all(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/unit/getall";
		return HttpClientUtil.get(url, HttpClientUtil.getToken(), paramMap);
	}
	
	@Override
	public JSONObject deladmin(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/administrativeUnit/"
				+ paramMap.get("unitCode");
		return HttpClientUtil.delete(url, HttpClientUtil.getToken(), paramMap);
	}

	@Override
	public JSONObject delCause(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/causeUnit/"
				+ paramMap.get("unitCode");
		return HttpClientUtil.delete(url, HttpClientUtil.getToken(), paramMap);
	}

	@Override
	public JSONObject delEnter(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/enterpriseUnit/"
				+ paramMap.get("unitCode");
		return HttpClientUtil.delete(url, HttpClientUtil.getToken(), paramMap);
	}

	@Override
	public JSONObject delProperty(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/propertyManagementOffice/"
				+ paramMap.get("unitCode");
		return HttpClientUtil.delete(url, HttpClientUtil.getToken(), paramMap);
	}

	/**
	 * 获取单个行政单位
	 */
	@Override
	public JSONObject findadmin(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/administrativeUnit/"
				+ paramMap.get("unitCode");
		return HttpClientUtil.get(url, HttpClientUtil.getToken(), paramMap);
	}

	@Override
	public JSONObject findcause(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/causeUnit/"
				+ paramMap.get("unitCode");
		return HttpClientUtil.get(url, HttpClientUtil.getToken(), paramMap);
	}

	@Override
	public JSONObject findenter(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/enterpriseUnit/"
				+ paramMap.get("unitCode");
		return HttpClientUtil.get(url, HttpClientUtil.getToken(), paramMap);
	}

	@Override
	public JSONObject findproperty(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/propertyManagementOffice/"
				+ paramMap.get("unitCode");
		return HttpClientUtil.get(url, HttpClientUtil.getToken(), paramMap);
	}

	@Override
	public JSONObject addadmin(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/administrativeUnit";
		return HttpClientUtil.postByBody(url, HttpClientUtil.getToken(),
				paramMap);
	}

	@Override
	public JSONObject addCause(String json) {
		String url = Constant.SERVERURL + "/causeUnit";
		return HttpClientUtil.postByBodyForJson(url, HttpClientUtil.getToken(),
				json);
	}

	@Override
	public JSONObject addEnter(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/enterpriseUnit";
		return HttpClientUtil.postByBody(url, HttpClientUtil.getToken(),
				paramMap);
	}

	@Override
	public JSONObject addProperty(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/propertyManagementOffice";
		return HttpClientUtil.postByBody(url, HttpClientUtil.getToken(),
				paramMap);
	}

	@Override
	public JSONObject updateadmin(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/administrativeUnit/"
				+ paramMap.get("unitCode");
		return HttpClientUtil.putByBody(url, HttpClientUtil.getToken(),
				paramMap);
	}

	@Override
	public JSONObject updateCause(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/causeUnit/"
				+ paramMap.get("unitCode");
		return HttpClientUtil.putByBody(url, HttpClientUtil.getToken(),
				paramMap);
	}

	@Override
	public JSONObject updateEnter(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/enterpriseUnit/"
				+ paramMap.get("unitCode");
		return HttpClientUtil.putByBody(url, HttpClientUtil.getToken(),
				paramMap);
	}

	@Override
	public JSONObject updateProperty(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/propertyManagementOffice/"
				+ paramMap.get("unitCode");
		return HttpClientUtil.putByBody(url, HttpClientUtil.getToken(),
				paramMap);
	}

	@Override
	public JSONObject getInfo(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/propertyManagementOffice/xzqhCode";
		return HttpClientUtil.get(url, HttpClientUtil.getToken(),
				paramMap);
	}

}
