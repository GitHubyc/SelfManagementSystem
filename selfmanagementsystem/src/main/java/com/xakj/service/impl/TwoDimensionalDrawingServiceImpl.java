package com.xakj.service.impl;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.xakj.constant.Constant;
import com.xakj.service.TwoDimensionalDrawingService;
import com.xakj.util.HttpClientUtil;

import net.sf.json.JSONObject;

@Component
public class TwoDimensionalDrawingServiceImpl implements TwoDimensionalDrawingService {

	@Override
	public JSONObject list(String buildCode,String floorCode,HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/build/"+buildCode+"/floor/"+floorCode+"/twoDimensionalDrawing";	
		return HttpClientUtil.get(url, HttpClientUtil.getToken(), paramMap);
	}

	@Override
	public JSONObject add(String buildCode,String floorCode,HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/build/"+buildCode+"/floor/"+floorCode+"/twoDimensionalDrawing";	
		return HttpClientUtil.postByBody(url, HttpClientUtil.getToken(), paramMap);
	}

	@Override
	public JSONObject del(String buildCode,String floorCode,String drawingCode) {
		String url = Constant.SERVERURL + "/build/"+buildCode+"/floor/"+floorCode+"/twoDimensionalDrawing/"+drawingCode;	
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		return HttpClientUtil.postByBody(url, HttpClientUtil.getToken(), paramMap);
	}

	@Override
	public JSONObject findOne(String buildCode,String floorCode,String drawingCode) {
		String url = Constant.SERVERURL + "/build/"+buildCode+"/floor/"+floorCode+"/twoDimensionalDrawing/"+drawingCode;	
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		return HttpClientUtil.get(url, HttpClientUtil.getToken(), paramMap);
	}

	@Override
	public JSONObject edit(String buildCode,String floorCode,String drawingCode,HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/build/"+buildCode+"/floor/"+floorCode+"/twoDimensionalDrawing/"+drawingCode;	
		return HttpClientUtil.putByBody(url, HttpClientUtil.getToken(), paramMap);
	}

	@Override
	public JSONObject save(String buildCode, String floorCode, HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/build/"+buildCode+"/floor/"+floorCode+"/two";
		return HttpClientUtil.postByBody(url, HttpClientUtil.getToken(), paramMap);
	}

	
	
	
	
}
