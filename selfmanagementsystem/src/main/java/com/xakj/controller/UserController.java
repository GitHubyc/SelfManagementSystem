package com.xakj.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xakj.constant.Constant;
import com.xakj.model.dto.User;
import com.xakj.service.BuildInfoService;
import com.xakj.service.GroupService;
import com.xakj.service.RightService;
import com.xakj.service.RoleService;
import com.xakj.service.UnitEmployeeService;
import com.xakj.service.UnitInfoService;
import com.xakj.service.UserService;
import com.xakj.util.HttpClientUtil;
import com.xakj.util.RightUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author 施先锋 深圳消安科技有限公司 2017-2-21下午5:27:03
 */
@Controller
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private RightService rightService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private GroupService groupService;
	@Autowired
	private BuildInfoService buildInfoService;
	@Autowired
	private UnitInfoService unitInfoService;
	@Autowired
	private UnitEmployeeService unitEmployeeService;
	
	/**
	 * 用户列表
	 */
	@RequestMapping(value = "/user/list", method = RequestMethod.GET)
	public String User_list(
			ModelMap map,
			@RequestParam(value = "userType", defaultValue = "", required = false) String userType,
			@RequestParam(value = "username", defaultValue = "", required = false) String username,
			@RequestParam(value = "userId", defaultValue = "", required = false) String userId,
			@RequestParam(value = "nickname", defaultValue = "", required = false) String nickname,
			@RequestParam(value = "sex", defaultValue = "", required = false) String sex,
			@RequestParam(value = "currentPage", defaultValue = "1", required = false) Integer currentPage,
			@RequestParam(value = "pageSize", defaultValue = "12", required = false) Integer pageSize) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userType", userType);
		paramMap.put("username", username);
		paramMap.put("userId", userId);
		paramMap.put("nickname", nickname);
		paramMap.put("sex", sex);
		paramMap.put("currentPage", currentPage);
		paramMap.put("pageSize", pageSize);
		JSONObject object = userService.list(paramMap);
		RightUtil ru = new RightUtil();
		map.addAttribute("menu", ru.menu());
		map.addAttribute("right", ru.right());
		map.addAttribute("paramMap", paramMap);
		map.addAttribute("object", object);
		return "Users/User/User_list";
	}

	/**
	 * 用户新增
	 */
	@RequestMapping(value = "/user/add", method = RequestMethod.GET)
	public String User_add(ModelMap map) {
		map.addAttribute("employees", unitEmployeeService.all(null));//所有人员（改成未添加账号的人员）
		return "Users/User/User_add";
	}

	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
	@ResponseBody
	public String User_add(@RequestBody String body) {
		HashMap<String, Object> paramMap = HttpClientUtil.toMap(body);
		if(paramMap.get("unitCode").equals("")){
			paramMap.remove("unitCode");
		}
		if(paramMap.get("plcBuildCode").equals("")){
			paramMap.remove("plcBuildCode");
		}
		JSONObject object = userService.add(paramMap);
		return object.toString();
	}

	/**
	 * 用户删除
	 */
	@RequestMapping(value = "/user/del", method = RequestMethod.DELETE)
	@ResponseBody
	public String User_del(
			@RequestParam(value = "userId", defaultValue = "", required = false) String userId) {
		JSONObject object = userService.del(userId);
		return object.toString();
	}

	/**
	 * 用户更新
	 */
	@RequestMapping(value = "/user/edit", method = RequestMethod.GET)
	public String User_edit(
			ModelMap map, 
			@RequestParam(value = "userId", defaultValue = "", required = false) String userId) {
		map.addAttribute("employees", unitEmployeeService.all(null));
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userId", userId);
		JSONObject object = userService.list(paramMap);
		map.addAttribute("object", object);
		return "Users/User/User_edit";
	}

	@RequestMapping(value = "/user/edit", method = RequestMethod.PUT)
	@ResponseBody
	public String User_edit(@RequestBody String body) {
		HashMap<String, Object> paramMap = HttpClientUtil.toMap(body);
		JSONObject object = userService.edit(paramMap);
		return object.toString();
	}

	/**
	 * 用户查看
	 */
	@RequestMapping(value = "/user/details", method = RequestMethod.GET)
	public String User_details(
			ModelMap map,
			@RequestParam(value = "userId", defaultValue = "", required = false) String userId) {
		map.addAttribute("builds", buildInfoService.list(null));
		map.addAttribute("units", unitInfoService.list(null));
		map.addAttribute("employees", unitEmployeeService.all(null));
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		if(userId.equals("")){
			User user = (User) SecurityUtils.getSubject().getSession().getAttribute(Constant.USER);
			userId = user.getUserId();
		}
		paramMap.put("userId", userId);
		JSONObject object = userService.list(paramMap);
		map.addAttribute("object", object);
		return "Users/User/User_details";
	}

	/**
	 * 用户分配组
	 */
	@RequestMapping(value = "/user/group", method = RequestMethod.GET)
	public String User_group(
			ModelMap map, 
			@RequestParam(value = "userId", defaultValue = "", required = false) String userId) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userId", userId);
		JSONObject object = userService.userGroup(paramMap); // 用户已有组
		paramMap.remove("userId");
		JSONObject allobject = groupService.all(null); // 所有组
		JSONArray data = new JSONArray();
		JSONArray objectdata = new JSONArray();
		JSONArray allobjectdata = new JSONArray();
		if (object.get("data") != null && !(object.get("data")).equals("null")) { // 判断得到的数据是否为空
			objectdata = (JSONArray) object.get("data");
		}
		if (allobject.get("data") != null && !(allobject.get("data")).equals("null")) {
			allobjectdata = (JSONArray) allobject.get("data");
		}
		for (int i = 0; i < allobjectdata.size(); i++) {	// 遍历数组，添加字段isgroup，分成两类：1为已有组，2为未有组
			JSONObject allrole = allobjectdata.getJSONObject(i); 
			String isgroup = "1";
			for (int j = 0; j < objectdata.size(); j++) {
				JSONObject role = objectdata.getJSONObject(j);
				if (role.get("groupId").equals(allrole.get("groupId"))) {
					isgroup = "2";
				}
			}
			allrole.put("isgroup", isgroup);
			data.add(allrole);
		}
		object.put("data", data);	//覆盖原有数据
		map.addAttribute("object", object);
		map.addAttribute("userId", userId);
		return "Users/User/User_group";
	}

	@RequestMapping(value = "/user/group", method = RequestMethod.POST)
	@ResponseBody
	public String User_group(
			@RequestParam(value = "userId", defaultValue = "", required = false) String userId,
			@RequestBody String body) {
		HashMap<String, Object> paramMap = HttpClientUtil.toMap(body);	//得到前台数据进行处理，封装到数组传给网关
		JSONObject object = new JSONObject();
		JSONArray array = new JSONArray();
		for (Object role : paramMap.values()) {
			JSONObject one = new JSONObject();
			one.put("groupId", role.toString());
			array.add(one);
		}
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("userId", userId);
		param.put("userAndGroupDto", array);
		object = userService.addUserGroup(param);
		String json = object.toString();
		return json;
	}

	/**
	 * 用户分配角色
	 */
	@RequestMapping(value = "/user/role", method = RequestMethod.GET)
	public String User_role(
			ModelMap map, 
			@RequestParam(value = "userId", defaultValue = "", required = false) String userId) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userId", userId);
		JSONObject object = userService.userRole(paramMap);// 用户已有角色
		paramMap.remove("userId");
		JSONObject allobject = roleService.all(paramMap); // 所有角色
		JSONArray data = new JSONArray();// 返回给前台
		JSONArray objectdata = new JSONArray();
		JSONArray allobjectdata = new JSONArray();
		if (object.get("data") != null && !(object.get("data")).equals("null")) { // 判断得到的数据是否为空
			objectdata = (JSONArray) object.get("data");
		}
		if (allobject.get("data") != null && !(allobject.get("data")).equals("null")) {
			allobjectdata = (JSONArray) allobject.get("data");
		}
		for (int i = 0; i < allobjectdata.size(); i++) {
			JSONObject allrole = allobjectdata.getJSONObject(i); // 遍历jsonarray数组，把每一个对象转成json对象
			String biaosi = "0";
			for (int j = 0; j < objectdata.size(); j++) {
				JSONObject role = objectdata.getJSONObject(j);
				if (role.get("roleId").equals(allrole.get("roleId"))) {
					biaosi = "1";
				}
			}
			if ("".equals(biaosi) || null == biaosi) {
				biaosi = "0";
			}
			allrole.put("biaosi", biaosi);
			data.add(allrole);
		}
		object.put("data", data);
		map.addAttribute("object", object);
		map.addAttribute("userId", userId);
		return "Users/User/User_role";
	}

	@RequestMapping(value = "/user/role", method = RequestMethod.POST)
	@ResponseBody
	public String User_role(
			@RequestParam(value = "userId", defaultValue = "", required = false) String userId,
			@RequestBody String body) {
		HashMap<String, Object> paramMap = HttpClientUtil.toMap(body);
		JSONObject object = new JSONObject();
		JSONArray array = new JSONArray();
		for (Object role : paramMap.values()) {
			JSONObject one = new JSONObject();
			one.put("roleId", role.toString());
			array.add(one);
		}
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("userId", userId);
		param.put("userAndRoleDto", array);
		object = userService.addUserRole(param);
		return object.toString();
	}

	/**
	 * 用户权限配置
	 */
	@RequestMapping(value = "/user/right", method = RequestMethod.GET)
	public String User_right(
			ModelMap map, 
			@RequestParam(value = "userId", defaultValue = "", required = false) String userId) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("applyId", "d2060e3ce66241eba4db978197a55b89");
		JSONObject object = userService.userRight(userId, "d2060e3ce66241eba4db978197a55b89");// 用户已有权限
		JSONObject allobject = rightService.list(paramMap); // 所有权限
		JSONArray data = new JSONArray();// 返回给前台
		JSONArray objectdata = new JSONArray();
		JSONArray allobjectdata = new JSONArray();
		if (object.get("data") != null && !(object.get("data")).equals("null")) { // 判断得到的数据是否为空
			objectdata = (JSONArray) object.get("data");
		}
		if (allobject.get("data") != null && !(allobject.get("data")).equals("null")) {
			allobjectdata = (JSONArray) allobject.get("data");
		}
		for (int i = 0; i < allobjectdata.size(); i++) {
			JSONObject allrole = allobjectdata.getJSONObject(i); // 遍历jsonarray数组，把每一个对象转成json对象
			String biaosi = "0";
			for (int j = 0; j < objectdata.size(); j++) {
				JSONObject role = objectdata.getJSONObject(j);
				if (role.get("rightId").equals(allrole.get("rightId"))) {
					biaosi = (String) role.get("biaoSi");
				}
			}
			if (null == biaosi || biaosi.equals("")) {
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
		map.addAttribute("userId", userId);
		return "Users/User/User_right";
	}

	@RequestMapping(value = "/user/right", method = RequestMethod.POST)
	@ResponseBody
	public String User_right(
			@RequestParam(value = "userId", defaultValue = "", required = false) String userId,
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
		param.put("userId", userId);
		param.put("userAndRightDto", array);
		object = userService.addUserRight(param);
		return object.toString();
	}
	
	/**
	 * 单位信息页面
	 */
	@RequestMapping(value = "/user/unit")
	public String User_unit() {

		return "/Users/User/User_unit";
	}
	
	/**
	 * 添加单位用户时单位信息
	 */
	@RequestMapping(value = "/user/unit", method = RequestMethod.POST)
	@ResponseBody
	public String BuildInfo_listInfo(
			ModelMap map,
			@RequestBody String body) {
		JSONObject object = unitInfoService.list(null);
		map.addAttribute("object", object);
		return object.toString();
	}
	
	/**
	 * 单位人员信息页面
	 */
	@RequestMapping(value = "/user/employee")
	public String User_employee(
			ModelMap map,
			@RequestParam(value = "unitCode", defaultValue = "", required = false) String unitCode) {
		map.addAttribute("unitCode", unitCode);
		return "/Users/User/User_employee";
	}
	/**
	 * 添加单位用户时人员信息
	 */
	@RequestMapping(value = "/user/employee", method = RequestMethod.POST)
	@ResponseBody
	public String EmployeeInfo_listInfo(
			ModelMap map,
			@RequestBody String body) {
		HashMap<String, Object> paramMap = HttpClientUtil.toMap(body);
		paramMap.put("unitCode", paramMap.get("unitCode"));
		JSONObject object = unitEmployeeService.list(paramMap);
		map.addAttribute("object", object);
		return object.toString();
	}
	
	/**
	 * 建筑信息页面
	 */
	@RequestMapping(value = "/user/build")
	public String User_build() {

		return "/Users/User/User_build";
	}
	
	/**
	 * 添加建筑用户时建筑信息
	 */
	@RequestMapping(value = "/user/build", method = RequestMethod.POST)
	@ResponseBody
	public String Build_list(
			ModelMap map,
			@RequestBody String body) {
		JSONObject object = buildInfoService.list(null);
		map.addAttribute("object", object);
		return object.toString();
	}
	
	@RequestMapping("/session")  
	@ResponseBody
	public String session(HttpServletRequest request){  
		Session session = SecurityUtils.getSubject().getSession();
		User user = (User) session.getAttribute(Constant.USER);
		JSONObject object = userService.userRight(user.getUserId(), "");
		JSONArray array = new JSONArray();
		JSONArray data = new JSONArray();// 返回给前台
		if (object.get("data") != null && !(object.get("data")).equals("null")) {
			array = (JSONArray) object.get("data");
		}
		for (int i = 0; i < array.size(); i++) {
			JSONObject right = array.getJSONObject(i); // 遍历jsonarray数组，把每一个对象转成json对象
			if (right.getString("rightType").equals("1")) {
				data.add(right);
			}
		}
		object.put("data", data);
	    return object.toString();  
	} 
}