package com.xakj.service.impl;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.xakj.constant.Constant;
import com.xakj.service.WorkService;
import com.xakj.util.HttpClientUtil;

import net.sf.json.JSONObject;

@Component
public class WorkServiceImpl implements WorkService {

	@Override
	public JSONObject list(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/work";	
		return HttpClientUtil.get(url, HttpClientUtil.getToken(), paramMap);
	}

	@Override
	public JSONObject add(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/work";
		return HttpClientUtil.postByBody(url, HttpClientUtil.getToken(), paramMap);
	}

	@Override
	public JSONObject edit(String buildCode, HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/work";
		return HttpClientUtil.putByBody(url, HttpClientUtil.getToken(), paramMap);
	}
	
	@Override
	public JSONObject del(String workCode) {
		String url = Constant.SERVERURL + "/work/"+workCode;
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		return HttpClientUtil.delete(url, HttpClientUtil.getToken(), paramMap);
	}

	

	
}
