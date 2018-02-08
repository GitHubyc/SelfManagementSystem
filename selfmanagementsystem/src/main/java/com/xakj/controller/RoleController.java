package com.xakj.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xakj.service.RightService;
import com.xakj.service.RoleService;
import com.xakj.util.HttpClientUtil;
import com.xakj.util.RightUtil;

/**
 * @author 施先锋 深圳消安科技有限公司 2017-2-21下午5:27:03
 */
@Controller
public class RoleController {

	@Autowired
	private RoleService roleService;
	@Autowired
	private RightService rightService;

	/**
	 * 角色列表
	 */
	@RequestMapping(value = "/role/list", method = RequestMethod.GET)
	public String role_list(
			ModelMap map,
			@RequestParam(value = "createdDate", defaultValue = "", required = false) String createdDate,
			@RequestParam(value = "updateDate", defaultValue = "", required = false) String updateDate,
			@RequestParam(value = "roleId", defaultValue = "", required = false) String roleId,
			@RequestParam(value = "parentId", defaultValue = "", required = false) String parentId,
			@RequestParam(value = "roleName", defaultValue = "", required = false) String roleName,
			@RequestParam(value = "roleDescribe", defaultValue = "", required = false) String roleDescribe,
			@RequestParam(value = "currentPage", defaultValue = "1", required = false) Integer currentPage,
			@RequestParam(value = "pageSize", defaultValue = "12", required = false) Integer pageSize) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("createdDate", createdDate);
		paramMap.put("updateDate", updateDate);
		paramMap.put("roleId", roleId);
		paramMap.put("parentId", parentId);
		paramMap.put("roleName", roleName);
		paramMap.put("roleDescribe", roleDescribe);
		paramMap.put("currentPage", currentPage);
		paramMap.put("pageSize", pageSize);
		JSONObject object = roleService.list(paramMap);
		JSONObject allobject = roleService.list(new HashMap<String, Object>());
		RightUtil ru = new RightUtil();
		map.addAttribute("menu", ru.menu());
		map.addAttribute("right", ru.right());
		map.addAttribute("paramMap", paramMap);
		map.addAttribute("object", object);
		map.addAttribute("allobject", allobject);
		return "Users/Role/Role_list";
	}

	/**
	 * 角色新增
	 */
	@RequestMapping(value = "/role/add", method = RequestMethod.GET)
	public String Role_add(ModelMap map) {
		JSONObject object = roleService.all(new HashMap<String, Object>());
		map.addAttribute("object", object);
		return "Users/Role/Role_add";
	}

	@RequestMapping(value = "/role/add", method = RequestMethod.POST)
	@ResponseBody
	public String Role_add(@RequestBody String body) {
		HashMap<String, Object> paramMap = HttpClientUtil.toMap(body);
		JSONObject object = roleService.add(paramMap);
		String json = object.toString();
		return json;
	}

	/**
	 * 角色删除
	 */
	@RequestMapping(value = "/role/del", method = RequestMethod.DELETE)
	@ResponseBody
	public String Role_del(
			@RequestParam(value = "roleId", defaultValue = "", required = false) String roleId) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("roleId", roleId);
		JSONObject object = roleService.del(paramMap);
		String json = object.toString();
		return json;
	}

	/**
	 * 角色更新
	 */
	@RequestMapping(value = "/role/edit", method = RequestMethod.GET)
	public String Role_edit(
			ModelMap map, 
			@RequestParam(value = "roleId", defaultValue = "", required = false) String roleId) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("roleId", roleId);
		JSONObject object = roleService.list(paramMap);
		JSONObject allobject = roleService.all(new HashMap<String, Object>());
		map.addAttribute("object", object);
		map.addAttribute("allobject", allobject);
		return "Users/Role/Role_edit";
	}

	@RequestMapping(value = "/role/edit", method = RequestMethod.PUT)
	@ResponseBody
	public String Role_edit(@RequestBody String body) {
		HashMap<String, Object> paramMap = HttpClientUtil.toMap(body);
		JSONObject object = roleService.edit(paramMap);
		String json = object.toString();
		return json;
	}

	/**
	 * 角色查看
	 */
	@RequestMapping(value = "/role/details", method = RequestMethod.GET)
	public String Role_details(
			ModelMap map,
			@RequestParam(value = "roleId", defaultValue = "", required = false) String roleId) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("roleId", roleId);
		JSONObject object = roleService.list(paramMap);
		JSONObject allobject = roleService.all(new HashMap<String, Object>());
		map.addAttribute("object", object);
		map.addAttribute("allobject", allobject);
		return "Users/Role/Role_details";
	}

	/**
	 * 角色分配权限
	 */
	@RequestMapping(value = "/role/right", method = RequestMethod.GET)
	public String Role_right(
			ModelMap map, 
			@RequestParam(value = "roleId", defaultValue = "", required = false) String roleId) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("roleId", roleId);
		JSONObject object = roleService.roleRight(paramMap);// 角色已有权限
		paramMap.remove("roleId");
		JSONObject allobject = rightService.list(paramMap); // 所有权限
		JSONArray data = new JSONArray();// 返回给前台
		JSONArray objectdata = new JSONArray();
		JSONArray allobjectdata = allobject.getJSONArray("data");
		if (object.get("data") != null && !(object.get("data")).equals("null")) { // 判断得到的数据是否为空
			objectdata = (JSONArray) object.get("data");
		}
		if (allobject.get("data") != null
				&& !(allobject.get("data")).equals("null")) {
			allobjectdata = (JSONArray) allobject.get("data");
		}
		for (int i = 0; i < allobjectdata.size(); i++) {
			JSONObject allrole = allobjectdata.getJSONObject(i); // 遍历jsonarray数组，把每一个对象转成json对象
			String biaosi = "0";
			for (int j = 0; j < objectdata.size(); j++) {
				JSONObject role = objectdata.getJSONObject(j);
				if (role.get("rightId").equals(allrole.get("rightId"))) {
					biaosi = "1";
				}
			}
			if ("".equals(biaosi) || null == biaosi) {
				biaosi = "0";
			}
			allrole.put("biaosi", biaosi);
			data.add(allrole);
		}
		object.remove("data");
		object.put("data", data);
		HashMap<String, Object> paramMap1 = new HashMap<String, Object>();
		paramMap1.put("parentId", "0");
		JSONObject appObject = rightService.list(paramMap1);	//所有最高权限，如消防应用
		map.addAttribute("appObject", appObject);
		map.addAttribute("object", object);
		map.addAttribute("roleId", roleId);
		return "Users/Role/Role_right";
	}

	@RequestMapping(value = "/role/right", method = RequestMethod.POST)
	@ResponseBody
	public String Role_right(
			@RequestParam(value = "roleId", defaultValue = "", required = false) String roleId,
			@RequestBody String body) {
		HashMap<String, Object> paramMap = HttpClientUtil.toMap(body);
		JSONObject object = new JSONObject();
		JSONArray array = new JSONArray();
		for (Object role : paramMap.values()) {
			JSONObject one = new JSONObject();
			one.put("rightId", role.toString());
			array.add(one);
		}
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("roleId", roleId);
		param.put("roleAndRightDto", array);
		object = roleService.addRoleRight(param);
		String json = object.toString();
		return json;
	}
}