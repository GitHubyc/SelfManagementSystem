package com.xakj.service.impl;


import java.util.HashMap;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;

import com.xakj.constant.Constant;
import com.xakj.service.ApplyService;
import com.xakj.util.HttpClientUtil;

@Service
public class ApplyServiceImpl implements ApplyService {

	/**
	 * 获取应用
	 */
	@Override
	public JSONObject list(HashMap<String, Object> paramMap){
		String url = Constant.SERVERURL + "/apply";		
		return HttpClientUtil.get(url, HttpClientUtil.getToken(), paramMap);
	};
	
	/**
	 * 新增应用
	 */
	@Override
	public JSONObject add(HashMap<String, Object> paramMap){
		String url = Constant.SERVERURL + "/apply";		
		return HttpClientUtil.postByBody(url, HttpClientUtil.getToken(), paramMap);
	};
	
	/**
	 * 删除应用
	 */
	@Override
	public JSONObject del(HashMap<String, Object> paramMap){
		String url = Constant.SERVERURL + "/apply/"+paramMap.get("applyId");				
		return HttpClientUtil.delete(url, HttpClientUtil.getToken(), paramMap);
	};

	/**
	 * 更新应用
	 */
	@Override
	public JSONObject edit(HashMap<String, Object> paramMap){
		String url = Constant.SERVERURL + "/apply/"+paramMap.get("applyId");
		paramMap.remove("applyId");	
		return HttpClientUtil.putByBody(url, HttpClientUtil.getToken(), paramMap);
	};
	
	/**
	 * 查看应用
	 */
	@Override
	public JSONObject details(HashMap<String, Object> paramMap){
		String url = Constant.SERVERURL + "/apply/"+paramMap.get("applyId");		
		return HttpClientUtil.get(url, HttpClientUtil.getToken(), paramMap);
	}
}