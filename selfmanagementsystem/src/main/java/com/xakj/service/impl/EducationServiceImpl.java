package com.xakj.service.impl;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.xakj.constant.Constant;
import com.xakj.service.EducationService;
import com.xakj.util.HttpClientUtil;

import net.sf.json.JSONObject;

@Component
public class EducationServiceImpl implements EducationService {

	@Override
	public JSONObject list(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/education";	
		return HttpClientUtil.get(url, HttpClientUtil.getToken(), paramMap);
	}

	@Override
	public JSONObject add(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/education";	
		return HttpClientUtil.putByBody(url, HttpClientUtil.getToken(), paramMap);
	}

	@Override
	public JSONObject del(String educationCode) {
		String url = Constant.SERVERURL + "/education/"+educationCode;		
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		return HttpClientUtil.delete(url,  HttpClientUtil.getToken(), paramMap);
	}

	@Override
	public JSONObject edit(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/education";	
		return HttpClientUtil.putByBody(url, HttpClientUtil.getToken(), paramMap);
	}

	
}
