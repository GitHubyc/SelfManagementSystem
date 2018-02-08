package com.xakj.service.impl;


import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.xakj.constant.Constant;
import com.xakj.service.UserService;
import com.xakj.util.HttpClientUtil;

import net.sf.json.JSONObject;

@Component
public class UserServiceImpl implements UserService {

	/**
	 * 获取用户
	 */
	@Override
	public JSONObject list(HashMap<String, Object> paramMap){
		String url = Constant.SERVERURL + "/user";		
		return HttpClientUtil.get(url, HttpClientUtil.getToken(), paramMap);
	};
	
	/**
	 * 根据用户名/id获取用户
	 */
	@Override
	public JSONObject selByNameOrId(HashMap<String, Object> paramMap){
		String url = Constant.SERVERURL + "/user/"+paramMap.get("userId");		
		return HttpClientUtil.get(url, HttpClientUtil.getToken(), null);
	};
	
	/**
	 * 新增用户
	 */
	@Override
	public JSONObject add(HashMap<String, Object> paramMap){
		String url = Constant.SERVERURL + "/user";		
		return HttpClientUtil.postByBody(url, HttpClientUtil.getToken(), paramMap);
	};
	
	/**
	 * 删除用户
	 */
	@Override
	public JSONObject del(String userId){
		String url = Constant.SERVERURL + "/user/"+userId;
		return HttpClientUtil.delete(url, HttpClientUtil.getToken(), null);
	};

	/**
	 * 更新用户
	 */
	@Override
	public JSONObject edit(HashMap<String, Object> paramMap){
		String url = Constant.SERVERURL + "/user/"+paramMap.get("userId");	
		return HttpClientUtil.putByBody(url, HttpClientUtil.getToken(), paramMap);
	};
	
	/**
	 * 查看用户
	 */
	@Override
	public JSONObject details(HashMap<String, Object> paramMap){
		String url = Constant.SERVERURL + "/user/"+paramMap.get("userId");		
		return HttpClientUtil.get(url, HttpClientUtil.getToken(), paramMap);
	}

	/**
	 * 查询用户组
	 */
	@Override
	public JSONObject userGroup(HashMap<String, Object> paramMap){
		String url = Constant.SERVERURL + "/user/"+paramMap.get("userId")+"/group";		
		return HttpClientUtil.get(url, HttpClientUtil.getToken(), paramMap);
	}
	
	/**
	 * 添加用户组
	 */
	@Override
	public JSONObject addUserGroup(HashMap<String, Object> paramMap){
		String url = Constant.SERVERURL + "/user/"+paramMap.get("userId")+"/saveugroup";	
		return HttpClientUtil.postByBodyForJson(url, HttpClientUtil.getToken(), paramMap.get("userAndGroupDto").toString());
	}
	
	/**
	 * 查询用户角色
	 */
	@Override
	public JSONObject userRole(HashMap<String, Object> paramMap){
		String url = Constant.SERVERURL + "/user/"+paramMap.get("userId")+"/role";		
		return HttpClientUtil.get(url, HttpClientUtil.getToken(), paramMap);
	}
	
	/**
	 * 添加用户角色
	 */
	@Override
	public JSONObject addUserRole(HashMap<String, Object> paramMap){
		String url = Constant.SERVERURL + "/user/"+paramMap.get("userId")+"/saveurole";
		return HttpClientUtil.postByBodyForJson(url, HttpClientUtil.getToken(), paramMap.get("userAndRoleDto").toString());
	}
	
	/**
	 * 查询用户权限（需要进行标识：自身的为1，通过角色和组获得的权限为2）
	 */
	@Override
	public JSONObject userRight(String userId, String applyId){
		String url = Constant.SERVERURL + "/right/user";
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userId", userId);
		paramMap.put("applyId", applyId);
		return HttpClientUtil.get(url, HttpClientUtil.getToken(), paramMap);
	}
	
	/**
	 * 添加用户权限
	 */
	@Override
	public JSONObject addUserRight(HashMap<String, Object> paramMap){
		String url = Constant.SERVERURL + "/user/"+paramMap.get("userId")+"/saveuright";	
		return HttpClientUtil.postByBodyForJson(url, HttpClientUtil.getToken(), paramMap.get("userAndRightDto").toString());
	}
}