package com.xakj.service.impl;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.xakj.constant.Constant;
import com.xakj.service.FloorInfoService;
import com.xakj.util.HttpClientUtil;

import net.sf.json.JSONObject;

@Component
public class FloorInfoServiceImpl implements FloorInfoService {

	@Override
	public JSONObject list(String buildCode, HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/build/" + buildCode + "/floor";
		return HttpClientUtil.get(url, HttpClientUtil.getToken(), paramMap);

	}
	

	@Override
	public JSONObject add(String buildCode, HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/build/" + buildCode + "/floor";
		return HttpClientUtil.postByBody(url, HttpClientUtil.getToken(), paramMap);
	}

	@Override
	public JSONObject edit(String buildCode, String floorCode, HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/build/" + buildCode + "/floor/" + floorCode;
		return HttpClientUtil.putByBody(url, HttpClientUtil.getToken(), paramMap);
	}

	@Override
	public JSONObject del(String buildCode, String floorCode) {
		String url = Constant.SERVERURL + "/build/" + buildCode + "/floor/" + floorCode;
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		return HttpClientUtil.delete(url, HttpClientUtil.getToken(), paramMap);
	}

	@Override
	public JSONObject findOne(String buildCode, String floorCode) {
		String url = Constant.SERVERURL + "/build/" + buildCode + "/floor/" + floorCode;
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		return HttpClientUtil.delete(url, HttpClientUtil.getToken(), paramMap);
	}

}
