package com.xakj.service.impl;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.xakj.constant.Constant;
import com.xakj.service.BuildInfoService;
import com.xakj.util.HttpClientUtil;
import net.sf.json.JSONObject;

@Component
public class BuildInfoServiceImpl implements BuildInfoService {

	@Override
	public JSONObject list(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/build";	
		return HttpClientUtil.get(url, HttpClientUtil.getToken(), paramMap);
		
	}

	@Override
	public JSONObject add(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/build";		
		return HttpClientUtil.postByBody(url, HttpClientUtil.getToken(), paramMap);
	}

	@Override
	public JSONObject edit(String buildCode,HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/build/"+buildCode;		
		return HttpClientUtil.putByBody(url, HttpClientUtil.getToken(), paramMap);
	}

	@Override
	public JSONObject del(String buildCode) {
		String url = Constant.SERVERURL + "/build/"+buildCode;		
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		return HttpClientUtil.delete(url,  HttpClientUtil.getToken(), paramMap);
	}

	@Override
	public JSONObject findOne(String buildCode) {
		String url = Constant.SERVERURL + "/build/"+buildCode;		
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		return HttpClientUtil.get(url,  HttpClientUtil.getToken(), paramMap);
	}

	@Override
	public JSONObject set(String buildCode, String plcBuildCode) {
		String url = Constant.SERVERURL + "/build/"+buildCode+"/plcbuild/"+plcBuildCode;
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		return HttpClientUtil.get(url,  HttpClientUtil.getToken(), paramMap);
	}

	@Override
	public JSONObject getBuildname(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/builds/like";
		return HttpClientUtil.get(url,  HttpClientUtil.getToken(), paramMap);
	}

	@Override
	public JSONObject unitAndBuildList(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/build/list/unitCode";
		return HttpClientUtil.get(url,  HttpClientUtil.getToken(), paramMap);
	}
	
	
	
	
}
