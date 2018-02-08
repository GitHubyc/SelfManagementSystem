package com.xakj.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.xakj.constant.Constant;
import com.xakj.model.dto.Right;
import com.xakj.model.dto.Role;
import com.xakj.model.dto.User;
import com.xakj.service.LoginService;
import com.xakj.util.HttpClientUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author 施先锋 深圳消安科技有限公司 2017-2-21下午6:36:57
 */
@Component
public class LoginServiceImpl implements LoginService {

	public User Login(String userName, String password) {
		User user = new User();
		String token = null;
		String url = Constant.SERVERURL + "/login";
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("appid", Constant.APPAYID);
		paramMap.put("username", userName);
		paramMap.put("password", password);
		JSONObject object = HttpClientUtil.postByBody(url, null, paramMap);
		if (object.getString("msg").equals("success")) {

			System.out.println("登录成功！");
			token = object.getString("data");
			System.out.println("授权码" + token);
			if (token != null) {
				// 获取解析令牌
				String[] arr = HttpClientUtil.getTokenall(token);
				Map<String, List<String>> map = new HashMap<String, List<String>>();
				List<String> value = new ArrayList<String>();
				value.add(token);
				map.put(Constant.AUTHORIZATION, value);
				// 获取user信息
				String userurl = Constant.SERVERURL + "/user/" + arr[3];
				JSONObject resultUser = HttpClientUtil.get(userurl, map,
						paramMap);
				JSONObject dataUser = JSONObject.fromObject(resultUser);
				 String xzqhCode=null;
				int statusUser = dataUser.getInt("status");
				if (statusUser == HttpStatus.OK.value()) {
					JSONObject jsonObject = (JSONObject) dataUser.get("data");
					user = (User) JSONObject.toBean(jsonObject, User.class);
					//存放角色（袁文彪）
					List<Role> role = new ArrayList<Role>();
					String roleurl = Constant.SERVERURL + "/user/"+user.getUserId()+"/role";
					JSONObject resultRole = HttpClientUtil.get(roleurl, map,
							null);
			        JSONArray objectdata = new JSONArray();
			        if (resultRole.get("data") != null && !(resultRole.get("data")).equals("null")) { // 判断得到的数据是否为空
						objectdata = (JSONArray) resultRole.get("data");
					}
			        for (int i = 0; i < objectdata.size(); i++) {
			        	role.add((Role)JSONObject.toBean((JSONObject) objectdata.get(i),Role.class));
					}
			        user.setRole(role);
					//存放权限（袁文彪）
					String righturl = Constant.SERVERURL + "/right/user";
					HashMap<String, Object> param = new HashMap<String, Object>();
					param.put("userId", user.getUserId());
					JSONObject resultRight = HttpClientUtil.get(righturl, map,
							param);
					List<Right> right = new ArrayList<Right>();
					JSONArray rightObject = new JSONArray();
					if (resultRight.get("data") != null && !(resultRight.get("data")).equals("null")) {
						rightObject = (JSONArray) resultRight.get("data");
					}
					for (int j = 0; j < rightObject.size(); j++) {
						JSONObject r = rightObject.getJSONObject(j);
						right.add((Right)JSONObject.toBean(r,Right.class));
					}
					user.setRight(right);
					//权限完成
					//获取行政区划
					String userType= user.getUserType();
					
					if(userType.equals("1")||userType.equals("2")){
						String uniturl = Constant.SERVERURL + "/unit/" +user.getUnitCode();
						JSONObject resultunit = HttpClientUtil.get(uniturl, map,
								paramMap);
						JSONObject unitinfoObject = (JSONObject) JSONObject.fromObject(resultunit).get("data");
					    xzqhCode=(String)unitinfoObject.get("xzqhCode");
					}else{
						String buildurl = Constant.SERVERURL + "/builds/" +user.getPlcBuildCode();
						JSONObject resultbuild = HttpClientUtil.get(buildurl, map,
								paramMap);
						xzqhCode =(String)JSONObject.fromObject(resultbuild).get("data");
					}
				} else {
					System.out.println("登录失败！");
					user = null;
					return user;
				}
				// 获取role信息
				String roleurl = Constant.SERVERURL + "/user/" + arr[3]
						+ "/role";
				JSONObject resultRole = HttpClientUtil.get(roleurl, map,
						paramMap);
				JSONObject dataRole = JSONObject.fromObject(resultRole);
				int statusRole = dataRole.getInt("status");
				if (statusRole == HttpStatus.OK.value()) {
					JSONArray jsonArray = JSONArray.fromObject(dataRole
							.get("data"));
					List<Role> roles = JSONArray.toList(jsonArray, Role.class);
					user.setRole(roles);
					user.setToken(token);
					user.setXzqhCode(xzqhCode);
				} else {
					System.out.println("登录失败！");
					user = null;
					return user;
				}
			}
		} else {
			System.out.println("登录失败！");
			user = null;
			return user;
		}

		return user;
	}

	@Override
	public User LoginInfo(String token) {
		User user = new User();

		// 获取解析令牌
		String[] arr = HttpClientUtil.getTokenall(token);
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		List<String> value = new ArrayList<String>();
		value.add(token);
		map.put(Constant.AUTHORIZATION, value);
		// 获取user信息
		String userurl = Constant.SERVERURL + "/user/" + arr[3];
		JSONObject resultUser = HttpClientUtil.get(userurl, map, paramMap);
		JSONObject dataUser = JSONObject.fromObject(resultUser);
		int statusUser = dataUser.getInt("status");
		if (statusUser == HttpStatus.OK.value()) {
			JSONObject jsonObject = (JSONObject) dataUser.get("data");
			user = (User) JSONObject.toBean(jsonObject, User.class);
		} else {
			System.out.println("登录失败！");
			user = null;
			return user;
		}
		// 获取role信息
		String roleurl = Constant.SERVERURL + "/user/" + arr[3] + "/role";
		JSONObject resultRole = HttpClientUtil.get(roleurl, map, paramMap);
		JSONObject dataRole = JSONObject.fromObject(resultRole);
		int statusRole = dataRole.getInt("status");
		if (statusRole == HttpStatus.OK.value()) {
			JSONArray jsonArray = JSONArray.fromObject(dataRole.get("data"));
			List<Role> roles = JSONArray.toList(jsonArray, Role.class);
			user.setRole(roles);
		} else {
			System.out.println("登录失败！");
			user = null;
			return user;
		}
		return user;
	}

	@Override
	public JSONObject checkToken(String authorization) {
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		List<String> value = new ArrayList<String>();
		value.add(authorization);
		map.put(Constant.AUTHORIZATION, value);
		String url = Constant.SERVERURL + "/build";
		return HttpClientUtil.get(url, map, null);
	}

}
