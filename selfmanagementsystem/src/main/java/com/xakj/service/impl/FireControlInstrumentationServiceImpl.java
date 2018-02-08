package com.xakj.service.impl;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import net.sf.json.JSONObject;

import com.xakj.constant.Constant;
import com.xakj.service.FireControlInstrumentationService;
import com.xakj.util.HttpClientUtil;

@Component
public class FireControlInstrumentationServiceImpl implements
		FireControlInstrumentationService {

	@Override
	public JSONObject sensorTypeList(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/sensorType/list";
		return HttpClientUtil.get(url, HttpClientUtil.getToken(), paramMap);
	}
	
	@Override
	public JSONObject spotTypeList(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/spotType/list";
		return HttpClientUtil.get(url, HttpClientUtil.getToken(), paramMap);
	}

	@Override
	public JSONObject sensorInfoList(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/sensorInfo/list";
		return HttpClientUtil.get(url, HttpClientUtil.getToken(), paramMap);
	}

	@Override
	public JSONObject sensorInfoListByUnitCode(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/sensorInfo/listByUnitCode";
		return HttpClientUtil.get(url, HttpClientUtil.getToken(), paramMap);
	}

	@Override
	public JSONObject getFrontEndComputerByUnitId(
			HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/frontEndComputer/list";
		return HttpClientUtil.get(url, HttpClientUtil.getToken(), paramMap);
	}

	@Override
	public JSONObject saveFrontEndComputer(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/frontEndComputer/";
		return HttpClientUtil.postByBody(url, HttpClientUtil.getToken(),
				paramMap);
	}

	@Override
	public JSONObject deleteFrontEndComputer(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/frontEndComputer/"
				+ paramMap.get("id");
		return HttpClientUtil.delete(url, HttpClientUtil.getToken(), paramMap);
	}

	@Override
	public JSONObject updateFrontEndComputer(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/frontEndComputer/";
		return HttpClientUtil.putByBody(url, HttpClientUtil.getToken(),
				paramMap);
	}

	@Override
	public JSONObject getFrontEndComputer(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/frontEndComputer/"
				+ paramMap.get("id");
		return HttpClientUtil.get(url, HttpClientUtil.getToken(), paramMap);
	}

	@Override
	public JSONObject saveSensor(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/sensorInfo/";
		return HttpClientUtil.postByBody(url, HttpClientUtil.getToken(),
				paramMap);
	}

	@Override
	public JSONObject deleteSensor(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/sensorInfo/" + paramMap.get("id");
		return HttpClientUtil.delete(url, HttpClientUtil.getToken(), paramMap);
	}

	@Override
	public JSONObject updateSensor(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/sensorInfo/";
		return HttpClientUtil.putByBody(url, HttpClientUtil.getToken(),
				paramMap);
	}

	@Override
	public JSONObject getSensor(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/sensorInfo/" + paramMap.get("id");
		return HttpClientUtil.get(url, HttpClientUtil.getToken(), paramMap);
	}
	
	@Override
	public JSONObject listFireengine(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/fireEngine/list";
		return HttpClientUtil.get(url, HttpClientUtil.getToken(),
				paramMap);
	}

	@Override
	public JSONObject saveFireengine(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/fireEngine/";
		return HttpClientUtil.postByBody(url, HttpClientUtil.getToken(),
				paramMap);
	}

	@Override
	public JSONObject deleteFireengine(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/fireEngine/" + paramMap.get("id");
		return HttpClientUtil.delete(url, HttpClientUtil.getToken(), paramMap);
	}

	@Override
	public JSONObject updateFireengine(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/fireEngine/";
		return HttpClientUtil.putByBody(url, HttpClientUtil.getToken(),
				paramMap);
	}

	@Override
	public JSONObject getFireengine(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/fireEngine/" + paramMap.get("id");
		return HttpClientUtil.get(url, HttpClientUtil.getToken(), paramMap);
	}

	@Override
	public JSONObject saveSpotpoint(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/spotPoint/";
		return HttpClientUtil.postByBody(url, HttpClientUtil.getToken(),
				paramMap);
	}

	@Override
	public JSONObject deleteSpotpoint(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/spotPoint/" + paramMap.get("id");
		return HttpClientUtil.delete(url, HttpClientUtil.getToken(), paramMap);
	}

	@Override
	public JSONObject updateSpotpoint(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/spotPoint/";
		return HttpClientUtil.putByBody(url, HttpClientUtil.getToken(),
				paramMap);
	}

	@Override
	public JSONObject getSpotpoint(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/spotPoint/" + paramMap.get("id");
		return HttpClientUtil.get(url, HttpClientUtil.getToken(), paramMap);
	}

	@Override
	public JSONObject listSpotpoint(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/spotPoint/list";
		return HttpClientUtil.get(url, HttpClientUtil.getToken(),
				paramMap);
	}

	@Override
	public JSONObject spotpointListByUnitCode(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/spotPoint/listByUnitCode";
		return HttpClientUtil.get(url, HttpClientUtil.getToken(), paramMap);
	}

}
