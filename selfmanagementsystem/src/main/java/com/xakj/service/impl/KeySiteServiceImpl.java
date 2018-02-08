package com.xakj.service.impl;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.xakj.constant.Constant;
import com.xakj.service.KeySiteService;
import com.xakj.util.HttpClientUtil;

import net.sf.json.JSONObject;

@Component
public class KeySiteServiceImpl implements KeySiteService {

	@Override
	public JSONObject list(String buildCode, String floorCode, HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/build/"+buildCode+"/floor/"+floorCode+"/keySite";	
		return HttpClientUtil.get(url, HttpClientUtil.getToken(), paramMap);
	}

	@Override
	public JSONObject add(String buildCode, String floorCode, HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/build/"+buildCode+"/floor/"+floorCode+"/keySite";	
		return HttpClientUtil.postByBody(url, HttpClientUtil.getToken(), paramMap);
	}

	@Override
	public JSONObject del(String buildCode, String floorCode, String keySiteCode) {
		String url = Constant.SERVERURL + "/build/"+buildCode+"/floor/"+floorCode+"/keySite/"+keySiteCode;	
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		return HttpClientUtil.delete(url, HttpClientUtil.getToken(), paramMap);
	}

	@Override
	public JSONObject findOne(String buildCode, String floorCode, String keySiteCode) {
		String url = Constant.SERVERURL + "/build/"+buildCode+"/floor/"+floorCode+"/keySite/"+keySiteCode;	
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		return HttpClientUtil.get(url, HttpClientUtil.getToken(), paramMap);
	}

	@Override
	public JSONObject edit(String buildCode, String floorCode, String keySiteCode, HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/build/"+buildCode+"/floor/"+floorCode+"/keySite/"+keySiteCode;	
		return HttpClientUtil.putByBody(url, HttpClientUtil.getToken(), paramMap);
	}

	
	
}
