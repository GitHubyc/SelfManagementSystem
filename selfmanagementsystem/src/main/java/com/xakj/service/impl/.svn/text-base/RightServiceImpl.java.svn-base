package com.xakj.service.impl;


import java.util.HashMap;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;

import com.xakj.constant.Constant;
import com.xakj.service.RightService;
import com.xakj.util.HttpClientUtil;

@Service
public class RightServiceImpl implements RightService {

	/**
	 * 获取权限
	 */
	@Override
	public JSONObject list(HashMap<String, Object> paramMap){
		String url = Constant.SERVERURL + "/right";		
		return HttpClientUtil.get(url, HttpClientUtil.getToken(), paramMap);
	};
	
	/**
	 * 新增权限
	 */
	@Override
	public JSONObject add(HashMap<String, Object> paramMap){
		String url = Constant.SERVERURL + "/right";		
		return HttpClientUtil.postByBody(url, HttpClientUtil.getToken(), paramMap);
	};
	
	/**
	 * 删除权限
	 */
	@Override
	public JSONObject del(HashMap<String, Object> paramMap){
		String url = Constant.SERVERURL + "/right/"+paramMap.get("rightId");				
		return HttpClientUtil.delete(url, HttpClientUtil.getToken(), paramMap);
	};

	/**
	 * 更新权限
	 */
	@Override
	public JSONObject edit(HashMap<String, Object> paramMap){
		String url = Constant.SERVERURL + "/right/"+paramMap.get("rightId");
		paramMap.remove("rightId");	
		return HttpClientUtil.putByBody(url, HttpClientUtil.getToken(), paramMap);
	};
	
	/**
	 * 查看权限
	 */
	@Override
	public JSONObject details(HashMap<String, Object> paramMap){
		String url = Constant.SERVERURL + "/right/"+paramMap.get("rightId");		
		return HttpClientUtil.get(url, HttpClientUtil.getToken(), paramMap);
	}
}