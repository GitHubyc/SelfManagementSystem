package com.xakj.service.impl;


import java.util.HashMap;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;

import com.xakj.constant.Constant;
import com.xakj.service.GroupService;
import com.xakj.util.HttpClientUtil;

@Service
public class GroupServiceImpl implements GroupService {
	/**
	 * 获取组
	 */
	@Override
	public JSONObject list(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/group";
		return HttpClientUtil.get(url, HttpClientUtil.getToken(), paramMap);
	}
	
	/**
	 * 获取所有组
	 */
	@Override
	public JSONObject all(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/group/allgroup";
		return HttpClientUtil.get(url, HttpClientUtil.getToken(), new HashMap<String, Object>());
	}
	
	/**
	 * 新增组
	 */
	@Override
	public JSONObject add(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/group";		
		return HttpClientUtil.postByBody(url, HttpClientUtil.getToken(), paramMap);
	}

	/**
	 * 删除组
	 */
	@Override
	public JSONObject del(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/group/" + paramMap.get("groupId");		
		return HttpClientUtil.delete(url, HttpClientUtil.getToken(), paramMap);
	}

	/**
	 * 更新组
	 */
	@Override
	public JSONObject edit(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/group/"+paramMap.get("groupId");				
		return HttpClientUtil.putByBody(url, HttpClientUtil.getToken(), paramMap);
	}

	/**
	 * 查看组
	 */
	@Override
	public JSONObject details(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/group/"+paramMap.get("groupId");		
		return HttpClientUtil.get(url, HttpClientUtil.getToken(), paramMap);
	}

	/**
	 * 查询组用户
	 */
	@Override
	public JSONObject group_user(HashMap<String, Object> paramMap) {
		String url = Constant.SERVERURL + "/group/"+paramMap.get("groupId")+"/user";	
		return HttpClientUtil.get(url, HttpClientUtil.getToken(), paramMap);
	}

	/**
	 * 查询组角色
	 */
	@Override
	public JSONObject group_role(HashMap<String, Object> paramMap){
		String url = Constant.SERVERURL + "/group/"+paramMap.get("groupId")+"/role";		
		return HttpClientUtil.get(url, HttpClientUtil.getToken(), paramMap);
	}
	
	/**
	 * 添加组角色
	 */
	@Override
	public JSONObject add_group_role(HashMap<String, Object> paramMap){
		String url = Constant.SERVERURL + "/group/"+paramMap.get("groupId")+"/savegrole";
		paramMap.remove("groupId");
		return HttpClientUtil.postByBodyForJson(url, HttpClientUtil.getToken(), paramMap.get("groupAndRoleDto").toString());
	}

	/**
	 * 查询组权限
	 */
	@Override
	public JSONObject group_right(HashMap<String, Object> paramMap){
		String url = Constant.SERVERURL + "/group/"+paramMap.get("groupId")+"/right";		
		return HttpClientUtil.get(url, HttpClientUtil.getToken(), paramMap);
	}
	
	/**
	 * 添加组权限
	 */
	@Override
	public JSONObject add_group_right(HashMap<String, Object> paramMap){
		String url = Constant.SERVERURL + "/group/"+paramMap.get("groupId")+"/savegright";	
		paramMap.remove("groupId");
		return HttpClientUtil.postByBodyForJson(url, HttpClientUtil.getToken(), paramMap.get("groupAndRightDto").toString());
	}
}