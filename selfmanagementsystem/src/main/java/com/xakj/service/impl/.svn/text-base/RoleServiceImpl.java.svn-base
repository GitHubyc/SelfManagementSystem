package com.xakj.service.impl;


import java.util.HashMap;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Component;

import com.xakj.constant.Constant;
import com.xakj.service.RoleService;
import com.xakj.util.HttpClientUtil;

@Component
public class RoleServiceImpl implements RoleService {

	/**
	 * 获取角色
	 */
	@Override
	public JSONObject list(HashMap<String, Object> paramMap){
		String url = Constant.SERVERURL + "/role";		
		return HttpClientUtil.get(url, HttpClientUtil.getToken(), paramMap);
	};
	
	/**
	 * 获取所有角色
	 */
	@Override
	public JSONObject all(HashMap<String, Object> paramMap){
		String url = Constant.SERVERURL + "/role/allrole";		
		return HttpClientUtil.get(url, HttpClientUtil.getToken(), new HashMap<String, Object>());
	};
	
	/**
	 * 新增角色
	 */
	@Override
	public JSONObject add(HashMap<String, Object> paramMap){
		String url = Constant.SERVERURL + "/role";		
		return HttpClientUtil.postByBody(url, HttpClientUtil.getToken(), paramMap);
	};
	
	/**
	 * 删除角色
	 */
	@Override
	public JSONObject del(HashMap<String, Object> paramMap){
		String url = Constant.SERVERURL + "/role/"+paramMap.get("roleId");		
		return HttpClientUtil.delete(url, HttpClientUtil.getToken(), paramMap);
	};

	/**
	 * 更新角色
	 */
	@Override
	public JSONObject edit(HashMap<String, Object> paramMap){
		String url = Constant.SERVERURL + "/role/"+paramMap.get("roleId");	
		paramMap.remove("roleId");
		return HttpClientUtil.putByBody(url, HttpClientUtil.getToken(), paramMap);
	};
	
	/**
	 * 查看角色
	 */
	@Override
	public JSONObject details(HashMap<String, Object> paramMap){
		String url = Constant.SERVERURL + "/role/"+paramMap.get("roleId");		
		return HttpClientUtil.get(url, HttpClientUtil.getToken(), paramMap);
	}

	/**
	 * 查询角色权限
	 */
	@Override
	public JSONObject roleRight(HashMap<String, Object> paramMap){
		String url = Constant.SERVERURL + "/role/"+paramMap.get("roleId")+"/right";		
		return HttpClientUtil.get(url, HttpClientUtil.getToken(), paramMap);
	}
	
	/**
	 * 添加角色权限
	 */
	@Override
	public JSONObject addRoleRight(HashMap<String, Object> paramMap){
		String url = Constant.SERVERURL + "/role/"+paramMap.get("roleId")+"/saverright";	
		paramMap.remove("roleId");
		return HttpClientUtil.postByBodyForJson(url, HttpClientUtil.getToken(), paramMap.get("roleAndRightDto").toString());
	}
}