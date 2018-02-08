package com.xakj.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

import com.xakj.constant.Constant;
import com.xakj.model.dto.Right;
import com.xakj.model.dto.User;

public class RightUtil {
	/**
	 * 获取权限，生成页面左侧菜单
	 * 
	 * @return
	 */
	public JSONArray menu() {
		JSONArray array = new JSONArray();
		JSONObject object = new JSONObject();
		Session session = SecurityUtils.getSubject().getSession();
		User user = (User) session.getAttribute(Constant.USER);
		List<Right> right = new ArrayList<Right>();
		for (int i = 0; i < user.getRight().size(); i++) {	//不能直接操作，影响session的值
			right.add(user.getRight().get(i));
		}
		for (int i = right.size() - 1; i >= 0; i--) {
			if (right.get(i).getRightType().equals("2")
					|| right.get(i).getMeunIcon().equals("无图标")) {
				right.remove(i);
			}
		}
		for (int i = right.size() - 1; i >= 0; i--) {
			object = JSONObject.fromObject(right.get(i));
			String haschild = "0";
			String hasparent = "0";
			for (int j = right.size() - 1; j >= 0; j--) {
				if(right.get(j).getParentId().equals(right.get(i).getRightId())){
					haschild = "1";
				}
				if(right.get(j).getRightId().equals(right.get(i).getParentId())){
					hasparent = "1";
				}
			}
			object.put("haschild", haschild);
			object.put("hasparent", hasparent);
			array.add(object);
		}
		sort(array, "menuSort", true);
		return array;
	}

	/**
	 * 获取操作
	 * 
	 * @return
	 */
	public JSONArray operate() {
		JSONArray array = new JSONArray();
		JSONObject object = new JSONObject();
		Session session = SecurityUtils.getSubject().getSession();
		User user = (User) session.getAttribute(Constant.USER);
		List<Right> right = user.getRight();
		for (int i = 0; i < right.size(); i++) {
			if ((right.get(i).getRightType()).equals("2")) {
				object = JSONObject.fromObject(right.get(i));
				array.add(object);
			}
		}
		return array;
	}

	/**
	 * 获取所有权限
	 * 
	 * @return
	 */
	public JSONArray right() {
		JSONArray array = new JSONArray();
		JSONObject object = new JSONObject();
		Session session = SecurityUtils.getSubject().getSession();
		User user = (User) session.getAttribute(Constant.USER);
		List<Right> right = user.getRight();
		for (int i = 0; i < right.size(); i++) {
			object = JSONObject.fromObject(right.get(i));
			array.add(object);
		}
		return array;
	}
	
	/**
	 * 获取所有权限路径
	 * 
	 * @return
	 */
	public List<String> url() {
		List<String> url = new ArrayList<String>();
		Session session = SecurityUtils.getSubject().getSession();
		User user = (User) session.getAttribute(Constant.USER);
		List<Right> right = user.getRight();
		for (int i = 0; i < right.size(); i++) {
			if(right.get(i).getRightType().equals("1")){
				url.add(right.get(i).getMenuUrl());
			}else{
				url.add(right.get(i).getOperateUrl());
			}
		}
		return url;
	}

	/**
	 * JSONArray排序
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private static void sort(JSONArray ja, final String field, boolean isAsc) {
		Collections.sort(ja, new Comparator<JSONObject>() {
			@Override
			public int compare(JSONObject o1, JSONObject o2) {
				Object f1 = o1.get(field);
				Object f2 = o2.get(field);
				if (f1 instanceof Number && f2 instanceof Number) {
					return ((Number) f1).intValue() - ((Number) f2).intValue();
				} else {
					return f1.toString().compareTo(f2.toString());
				}
			}
		});
		if (!isAsc) {
			Collections.reverse(ja);
		}
	}
}
