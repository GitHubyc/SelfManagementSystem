package com.xakj.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.stereotype.Component;

import net.sf.json.JSONObject;

import com.xakj.constant.Constant;
import com.xakj.model.dto.User;
import com.xakj.service.AutomaticFireAlarmSystemService;
import com.xakj.util.HttpClientUtil;

/**
 *描述:火灾自动报警系统
 *作者:袁文彪
 *时间:2017-08-09 14:14:08
 */
@Component
public class AutomaticFireAlarmSystemServiceImpl implements AutomaticFireAlarmSystemService{

	@Override
	public JSONObject list(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/automaticfirealarmsystem/list";
		return HttpClientUtil.postByBody(url, HttpClientUtil.getToken(), paramMap);
	}

	@Override
	public long add(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/automaticfirealarmsystem/add";
		HttpClientUtil.postByForm(url, HttpClientUtil.getToken(), paramMap);
		return 0;
	}

	@Override
	public long del(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long edit(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long details(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return 0;
	}

}
