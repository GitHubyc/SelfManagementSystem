package com.xakj.service.impl;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.xakj.constant.Constant;
import com.xakj.service.UnitBuildService;
import com.xakj.util.HttpClientUtil;

import net.sf.json.JSONObject;

@Component
public class UnitBuildServiceImpl implements UnitBuildService {
	
	@Override
	public JSONObject list(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/unitBuild";	
		return HttpClientUtil.get(url, HttpClientUtil.getToken(), paramMap);
		
	}

	@Override
	public JSONObject add(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/unitBuild";	
		return HttpClientUtil.postByBody(url, HttpClientUtil.getToken(), paramMap);
	}



	@Override
	public JSONObject del(String unitBuildCode) {
		String url = Constant.SERVERURL + "/unitBuild/"+unitBuildCode;		
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		return HttpClientUtil.delete(url,  HttpClientUtil.getToken(), paramMap);
	}

	@Override
	public JSONObject setbuildCode(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/unitBuild/buildCode";
		return HttpClientUtil.get(url,  HttpClientUtil.getToken(), paramMap);
	}
	@Override
	public JSONObject set(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/unitBuild/unitCode";
		return HttpClientUtil.get(url,  HttpClientUtil.getToken(), paramMap);
	}

	@Override
	public JSONObject findOne(String unitBuildCode) {	
		String url = Constant.SERVERURL + "/unitBuild/"+unitBuildCode;		
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		return HttpClientUtil.get(url,  HttpClientUtil.getToken(), paramMap);	
	}
	

}
