package com.xakj.service.impl;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.xakj.constant.Constant;
import com.xakj.service.HouseInfoService;
import com.xakj.util.HttpClientUtil;

import net.sf.json.JSONObject;

@Component
public class HouseInfoServiceImpl implements HouseInfoService {

	@Override
	public JSONObject list(String buildCode,String floorCode,HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/build/"+ buildCode+"/floor/"+floorCode+"/house";
		return HttpClientUtil.get(url,  HttpClientUtil.getToken(), paramMap);
	}

	@Override
	public JSONObject add(String buildCode,String floorCode,HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/build/"+ buildCode+"/floor/"+floorCode+"/house";
		return HttpClientUtil.postByBody(url,  HttpClientUtil.getToken(), paramMap);
	}

	@Override
	public JSONObject del(String buildCode,String floorCode,String houseCode) {
		String url = Constant.SERVERURL + "/build/"+ buildCode+"/floor/"+floorCode+"/house/"+houseCode;
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		return HttpClientUtil.delete(url,  HttpClientUtil.getToken(), paramMap);
	}

	@Override
	public JSONObject findOne(String buildCode,String floorCode,String houseCode) {
		String url = Constant.SERVERURL + "/build/"+ buildCode+"/floor/"+floorCode+"/house/"+houseCode;
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		return HttpClientUtil.get(url,  HttpClientUtil.getToken(), paramMap);
	}

	@Override
	public JSONObject edit(String buildCode,String floorCode,String houseCode, HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/build/"+ buildCode+"/floor/"+floorCode+"/house/"+houseCode;
		return HttpClientUtil.putByBody(url,  HttpClientUtil.getToken(), paramMap);
	}



	
}
