package com.xakj.service.impl;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.xakj.constant.Constant;
import com.xakj.service.FireFacilitieService;
import com.xakj.util.HttpClientUtil;

import net.sf.json.JSONObject;

@Component
public class FireFacilitieServiceImpl implements FireFacilitieService {

	@Override
	public JSONObject list(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/fireFacilitie";	
		return HttpClientUtil.get(url, HttpClientUtil.getToken(), paramMap);		
	}

	@Override
	public JSONObject setFire(String jsonString) {
		String url = Constant.SERVERURL + "/fireFacilitie";	
		return HttpClientUtil.postByBodyForJson(url, HttpClientUtil.getToken(), jsonString);		
	}
	
	@Override
	public JSONObject listType(String facilitieCode,HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/fireFacilitie/"+facilitieCode+"/fireFacilitieSystem";
		return HttpClientUtil.get(url, HttpClientUtil.getToken(), paramMap);
	}
	
	
	@Override
	public JSONObject add(String facilitieCode,HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/fireFacilitie/"+facilitieCode+"/fireFacilitieSystem";	
		return HttpClientUtil.postByBody(url, HttpClientUtil.getToken(), paramMap);
	}

	@Override
	public JSONObject del(String facilitieCode,String facilitieSystemCode) {
		String url = Constant.SERVERURL + "/fireFacilitie/"+facilitieCode+"/fireFacilitieSystem/"+facilitieSystemCode;
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		return HttpClientUtil.delete(url,  HttpClientUtil.getToken(), paramMap);
	}

	@Override
	public JSONObject findOne(String facilitieCode,String facilitieSystemCode) {
		String url = Constant.SERVERURL + "/fireFacilitie/"+facilitieCode+"/fireFacilitieSystem/"+facilitieSystemCode;		
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		return HttpClientUtil.get(url,  HttpClientUtil.getToken(), paramMap);
	}

	@Override
	public JSONObject edit(String facilitieCode,String facilitieSystemCode,HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/fireFacilitie/"+facilitieCode+"/fireFacilitieSystem/"+facilitieSystemCode;		
		return HttpClientUtil.putByBody(url, HttpClientUtil.getToken(), paramMap);
	}

	
	
	
	
}
