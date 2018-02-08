package com.xakj.service.impl;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.xakj.constant.Constant;
import com.xakj.service.PopulationService;
import com.xakj.util.HttpClientUtil;

import net.sf.json.JSONObject;

@Component
public class PopulationServiceImpl implements PopulationService {

	@Override
	public JSONObject list(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/population";
		return HttpClientUtil.get(url, HttpClientUtil.getToken(), paramMap);
	}
	@Override
	public JSONObject edit(String buildCode, HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/population";
		return HttpClientUtil.postByBody(url, HttpClientUtil.getToken(), paramMap);
	}

	@Override
	public JSONObject add(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/population";
		return HttpClientUtil.postByBody(url, HttpClientUtil.getToken(), paramMap);
	}

	@Override
	public JSONObject del(String populationCode) {
		String url = Constant.SERVERURL + "/population/" + populationCode;
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		return HttpClientUtil.delete(url, HttpClientUtil.getToken(), paramMap);
	}

	@Override
	public JSONObject findOne(String populationCode) {
		String url = Constant.SERVERURL + "/population/" + populationCode;
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		return HttpClientUtil.get(url, HttpClientUtil.getToken(), paramMap);
	}


}
