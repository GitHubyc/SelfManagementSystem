package com.xakj.service;

import java.util.HashMap;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Component;

@Component
public interface BuildResponsibilityService {
	/**
	 * 获取数据
	 */
	public JSONObject list(HashMap<String, Object> paramMap);
}
