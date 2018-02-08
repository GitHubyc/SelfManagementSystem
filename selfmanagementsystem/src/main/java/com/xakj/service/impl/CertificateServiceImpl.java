package com.xakj.service.impl;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.xakj.constant.Constant;
import com.xakj.service.CertificateService;
import com.xakj.util.HttpClientUtil;

import net.sf.json.JSONObject;

@Component
public class CertificateServiceImpl implements CertificateService {

	@Override
	public JSONObject list(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/certificate";	
		return HttpClientUtil.get(url, HttpClientUtil.getToken(), paramMap);
	}

	@Override
	public JSONObject add(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/certificate";	
		return HttpClientUtil.postByBody(url, HttpClientUtil.getToken(), paramMap);
	}

	@Override
	public JSONObject del(String certificateCode) {
		String url = Constant.SERVERURL + "/certificate/"+certificateCode;	
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		return HttpClientUtil.postByBody(url, HttpClientUtil.getToken(), paramMap);
	}

	@Override
	public JSONObject edit(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/certificate";	
		return HttpClientUtil.putByBody(url, HttpClientUtil.getToken(), paramMap);
	}

	@Override
	public JSONObject findOne(String certificateCode) {
		String url = Constant.SERVERURL + "/certificate/"+certificateCode;	
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		return HttpClientUtil.get(url, HttpClientUtil.getToken(), paramMap);
	}

}
