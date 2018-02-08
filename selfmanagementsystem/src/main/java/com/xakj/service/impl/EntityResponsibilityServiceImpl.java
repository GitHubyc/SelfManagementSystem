package com.xakj.service.impl;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.xakj.constant.Constant;
import com.xakj.service.EntityResponsibilityService;
import com.xakj.util.HttpClientUtil;

import net.sf.json.JSONObject;

@Component
public class EntityResponsibilityServiceImpl implements EntityResponsibilityService {
	
	@Override
	public JSONObject list(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/build/"+ paramMap.get("buildCode")+"/entityResponsibility";	
		return HttpClientUtil.get(url, HttpClientUtil.getToken(), paramMap);
		
	}

	@Override
	public JSONObject add(String buildCode, HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/build/"+ buildCode+"/entityResponsibility";	
		return HttpClientUtil.postByBody(url, HttpClientUtil.getToken(), paramMap);
	}

	@Override
	public JSONObject edit(String buildCode,String responsibilityCode,HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/build/"+buildCode+"/entityResponsibility/"+responsibilityCode;		
		return HttpClientUtil.putByBody(url, HttpClientUtil.getToken(), paramMap);
	}

	@Override
	public JSONObject del(String buildCode,String responsibilityCode) {
		String url = Constant.SERVERURL + "/build/"+buildCode+"/entityResponsibility/"+responsibilityCode;		
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		return HttpClientUtil.delete(url,  HttpClientUtil.getToken(), paramMap);
	}

	@Override
	public JSONObject findOne(String buildCode,String responsibilityCode) {
		String url = Constant.SERVERURL + "/build/"+buildCode+"/entityResponsibility/"+responsibilityCode;		
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		return HttpClientUtil.get(url,  HttpClientUtil.getToken(), paramMap);
	}

	@Override
	public JSONObject set(String buildCode) {
		String url = Constant.SERVERURL + "/build/"+buildCode+"/entityResponsibility/responsibility";		
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		return HttpClientUtil.get(url,  HttpClientUtil.getToken(), paramMap);
	
	}
	

}
