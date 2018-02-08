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

import com.xakj.service.GroupService;
import com.xakj.service.RightService;
import com.xakj.service.RoleService;
import com.xakj.util.HttpClientUtil;
import com.xakj.util.RightUtil;

/**
 * @author 施先锋 深圳消安科技有限公司 2017-2-21下午5:27:03
 */
@Controller
public class GroupController {

	@Autowired
	private GroupService groupService;
	@Autowired
	private RightService rightService;
	@Autowired
	private RoleService roleService;

	/**
	 * 组列表
	 */
	@RequestMapping(value = "/group/list", method = RequestMethod.GET)
	public String Group_list(
			ModelMap map,
			@RequestParam(value = "createdDate", defaultValue = "", required = false) String createdDate,
			@RequestParam(value = "updateDate", defaultValue = "", required = false) String updateDate,
			@RequestParam(value = "groupId", defaultValue = "", required = false) String groupId,
			@RequestParam(value = "parentId", defaultValue = "", required = false) String parentId,
			@RequestParam(value = "groupName", defaultValue = "", required = false) String groupName,
			@RequestParam(value = "groupDescribe", defaultValue = "", required = false) String groupDescribe,
			@RequestParam(value = "currentPage", defaultValue = "1", required = false) Integer currentPage,
			@RequestParam(value = "pageSize", defaultValue = "12", required = false) Integer pageSize) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("createdDate", createdDate);
		paramMap.put("updateDate", updateDate);
		paramMap.put("groupId", groupId);
		paramMap.put("parentId", parentId);
		paramMap.put("groupName", groupName);
		paramMap.put("groupDescribe", groupDescribe);
		paramMap.put("currentPage", currentPage);
		paramMap.put("pageSize", pageSize);
		JSONObject object = groupService.list(paramMap);
		JSONObject allobject = groupService.all(null);
		RightUtil ru = new RightUtil();
		map.addAttribute("menu", ru.menu());
		map.addAttribute("right", ru.right());
		map.addAttribute("paramMap", paramMap);
		map.addAttribute("object", object);
		map.addAttribute("allobject", allobject);
		return "Users/Group/Group_list";
	}

	/**
	 * 组新增
	 */
	@RequestMapping(value = "/group/add", method = RequestMethod.GET)
	public String Group_add(ModelMap map) {
		JSONObject object = groupService.all(null);
		map.addAttribute("object", object);
		return "Users/Group/Group_add";
	}

	@RequestMapping(value = "/group/add", method = RequestMethod.POST)
	@ResponseBody
	public String Group_add(@RequestBody String body) {
		HashMap<String, Object> paramMap = HttpClientUtil.toMap(body);
		JSONObject object = groupService.add(paramMap);
		String json = object.toString();
		return json;
	}

	/**
	 * 组删除
	 */
	@RequestMapping(value = "/group/del", method = RequestMethod.DELETE)
	@ResponseBody
	public String User_del(
			@RequestParam(value = "groupId", defaultValue = "", required = false) String groupId) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("groupId", groupId);
		JSONObject object = groupService.del(paramMap);
		String json = object.toString();
		return json;
	}

	/**
	 * 组更新
	 */
	@RequestMapping(value = "/group/edit", method = RequestMethod.GET)
	public String Group_edit(ModelMap map,
			@RequestParam(value = "groupId", defaultValue = "", required = false) String groupId) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("groupId", groupId);
		JSONObject object = groupService.list(paramMap);
		JSONObject allobject = groupService.all(null);
		map.addAttribute("object", object);
		map.addAttribute("allobject", allobject);
		return "Users/Group/Group_edit";
	}

	@RequestMapping(value = "/group/edit", method = RequestMethod.PUT)
	@ResponseBody
	public String Group_edit(@RequestBody String body) {
		HashMap<String, Object> paramMap = HttpClientUtil.toMap(body);
		JSONObject object = groupService.edit(paramMap);
		String json = object.toString();
		return json;
	}

	/**
	 * 组查看
	 */
	@RequestMapping(value = "/group/details", method = RequestMethod.GET)
	public String Role_details(ModelMap map,
			@RequestParam(value = "groupId", defaultValue = "", required = false) String groupId) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("groupId", groupId);
		JSONObject object = groupService.list(paramMap);
		JSONObject allobject = groupService.list(null);
		map.addAttribute("object", object);
		map.addAttribute("allobject", allobject);
		return "Users/Group/Group_details";
	}

	/**
	 * 查询组用户
	 */
	@RequestMapping(value = "/group/user", method = RequestMethod.GET)
	public String Group_user(
			ModelMap map,
			@RequestParam(value = "groupId", defaultValue = "", required = false) String groupId,
			@RequestParam(value = "userType", defaultValue = "", required = false) String userType,
			@RequestParam(value = "username", defaultValue = "", required = false) String username,
			@RequestParam(value = "userId", defaultValue = "", required = false) String userId,
			@RequestParam(value = "nickname", defaultValue = "", required = false) String nickname,
			@RequestParam(value = "sex", defaultValue = "", required = false) String sex,
			@RequestParam(value = "currentPage", defaultValue = "1", required = false) Integer currentPage,
			@RequestParam(value = "pageSize", defaultValue = "12", required = false) Integer pageSize) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("groupId", groupId);
		paramMap.put("userType", userType);
		paramMap.put("username", username);
		paramMap.put("userId", userId);
		paramMap.put("nickname", nickname);
		paramMap.put("sex", sex);
		paramMap.put("currentPage", currentPage);
		paramMap.put("pageSize", pageSize);
		JSONObject object = groupService.group_user(paramMap);// 组已有用户
		RightUtil ru = new RightUtil();
		map.addAttribute("menu", ru.menu());
		map.addAttribute("right", ru.right());
		map.addAttribute("paramMap", paramMap);
		map.addAttribute("object", object);
		return "Users/Group/Group_edituser";
	}

	/**
	 * 组角色查看
	 */
	@RequestMapping(value = "/group/role", method = RequestMethod.GET)
	public String Group_role(
			ModelMap map,
			@RequestParam(value = "groupId", defaultValue = "", required = false) String groupId,
			@RequestParam(value = "createdDate", defaultValue = "", required = false) String createdDate,
			@RequestParam(value = "updateDate", defaultValue = "", required = false) String updateDate,
			@RequestParam(value = "roleId", defaultValue = "", required = false) String roleId,
			@RequestParam(value = "parentId", defaultValue = "", required = false) String parentId,
			@RequestParam(value = "roleName", defaultValue = "", required = false) String roleName,
			@RequestParam(value = "roleDescribe", defaultValue = "", required = false) String roleDescribe,
			@RequestParam(value = "currentPage", defaultValue = "1", required = false) Integer currentPage,
			@RequestParam(value = "pageSize", defaultValue = "12", required = false) Integer pageSize) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("groupId", groupId);
		paramMap.put("createdDate", createdDate);
		paramMap.put("updateDate", updateDate);
		paramMap.put("roleId", roleId);
		paramMap.put("parentId", parentId);
		paramMap.put("roleName", roleName);
		paramMap.put("roleDescribe", roleDescribe);
		paramMap.put("currentPage", currentPage);
		paramMap.put("pageSize", pageSize);
		JSONObject object = groupService.group_role(paramMap);// 组已有角色
		JSONObject roles = roleService.all(null);
		RightUtil ru = new RightUtil();
		map.addAttribute("menu", ru.menu());
		map.addAttribute("right", ru.right());
		map.addAttribute("paramMap", paramMap);
		map.addAttribute("object", object);
		map.addAttribute("allobject", roles);
		map.addAttribute("groupId", groupId);
		return "Users/Group/Group_editrole";
	}

	/**
	 * 组角色添加
	 */
	@RequestMapping(value = "/group/addrole", method = RequestMethod.GET)
	public String add_group_role(ModelMap map,
			@RequestParam(value = "groupId", defaultValue = "", required = false) String groupId) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("groupId", groupId);
		JSONObject object = groupService.group_role(paramMap);// 组已有角色
		paramMap.remove("groupId");
		JSONObject allobject = roleService.all(paramMap); // 所有角色
		JSONArray objectdata = new JSONArray();
		JSONArray allobjectdata = new JSONArray();
		JSONArray data = new JSONArray();// 返回给前台
		if (allobject.getJSONArray("data") != null
				&& !(allobject.get("data").equals("null"))) {
			allobjectdata = allobject.getJSONArray("data");
		}
		if (object.get("data") != null && !(object.get("data").equals("null"))) {
			objectdata = object.getJSONArray("data");
		}
		for (int i = 0; i < allobjectdata.size(); i++) {
			JSONObject allrole = allobjectdata.getJSONObject(i); // 遍历jsonarray数组，把每一个对象转成json对象
			String hasrole = "1";
			for (int j = 0; j < objectdata.size(); j++) {
				JSONObject role = objectdata.getJSONObject(j);
				if (role.get("roleId").equals(allrole.get("roleId"))) {
					hasrole = "2";
				}
			}
			allrole.put("is", hasrole);
			data.add(allrole);
		}
		object.remove("data");
		object.put("data", data);
		map.addAttribute("object", object);
		map.addAttribute("groupId", groupId);
		return "Users/Group/Group_addrole";
	}

	@RequestMapping(value = "/group/addrole", method = RequestMethod.POST)
	@ResponseBody
	public String Group_role(
			@RequestParam(value = "groupId", defaultValue = "", required = false) String groupId,
			@RequestBody String body) {
		HashMap<String, Object> paramMap = HttpClientUtil.toMap(body);
		JSONObject object = new JSONObject();
		List<JSONObject> rolelist = new ArrayList<JSONObject>();
		for (Object role : paramMap.keySet()) {
			JSONObject one = new JSONObject();
			one.put("roleId", paramMap.get(role));
			rolelist.add(one);
		}
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("groupId", groupId);
		param.put("groupAndRoleDto", rolelist);
		object = groupService.add_group_role(param);
		String json = object.toString();
		return json;
	}

	/**
	 * 组权限配置
	 */
	@RequestMapping(value = "/group/right", method = RequestMethod.GET)
	public String group_right(
			ModelMap map,
			@RequestParam(value = "groupId", defaultValue = "", required = false) String groupId) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("groupId", groupId);
		JSONObject object = groupService.group_right(paramMap);// 组已有权限
		paramMap.remove("groupId");
		JSONObject allobject = rightService.list(paramMap); // 所有权限
		JSONArray objectdata = new JSONArray();
		JSONArray allobjectdata = new JSONArray();
		JSONArray data = new JSONArray();// 返回给前台
		if (allobject.getJSONArray("data") != null
				&& !(allobject.get("data").equals("null"))) {
			allobjectdata = allobject.getJSONArray("data");
		}
		if (object.get("data") != null && !(object.get("data").equals("null"))) {
			objectdata = object.getJSONArray("data");
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
		map.addAttribute("groupId", groupId);
		return "Users/Group/Group_right";
	}

	@RequestMapping(value = "/group/right", method = RequestMethod.POST)
	@ResponseBody
	public String Group_right(
			@RequestParam(value = "groupId", defaultValue = "", required = false) String groupId,
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
		param.put("groupId", groupId);
		param.put("groupAndRightDto", array);
		object = groupService.add_group_right(param);
		String json = object.toString();
		return json;
	}

}